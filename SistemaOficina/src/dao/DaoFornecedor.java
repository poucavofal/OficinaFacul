
package dao;

import Pojo.Fornecedor;
import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DaoFornecedor {
    public Fornecedor fornecedor;
    private static String SQLINCLUIR = "INSERT INTO FORNECEDOR VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
    private static String SQLALTERAR = "UPDATE FORNECEDOR SET NOME_FORNECEDOR = ?, TELEFONE_COMERCIAL = ?,"
            + "NOME_VENDEDOR = ?,TELEFONE_CELULAR = ?, EMAIL_FORNECEDOR = ?, CNPJ = ?, "
            + "ENDERECO = ?, NUM_ESTABE = ?,BAIRRO = ?, CEP = ?,CODIGO_CIDADE = ? WHERE CODIGO_FORNECEDOR = ?";
    private static String SQLEXCLUIR = "DELETE FROM FORNECEDOR WHERE CODIGO_FORNECEDOR = ?";
    private static String SQLCONSULTAR = "SELECT * FOM FORNECEDOR WHERE CODIGO_FORNECEDOR = ?";
    
    public DaoFornecedor(Fornecedor fornecedor){
        this.fornecedor = fornecedor;
    }
    public boolean incluir(){
            try {
                PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
                ps.setInt(   1, fornecedor.getCodigo_Fornecedor());
                ps.setString(2, fornecedor.getNome_Fornecedor());
                ps.setString(3, fornecedor.getTelefone_Comercial());
                ps.setString(4, fornecedor.getNome_Vendedor());
                ps.setString(5, fornecedor.getTelefone_Celular());
                ps.setString(6, fornecedor.getEmail_Fornecedor());
                ps.setString(7, fornecedor.getCNPJ());
                ps.setString(8, fornecedor.getEndereco());
                ps.setString(9, fornecedor.getNum_Estabe());
                ps.setString(10, fornecedor.getBairro());
                ps.setString(11, fornecedor.getCep());
                ps.setInt(12, fornecedor.getCodigo_Cidade());
                return true;
            } catch (SQLException ex) {
                
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Nao foi possivel incluir o funcionario;");
                return false;
            }
       
    }
    public boolean alterar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLALTERAR);
              
                ps.setString(1, fornecedor.getNome_Fornecedor());
                ps.setString(2, fornecedor.getTelefone_Comercial());
                ps.setString(3, fornecedor.getNome_Vendedor());
                ps.setString(4, fornecedor.getTelefone_Celular());
                ps.setString(5, fornecedor.getEmail_Fornecedor());
                ps.setString(6, fornecedor.getCNPJ());
                ps.setString(7, fornecedor.getEndereco());
                ps.setString(8, fornecedor.getNum_Estabe());
                ps.setString(9, fornecedor.getBairro());
                ps.setString(10, fornecedor.getCep());
                ps.setInt(11, fornecedor.getCodigo_Cidade());
                ps.setInt(   1, fornecedor.getCodigo_Fornecedor());
                ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o fornecedor.");
            return false;
        }
    }

    public boolean excluir() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
            ps.setInt(1, fornecedor.getCodigo_Fornecedor());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o fornecedor.");
            return false;
        }
    }

    public boolean consultar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLCONSULTAR);
            ps.setInt(1, fornecedor.getCodigo_Fornecedor());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                fornecedor.setNome_Fornecedor(rs.getString(2));
                fornecedor.setTelefone_Comercial(rs.getString(3));
                fornecedor.setNome_Vendedor(rs.getString(4));
                fornecedor.setTelefone_Celular(rs.getString(5));
                fornecedor.setEmail_Fornecedor(rs.getString(6));
                fornecedor.setCNPJ(rs.getString(7));
                fornecedor.setEndereco(rs.getString(8));
                fornecedor.setNum_Estabe(rs.getString(9));
                fornecedor.setBairro(rs.getString(10));
                fornecedor.setCep(rs.getString(11));
                fornecedor.setCodigo_Cidade(rs.getInt(12));
            } else {
                JOptionPane.showMessageDialog(null, "fornecedor não encontrado.");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar o fornecedor.");
            return false;
        }
    }
}
