package project.tasks_management.entities;

import java.io.Serializable;

public class Produit implements Serializable {
    private Long ID= Long.valueOf(0);
    private String NOM="";
    private String DESCRIPTION="";
    private float PRIX=0;
    private int QUANTITE=0;

    public Produit() {}

    public Produit(Long ID, String NOM, String DESCRIPTION, float PRIX, int QUANTITE) {
        this.ID = ID;
        this.NOM = NOM;
        this.DESCRIPTION = DESCRIPTION;
        this.PRIX = PRIX;
        this.QUANTITE = QUANTITE;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getDESCRIPTION() {
        return DESCRIPTION;
    }

    public void setDESCRIPTION(String DESCRIPTION) {
        this.DESCRIPTION = DESCRIPTION;
    }

    public float getPRIX() {
        return PRIX;
    }

    public void setPRIX(float PRIX) {
        this.PRIX = PRIX;
    }

    public int getQUANTITE() {
        return QUANTITE;
    }

    public void setQUANTITE(int QUANTITE) {
        this.QUANTITE = QUANTITE;
    }
}
