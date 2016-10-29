package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexao {
    private static Connection conexao;

    public static Connection getConexao() {
        try {
            if (conexao == null) {
                Class.forName("org.firebirdsql.jdbc.FBDriver");
                conexao = DriverManager.getConnection("jdbc:firebirdsql://localhost/"+ System.getProperty("user.dir") +"/BANCO.FDB", "SYSDBA", "masterkey");//Fazendo conexao com o banco
            }
            return conexao;
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro no driver jdbc.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados.");
            e.printStackTrace();
            return null;
        }
    }
}
