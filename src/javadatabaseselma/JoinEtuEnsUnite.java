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
public class JoinEtuEnsUnite {
    
    private SimpleStringProperty NOM_ETU ;
    private SimpleStringProperty PRENOM_ETU;
    private SimpleStringProperty LIBELLE;
    private SimpleIntegerProperty moy;
    
    public JoinEtuEnsUnite(String NOM_ETU ,String PRENOM_ETU,String LIBELLE,int moy)
    {
        this.NOM_ETU = new SimpleStringProperty(NOM_ETU);
        this.PRENOM_ETU = new SimpleStringProperty(PRENOM_ETU);
        this.LIBELLE = new SimpleStringProperty(LIBELLE);
        this.moy  = new SimpleIntegerProperty(moy );
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
     * @return the moy
     */
    public int getMoy() {
        return moy.get();
    }

    /**
     * @param moy the moy to set
     */
    public void setMoy(SimpleIntegerProperty moy) {
        this.moy = moy;
    }
    
}
