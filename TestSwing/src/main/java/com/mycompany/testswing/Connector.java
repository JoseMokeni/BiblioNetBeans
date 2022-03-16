/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testswing;
import java.sql.*;
/**
 *
 * @author JOSE MOKENI
 */
public class Connector {
    public static Connection connecterBDD(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver ok");
            String url = "jdbc:mysql://localhost:3306/biblio";
            String username = "root";
            String pwd = "root";
            Connection cn = DriverManager.getConnection(url, username, pwd);
            System.out.println("Connexion etablie");
            return cn;
        } catch (ClassNotFoundException | SQLException e){
            return null;
        }

    }
}
