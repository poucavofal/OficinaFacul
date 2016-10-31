package dao;

import Pojo.Estado;
import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DaoEstado {
    private Estado estado;
    private final String SQLINCLUIR = "INSERT INTO ESTADO VALUES (?,?,?)";
    private final String SQLALTERAR = "UPDATE ESTADO SET NOME_ESTADO = ?, SIGLA = ?, WHERE CODIGO_ESTADO = ?";
    private final String SQLEXCLUIR = "DELETE FROM ESTADO WHERE CODIGO_ESTADO = ?";
    private final String SQLCONSULTAR = "SELECT * FROM ESTADO WHERE CODIGO_ESTADO = ?";


public DaoEstado(Estado estado){
    this.estado = estado;
}
public boolean incluir() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
            ps.setInt(1, estado.getCodigo_Estado());
            ps.setString(2, estado.getNome_Estado());
            ps.setString(3, estado.getSigla());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível incluir o estado.");
            return false;
        }
    }

    public boolean alterar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLALTERAR);
            ps.setString(1, estado.getNome_Estado());
            ps.setString(2, estado.getSigla());
            ps.setInt(3, estado.getCodigo_Estado());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o estado.");
            return false;
        }
    }

    public boolean excluir() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
            ps.setInt(1, estado.getCodigo_Estado());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o estado.");
            return false;
        }
    }

    public boolean consultar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLCONSULTAR);
            ps.setInt(1, estado.getCodigo_Estado());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                estado.setNome_Estado(rs.getString(2));
                estado.setSigla(rs.getString(3));
            } else {
                JOptionPane.showMessageDialog(null, "Estado não encontrado.");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar o estado.");
            return false;
        }
    }



}



