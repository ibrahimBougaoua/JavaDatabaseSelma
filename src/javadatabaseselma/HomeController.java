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
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.SceneAntialiasing;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author b
 */
public class HomeController implements Initializable {

    private ObservableList<Etudiant> data;
    private ObservableList<EtudiantUnite> etudiantUnitData;
    private ObservableList<Enseignant> etudiantData;
    private ObservableList<Unite> uniteData;

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
    DatePicker date_naissance;
    
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
    
    // enseignant unit fields
    
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
    Button return_to_login_page;
    
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

    // using for etudiant table
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
    
    // using for etudiant unit
    
    @FXML
    TableView<EtudiantUnite> etudiantUnit;
    
    @FXML
    TableColumn<EtudiantUnite, Integer> etudiantUnitMatEtu;

    @FXML
    TableColumn<EtudiantUnite, String> etudiantUnitCode;

    @FXML
    TableColumn<EtudiantUnite, Integer> etudiantUnitNoteCc;
    
    @FXML
    TableColumn<EtudiantUnite, Integer> etudiantUnitNoteTp;   
    
    @FXML
    TableColumn<EtudiantUnite, Integer> etudiantUnitNoteExamen;

    // using for enseignant
    
    @FXML
    TableView<Enseignant> enseignant;
    
    @FXML
    TableColumn<Enseignant, Integer> enseignantMatTable;
    
    @FXML
    TableColumn<Enseignant, String> enseignantNomTable;   
    
    @FXML
    TableColumn<EtudiantUnite, String> enseignantPrenomTable;
    
    // using for enseignant
    
    @FXML
    TableView<Unite> unite;
    
    @FXML
    TableColumn<Unite, String> uniteCu;
    
    @FXML
    TableColumn<Unite, String> uniteLb;   
    
    @FXML
    TableColumn<Unite, Integer> uniteNh;
    
    @FXML
    TableColumn<Unite, Integer> uniteMe;
    
    @FXML
    AnchorPane a1,a2,a3,a4;
    
    @FXML
    Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17;
    
    @FXML
    Label insertResult1,insertResult2,insertResult3,insertResult4;
    
    @FXML
    public void Retry(ActionEvent e) throws SQLException {
        
    a1.setStyle("-fx-background-color: #fff;-fx-effect:dropshadow(three-pass-box, #ccc, 10, 0, 0, 0);");
    a2.setStyle("-fx-background-color: #fff;-fx-effect:dropshadow(three-pass-box, #ccc, 10, 0, 0, 0);");
    a3.setStyle("-fx-background-color: #fff;-fx-effect:dropshadow(three-pass-box, #ccc, 10, 0, 0, 0);");
    a4.setStyle("-fx-background-color: #fff;-fx-effect:dropshadow(three-pass-box, #ccc, 10, 0, 0, 0);");
    
    Matricule_etu.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    nom_etu.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    prenom_etu.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    date_naissance.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    Addresse.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    Matricule_etu_unit.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    code_unit.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    note_cc.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    note_tp.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    note_examen.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    Matricule_Ens.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    nom_ens.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    prenom_ens.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    code_unit_u.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    libelle.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    nbr_heurs.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    Matricule_Ens_u.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    
    l1.setTextFill(Color.web("#000"));
    l2.setTextFill(Color.web("#000"));
    l3.setTextFill(Color.web("#000"));
    l4.setTextFill(Color.web("#000"));
    l5.setTextFill(Color.web("#000"));
    l6.setTextFill(Color.web("#000"));
    l7.setTextFill(Color.web("#000"));
    l8.setTextFill(Color.web("#000"));
    l9.setTextFill(Color.web("#000"));
    l10.setTextFill(Color.web("#000"));
    l6.setTextFill(Color.web("#000"));
    l7.setTextFill(Color.web("#000"));
    l8.setTextFill(Color.web("#000"));
    l9.setTextFill(Color.web("#000"));
    l10.setTextFill(Color.web("#000"));
    l11.setTextFill(Color.web("#000"));
    l12.setTextFill(Color.web("#000"));
    l13.setTextFill(Color.web("#000"));
    l14.setTextFill(Color.web("#000"));
    l15.setTextFill(Color.web("#000"));
    l16.setTextFill(Color.web("#000"));
    l17.setTextFill(Color.web("#000"));
    
    Matricule_etu.setText("");
    nom_etu.setText("");
    prenom_etu.setText("");
    date_naissance.setValue(null);
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
    public void backToLoginPage(ActionEvent event) throws IOException  {
        Stage stage = (Stage) return_to_login_page.getScene().getWindow();
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
    
    @FXML
    public void AddEtudiant(ActionEvent e) throws SQLException {
        
        Connection connection = Database.getConnectionDb();
        
        String selected = ((RadioButton) group1.getSelectedToggle()).getText();
        
        insertResult1.setText("");
        insertResult2.setText("");
        insertResult3.setText("");
        insertResult4.setText("");
            
    Matricule_etu.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    nom_etu.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    prenom_etu.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    date_naissance.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    Addresse.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    Matricule_etu_unit.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    code_unit.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    note_cc.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    note_tp.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    note_examen.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    Matricule_Ens.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    nom_ens.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    prenom_ens.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    code_unit_u.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    libelle.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    nbr_heurs.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    Matricule_Ens_u.setStyle("-fx-border-color: #ccc; -fx-border-width: 1px 1px 1px 0px");
    
        a1.setStyle("-fx-background-color: #fff;-fx-effect:dropshadow(three-pass-box, #ccc, 10, 0, 0, 0);");
        a2.setStyle("-fx-background-color: #fff;-fx-effect:dropshadow(three-pass-box, #ccc, 10, 0, 0, 0);");
        a3.setStyle("-fx-background-color: #fff;-fx-effect:dropshadow(three-pass-box, #ccc, 10, 0, 0, 0);");
        a4.setStyle("-fx-background-color: #fff;-fx-effect:dropshadow(three-pass-box, #ccc, 10, 0, 0, 0);");
        
        l1.setTextFill(Color.web("#000"));
        l2.setTextFill(Color.web("#000"));
        l3.setTextFill(Color.web("#000"));
        l4.setTextFill(Color.web("#000"));
        l5.setTextFill(Color.web("#000"));
        l6.setTextFill(Color.web("#000"));
        l7.setTextFill(Color.web("#000"));
        l8.setTextFill(Color.web("#000"));
        l9.setTextFill(Color.web("#000"));
        l10.setTextFill(Color.web("#000"));
        l6.setTextFill(Color.web("#000"));
        l7.setTextFill(Color.web("#000"));
        l8.setTextFill(Color.web("#000"));
        l9.setTextFill(Color.web("#000"));
        l10.setTextFill(Color.web("#000"));
        l11.setTextFill(Color.web("#000"));
        l12.setTextFill(Color.web("#000"));
        l13.setTextFill(Color.web("#000"));
        l14.setTextFill(Color.web("#000"));
        l15.setTextFill(Color.web("#000"));
        l16.setTextFill(Color.web("#000"));
        l17.setTextFill(Color.web("#000"));
            
        if(selected.equals("one"))
        {
            a1.setStyle("-fx-background-color: #6c757d;-fx-effect:dropshadow(three-pass-box, #ccc, 10, 0, 0, 0);");
            l1.setTextFill(Color.web("#fff"));
            l2.setTextFill(Color.web("#fff"));
            l3.setTextFill(Color.web("#fff"));
            l4.setTextFill(Color.web("#fff"));
            l5.setTextFill(Color.web("#fff"));
        } else if(selected.equals("tow"))
        {
            a2.setStyle("-fx-background-color: #6c757d;-fx-effect:dropshadow(three-pass-box, #ccc, 10, 0, 0, 0);");
            l6.setTextFill(Color.web("#fff"));
            l7.setTextFill(Color.web("#fff"));
            l8.setTextFill(Color.web("#fff"));
            l9.setTextFill(Color.web("#fff"));
            l10.setTextFill(Color.web("#fff"));
        } else if(selected.equals("three"))
        {
            a3.setStyle("-fx-background-color: #6c757d;-fx-effect:dropshadow(three-pass-box, #ccc, 10, 0, 0, 0);");
            l11.setTextFill(Color.web("#fff"));
            l12.setTextFill(Color.web("#fff"));
            l13.setTextFill(Color.web("#fff"));
        } else if(selected.equals("four"))
        {
            a4.setStyle("-fx-background-color: #6c757d;-fx-effect:dropshadow(three-pass-box, #ccc, 10, 0, 0, 0);");
            l14.setTextFill(Color.web("#fff"));
            l15.setTextFill(Color.web("#fff"));
            l16.setTextFill(Color.web("#fff"));
            l17.setTextFill(Color.web("#fff"));
        }
        
        

        switch (selected) {
            case "one":
        
        //messageME.setText("");
        //messageNE.setText("");
        //messagePE.setText("");
        //messageDE.setText("");
        //messageAE.setText("");
        
        if(Matricule_etu.getText().equals(""))
        {
            Matricule_etu.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //messageME.setText("Matricule is empty !");
            //messageME.setTextFill(Color.rgb(210, 39, 30));
        } else {
            Matricule_etu.setStyle("-fx-text-box-border: #28a745; -fx-focus-color: #28a745;");
        }
        
        if(nom_etu.getText().equals(""))
        {            
            nom_etu.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //messageNE.setText("Nom is empty !");
            //messageNE.setTextFill(Color.rgb(210, 39, 30));
        } else {
            nom_etu.setStyle("-fx-text-box-border: #28a745; -fx-focus-color: #28a745;");
        }
        
        if(prenom_etu.getText().equals(""))
        {
            prenom_etu.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //messagePE.setText("Prenome is empty !");
            //messagePE.setTextFill(Color.rgb(210, 39, 30));
        } else {
            prenom_etu.setStyle("-fx-text-box-border: #28a745; -fx-focus-color: #28a745;");
        }
        
        if(date_naissance.getValue().equals(null))
        {
            date_naissance.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545; -fx-border-width: 1px 1px 1px 1px;");
            //messageDE.setText("Date naissance is empty !");
            //messageDE.setTextFill(Color.rgb(210, 39, 30));
        } else {
            date_naissance.setStyle("-fx-text-box-border: #28a745; -fx-focus-color: #28a745; -fx-border-width: 1px 1px 1px 1px;");
        }
        
        if(Addresse.getText().equals(""))
        {
            Addresse.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545; -fx-border-width: 1px 1px 1px 1px;");
            //messageAE.setText("Addresse is empty !");
            //messageAE.setTextFill(Color.rgb(210, 39, 30));
        } else {
            Addresse.setStyle("-fx-text-box-border: #28a745; -fx-focus-color: #28a745; -fx-border-width: 1px 1px 1px 1px;");
        }
        
        if(!Matricule_etu.getText().equals(""))
        {
            if( duplicateMatricule(connection,Matricule_etu.getText()) )
            {
                Matricule_etu.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
                //messageME.setText("duplicate matricule !");
                //messageME.setTextFill(Color.rgb(210, 39, 30));
            } else {
                Matricule_etu.setStyle("-fx-text-box-border: #28a745; -fx-focus-color: #28a745;");
            }
           if(!nom_etu.getText().equals(""))
           {  
               nom_etu.setStyle("-fx-text-box-border: #28a745; -fx-focus-color: #28a745;");
                if(!prenom_etu.getText().equals(""))
                {  
                    prenom_etu.setStyle("-fx-text-box-border: #28a745; -fx-focus-color: #28a745;");
                    if(!date_naissance.getValue().equals(null))
                    {  
                        date_naissance.setStyle("-fx-text-box-border: #28a745; -fx-focus-color: #28a745;");
                        if(!Addresse.getText().equals(""))
                        {  
                            Addresse.setStyle("-fx-text-box-border: #28a745; -fx-focus-color: #28a745;");
                            String sql = "INSERT INTO etudiant (MATRICULE_ETU,NOM_ETU,PRENOM_ETU,DATE_NAISSANCE,ADDRESSE) VALUES (?,?,?,?,?)";
                            PreparedStatement ps = (PreparedStatement) connection.prepareStatement(sql);
                            ps.setString(1, Matricule_etu.getText());
                            ps.setString(2, nom_etu.getText());
                            ps.setString(3, prenom_etu.getText());
                            ps.setString(4, date_naissance.getValue().toString());
                            ps.setString(5, Addresse.getText());
                            ps.executeUpdate();
                            insertResult1.setText("Etudiant added successfully !");
                            insertResult1.setTextFill(Color.GREEN);
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
            Matricule_etu_unit.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //messageME.setText("Matricule is empty !");
            //messageME.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(code_unit.getText().equals(""))
        {
            code_unit.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //messageNE.setText("Nom is empty !");
            //messageNE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(note_cc.getText().equals(""))
        {
            note_cc.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //messagePE.setText("Prenome is empty !");
            //messagePE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(note_tp.getText().equals(""))
        {
            note_tp.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //messageDE.setText("Date naissance is empty !");
            //messageDE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(note_examen.getText().equals(""))
        {
            note_examen.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //messageAE.setText("Addresse is empty !");
            //messageAE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(!Matricule_etu_unit.getText().equals(""))
        {
            if( duplicateMatriculeEtUnit(connection,Matricule_etu_unit.getText()) )
            {
                Matricule_etu_unit.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
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
                            insertResult2.setText("Etudiant unite added successfully !");
                            insertResult2.setTextFill(Color.GREEN);
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
            Matricule_Ens.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //messageME.setText("Matricule is empty !");
            //messageME.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(nom_ens.getText().equals(""))
        {
            nom_ens.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //messageNE.setText("Nom is empty !");
            //messageNE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(prenom_ens.getText().equals(""))
        {
            prenom_ens.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //messagePE.setText("Prenome is empty !");
            //messagePE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(!Matricule_Ens.getText().equals(""))
        {
            if( duplicateMatriculeEns(connection,Matricule_Ens.getText()) )
            {
                Matricule_Ens.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
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
                    insertResult3.setText("Enseignant added successfully !");
                    insertResult3.setTextFill(Color.GREEN);
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
            code_unit_u.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //messageME.setText("Matricule is empty !");
            //messageME.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(libelle.getText().equals(""))
        {
            libelle.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //messageNE.setText("Nom is empty !");
            //messageNE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(nbr_heurs.getText().equals(""))
        {
            nbr_heurs.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //messagePE.setText("Prenome is empty !");
            //messagePE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(Matricule_Ens_u.getText().equals(""))
        {
            Matricule_Ens_u.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
            //messageDE.setText("Date naissance is empty !");
            //messageDE.setTextFill(Color.rgb(210, 39, 30));
        }
        
        if(!code_unit_u.getText().equals(""))
        {
            if( duplicateMatriculeCodeUnite(connection,code_unit_u.getText()) )
            {
                code_unit_u.setStyle("-fx-text-box-border: #dc3545; -fx-focus-color: #dc3545;");
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
                            insertResult4.setText("Unite added successfully !");
                            insertResult4.setTextFill(Color.GREEN);
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
        
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        etudiantMat.setCellValueFactory(new PropertyValueFactory<>("MATRICULE_ETU"));
        etudiantNom.setCellValueFactory(new PropertyValueFactory<>("NOM_ETU"));
        etudiantPrenom.setCellValueFactory(new PropertyValueFactory<>("PRENOM_ETU"));
        etudiantDn.setCellValueFactory(new PropertyValueFactory<>("DATE_NAISSANCE"));
        etudiantAd.setCellValueFactory(new PropertyValueFactory<>("ADDRESSE"));
        
        data = FXCollections.observableArrayList();

        Connection connection;
        try {
        
        connection = Database.getConnectionDb();
            
        String sql = "SELECT * FROM etudiant";
        
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        
        while (rs.next()) {	
                data.add(new Etudiant(rs.getInt("MATRICULE_ETU"),rs.getString("NOM_ETU"),rs.getString("PRENOM_ETU"),rs.getString("DATE_NAISSANCE"),rs.getString("ADDRESSE")));
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        etudiantTable.setItems(data);
         
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        etudiantUnitMatEtu.setCellValueFactory(new PropertyValueFactory<>("MATRICULE_ETU"));
        etudiantUnitCode.setCellValueFactory(new PropertyValueFactory<>("CODE_UNITE"));
        etudiantUnitNoteCc.setCellValueFactory(new PropertyValueFactory<>("NOTE_CC"));
        etudiantUnitNoteTp.setCellValueFactory(new PropertyValueFactory<>("NOTE_TP"));
        etudiantUnitNoteExamen.setCellValueFactory(new PropertyValueFactory<>("NOTE_EXAMEN"));
        
        etudiantUnitData = FXCollections.observableArrayList();
        
        try {
        
        connection = Database.getConnectionDb();
            
        String sql = "SELECT * FROM etudiantunite";
        
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        
        while (rs.next()) {	
                etudiantUnitData.add(new EtudiantUnite(rs.getInt("MATRICULE_ETU"),rs.getString("CODE_UNITE"),rs.getInt("NOTE_CC"),rs.getInt("NOTE_TP"),rs.getInt("NOTE_EXAMEN")));
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        etudiantUnit.setItems(etudiantUnitData);
        
        
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        enseignantMatTable.setCellValueFactory(new PropertyValueFactory<>("MATRICULE_ENS"));
        enseignantNomTable.setCellValueFactory(new PropertyValueFactory<>("NOM_ENS"));
        enseignantPrenomTable.setCellValueFactory(new PropertyValueFactory<>("PRENOM_ENS"));
        
        etudiantData = FXCollections.observableArrayList();   
    
        try {
        
        connection = Database.getConnectionDb();
            
        String sql = "SELECT * FROM enseignant";
        
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        
        while (rs.next()) {	
                etudiantData.add(new Enseignant(rs.getInt("MATRICULE_ENS"),rs.getString("NOM_ENS"),rs.getString("PRENOM_ENS")));
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        enseignant.setItems(etudiantData);
        
        
        
        
        //make sure the property value factory should be exactly same as the e.g getStudentId from your model class
        uniteCu.setCellValueFactory(new PropertyValueFactory<>("CODE_UNITE"));
        uniteLb.setCellValueFactory(new PropertyValueFactory<>("LIBELLE"));
        uniteNh.setCellValueFactory(new PropertyValueFactory<>("NBR_HEURES"));
        uniteMe.setCellValueFactory(new PropertyValueFactory<>("MATRICULE_ENS"));
        
        uniteData = FXCollections.observableArrayList();    
    
        try {
        
        connection = Database.getConnectionDb();
            
        String sql = "SELECT * FROM unite";
        
        PreparedStatement preparedStatement = (PreparedStatement) connection.prepareStatement(sql);
        ResultSet rs = preparedStatement.executeQuery(sql );
        
        while (rs.next()) {	
                uniteData.add(new Unite(rs.getString("CODE_UNITE"),rs.getString("LIBELLE"),rs.getInt("NBR_HEURES"),rs.getInt("MATRICULE_ENS")));
        }
        
        } catch (SQLException ex) {
            Logger.getLogger(HomeController.class.getName()).log(Level.SEVERE, null, ex);
        }
                
        unite.setItems(uniteData);
        
        
        
    } 
    

    
}
