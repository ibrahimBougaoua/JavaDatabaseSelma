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
public class Unite {
    
    private SimpleStringProperty CODE_UNITE ;
    private SimpleStringProperty LIBELLE;
    private SimpleIntegerProperty NBR_HEURES;
    private SimpleIntegerProperty MATRICULE_ENS ;
    
    public Unite()
    {
        
    }
    
    public Unite(String CODE_UNITE ,String LIBELLE,int NBR_HEURES,int MATRICULE_ENS)
    {
        this.CODE_UNITE = new SimpleStringProperty(CODE_UNITE);
        this.LIBELLE = new SimpleStringProperty(LIBELLE);
        this.NBR_HEURES = new SimpleIntegerProperty(NBR_HEURES);
        this.MATRICULE_ENS  = new SimpleIntegerProperty(MATRICULE_ENS );
    }

    /**
     * @return the CODE_UNITE
     */
    public String getCODE_UNITE() {
        return CODE_UNITE.get();
    }

    /**
     * @param CODE_UNITE the CODE_UNITE to set
     */
    public void setCODE_UNITE(SimpleStringProperty CODE_UNITE) {
        this.CODE_UNITE = CODE_UNITE;
    }

    /**
     * @return the LIBELLE
     */
    public String getLIBELLE() {
        return LIBELLE.get();
    }

    /**
     * @param LIBELLE the LIBELLE to set
     */
    public void setLIBELLE(SimpleStringProperty LIBELLE) {
        this.LIBELLE = LIBELLE;
    }

    /**
     * @return the NBR_HEURES
     */
    public int getNBR_HEURES() {
        return NBR_HEURES.get();
    }

    /**
     * @param NBR_HEURES the NBR_HEURES to set
     */
    public void setNBR_HEURES(SimpleIntegerProperty NBR_HEURES) {
        this.NBR_HEURES = NBR_HEURES;
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
    
}
