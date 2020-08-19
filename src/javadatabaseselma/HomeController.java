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
public class HomeController implements Initializable {

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
    
    @FXML
    Button insert;
    
    @FXML
    public void createUser(ActionEvent e) throws SQLException {
        
        Connection connection = Database.getConnectionDb();
        
        messageME.setText("");
        messageNE.setText("");
        messagePE.setText("");
        messageDE.setText("");
        messageAE.setText("");
        
        if(Matricule_etu.getText().equals(""))
        {
            messageME.setText("Matricule is empty !");
            messageME.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(nom_etu.getText().equals(""))
        {
            messageNE.setText("Nom is empty !");
            messageNE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(prenom_etu.getText().equals(""))
        {
            messagePE.setText("Prenome is empty !");
            messagePE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(date_naissance.getText().equals(""))
        {
            messageDE.setText("Date naissance is empty !");
            messageDE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(Addresse.getText().equals(""))
        {
            messageAE.setText("Addresse is empty !");
            messageAE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(!Matricule_etu.getText().equals(""))
        {
            if( duplicateMatricule(connection,Matricule_etu.getText()) )
            {
                messageME.setText("duplicate matricule !");
                messageME.setTextFill(Color.rgb(210, 39, 30));
            }
           if(!nom_etu.getText().equals(""))
           {
                if(!prenom_etu.getText().equals(""))
                {
                    if(!date_naissance.getText().equals(""))
                    {
                        if(!Addresse.getText().equals(""))
                        {
                                             
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
