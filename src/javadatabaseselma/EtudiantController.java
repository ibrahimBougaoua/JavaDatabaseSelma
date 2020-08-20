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
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author b
 */
public class EtudiantController implements Initializable {

    // using by etudiant validation...
    
    @FXML
    TextField getMatriculeField;
    
    @FXML
    Label getMatricule;
    
    @FXML
    Label getNom;
    
    @FXML
    Label getPrenom;
    
    @FXML
    Label getDn;
    
    @FXML
    Label errorValider;
    
    @FXML
    Button resetValiderEt;
    
    @FXML
    Button backToLoginPage;
    
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
        
        String sql = "SELECT * FROM etudiant where MATRICULE_ETU = " + Integer.parseInt(getMatriculeField.getText());
        Connection connection = Database.getConnectionDb();
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        
        getMatricule.setText("");
        getNom.setText(""); 
        getPrenom.setText("");
        getDn.setText("");
           
        while (rs.next()) {
           getMatricule.setText(rs.getString("MATRICULE_ETU").toString());
           getNom.setText(rs.getString("NOM_ETU").toString()); 
           getPrenom.setText(rs.getString("PRENOM_ETU").toString());
           getDn.setText(rs.getString("DATE_NAISSANCE").toString());
        }
        } else {
            getMatricule.setText("");
            getNom.setText(""); 
            getPrenom.setText("");
            getDn.setText("");
            errorValider.setText("Votre Matricule est faux ou n'existe pas");
            errorValider.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(getMatricule.getText().equals(""))
        {
            errorValider.setText("Votre Matricule est faux ou n'existe pas");
            errorValider.setTextFill(Color.rgb(210, 39, 30));
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
