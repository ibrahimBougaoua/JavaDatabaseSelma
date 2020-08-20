/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadatabaseselma;

import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javadatabaseselma.Etudiant;


/**
 * FXML Controller class
 *
 * @author b
 */
public class HomeController implements Initializable {

    
    // etudiant fields
    
    @FXML
    TextField Matricule_etu;
    
    @FXML
    Label messageME;
    
    @FXML
    TextField nom_etu;
    
    @FXML
    Label messageNE;
    
    @FXML
    TextField prenom_etu;
    
    @FXML
    Label messagePE;
    
    @FXML
    TextField date_naissance;
    
    @FXML
    Label messageDE;
    
    @FXML
    TextField Addresse;
  
    @FXML
    Label messageAE;

    // etudiant unit fields
    
    @FXML
    TextField Matricule_etu_unit;
    
    @FXML
    Label messageMEU;
    
    @FXML
    TextField code_unit;
    
    @FXML
    Label messageCEU;
    
    @FXML
    TextField note_cc;
    
    @FXML
    Label messageNEU;
    
    @FXML
    TextField note_tp;
    
    @FXML
    Label messageTEU;
    
    @FXML
    TextField note_examen;
  
    @FXML
    Label messageXEU;
    
    // etudiant unit fields
    
    @FXML
    TextField Matricule_Ens;
    
    @FXML
    Label messageMES;
    
    @FXML
    TextField nom_ens;
    
    @FXML
    Label messageENS;
    
    @FXML
    TextField prenom_ens;
    
    @FXML
    Label messageENP;
    
    // unit fields
    
    @FXML
    TextField code_unit_u;
    
    @FXML
    Label messageCU;
    
    @FXML
    TextField libelle;
    
    @FXML
    Label messageLB;
    
    @FXML
    TextField nbr_heurs;
    
    @FXML
    Label messageNBR;
    
    @FXML
    TextField Matricule_Ens_u;
    
    @FXML
    Label messageMTESU;
    
    @FXML
    Button insert;
    
    @FXML
    Label messageR;
    
    @FXML
    RadioButton radio1;
    
    @FXML
    RadioButton radio2;
   
    @FXML
    RadioButton radio3;
    
    @FXML
    RadioButton radio4;
    
    ToggleGroup group1;
    
    @FXML
    RadioButton cradio1;
    
    @FXML
    RadioButton cradio2;
   
    @FXML
    RadioButton cradio3;
    
    @FXML
    RadioButton cradio4;
    
    ToggleGroup cgroup1;

    @FXML
    TableView<Etudiant> etudiantTable;
    
    @FXML
    TableColumn<Etudiant, Integer> etudiantMat;

    @FXML
    TableColumn<Etudiant, String> etudiantNom;

    @FXML
    TableColumn<Etudiant, String> etudiantPrenom;
    
    @FXML
    TableColumn<Etudiant, String> etudiantDn;   
    
    @FXML
    TableColumn<Etudiant, String> etudiantAd;
    
    @FXML
    public void Retry(ActionEvent e) throws SQLException {
    Matricule_etu.setText("");
    nom_etu.setText("");
    prenom_etu.setText("");
    date_naissance.setText("");
    Addresse.setText("");
    Matricule_etu_unit.setText("");
    code_unit.setText("");
    note_cc.setText("");
    note_tp.setText("");
    note_examen.setText("");
    Matricule_Ens.setText("");
    nom_ens.setText("");
    prenom_ens.setText("");
    code_unit_u.setText("");
    libelle.setText("");
    nbr_heurs.setText("");
    Matricule_Ens_u.setText("");
    }
    
    @FXML
    public void AddEtudiant(ActionEvent e) throws SQLException {
        
        Connection connection = Database.getConnectionDb();
        
        String selected = ((RadioButton) group1.getSelectedToggle()).getText();

        switch (selected) {
            case "one":
        
        //messageME.setText("");
        //messageNE.setText("");
        //messagePE.setText("");
        //messageDE.setText("");
        //messageAE.setText("");
        
        if(Matricule_etu.getText().equals(""))
        {
            //messageME.setText("Matricule is empty !");
            //messageME.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(nom_etu.getText().equals(""))
        {
            //messageNE.setText("Nom is empty !");
            //messageNE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(prenom_etu.getText().equals(""))
        {
            //messagePE.setText("Prenome is empty !");
            //messagePE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(date_naissance.getText().equals(""))
        {
            //messageDE.setText("Date naissance is empty !");
            //messageDE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(Addresse.getText().equals(""))
        {
            //messageAE.setText("Addresse is empty !");
            //messageAE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(!Matricule_etu.getText().equals(""))
        {
            if( duplicateMatricule(connection,Matricule_etu.getText()) )
            {
                //messageME.setText("duplicate matricule !");
                //messageME.setTextFill(Color.rgb(210, 39, 30));
            }
           if(!nom_etu.getText().equals(""))
           {
                if(!prenom_etu.getText().equals(""))
                {
                    if(!date_naissance.getText().equals(""))
                    {
                        if(!Addresse.getText().equals(""))
                        {
                            String sql = "INSERT INTO etudiant (MATRICULE_ETU,NOM_ETU,PRENOM_ETU,DATE_NAISSANCE,ADDRESSE) VALUES (?,?,?,?,?)";
                            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
                            ps.setString(1, Matricule_etu.getText());
                            ps.setString(2, nom_etu.getText());
                            ps.setString(3, prenom_etu.getText());
                            ps.setString(4, date_naissance.getText());
                            ps.setString(5, Addresse.getText());
                            ps.executeUpdate();
                            //messageR.setText("Etudiant added successfully !");
                            //messageR.setTextFill(Color.GREEN);
                        }
                    }
                }
            }
        }
                     break;
                     
                     
                     
                     
            case "tow":
        
        //messageME.setText("");
        //messageNE.setText("");
        //messagePE.setText("");
        //messageDE.setText("");
        //messageAE.setText("");
        
        if(Matricule_etu_unit.getText().equals(""))
        {
            //messageME.setText("Matricule is empty !");
            //messageME.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(code_unit.getText().equals(""))
        {
            //messageNE.setText("Nom is empty !");
            //messageNE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(note_cc.getText().equals(""))
        {
            //messagePE.setText("Prenome is empty !");
            //messagePE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(note_tp.getText().equals(""))
        {
            //messageDE.setText("Date naissance is empty !");
            //messageDE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(note_examen.getText().equals(""))
        {
            //messageAE.setText("Addresse is empty !");
            //messageAE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(!Matricule_etu_unit.getText().equals(""))
        {
            if( duplicateMatriculeEtUnit(connection,Matricule_etu_unit.getText()) )
            {
                //messageME.setText("duplicate matricule !");
                //messageME.setTextFill(Color.rgb(210, 39, 30));
            }
           if(!code_unit.getText().equals(""))
           {
                if(!note_cc.getText().equals(""))
                {
                    if(!note_tp.getText().equals(""))
                    {
                        if(!note_examen.getText().equals(""))
                        {
                            String sql = "INSERT INTO etudiantunite (MATRICULE_ETU,CODE_UNITE,NOTE_CC,NOTE_TP,NOTE_EXAMEN) VALUES (?,?,?,?,?)";
                            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
                            ps.setInt(1, Integer.parseInt(Matricule_etu_unit.getText()));
                            ps.setString(2, code_unit.getText());
                            ps.setInt(3, Integer.parseInt(note_cc.getText()));
                            ps.setInt(4, Integer.parseInt(note_tp.getText()));
                            ps.setInt(5, Integer.parseInt(note_examen.getText()));
                            ps.executeUpdate();
                            //messageR.setText("Etudiant added successfully !");
                            //messageR.setTextFill(Color.GREEN);
                        }
                    }
                }
            }
        }
                     break;
                     
                     

                     
                     
            case "three":
        
        //messageME.setText("");
        //messageNE.setText("");
        //messagePE.setText("");
        //messageDE.setText("");
        //messageAE.setText("");
        
        if(Matricule_Ens.getText().equals(""))
        {
            //messageME.setText("Matricule is empty !");
            //messageME.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(nom_ens.getText().equals(""))
        {
            //messageNE.setText("Nom is empty !");
            //messageNE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(prenom_ens.getText().equals(""))
        {
            //messagePE.setText("Prenome is empty !");
            //messagePE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(!Matricule_Ens.getText().equals(""))
        {
            if( duplicateMatriculeEns(connection,Matricule_Ens.getText()) )
            {
                //messageME.setText("duplicate matricule !");
                //messageME.setTextFill(Color.rgb(210, 39, 30));
            }
           if(!nom_ens.getText().equals(""))
           {
                if(!prenom_ens.getText().equals(""))
                {
                    String sql = "INSERT INTO enseignant (MATRICULE_ENS,NOM_ENS,PRENOM_ENS) VALUES (?,?,?)";
                    PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
                    ps.setInt(1, Integer.parseInt(Matricule_Ens.getText()));
                    ps.setString(2, nom_ens.getText());
                    ps.setString(3, prenom_ens.getText());
                    ps.executeUpdate();
                    //messageR.setText("Etudiant added successfully !");
                    //messageR.setTextFill(Color.GREEN);
                }
            }
        }
                     break;  
                     
                     

            case "four":
        
        //messageME.setText("");
        //messageNE.setText("");
        //messagePE.setText("");
        //messageDE.setText("");
        //messageAE.setText("");
        
        if(code_unit_u.getText().equals(""))
        {
            //messageME.setText("Matricule is empty !");
            //messageME.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(libelle.getText().equals(""))
        {
            //messageNE.setText("Nom is empty !");
            //messageNE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(nbr_heurs.getText().equals(""))
        {
            //messagePE.setText("Prenome is empty !");
            //messagePE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(Matricule_Ens_u.getText().equals(""))
        {
            //messageDE.setText("Date naissance is empty !");
            //messageDE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(!code_unit_u.getText().equals(""))
        {
            if( duplicateMatriculeCodeUnite(connection,code_unit_u.getText()) )
            {
                //messageME.setText("duplicate matricule !");
                //messageME.setTextFill(Color.rgb(210, 39, 30));
            }
           if(!libelle.getText().equals(""))
           {
                if(!nbr_heurs.getText().equals(""))
                {
                    if(!Matricule_Ens_u.getText().equals(""))
                    {
                            String sql = "INSERT INTO unite (CODE_UNITE,LIBELLE,NBR_HEURES,MATRICULE_ENS) VALUES (?,?,?,?)";
                            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
                            ps.setString(1, code_unit_u.getText());
                            ps.setString(2, libelle.getText());
                            ps.setInt(3, Integer.parseInt(nbr_heurs.getText()));
                            ps.setInt(4, Integer.parseInt(Matricule_Ens_u.getText()));
                            ps.executeUpdate();
                            //messageR.setText("Etudiant added successfully !");
                            //messageR.setTextFill(Color.GREEN);
                    }
                }
            }
        }
                     break;
                     
                     
           default: // some thing...
                     break;
        }
        
    }
    
    public static boolean duplicateMatricule(Connection connection , String matricule ) throws SQLException {
        
        String sql = "SELECT MATRICULE_ETU FROM etudiant where MATRICULE_ETU = '" + matricule + "'";
        
        com.mysql.jdbc.PreparedStatement preparedStatement = (com.mysql.jdbc.PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        
        return rs.next();
    }
    
    public static boolean duplicateMatriculeEtUnit(Connection connection , String matricule ) throws SQLException {
        
        String sql = "SELECT MATRICULE_ETU FROM etudiantunite where MATRICULE_ETU = '" + matricule + "'";
        
        com.mysql.jdbc.PreparedStatement preparedStatement = (com.mysql.jdbc.PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        
        return rs.next();
    }
    
    public static boolean duplicateMatriculeCodeUnite(Connection connection , String matricule ) throws SQLException {
        
        String sql = "SELECT CODE_UNITE FROM unite where CODE_UNITE  = '" + matricule + "'";
        
        com.mysql.jdbc.PreparedStatement preparedStatement = (com.mysql.jdbc.PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        
        return rs.next();
    }
    
    public static boolean duplicateMatriculeEns(Connection connection , String matricule ) throws SQLException {
        
        String sql = "SELECT MATRICULE_ENS FROM enseignant where MATRICULE_ENS = '" + matricule + "'";
        
        com.mysql.jdbc.PreparedStatement preparedStatement = (com.mysql.jdbc.PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        
        return rs.next();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        group1 = new ToggleGroup();
        radio1.setText("one");
        radio2.setText("tow");
        radio3.setText("three");
        radio4.setText("four");
        radio1.setToggleGroup(group1);
        radio2.setToggleGroup(group1);
        radio3.setToggleGroup(group1);
        radio4.setToggleGroup(group1);
        
        cgroup1 = new ToggleGroup();
        cradio1.setText("one");
        cradio2.setText("tow");
        cradio3.setText("three");
        cradio4.setText("four");
        cradio1.setToggleGroup(cgroup1);
        cradio2.setToggleGroup(cgroup1);
        cradio3.setToggleGroup(cgroup1);
        cradio4.setToggleGroup(cgroup1);
        
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        etudiantMat.setCellValueFactory(new PropertyValueFactory<>("MATRICULE_ETU"));
        etudiantNom.setCellValueFactory(new PropertyValueFactory<>("NOM_ETU"));
        etudiantPrenom.setCellValueFactory(new PropertyValueFactory<>("PRENOM_ETU"));
        etudiantDn.setCellValueFactory(new PropertyValueFactory<>("DATE_NAISSANCE"));
        etudiantAd.setCellValueFactory(new PropertyValueFactory<>("ADDRESSE"));
                
        //add your data to the table here.
        etudiantTable.setItems(etudiant);
        
    } 
    
    // add your data here from any source 
    private ObservableList<Etudiant> etudiant = FXCollections.observableArrayList(
            new Etudiant(1,"Amos", "Chepchieng", "Chepchieng", "Chepchieng")
    );

    
    
    
}
