package com.tauaferreira.robiitcc.Utils;

import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLDatabaseConnection {
    // Objeto de conexão
    static String ip = "192.168.41.191";
    static String banco = "ROBIIAPP";

    static String usuario = "sa";
    static String senha = "123456";

    public static Connection conectar() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Connection conn;
        String URL_CONEXAO;

        try {

            String class_driver = "net.sourceforge.jtds.jdbc.Driver";
            Class.forName(class_driver);
            URL_CONEXAO = "jdbc:jtds:sqlserver://" + ip + ";"
                    + "databaseName=" + banco + ";"
                    + "user=" + usuario + ";"
                    + "password=" + senha + ";";

            conn = DriverManager.getConnection(URL_CONEXAO);

        } catch (Exception erro) {
            Log.d("CONEXAO_MSSQL", erro.getMessage());
            return null;
        }

        return conn;
    }
}