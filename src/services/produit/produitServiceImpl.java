package project.tasks_management.services.produit;

import project.tasks_management.dao.produit.produitDAO;
import project.tasks_management.entities.Commande;
import project.tasks_management.entities.Produit;

import java.sql.SQLException;
import java.util.List;

public class produitServiceImpl implements produitService{
    produitDAO pdo;
    @Override
    public void addProduit(Produit p) throws SQLException {
        pdo.save(p);
    }

    @Override
    public void deleteProduit(Produit p) throws SQLException {
        pdo.delete(p);
    }

    @Override
    public void updateProduit(Produit p) throws SQLException {
        pdo.update(p);
    }

    @Override
    public List<Produit> getProduits() throws SQLException {
        return pdo.findAll();
    }

    @Override
    public List<Produit> getProduitsByCommande(Commande c) throws SQLException {
        return pdo.getProduitsByCommande(c);
    }
}
