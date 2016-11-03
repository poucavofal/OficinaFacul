package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class Conexao {
    private static Connection conexao;

    public static Connection getConexao() {
        try {
            if (conexao == null) {
                Class.forName("org.firebirdsql.jdbc.FBDriver");
                conexao = DriverManager.getConnection("jdbc:firebirdsql://localhost/"+ System.getProperty("user.dir") +"/BANCO.FDB", "SYSDBA", "masterkey");
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
    public static List<Object[]> consultarComboBox(String sql) {
        try {
            List<Object[]> retorno = new ArrayList();
            PreparedStatement ps = Conexao.getConexao().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
               Object[] linha = new Object[2];
               linha[0] = rs.getInt(1);
               linha[1] = rs.getString(2);
               retorno.add(linha);
            }
            return retorno;            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar dados para o ComboBox");
            return null;
        }
    }
}
