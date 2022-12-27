package services.commande;

import dao.commande.commandeDAO;
import entities.Commande;
import entities.Produit;
import services.produit.commandeService;

import java.sql.SQLException;
import java.util.List;

public class commandeServiceImpl implements commandeService {
    commandeDAO cda;
    @Override
    public void addCommande(Commande p) throws SQLException {
        cda.save(p);
    }

    @Override
    public void deleteCommande(Commande p) throws SQLException {
        cda.delete(p);
    }

    @Override
    public void updateCommande(Commande p) throws SQLException {
        cda.update(p);
    }

    @Override
    public List<Commande> getCommandes() throws SQLException {
        return cda.findAll();
    }

    @Override
    public List<Commande> getCommandesByProduit(Produit p) throws SQLException {
        return cda.getCommandesByProduit(p);
    }
}
