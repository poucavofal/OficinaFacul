
package dao;

import Pojo.Carro;
import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DaoCarro {
    public Carro carro = new Carro();
    private static String SQLINCLUIR = "INSERT INTO CARRO VALUES (?,?,?,?,?)";
    private static String SQLALTERAR = "UPDATE CARRO SET CODIGO_MARCA = ?, CODIGO_COR = ? CODIGO_CARRO = ? PLACA_CARRO = ? Codigo_Modelo = ?";
    private static String SQLEXCLUIR = "DELETE FROM CARRO WHERE CODIGO_CARRO = ?";
    private static String SQLCONSULTAR = "SELECT * FROM CARRO WHERE CODIGO_CARRO = ?";
    
    public DaoCarro (Carro carro){
        this.carro = carro;
    }
    public boolean incluir() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
            ps.setInt(1, carro.getCodigo_Marca());
            ps.setInt(2, carro.getCodigo_Cor());
            ps.setInt(3, carro.getCodigo_Carro());
            ps.setString(4, carro.getPlaca_Carro());
            ps.setInt(5, carro.getCodigo_Modelo());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível incluir o carro.");
            return false;
        }
    }

    public boolean alterar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLALTERAR);
            ps.setInt(1, carro.getCodigo_Marca());
            ps.setInt(2, carro.getCodigo_Cor());
            ps.setInt(3, carro.getCodigo_Marca());
            ps.setString(4, carro.getPlaca_Carro());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o carro.");
            return false;
        }
    }

    public boolean excluir() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
            ps.setInt(1, carro.getCodigo_Carro());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o carro.");
            return false;
        }
    }

    public boolean consultar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLCONSULTAR);
            ps.setInt(1, carro.getCodigo_Carro());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
//                carro.setCodigo_Marca(rs.getInt(1));
//                carro.setCodigo_Cor(rs.getString(2));
//                carro.setNome_Cor(rs.getString(3));
//                carro.setNome_Cor(rs.getString(4));
                
                
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
