package dao.client;

import dao.SingletonConnexionDB;
import entities.Client;
import entities.Commande;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class clientDmpl implements clientDAO {
    @Override
    public List<Client> findAll() throws SQLException {
        List<Client> Clients = new ArrayList<>();
        Connection connection=new SingletonConnexionDB().getConnexion();
        Statement stmt = null;
        PreparedStatement ptmt = null;
        ResultSet rs1 = null;
        ResultSet rs2 = null;
        List<Client> clients = new ArrayList<>();
        List<Commande> commandes = new ArrayList<>();
        try {
            stmt = connection.createStatement();
            rs1 = stmt.executeQuery("SELECT * FROM Client");

            ptmt = connection.prepareStatement("SELECT * FROM Commande where CLIENT_ID=?");
            while (rs1.next()) {
                Client client=new Client();
                client.setID(rs1.getLong("ID"));
                client.setNOM(rs1.getString("NOM"));
                client.setPRENOM(rs1.getString("PRENOM"));
                client.setTEL(rs1.getString("TEL"));
                client.setEMAIL(rs1.getString("EMAIL"));
                client.setADRESSE(rs1.getString("ADRESSE"));

                ptmt.setLong(1,rs1.getLong("ID"));
                rs2 = ptmt.executeQuery();
                if(rs2.next()) {
                    Commande c=new Commande();
                    c.setID(rs2.getLong("ID"));
                    c.setDATE_COMMANDE(rs2.getDate("DATE_COMMANDE"));
                    c.getCLIENT().setID(rs2.getLong("CLIENT_ID"));
                    commandes.add(c);
                }
                client.setCOMMANDES(commandes);
                clients.add(client);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return clients;
    }

    @Override
    public Client findOne(int id) throws SQLException {
        Client client = new Client();
        Connection connection=new SingletonConnexionDB().getConnexion();
        PreparedStatement pstm=null;
        PreparedStatement ptmt = null;
        ResultSet rs=null;
        ResultSet rs2=null;
        List<Commande> commandes = new ArrayList<>();
        try {
            pstm=connection.prepareStatement("SELECT * FROM client where ID=?");
            ptmt = connection.prepareStatement("SELECT * FROM Commande where CLIENT_ID=?");
            pstm.setLong(1, id);
            rs=pstm.executeQuery();
            if(rs.next()) {
                client.setID(rs.getLong("ID"));
                client.setNOM(rs.getString("NOM"));
                client.setPRENOM(rs.getString("PRENOM"));
                client.setTEL(rs.getString("TEL"));
                client.setEMAIL(rs.getString("EMAIL"));
                client.setADRESSE(rs.getString("ADRESSE"));

                ptmt.setLong(1,rs.getLong("ID"));
                rs2 = ptmt.executeQuery();
                if(rs2.next()) {
                    Commande c=new Commande();
                    c.setID(rs2.getLong("ID"));
                    c.setDATE_COMMANDE(rs2.getDate("DATE_COMMANDE"));
                    c.getCLIENT().setID(rs2.getLong("CLIENT_ID"));
                    commandes.add(c);
                }
                client.setCOMMANDES(commandes);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return client;
    }

    @Override
    public Client save(Client c) throws SQLException {
        Connection connection=new SingletonConnexionDB().getConnexion();
        PreparedStatement pstm=null;
        try {
            pstm=connection.prepareStatement("insert into client (NOM,PRENOM,TEL,EMAIL,ADRESSE) values (?,?,?,?,?)");
            pstm.setString(1,c.getNOM());
            pstm.setString(2,c.getPRENOM());
            pstm.setString(3,c.getTEL());
            pstm.setString(4,c.getEMAIL());
            pstm.setString(5,c.getADRESSE());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return c;
    }

    @Override
    public boolean delete(Client c) throws SQLException {
        Connection connection=new SingletonConnexionDB().getConnexion();
        PreparedStatement pstm=null;
        try {
            pstm=connection.prepareStatement("delete from client where ID=?");
            pstm.setLong(1,c.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Client update(Client c) throws SQLException {
        Connection connection=new SingletonConnexionDB().getConnexion();
        PreparedStatement pstm=null;
        try {
            pstm=connection.prepareStatement("update client set NOM=?,PRENOM=?,TEL=?,EMAIL=?,ADRESSE where ID=?");
            pstm.setString(1,c.getNOM());
            pstm.setString(2,c.getPRENOM());
            pstm.setString(3,c.getTEL());
            pstm.setString(4,c.getEMAIL());
            pstm.setString(5,c.getADRESSE());
            pstm.setLong(6,c.getID());
            pstm.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
        return c;
    }
}
