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
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

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
    
    @FXML
    Button insert;
    
    @FXML
    Label messageR;
            
    @FXML
    public void AddEtudiant(ActionEvent e) throws SQLException {
        
        Connection connection = Database.getConnectionDb();
        
        switch (2) {
            case 1:
        
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
                     
                     
                     
                     
            case 2:
        
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
            if( duplicateMatriculeUnit(connection,Matricule_etu_unit.getText()) )
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
                            ps.setString(1, Matricule_etu_unit.getText());
                            ps.setString(2, code_unit.getText());
                            ps.setString(3, note_cc.getText());
                            ps.setString(4, note_tp.getText());
                            ps.setString(5, note_examen.getText());
                            ps.executeUpdate();
                            //messageR.setText("Etudiant added successfully !");
                            //messageR.setTextFill(Color.GREEN);
                        }
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
    
    public static boolean duplicateMatriculeUnit(Connection connection , String matricule ) throws SQLException {
        
        String sql = "SELECT MATRICULE_ETU FROM etudiantunite where MATRICULE_ETU = '" + matricule + "'";
        
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
