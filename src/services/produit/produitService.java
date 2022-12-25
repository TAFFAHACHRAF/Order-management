package project.tasks_management.services.produit;

import project.tasks_management.entities.Client;
import project.tasks_management.entities.Commande;
import project.tasks_management.entities.Produit;

import java.sql.SQLException;
import java.util.List;

public interface produitService {
    void addProduit(Produit p) throws SQLException;
    void deleteProduit(Produit p) throws SQLException;
    void updateProduit(Produit p) throws SQLException;
    List<Produit> getProduits() throws SQLException;
    List<Produit> getProduitsByCommande(Commande c) throws SQLException;
}
