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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

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
    public void validerDataByMatricule(ActionEvent e) throws SQLException {
        String sql = "SELECT * FROM etudiant where MATRICULE_ETU = " + Integer.parseInt(getMatriculeField.getText());
        Connection connection = Database.getConnectionDb();
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        
        while (rs.next()) {
           getMatricule.setText(rs.getString("MATRICULE_ETU").toString());
           getNom.setText(rs.getString("NOM_ETU").toString()); 
           getPrenom.setText(rs.getString("PRENOM_ETU").toString());
           getDn.setText(rs.getString("DATE_NAISSANCE").toString());
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
