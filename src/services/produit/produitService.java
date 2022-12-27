package services.produit;

import entities.Client;
import entities.Commande;
import entities.Produit;

import java.sql.SQLException;
import java.util.List;

public interface produitService {
    void addProduit(Produit p) throws SQLException;
    void deleteProduit(Produit p) throws SQLException;
    void updateProduit(Produit p) throws SQLException;
    List<Produit> getProduits() throws SQLException;
    List<Produit> getProduitsByCommande(Commande c) throws SQLException;
}
