package project.tasks_management.dao.commande;

import project.tasks_management.dao.Dao;
import project.tasks_management.entities.Commande;
import project.tasks_management.entities.Produit;

import java.util.List;

public interface commandeDAO extends Dao<Commande> {
    List<Commande> getCommandesByProduit(Produit p);
}
