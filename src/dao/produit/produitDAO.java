package project.tasks_management.dao.produit;

import project.tasks_management.dao.Dao;
import project.tasks_management.entities.Commande;
import project.tasks_management.entities.Produit;

import java.util.List;

public interface produitDAO extends Dao<Produit> {
    List<Produit> getProduitsByCommande(Commande c);
}
