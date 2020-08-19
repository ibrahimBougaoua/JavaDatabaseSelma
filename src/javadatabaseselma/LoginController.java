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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
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
                    Stage dashboardStage = new Stage();
                    Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
                    Scene scene = new Scene(root, 1200, 600);
                    scene.getStylesheets().add(getClass().getResource("home.css").toExternalForm());
                    dashboardStage.setTitle("Home");
                    dashboardStage.setScene(scene);
                    dashboardStage.show();
              } else {
                    messageE.setText("username or password is incorrect !");
                    messageE.setTextFill(Color.rgb(210, 39, 30));
              } 
           }
        }

    }
    
    public static boolean ifLogIn(Connection connection , String username , String password ) throws SQLException {
        
        String sql = "SELECT * FROM users";
        
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        
        while (rs.next()) {	
            if ( username.equals(rs.getString("username")) & password.equals(rs.getString("password")) ) { 
                return true;
	    }
        }
        return false;
    }
	
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }    

    
}
