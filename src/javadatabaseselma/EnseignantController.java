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
import static javadatabaseselma.HomeController.duplicateMatricule;
import static javadatabaseselma.HomeController.duplicateMatriculeCodeUnite;
import static javadatabaseselma.HomeController.duplicateMatriculeEns;
import static javadatabaseselma.HomeController.duplicateMatriculeEtUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
    Label errorValider;
    
    @FXML
    Button resetInsertEns;
    
    @FXML
    Button resetValiderEns;
    
    @FXML
    Button backToLoginPage;
    
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
        
        boolean isNumeric = getMatriculeField.getText().chars().allMatch( Character::isDigit );
        errorValider.setText("");

        if(isNumeric)
        {
        String sql = "SELECT * FROM enseignant where MATRICULE_ENS  = " + Integer.parseInt(getMatriculeField.getText());
        Connection connection = Database.getConnectionDb();
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        
        getMatriculeEns.setText("");
        getNomEns.setText(""); 
        getPrenomEns.setText("");
        
        while (rs.next()) {
           getMatriculeEns.setText(rs.getString("MATRICULE_ENS").toString());
           getNomEns.setText(rs.getString("NOM_ENS").toString()); 
           getPrenomEns.setText(rs.getString("PRENOM_ENS").toString());
        }
        } else {
            errorValider.setText("Votre Matricule est faux ou n'existe pas");
            errorValider.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(getMatriculeEns.getText().equals(""))
        {
            errorValider.setText("Votre Matricule est faux ou n'existe pas");
            errorValider.setTextFill(Color.rgb(210, 39, 30));
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
            
            boolean isNumeric = Matricule_Ens.getText().chars().allMatch( Character::isDigit );
            mat.setText("");
            
            if( HomeController.duplicateMatriculeEns(connection,Matricule_Ens.getText()) )
            {
                mat.setText("duplicate matricule !");
                mat.setTextFill(Color.rgb(210, 39, 30));
            }

            if(isNumeric)
            {
            
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
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Enseignant ajouté avec succès! !");
                    alert.setHeaderText("les information de Enseignant");
                    alert.setContentText("Matrcule : " + Matricule_Ens.getText() + "\nNom : " + nom_ens.getText() + "\nPrenom : " + prenom_ens.getText());
                    alert.showAndWait();
                }
            }
           
           } else {
                mat.setText("cette valeur n'est pas valide");
                mat.setTextFill(Color.rgb(210, 39, 30));
            }
            
        }
        
    }
    
    @FXML
    public void backToLoginPage(ActionEvent event) throws IOException  {
        Stage stage = (Stage) backToLoginPage.getScene().getWindow();
        stage.close();
        Stage login = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        //Scene scene = new Scene(root, 450, 300);
        Scene scene = new Scene(root, -1, -1, true, SceneAntialiasing.BALANCED);
        scene.getStylesheets().add(getClass().getResource("login.css").toExternalForm());
        login.setTitle("Login");
        login.setScene(scene);
        login.show();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
