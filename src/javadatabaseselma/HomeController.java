/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadatabaseselma;

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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author b
 */
public class HomeController implements Initializable {

    @FXML
    TextField firstname;
    
    @FXML
    Label messageF;
    
    @FXML
    TextField lastname;
    
    @FXML
    Label messageL;
    
    @FXML
    TextField username;
    
    @FXML
    Label messageU;
    
    @FXML
    TextField email;
    
    @FXML
    Label messageE;
    
    @FXML
    TextField password;
    
    @FXML
    Label messageP;
    
    @FXML
    TextField confirmepassword;
    
    @FXML
    Label messageC;
    
    @FXML
    TextField telephone;
    
    @FXML
    Label messageT;
    
    @FXML
    Button create;
    
    @FXML
    Label messageR;
    
    @FXML
    ChoiceBox choiceBox;
    
    @FXML
    Label gender;
    
    @FXML
    public void createUser(ActionEvent e) throws SQLException {
        
        Connection connection = Database.getConnectionDb();
        
        messageF.setText("");
        messageL.setText("");
        messageU.setText("");
        messageE.setText("");
        messageP.setText("");
        messageC.setText("");
        messageT.setText("");
        messageR.setText("");
        
        if(firstname.getText().equals(""))
        {
            messageF.setText("firstname is empty !");
            messageF.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(lastname.getText().equals(""))
        {
            messageL.setText("lastname is empty !");
            messageL.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(username.getText().equals(""))
        {
            messageU.setText("username is empty !");
            messageU.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(email.getText().equals(""))
        {
            messageE.setText("email is empty !");
            messageE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(password.getText().equals(""))
        {
            messageP.setText("password is empty !");
            messageP.setTextFill(Color.rgb(210, 39, 30));
        }
        
        
        if(confirmepassword.getText().equals(""))
        {
            messageC.setText("confirme password is empty !");
            messageC.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(telephone.getText().equals(""))
        {
            messageT.setText("telephone is empty !");
            messageT.setTextFill(Color.rgb(210, 39, 30));
        } 
        
        if(!choiceBox.getValue().equals(""))
        {
            gender.setText(choiceBox.getValue().toString());
        }
        
        if(!firstname.getText().equals(""))
        {
           if(!lastname.getText().equals(""))
           {
                if(!username.getText().equals(""))
                {
                    if(!email.getText().equals(""))
                    {
                        if( duplicateEmail(connection,email.getText()) )
                        {
                            messageE.setText("duplicate email !");
                            messageE.setTextFill(Color.rgb(210, 39, 30));
                        }
                        if(!password.getText().equals(""))
                        {
                            if(!confirmepassword.getText().equals(""))
                            {
                                if(!confirmepassword.getText().equals(password.getText()))
                                {
                                    messageC.setText("password not match with the first one !");
                                    messageC.setTextFill(Color.rgb(210, 39, 30));
                                }
                                if(!telephone.getText().equals(""))
                                {
                                    if( duplicateTelephone(connection,telephone.getText()) )
                                    {
                                        messageT.setText("duplicate telephone !");
                                        messageT.setTextFill(Color.rgb(210, 39, 30));
                                    }
                                    if(!choiceBox.getValue().equals(""))
                                    {
                                    gender.setText(choiceBox.getValue().toString());
                                         if ( ! duplicateEmail(connection,email.getText()) && ! duplicateTelephone(connection,telephone.getText()) ) {
                                             
                                           String sql = "INSERT INTO users (firstname,lastname,username,email,password,telephone,gender) VALUES (?,?,?,?,?,?,?)";
                                           PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
                                           ps.setString(1, firstname.getText());
                                           ps.setString(2, lastname.getText());
                                           ps.setString(3, username.getText());
                                           ps.setString(4, email.getText());
                                           ps.setString(5, password.getText());
                                           ps.setString(6, telephone.getText());
                                           ps.setString(7, choiceBox.getValue().toString());
                                           ps.executeUpdate();
                                           messageR.setText("user added successfully !");
                                           messageR.setTextFill(Color.GREEN);
                                           
                                        }
                                    } 
                                }
                            }
                        }
                    }
                }
            }
        }
                            
    }
    
    public static boolean duplicateMatricule(Connection connection , String matricule ) throws SQLException {
        
        String sql = "SELECT email FROM users where email = '" + matricule + "'";
        
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
    }    
    
}
