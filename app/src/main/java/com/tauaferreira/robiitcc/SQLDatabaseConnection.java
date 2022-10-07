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
    static String ip = "192.168.107.191";
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
}