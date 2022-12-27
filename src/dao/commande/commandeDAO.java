package dao.commande;


import dao.Dao;
import entities.Commande;
import entities.Produit;

import java.util.List;

public interface commandeDAO extends Dao<Commande> {
    List<Commande> getCommandesByProduit(Produit p);
}
