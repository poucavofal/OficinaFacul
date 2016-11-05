
package dao;

import Pojo.Servico;
import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DaoServico {
    public Servico servico = new Servico();
    private static String SQLINCLUIR = "INSERT INTO SERVICO (?,?)";
    private static String SQLALTERAR = "UPDATE SERVICO SET NOME_SERVICO = ?, CODIGO_SERVICO = ?";
    private static String SQLEXCLUIR = "DELETE FROM WHERE CODIGO_SERVICO = ?";
    private static String SQLCONSULTAR = "SELECT * FROM SERVICO WHERE CODIGO_SERVICO = ?";
    
    public DaoServico (Servico servico){
        this.servico = servico;
    }
    public boolean incluir() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
            ps.setInt(1, servico.getCodigo_Servico());
            ps.setString(2, servico.getNome_Servico());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível incluir o serviço.");
            return false;
        }
    }

    public boolean alterar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLALTERAR);
            ps.setString(1, servico.getNome_Servico());
            ps.setInt(2, servico.getCodigo_Servico());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o serviço.");
            return false;
        }
    }

    public boolean excluir() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
            ps.setInt(1, servico.getCodigo_Servico());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o serviço.");
            return false;
        }
    }

    public boolean consultar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLCONSULTAR);
            ps.setInt(1, servico.getCodigo_Servico());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                servico.setNome_Servico(rs.getString(2));
                
            } else {
                JOptionPane.showMessageDialog(null, "Serviço não encontrado.");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar serviço.");
            return false;
        }
    }
    
    
}
