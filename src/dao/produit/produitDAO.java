package dao.produit;

import dao.Dao;
import entities.Commande;
import entities.Produit;

import java.util.List;

public interface produitDAO extends Dao<Produit> {
    List<Produit> getProduitsByCommande(Commande c);
}
