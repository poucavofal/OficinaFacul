
package dao;

import Pojo.Cor;
import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DaoCor {
    public Cor cor = new Cor();
    private static String SQLINCLUIR = "INSERT INTO COR VALUES(?,?)";
    private static String SQLALTERAR = "UPDATE COR SET NOME_COR = ? WHERE CODIGO_COR = ?";
    private static String SQLEXCLUIR = "DELETE FROM COR WHERE CODIGO_COR = ?";
    private static String SQLCONSULTAR = "SELECT * FROM COR WHERE CODIGO_COR = ?";
    public static final String SQLCOMBOBOX = "SELECT CODIGO_COR, NOME_COR FROM COR ORDER BY NOME_COR";
    
    public DaoCor (Cor cor){
        this.cor = cor;
    }
    public boolean incluir() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
            ps.setInt(1, cor.getCodigo_Cor());
            ps.setString(2, cor.getNome_Cor());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível incluir a cor.");
            return false;
        }
    }

    public boolean alterar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLALTERAR);
            ps.setString(1, cor.getNome_Cor());
            ps.setInt(2, cor.getCodigo_Cor());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a cor.");
            return false;
        }
    }

    public boolean excluir() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
            ps.setInt(1, cor.getCodigo_Cor());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a cor.");
            return false;
        }
    }

    public boolean consultar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLCONSULTAR);
            ps.setInt(1, cor.getCodigo_Cor());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cor.setNome_Cor(rs.getString(2));
                
            } else {
                JOptionPane.showMessageDialog(null, "Cor não encontrada.");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar a cor.");
            return false;
        }
    }
    
}
