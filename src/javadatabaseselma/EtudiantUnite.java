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
public class EtudiantUnite {
    
    private SimpleIntegerProperty MATRICULE_ETU;
    private SimpleStringProperty CODE_UNITE;
    private SimpleIntegerProperty NOTE_CC;
    private SimpleIntegerProperty NOTE_TP;
    private SimpleIntegerProperty NOTE_EXAMEN;
    
    public EtudiantUnite()
    {
        
    }
    
    public EtudiantUnite(int MATRICULE_ETU,String CODE_UNITE,int NOTE_CC,int NOTE_TP,int NOTE_EXAMEN)
    {
        this.MATRICULE_ETU = new SimpleIntegerProperty(MATRICULE_ETU);
        this.CODE_UNITE = new SimpleStringProperty(CODE_UNITE);
        this.NOTE_CC = new SimpleIntegerProperty(NOTE_CC);
        this.NOTE_TP = new SimpleIntegerProperty(NOTE_TP);
        this.NOTE_EXAMEN = new SimpleIntegerProperty(NOTE_EXAMEN);
    }

    /**
     * @return the MATRICULE_ETU
     */
    public SimpleIntegerProperty getMATRICULE_ETU() {
        return MATRICULE_ETU;
    }

    /**
     * @param MATRICULE_ETU the MATRICULE_ETU to set
     */
    public void setMATRICULE_ETU(SimpleIntegerProperty MATRICULE_ETU) {
        this.MATRICULE_ETU = MATRICULE_ETU;
    }

    /**
     * @return the CODE_UNITE
     */
    public SimpleStringProperty getCODE_UNITE() {
        return CODE_UNITE;
    }

    /**
     * @param CODE_UNITE the CODE_UNITE to set
     */
    public void setCODE_UNITE(SimpleStringProperty CODE_UNITE) {
        this.CODE_UNITE = CODE_UNITE;
    }

    /**
     * @return the NOTE_CC
     */
    public SimpleIntegerProperty getNOTE_CC() {
        return NOTE_CC;
    }

    /**
     * @param NOTE_CC the NOTE_CC to set
     */
    public void setNOTE_CC(SimpleIntegerProperty NOTE_CC) {
        this.NOTE_CC = NOTE_CC;
    }

    /**
     * @return the NOTE_TP
     */
    public SimpleIntegerProperty getNOTE_TP() {
        return NOTE_TP;
    }

    /**
     * @param NOTE_TP the NOTE_TP to set
     */
    public void setNOTE_TP(SimpleIntegerProperty NOTE_TP) {
        this.NOTE_TP = NOTE_TP;
    }

    /**
     * @return the NOTE_EXAMEN
     */
    public SimpleIntegerProperty getNOTE_EXAMEN() {
        return NOTE_EXAMEN;
    }

    /**
     * @param NOTE_EXAMEN the NOTE_EXAMEN to set
     */
    public void setNOTE_EXAMEN(SimpleIntegerProperty NOTE_EXAMEN) {
        this.NOTE_EXAMEN = NOTE_EXAMEN;
    }
    
}
