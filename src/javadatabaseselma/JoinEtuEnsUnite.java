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
    
}
