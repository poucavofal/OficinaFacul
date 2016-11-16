
package dao;

import Componentes.MeuDBComboBox;
import Pojo.Cliente;
import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DaoCliente {
    
    public Cliente cliente;
    private static String SQLINCLUIR = "INSERT INTO CLIENTE VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static String SQLALTERAR = "UPDATE CLIENTE SET NOME_CLIENTE = ?, TELEFONE_CELULAR = ?,"
            + "TELEFONE_RESIDENCIAL = ?, SEXO_CLIENTE = ?, EMAIL_CLIENTE = ?, DATA_CADASTRO = ?,"
            + "RG_CLIENTE = ?, CPF_CLIENTE = ?, ENDERECO = ?, NUM_CASA = ?, BAIRRO = ?, CEP = ?,"
            + "CODIGO_CIDADE = ? WHERE CODIGO_CLIENTE = ?";
    private static String SQLEXCLUIR = "DELETE FROM CLIENTE WHERE CODIGO_CLIENTE = ?";
    private static String SQLCONSULTAR = "SELECT * FROM CLIENTE WHERE CODIGO_CLIENTE = ?";
    public static final String SQLCOMBOBOX = "SELECT CODIGO_Cliente, NOME_CLIENTE FROM CLIENTE ORDER BY NOME_CLIENTE";
    
    
    public DaoCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public boolean incluir(){
            try {
                PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
                ps.setInt(   1, cliente.getCodigo_Cliente());
                ps.setString(2, cliente.getNome_Cliente());
                ps.setString(3, cliente.getTelefone_Celular());
                ps.setString(4, cliente.getTelefone_Residencial());
                ps.setString(5, cliente.getSexo_Cliente());
                ps.setString(6, cliente.getEmail_Cliente());
                ps.setString(7, cliente.getData_Cadastro());
                ps.setString(8, cliente.getRG_Cliente());
                ps.setString(9, cliente.getCPF_Cliente());
                ps.setString(10, cliente.getEndereco());
                ps.setString(11, cliente.getNum_Casa());
                ps.setString(12, cliente.getBairro());
                ps.setString(13, cliente.getCep());
                ps.setInt(   14, cliente.getCodigo_Cidade());
                ps.executeUpdate();
                return true;
            } catch (SQLException ex) {
                
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Nao foi possivel incluir o cliente;");
                return false;
            }
       
    }
    public boolean alterar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLALTERAR);
                ps.setString(1, cliente.getNome_Cliente());
                ps.setString(2, cliente.getTelefone_Celular());
                ps.setString(3, cliente.getTelefone_Residencial());
                ps.setString(4, cliente.getSexo_Cliente());
                ps.setString(5, cliente.getEmail_Cliente());
                ps.setString(6, cliente.getData_Cadastro());
                ps.setString(7, cliente.getRG_Cliente());
                ps.setString(8, cliente.getCPF_Cliente());
                ps.setString(9, cliente.getEndereco());
                ps.setString(10, cliente.getNum_Casa());
                ps.setString(11, cliente.getBairro());
                ps.setString(12, cliente.getCep());
                ps.setInt(   13, cliente.getCodigo_Cidade());
                ps.setInt(   14, cliente.getCodigo_Cliente());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o Cliente.");
            return false;
        }
    }

    public boolean excluir() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
            ps.setInt(1, cliente.getCodigo_Cliente());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o Cliente.");
            return false;
        }
    }

    public boolean consultar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLCONSULTAR);
            ps.setInt(1, cliente.getCodigo_Cliente());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                cliente.setNome_Cliente(rs.getString(2));
                cliente.setTelefone_Celular(rs.getString(3));
                cliente.setTelefone_Residencial(rs.getString(4));
                cliente.setSexo_Cliente(rs.getString(5));
                cliente.setEmail_Cliente(rs.getString(6));
                cliente.setData_Cadastro(rs.getString(7));
                cliente.setRG_Cliente(rs.getString(8));
                cliente.setCPF_Cliente(rs.getString(9));
                cliente.setEndereco(rs.getString(10));
                cliente.setNum_Casa(rs.getString(11));
                cliente.setBairro(rs.getString(12));
                cliente.setCep(rs.getString(13));
                cliente.setCodigo_Cidade(Integer.parseInt(rs.getString(14)));
            } else {
                JOptionPane.showMessageDialog(null, "Cliente não encontrado.");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar o Cliente.");
            return false;
        }
    }
}
