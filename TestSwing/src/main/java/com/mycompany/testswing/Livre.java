/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testswing;

/**
 *
 * @author JOSE MOKENI
 */

import java.sql.*;
import javax.swing.*;
public class Livre {
    private int id;
    private String nom;
    private String auteur;
    private String categorie;
    private int pages;
    private int stock;
    public Livre(int id, String nom, String auteur, String categorie, int pages, int stock){
        this.id = id;
        this.auteur = auteur;
        this.categorie = categorie;
        this.nom = nom;
        this.pages = pages;
        this.stock = stock;
    }
    public Livre(String nom, String auteur, int stock){
        this.id = 0;
        this.nom = nom;
        this.auteur = auteur;
        this.stock = stock;
        this.categorie = "";
        this.stock = stock;
        this.pages = 0;
    }
    public Livre(String nom, String auteur, String categorie, int stock){
        this.id = 0;
        this.nom = nom;
        this.auteur = auteur;
        this.stock = stock;
        this.categorie = categorie;
        this.stock = stock;
        this.pages = 0;
    }
    public Livre(String nom, String auteur, int pages, int stock){
        this.id = 0;
        this.nom = nom;
        this.auteur = auteur;
        this.stock = stock;
        this.categorie = "";
        this.stock = stock;
        this.pages = pages;
    }
    public Livre(String nom, String auteur,String categorie, int pages, int stock){
        this.id = 0;
        this.nom = nom;
        this.auteur = auteur;
        this.stock = stock;
        this.categorie = categorie;
        this.stock = stock;
        this.pages = pages;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    public void addLivre() throws SQLException{
        Connection c = Connector.connecterBDD();
        
        String sql = "INSERT INTO livres (nom, auteur, categorie, pages, stock) values (?, ?, ?, ?, ?)";
        PreparedStatement prepStatement = c.prepareStatement(sql);
        prepStatement.setString(1, this.nom);
        prepStatement.setString(2, this.auteur);
        if (this.categorie.isBlank()){
            prepStatement.setString(3, null);
        } else {
            prepStatement.setString(3, this.categorie);
        }
        if (this.pages == 0){
            prepStatement.setInt(4, Integer.parseInt("0"));
        } else {
            prepStatement.setInt(4, this.pages);
        }
        prepStatement.setInt(5, this.stock);
        prepStatement.executeUpdate();

        
    }
    public void deleteLivre() throws SQLException{
        Connection c = Connector.connecterBDD();
        String sql = "DELETE FROM livres WHERE id = ?";
        PreparedStatement prepStatement = c.prepareStatement(sql);
        prepStatement.setInt(1, this.id);
        prepStatement.executeUpdate();
        
    }
    public void modifyLivre() throws SQLException{
        Connection c = Connector.connecterBDD();
        String sql = "UPDATE livres set nom = ?, auteur = ?, categorie = ?, pages = ?, stock = ? WHERE id = ?";
        PreparedStatement prepStatement = c.prepareStatement(sql);
        prepStatement.setInt(6, this.id);
        prepStatement.setString(1, this.nom);
        prepStatement.setString(2, this.auteur);
        if (this.categorie == null){
            prepStatement.setString(3, null);
        } else {
            prepStatement.setString(3, this.categorie);
        }
        if (this.pages == 0){
            prepStatement.setInt(4, Integer.parseInt("0"));
        } else {
            prepStatement.setInt(4, this.pages);
        }
        prepStatement.setInt(5, this.stock);
        prepStatement.executeUpdate();
        
    }
    
        
    
}
