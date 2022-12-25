package project.tasks_management.dao.commande;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.entities.Commande;
import project.tasks_management.entities.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class commandeDmpl implements commandeDAO {

    @Override
    public List<Commande> findAll() throws SQLException {
        List<Commande> commandes = new ArrayList<>();
        Connection connection = new SingletonConnexionDB().getConnexion();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM commande");
            while (rs.next()) {
                Commande c = new Commande();
                c.setID(rs.getLong("ID"));
                c.setDATE_COMMANDE(rs.getDate("DATE_COMMANDE"));
                c.getCLIENT().setID(rs.getLong("CLIENT_ID"));
                commandes.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commandes;
    }

    @Override
    public Commande findOne(int id) throws SQLException {
        Commande commande = new Commande();
        Connection connection = new SingletonConnexionDB().getConnexion();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = connection.prepareStatement("SELECT * FROM commande where ID=?");
            pstm.setLong(1, id);
            rs = pstm.executeQuery();
            if (rs.next()) {
                commande.setID(rs.getLong("ID"));
                commande.setDATE_COMMANDE(rs.getDate("DATE_COMMANDE"));
                commande.getCLIENT().setID(rs.getLong("CLIENT_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commande;
    }

    @Override
    public Commande save(Commande c) throws SQLException {
        Connection connection = new SingletonConnexionDB().getConnexion();
        PreparedStatement pstm = null;
        try {
            pstm = connection.prepareStatement("insert into commande (DATE_COMMANDE,CLIENT_ID) values (?,?)");
            pstm.setDate(1, (Date) c.getDATE_COMMANDE());
            pstm.setLong(2, c.getCLIENT().getID());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public boolean delete(Commande c) throws SQLException {
        Connection connection = new SingletonConnexionDB().getConnexion();
        PreparedStatement pstm = null;
        try {
            pstm = connection.prepareStatement("delete from commande where ID=?");
            pstm.setLong(1, c.getID());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Commande update(Commande c) throws SQLException {
        Connection connection = new SingletonConnexionDB().getConnexion();
        PreparedStatement pstm = null;
        try {
            pstm = connection.prepareStatement("update produit set NOM=?,DESCRIPTION=?,PRIX=?,QUANTITE=? where ID=?");
            pstm.setDate(1, (Date) c.getDATE_COMMANDE());
            pstm.setLong(2, c.getCLIENT().getID());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public List<Commande> getCommandesByProduit(Produit p) {
        List<Commande> commandes=new ArrayList<>();
        Connection connection = new SingletonConnexionDB().getConnexion();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = connection.prepareStatement("SELECT C.ID,DATE_COMMANDE,CLIENT_ID FROM commande COM,produit PRO,contient CON where CON.PRODUIT_ID=? and CON.COMMANDE_ID=COM.ID");
            pstm.setLong(1, p.getID());
            rs = pstm.executeQuery();
            if (rs.next()) {
                Commande c = new Commande();
                c.setID(rs.getLong("ID"));
                c.setDATE_COMMANDE(rs.getDate("DATE_COMMANDE"));
                c.getCLIENT().setID(rs.getLong("CLIENT_ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return commandes;
    }
}

