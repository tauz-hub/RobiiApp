package com.tauaferreira.robiitcc;
import android.content.Context;
import android.os.StrictMode;
import android.util.Log;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLDatabaseConnection {
    // Objeto de conexão


    static String ip = "192.168.0.11";
    static String banco = "ROBIIAPP";

    static String usuario = "sa";
    static String senha = "123456";



    public static Connection conectar() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Connection conn = null;
        String URL_CONEXAO;

        try {

            String class_driver = "net.sourceforge.jtds.jdbc.Driver";
            Class.forName(class_driver);
            URL_CONEXAO = "jdbc:jtds:sqlserver://" + ip + ";"
                    + "databaseName=" + banco + ";"
                    + "user=" + usuario + ";"
                    + "password=" + senha + ";";

            conn = DriverManager.getConnection(URL_CONEXAO);

        } catch (SQLException erro) {
            Log.d("CONEXAO_MSSQL", erro.getMessage());
        } catch (ClassNotFoundException erro) {
            Log.d("CONEXAO_MSSQL", erro.getMessage());
        } catch (Exception erro) {
            Log.d("CONEXAO_MSSQL", erro.getMessage());
        }

        return conn;
    }

//    public static Connection conectar(Context ctx) {
//        Connection conn = null;
//        try {
//            // Adicionar política para criação de thread
//            StrictMode.ThreadPolicy politica;
//            politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(politica);
//            // Verificar se Driver de Conexão esta importado no projeto
//            Class.forName("net.sourceforge.jtds.jdbc.Driver");
//            // Realiza a conexão SQL Server
//            conn = DriverManager.getConnection(
//                    "jdbc:jtds:sqlserver://192.168.107.191:1433/"+
//                            "server=DESKTOP-QS2R5D;databaseName=ROBIIAPP;user=sa;password=123456;");
//
//
//            // MYSQL
//            //Class.forName("com.mysql.jdbc.Driver");
//            /*conn = DriverManager.getConnection(
//                    "jdbc:mysql://213.190.6.64:3306/u992616056_dadburger",
//                    "u992616056_wilson","8902sb00");*/
//            /*conn = DriverManager.getConnection(
//                    "jdbc:mysql://187.45.196.191:3306/prap3mysql",
//                    "prap3mysql","master2211##");*/
//
//        } catch (SQLException e) {
//            //e.getMessage();
//            System.out.println(e.getMessage().toString());
//
//            Toast.makeText(ctx, "SERVIDOR " +
//                    "INDISPONÍVEL", Toast.LENGTH_LONG).show();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        return conn;
//    }
}