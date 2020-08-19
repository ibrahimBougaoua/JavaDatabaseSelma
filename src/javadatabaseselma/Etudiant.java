/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javadatabaseselma;

/**
 *
 * @author b
 */
public class Etudiant {
    
    private int MATRICULE_ETU;
    private String NOM_ETU;
    private String PRENOM_ETU;
    private String DATE_NAISSANCE;
    private String ADDRESSE;
    
    public Etudiant()
    {
        
    }
    
    public Etudiant(int MATRICULE_ETU,String NOM_ETU,String PRENOM_ETU,String DATE_NAISSANCE,String ADDRESSE)
    {
        this.MATRICULE_ETU = MATRICULE_ETU;
        this.NOM_ETU = NOM_ETU;
        this.PRENOM_ETU = PRENOM_ETU;
        this.DATE_NAISSANCE = DATE_NAISSANCE;
        this.ADDRESSE = ADDRESSE;
    }

    /**
     * @return the MATRICULE_ETU
     */
    public int getMATRICULE_ETU() {
        return MATRICULE_ETU;
    }

    /**
     * @param MATRICULE_ETU the MATRICULE_ETU to set
     */
    public void setMATRICULE_ETU(int MATRICULE_ETU) {
        this.MATRICULE_ETU = MATRICULE_ETU;
    }

    /**
     * @return the NOM_ETU
     */
    public String getNOM_ETU() {
        return NOM_ETU;
    }

    /**
     * @param NOM_ETU the NOM_ETU to set
     */
    public void setNOM_ETU(String NOM_ETU) {
        this.NOM_ETU = NOM_ETU;
    }

    /**
     * @return the PRENOM_ETU
     */
    public String getPRENOM_ETU() {
        return PRENOM_ETU;
    }

    /**
     * @param PRENOM_ETU the PRENOM_ETU to set
     */
    public void setPRENOM_ETU(String PRENOM_ETU) {
        this.PRENOM_ETU = PRENOM_ETU;
    }

    /**
     * @return the DATE_NAISSANCE
     */
    public String getDATE_NAISSANCE() {
        return DATE_NAISSANCE;
    }

    /**
     * @param DATE_NAISSANCE the DATE_NAISSANCE to set
     */
    public void setDATE_NAISSANCE(String DATE_NAISSANCE) {
        this.DATE_NAISSANCE = DATE_NAISSANCE;
    }

    /**
     * @return the ADDRESSE
     */
    public String getADDRESSE() {
        return ADDRESSE;
    }

    /**
     * @param ADDRESSE the ADDRESSE to set
     */
    public void setADDRESSE(String ADDRESSE) {
        this.ADDRESSE = ADDRESSE;
    }
    
    
    
}
