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
import static javadatabaseselma.HomeController.duplicateMatricule;
import static javadatabaseselma.HomeController.duplicateMatriculeCodeUnite;
import static javadatabaseselma.HomeController.duplicateMatriculeEns;
import static javadatabaseselma.HomeController.duplicateMatriculeEtUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

/**
 * FXML Controller class
 *
 * @author b
 */
public class EnseignantController implements Initializable {

    @FXML
    TextField getMatriculeField;
    
    @FXML
    Label getMatriculeEns;
    
    @FXML
    Label getNomEns;
    
    @FXML
    Label getPrenomEns;
    
    // enseignant unit fields
    
    @FXML
    TextField Matricule_Ens;
    
    @FXML
    Label mat;
    
    @FXML
    TextField nom_ens;
    
    @FXML
    Label nom;
    
    @FXML
    TextField prenom_ens;
    
    @FXML
    Label pre;
    
    @FXML
    Label result;
    
    @FXML
    Label error;
    
    @FXML
    Button resetInsertEns;
    
    @FXML
    Button resetValiderEns;
    
    @FXML
    public void ResetInsertForm(ActionEvent e) throws SQLException {
    Matricule_Ens.setText("");
    nom_ens.setText("");
    prenom_ens.setText("");
    }
    
    @FXML
    public void ResetValiderForm(ActionEvent e) throws SQLException {
    getMatriculeField.setText("");
    }
    
    @FXML
    public void validerDataByMatricule(ActionEvent e) throws SQLException {
        String sql = "SELECT * FROM enseignant where MATRICULE_ENS  = " + Integer.parseInt(getMatriculeField.getText());
        Connection connection = Database.getConnectionDb();
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        error.setText("");
        while (rs.next()) {
           getMatriculeEns.setText(rs.getString("MATRICULE_ENS").toString());
           getNomEns.setText(rs.getString("NOM_ENS").toString()); 
           getPrenomEns.setText(rs.getString("PRENOM_ENS").toString());
        }
        
        if(getMatriculeEns.getText().equals(""))
        {
            error.setText("Votre Matricule est faux ou n'existe pas");
            error.setTextFill(Color.rgb(210, 39, 30));
        }
    }
    
        
    @FXML
    public void AddEnseignant(ActionEvent e) throws SQLException {
        
        Connection connection = Database.getConnectionDb();
        
        mat.setText("");
        nom.setText("");
        pre.setText("");
        result.setText("");
        
        if(Matricule_Ens.getText().equals(""))
        {
            mat.setText("Matricule is empty !");
            mat.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(nom_ens.getText().equals(""))
        {
            nom.setText("Nom is empty !");
            nom.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(prenom_ens.getText().equals(""))
        {
            pre.setText("Prenome is empty !");
            pre.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(!Matricule_Ens.getText().equals(""))
        {
            if( HomeController.duplicateMatriculeEns(connection,Matricule_Ens.getText()) )
            {
                mat.setText("duplicate matricule !");
                mat.setTextFill(Color.rgb(210, 39, 30));
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
                    result.setText("Enseignant added successfully !");
                    result.setTextFill(Color.GREEN);
                }
            }
        }
        
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
