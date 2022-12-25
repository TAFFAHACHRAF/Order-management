package project.tasks_management.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {
    private long ID=0;
    private String NOM="";
    private String PRENOM="";
    private String TEL="";
    private String EMAIL="";
    private String ADRESSE="";
    private List<Commande> COMMANDES=new ArrayList<>();

    public Client() {}

    public Client(long ID, String NOM, String PRENOM, String TEL, String EMAIL, String ADRESSE, List<Commande> COMMANDES) {
        this.ID = ID;
        this.NOM = NOM;
        this.PRENOM = PRENOM;
        this.TEL = TEL;
        this.EMAIL = EMAIL;
        this.ADRESSE = ADRESSE;
        this.COMMANDES = COMMANDES;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    public String getPRENOM() {
        return PRENOM;
    }

    public void setPRENOM(String PRENOM) {
        this.PRENOM = PRENOM;
    }

    public String getTEL() {
        return TEL;
    }

    public void setTEL(String TEL) {
        this.TEL = TEL;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public String getADRESSE() {
        return ADRESSE;
    }

    public void setADRESSE(String ADRESSE) {
        this.ADRESSE = ADRESSE;
    }

    public List<Commande> getCOMMANDES() {
        return COMMANDES;
    }

    public void setCOMMANDES(List<Commande> COMMANDES) {
        this.COMMANDES = COMMANDES;
    }
}
