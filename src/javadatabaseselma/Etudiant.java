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

    /**
     * @return the MATRICULE_ETU
     */
    public int getMATRICULE_ETU() {
        return MATRICULE_ETU.get();
    }

    /**
     * @param MATRICULE_ETU the MATRICULE_ETU to set
     */
    public void setMATRICULE_ETU(SimpleIntegerProperty MATRICULE_ETU) {
        this.MATRICULE_ETU = MATRICULE_ETU;
    }

    /**
     * @return the NOM_ETU
     */
    public String getNOM_ETU() {
        return NOM_ETU.get();
    }

    /**
     * @param NOM_ETU the NOM_ETU to set
     */
    public void setNOM_ETU(SimpleStringProperty NOM_ETU) {
        this.NOM_ETU = NOM_ETU;
    }

    /**
     * @return the PRENOM_ETU
     */
    public String getPRENOM_ETU() {
        return PRENOM_ETU.get();
    }

    /**
     * @param PRENOM_ETU the PRENOM_ETU to set
     */
    public void setPRENOM_ETU(SimpleStringProperty PRENOM_ETU) {
        this.PRENOM_ETU = PRENOM_ETU;
    }

    /**
     * @return the DATE_NAISSANCE
     */
    public String getDATE_NAISSANCE() {
        return DATE_NAISSANCE.get();
    }

    /**
     * @param DATE_NAISSANCE the DATE_NAISSANCE to set
     */
    public void setDATE_NAISSANCE(SimpleStringProperty DATE_NAISSANCE) {
        this.DATE_NAISSANCE = DATE_NAISSANCE;
    }

    /**
     * @return the ADDRESSE
     */
    public String getADDRESSE() {
        return ADDRESSE.get();
    }

    /**
     * @param ADDRESSE the ADDRESSE to set
     */
    public void setADDRESSE(SimpleStringProperty ADDRESSE) {
        this.ADDRESSE = ADDRESSE;
    }
    
    
    
}
