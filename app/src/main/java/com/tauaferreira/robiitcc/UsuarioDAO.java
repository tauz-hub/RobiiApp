package com.tauaferreira.robiitcc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    public static boolean VerificarUsuario(String username, String password) throws SQLException {

        String query = "Select * from USERS WHERE USERNAME = ?;";
        PreparedStatement pst = SQLDatabaseConnection.conectar().prepareStatement(query);
        pst.setString(1,username);
        ResultSet res = pst.executeQuery();

        String bdPassword  ="";
        while(res.next()){

            bdPassword = res.getString(3);
        }

        System.out.println(bdPassword);

        return bdPassword.equals(password);

    }

    public static boolean registrarUsuario(Usuario user) throws SQLException {
        boolean resposta = false;
        String query = "INSERT INTO USERS (USERNAME, EMAIL, PASSWORD) values (?, ?, ?);";
        PreparedStatement pst = SQLDatabaseConnection.conectar().prepareStatement(query);
        pst.setString(1,user.getUsername());
        pst.setString(2, user.getEmail());
        pst.setString(3, user.getPassword());

        resposta = pst.execute();
        return resposta;
    }

}
