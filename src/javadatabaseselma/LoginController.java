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
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author b
 */
public class LoginController implements Initializable {
    
    @FXML
    TextField username;
    
    @FXML
    Label messageU;
    
    @FXML      
    PasswordField password;
    
    @FXML      
    Label messageP;
    
    @FXML      
    Label messageE;
            
    @FXML
    Button loginDashoard;
    
    @FXML
    Button exit;
    
    @FXML
    public void login( ActionEvent e ) throws SQLException, IOException {
        
        Connection connection = Database.getConnectionDb();
        
        messageU.setText("");
        messageP.setText("");
        messageE.setText("");
        
        if(username.getText().equals(""))
        {
            messageU.setText("username is empty !");
            messageU.setTextFill(Color.rgb(210, 39, 30));
        } 
        
        if(password.getText().equals(""))
        {
            messageP.setText("password is empty !");
            messageP.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(!username.getText().equals(""))
        {
           if(!password.getText().equals(""))
           {
              if ( username.getText().equals("BDDAdmin") &&  password.getText().equals("TPAdmin") ) {
                    Stage HomeStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                    //Scene scene = new Scene(root, 1200, 600);
                    Scene scene = new Scene(root, -1, -1, true, SceneAntialiasing.BALANCED);
                    scene.getStylesheets().add(getClass().getResource("home.css").toExternalForm());
                    HomeStage.setTitle("Home");
                    HomeStage.setScene(scene);
                    HomeStage.show();
                    Stage st = (Stage) loginDashoard.getScene().getWindow();
                    st.close();
              } else if ( username.getText().equals("Etudiant") &&  password.getText().equals("TPEtudiant") ) {
                    Stage EtudiantStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("Etudiant.fxml"));
                    //Scene scene = new Scene(root, 1200, 600);
                    Scene scene = new Scene(root, -1, -1, true, SceneAntialiasing.BALANCED);
                    scene.getStylesheets().add(getClass().getResource("Etudiant.css").toExternalForm());
                    EtudiantStage.setTitle("Etudiant");
                    EtudiantStage.setScene(scene);
                    EtudiantStage.show();
                    Stage st = (Stage) loginDashoard.getScene().getWindow();
                    st.close();
              } else if ( username.getText().equals("Enseignant") &&  password.getText().equals("TPEnseignant") ) {
                    Stage EtudiantStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("Enseignant.fxml"));
                    //Scene scene = new Scene(root, 1200, 600);
                    Scene scene = new Scene(root, -1, -1, true, SceneAntialiasing.BALANCED);
                    scene.getStylesheets().add(getClass().getResource("Enseignant.css").toExternalForm());
                    EtudiantStage.setTitle("Enseignant");
                    EtudiantStage.setScene(scene);
                    EtudiantStage.show();
                    Stage st = (Stage) loginDashoard.getScene().getWindow();
                    st.close();
              } else {
                    messageE.setText("Username or password is incorrect !");
                    messageE.setTextFill(Color.rgb(210, 39, 30));
              } 
           }
        }

    }
    
    @FXML
    public void ResetValiderForm(ActionEvent e) throws SQLException {
        username.setText("");
        password.setText("");
    }
    
    @FXML
    public void closeWindow(ActionEvent e) throws SQLException {
        Stage stage = (Stage) exit.getScene().getWindow();
        stage.close();
    }
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    
}
