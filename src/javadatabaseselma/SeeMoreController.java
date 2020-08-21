/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadatabaseselma;

import com.mysql.jdbc.PreparedStatement;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.paint.Color;
import javadatabaseselma.JoinEtuEnsUnite;

/**
 * FXML Controller class
 *
 * @author b
 */
public class SeeMoreController implements Initializable {

    @FXML
    TextField getMatriculeFieldNote;
    
    @FXML
    Button noteValider;
    
    @FXML
    TableView<Etudiant> tableByNoteExam;
    
    @FXML
    TableColumn<Etudiant, String> tableNomNote;
    
    @FXML
    TableColumn<Etudiant, String> tablePrenomNote; 
    
    private ObservableList<Etudiant> noteExamData;
    
    @FXML
    TextField getMatriculeFieldLibelle;
    
    @FXML
    Button LibelleValider;
    
    @FXML
    TableView<Etudiant> tableByLibelle;
    
    @FXML
    TableColumn<Etudiant, String> tableNomLibelle;
    
    @FXML
    TableColumn<Etudiant, String> tablePrenomLibelle; 
    
    private ObservableList<Etudiant> LibelleData;

    @FXML
    TextField getMatriculeFieldLibelleUnite;
    
    @FXML
    Button LibelleUniteValider;
    
    @FXML
    TableView<Unite> tableLibelleUnite;
    
    @FXML
    TableColumn<Unite, String> tableColumnLibelleUnite; 
    
    private ObservableList<Unite> LibelleUniteData;
    
    @FXML
    TableView<JoinEtuEnsUnite> tablejoinData;
    
    @FXML
    TableColumn<JoinEtuEnsUnite, String> joinNom; 
    
    @FXML
    TableColumn<JoinEtuEnsUnite, String> joinPrenom; 
    
    @FXML
    TableColumn<JoinEtuEnsUnite, String> joinLibelle; 
    
    @FXML
    TableColumn<JoinEtuEnsUnite, Integer> joinMoyenne;
    
    private ObservableList<JoinEtuEnsUnite> joinData;
    
    @FXML
    public void validerDataByNote(ActionEvent e) throws SQLException {
        
        boolean isNumeric = getMatriculeFieldNote.getText().chars().allMatch( Character::isDigit );
        //getMatriculeFieldNote.setText("");

        if(isNumeric)
        {
        
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        tableNomNote.setCellValueFactory(new PropertyValueFactory<>("NOM_ETU"));
        tablePrenomNote.setCellValueFactory(new PropertyValueFactory<>("PRENOM_ETU"));
        
        noteExamData = FXCollections.observableArrayList();    
    
        try {
        
        Connection connection = Database.getConnectionDb();
            
        String sql = "select NOM_ETU,PRENOM_ETU from etudiant where MATRICULE_ETU in(select MATRICULE_ETU from etudiantunite where NOTE_EXAMEN=" + Integer.parseInt(getMatriculeFieldNote.getText()) + ")";
        
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        
        while (rs.next()) {	
                noteExamData.add(new Etudiant(rs.getString("NOM_ETU"),rs.getString("PRENOM_ETU")));
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        tableByNoteExam.setItems(noteExamData);
            
        } else {
            getMatriculeFieldNote.setText("");
            getMatriculeFieldNote.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //errorValider.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(getMatriculeFieldNote.getText().equals(""))
        {
           getMatriculeFieldNote.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");

        }
            
        
    }
    
    @FXML
    public void validerDataByLibelle(ActionEvent e) throws SQLException {
                
        if(!getMatriculeFieldLibelle.getText().equals(""))
        {
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        tableNomLibelle.setCellValueFactory(new PropertyValueFactory<>("NOM_ETU"));
        tablePrenomLibelle.setCellValueFactory(new PropertyValueFactory<>("PRENOM_ETU"));
        
        LibelleData = FXCollections.observableArrayList();    
            
        try {
        
        Connection connection = Database.getConnectionDb();

        String sql = "select NOM_ETU,PRENOM_ETU from etudiant where MATRICULE_ETU not in (select MATRICULE_ETU from etudiantunite where CODE_UNITE in (select CODE_UNITE from unite where LIBELLE='" + getMatriculeFieldNote.getText() + "'))";
        
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        
        while (rs.next()) {	
                LibelleData.add(new Etudiant(rs.getString("NOM_ETU"),rs.getString("PRENOM_ETU")));
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        tableByLibelle.setItems(LibelleData);
         
        } else {
            getMatriculeFieldLibelle.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //errorValider.setTextFill(Color.rgb(210, 39, 30));
        }
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        tableColumnLibelleUnite.setCellValueFactory(new PropertyValueFactory<>("LIBELLE"));

        LibelleUniteData = FXCollections.observableArrayList();    
            
        try {
        
        Connection connection = Database.getConnectionDb();

        String sql = "select LIBELLE from unite where CODE_UNITE not in (select CODE_UNITE from etudiantunite)";
        
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        
        while (rs.next()) {	
                LibelleUniteData.add(new Unite(rs.getString("LIBELLE")));
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        tableLibelleUnite.setItems(LibelleUniteData);
        
        
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        joinNom.setCellValueFactory(new PropertyValueFactory<>("NOM_ETU"));
        joinPrenom.setCellValueFactory(new PropertyValueFactory<>("PRENOM_ETU"));
        joinLibelle.setCellValueFactory(new PropertyValueFactory<>("LIBELLE"));
        joinMoyenne.setCellValueFactory(new PropertyValueFactory<>("moy"));

        joinData = FXCollections.observableArrayList();    
            
        try {
        
        Connection connection = Database.getConnectionDb();

        String sql = "select NOM_ETU,PRENOM_ETU,LIBELLE,((NOTE_CC+NOTE_TP+(NOTE_EXAMEN*2))/4) as MOY from etudiant,etudiantunite,unite where etudiant.MATRICULE_ETU =etudiantunite.MATRICULE_ETU  and etudiantunite.CODE_UNITE = unite.CODE_UNITE ";
        
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        
        while (rs.next()) {	
                joinData.add(new JoinEtuEnsUnite(rs.getString("NOM_ETU"),rs.getString("PRENOM_ETU"),rs.getString("LIBELLE"),rs.getInt("MOY")));
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        tablejoinData.setItems(joinData);
                
    }    
    
}
