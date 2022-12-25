package project.tasks_management.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Commande implements Serializable {
    private Long ID= Long.valueOf(0);
    private Date DATE_COMMANDE=new Date();
    private Client CLIENT=new Client();
    public Commande() {}

    public Commande(Long ID, Date DATE_COMMANDE,Client CLIENT) {
        this.ID = ID;
        this.DATE_COMMANDE = DATE_COMMANDE;
        this.CLIENT=CLIENT;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Date getDATE_COMMANDE() {
        return DATE_COMMANDE;
    }
    public void setDATE_COMMANDE(Date DATE_COMMANDE) {
        this.DATE_COMMANDE = DATE_COMMANDE;
    }

    public Client getCLIENT() {
        return CLIENT;
    }

    public void setCLIENT(Client CLIENT) {
        this.CLIENT = CLIENT;
    }
}
