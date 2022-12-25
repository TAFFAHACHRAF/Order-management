package project.tasks_management.dao.produit;

import project.tasks_management.dao.SingletonConnexionDB;
import project.tasks_management.entities.Commande;
import project.tasks_management.entities.Produit;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class produitDmpl implements produitDAO{
    @Override
    public List<Produit> findAll() throws SQLException {
        List<Produit> produits = new ArrayList<>();
        Connection connection=new SingletonConnexionDB().getConnexion();
        Statement stmt = null;
        ResultSet rs = null;
        try {
            stmt = connection.createStatement();
            rs = stmt.executeQuery("SELECT * FROM produit");
            while (rs.next()) {
                Produit p=new Produit();
                p.setID(rs.getLong("ID"));
                p.setNOM(rs.getString("NOM"));
                p.setDESCRIPTION(rs.getString("DESCRIPTION"));
                p.setPRIX(rs.getInt("PRIX"));
                p.setQUANTITE(rs.getInt("QUANTITE"));
                produits.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }

    @Override
    public Produit findOne(int id) throws SQLException {
        Produit produit = new Produit();
        Connection connection=new SingletonConnexionDB().getConnexion();
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try {
            pstm=connection.prepareStatement("SELECT * FROM produit where ID=?");
            pstm.setLong(1, id);
            rs=pstm.executeQuery();
            if(rs.next()) {
                produit.setID(rs.getLong("ID"));
                produit.setNOM(rs.getString("NOM"));
                produit.setDESCRIPTION(rs.getString("DESCRIPTION"));
                produit.setPRIX(rs.getFloat("PRIX"));
                produit.setQUANTITE(rs.getInt("QUANTITE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produit;
    }

    @Override
    public Produit save(Produit p) throws SQLException {
        Connection connection=new SingletonConnexionDB().getConnexion();
        PreparedStatement pstm=null;
        try {
            pstm=connection.prepareStatement("insert into produit (NOM,DESCRIPTION,PRIX,QUANTITE) values (?,?,?,?)");
            pstm.setString(1,p.getNOM());
            pstm.setString(2,p.getDESCRIPTION());
            pstm.setFloat(3,p.getPRIX());
            pstm.setInt(4,p.getQUANTITE());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public boolean delete(Produit p) throws SQLException {
        Connection connection=new SingletonConnexionDB().getConnexion();
        PreparedStatement pstm=null;
        try {
            pstm=connection.prepareStatement("delete from produit where ID=?");
            pstm.setLong(1,p.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Produit update(Produit p) throws SQLException {
        Connection connection=new SingletonConnexionDB().getConnexion();
        PreparedStatement pstm=null;
        try {
            pstm=connection.prepareStatement("update produit set NOM=?,DESCRIPTION=?,PRIX=?,QUANTITE=? where ID=?");
            pstm.setString(1,p.getNOM());
            pstm.setString(2,p.getDESCRIPTION());
            pstm.setFloat(3,p.getPRIX());
            pstm.setInt(4,p.getQUANTITE());
            pstm.setLong(5,p.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return p;
    }

    @Override
    public List<Produit> getProduitsByCommande(Commande c) {
        List<Produit> produits=new ArrayList<>();
        Connection connection = new SingletonConnexionDB().getConnexion();
        PreparedStatement pstm = null;
        ResultSet rs = null;
        try {
            pstm = connection.prepareStatement("SELECT C.ID,DATE_COMMANDE,CLIENT_ID FROM commande COM,produit PRO,contient CON where CON.COMMANDE_ID=? and CON.PRODUIT_ID=PRO.ID");
            pstm.setLong(1, c.getID());
            rs = pstm.executeQuery();
            if (rs.next()) {
                Produit p = new Produit();
                p.setID(rs.getLong("ID"));
                p.setNOM(rs.getString("NOM"));
                p.setDESCRIPTION(rs.getString("DESCRIPTION"));
                p.setPRIX(rs.getInt("PRIX"));
                p.setQUANTITE(rs.getInt("QUANTITE"));
                produits.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produits;
    }
}
