
package dao;

import Pojo.Marca;
import Pojo.Produto;
import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class DaoProduto {
     public Produto produto = new Produto();
    private static String SQLINCLUIR = "INSERT INTO PRODUTO VALUES (?,?,?,?,?)";
    private static String SQLALTERAR = "UPDATE PRODUTO SET NOME_PECA = ?, QNTD = ?, CODIGO_COR = ?, CODIGO_MARCA = ? WHERE CODIGO_PRODUTO = ?";
    private static String SQLEXCLUIR = "DELETE FROM PRODUTO WHERE CODIGO_PRODUTO = ?";
    private static String SQLCONSULTAR = "SELECT * FROM PRODUTO WHERE CODIGO_PRODUTO = ?";
    
    public DaoProduto (Produto produto){
        this.produto = produto;
    }
    public boolean incluir() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
            ps.setInt(1, produto.getCodigo_Produto());
            ps.setString(2, produto.getNome_Peca());
            ps.setInt(3, produto.getQntd());
            ps.setInt(4, produto.getCodigo_Cor());
            ps.setInt(5, produto.getCodigo_Marca());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível incluir o Produto.");
            return false;
        }
    }

    public boolean alterar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLALTERAR);
            ps.setString(1, produto.getNome_Peca());
            ps.setInt(2, produto.getQntd());
            ps.setInt(3, produto.getCodigo_Cor());
            ps.setInt(4, produto.getCodigo_Marca());
            ps.setInt(5, produto.getCodigo_Produto());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o produto.");
            return false;
        }
    }

    public boolean excluir() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
            ps.setInt(1, produto.getCodigo_Marca());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o produto.");
            return false;
        }
    }

    public boolean consultar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLCONSULTAR);
            ps.setInt(1, produto.getCodigo_Produto());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                produto.setNome_Peca(rs.getString(2));
                produto.setQntd(rs.getInt(3));
                produto.setCodigo_Cor(rs.getInt(4));
                produto.setCodigo_Marca(rs.getInt(5));
                
            } else {
                JOptionPane.showMessageDialog(null, "Produto nao encontrado.");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar o Produto.");
            return false;
        }
    }
}
