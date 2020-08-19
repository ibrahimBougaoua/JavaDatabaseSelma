/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadatabaseselma;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author b
 */
public class Etudiant {
    
    private SimpleIntegerProperty MATRICULE_ETU;
    private SimpleStringProperty  NOM_ETU;
    private SimpleStringProperty  PRENOM_ETU;
    private SimpleStringProperty  DATE_NAISSANCE;
    private SimpleStringProperty  ADDRESSE;
    
    public Etudiant()
    {
        
    }
    
    public Etudiant(int MATRICULE_ETU,String NOM_ETU,String PRENOM_ETU,String DATE_NAISSANCE,String ADDRESSE)
    {
        this.MATRICULE_ETU = new SimpleIntegerProperty(MATRICULE_ETU);
        this.NOM_ETU = new SimpleStringProperty(NOM_ETU);
        this.PRENOM_ETU = new SimpleStringProperty(PRENOM_ETU);
        this.DATE_NAISSANCE = new SimpleStringProperty(DATE_NAISSANCE);
        this.ADDRESSE = new SimpleStringProperty(ADDRESSE);
    }
    
    
    
}
