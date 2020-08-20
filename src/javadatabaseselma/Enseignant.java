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
public class Enseignant {
    
    private SimpleIntegerProperty MATRICULE_ENS;
    private SimpleStringProperty NOM_ENS;
    private SimpleStringProperty PRENOM_ENS;
    
    public Enseignant()
    {
        
    }
    
    public Enseignant(int MATRICULE_ENS,String NOM_ENS,String PRENOM_ENS)
    {
        this.MATRICULE_ENS = new SimpleIntegerProperty(MATRICULE_ENS);
        this.NOM_ENS = new SimpleStringProperty(NOM_ENS);
        this.PRENOM_ENS = new SimpleStringProperty(PRENOM_ENS);;
    }

    /**
     * @return the MATRICULE_ENS
     */
    public int getMATRICULE_ENS() {
        return MATRICULE_ENS.get();
    }

    /**
     * @param MATRICULE_ENS the MATRICULE_ENS to set
     */
    public void setMATRICULE_ENS(SimpleIntegerProperty MATRICULE_ENS) {
        this.MATRICULE_ENS = MATRICULE_ENS;
    }

    /**
     * @return the NOM_ENS
     */
    public String getNOM_ENS() {
        return NOM_ENS.get();
    }

    /**
     * @param NOM_ENS the NOM_ENS to set
     */
    public void setNOM_ENS(SimpleStringProperty NOM_ENS) {
        this.NOM_ENS = NOM_ENS;
    }

    /**
     * @return the PRENOM_ENS
     */
    public String getPRENOM_ENS() {
        return PRENOM_ENS.get();
    }

    /**
     * @param PRENOM_ENS the PRENOM_ENS to set
     */
    public void setPRENOM_ENS(SimpleStringProperty PRENOM_ENS) {
        this.PRENOM_ENS = PRENOM_ENS;
    }

}
