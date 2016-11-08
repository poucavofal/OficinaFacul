package dao;

import Pojo.Cidade;
import Pojo.Estado;
import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DaoCidade {
    public Cidade cidade;
    private static String SQLINCLUIR = "INSERT INTO CIDADE VALUES (?,?,?)";
    private static String SQLALTERAR = "UPDATE CIDADE SET NOME_CIDADE = ?, CODIGO_ESTADO = ? WHERE CODIGO_CIDADE = ?";
    private static String SQLEXCLUIR = "DELETE FROM CIDADE WHERE CODIGO_CIDADE = ?";
    private static String SQLCONSULTAR = "SELECT * FROM CIDADE WHERE CODIGO_CIDADE = ?";
    
    public DaoCidade (Cidade cidade){
        this.cidade = cidade;
    }
    public boolean incluir() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
            ps.setInt(1, cidade.getCodigo_Cidade());
            ps.setString(2, cidade.getNome_Cidade());
            ps.setInt(3, cidade.getCodigo_Estado());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível incluir a cidade.");
            return false;
        }
    }

    public boolean alterar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLALTERAR);
            ps.setString(1, cidade.getNome_Cidade());
            ps.setInt(2, cidade.getCodigo_Cidade());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar a cidade.");
            return false;
        }
    }

    public boolean excluir() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
            ps.setInt(1, cidade.getCodigo_Cidade());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir a cidade.");
            return false;
        }
    }

    public boolean consultar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLCONSULTAR);
            ps.setInt(1, cidade.getCodigo_Cidade());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cidade.setNome_Cidade(rs.getString(2));
                
            } else {
                JOptionPane.showMessageDialog(null, "Cidade não encontrada.");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar a cidade.");
            return false;
        }
    }
}
