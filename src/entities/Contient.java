package project.tasks_management.entities;

public class Contient {
    private Long ID= Long.valueOf(0);
    private Long QUANTITE= Long.valueOf(0);
    private Produit PRODUIT=new Produit();
    private Commande COMMANDE=new Commande();

    Contient() {}

    public Contient(Long ID, Long QUANTITE, Produit PRODUIT, Commande COMMANDE) {
        this.ID = ID;
        this.QUANTITE = QUANTITE;
        this.PRODUIT = PRODUIT;
        this.COMMANDE = COMMANDE;
    }

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public Long getQUANTITE() {
        return QUANTITE;
    }

    public void setQUANTITE(Long QUANTITE) {
        this.QUANTITE = QUANTITE;
    }

    public Produit getPRODUIT() {
        return PRODUIT;
    }

    public void setPRODUIT(Produit PRODUIT) {
        this.PRODUIT = PRODUIT;
    }

    public Commande getCOMMANDE() {
        return COMMANDE;
    }

    public void setCOMMANDE(Commande COMMANDE) {
        this.COMMANDE = COMMANDE;
    }
}
