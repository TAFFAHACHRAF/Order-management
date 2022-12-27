package dao;

import dao.client.clientDmpl;
import dao.produit.produitDmpl;
import entities.Produit;

import java.sql.SQLException;

public class Test {
    public static void main(String args[]) throws SQLException {
        produitDmpl p=new produitDmpl();
        System.out.println(p.findAll().size());
        p.save(new Produit(1L,"","",4,5));
        p.delete(new Produit(2L,"","",4,5));
        p.update(new Produit(3L,"raja","",4,5));
        System.out.println(p.findOne(3).getPRIX());

        clientDmpl c=new clientDmpl();
        System.out.println(c.findOne(2).getEMAIL());
    }
}
