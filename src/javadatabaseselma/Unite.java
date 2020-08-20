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
    
}
