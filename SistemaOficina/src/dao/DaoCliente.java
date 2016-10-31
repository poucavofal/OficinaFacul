//    SEQUENCIA DO BANCO DE DADOS:
//    1-CODIGO_CLIENTE
//    2-NOME-CLIENTE
//    3-TELEFONE_CELULAR
//    4-TELEFONE_RESIDENCIAL
//    5-SEXO_CLIENTE
//    6-EMAIL_CLIENTE
//    7-DATA_CADASTRO
//    8-RG_CLIENTE
//    9-CPF_CLIENTE
//    10-ENDERECO
//    11-NUM_CASA
//    12-BAIRRO
//    13-CEP
//    14-CODIGO_CIDADE
package dao;

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
    private static String SQLINCLUIR = "INSERT INTO CLIENTE (?,?,?,?,?,?,?,?,?,?,?,?,?,?";
    private static String SQLALTERAR = "UPDATE CLIENTE SET NOME_CLIENTE = ?, TELEFONE_CELULAR = ?,"
            + "TELEFONE_RESIDENCIAL = ?, SEXO_CLIENTE = ?, EMAIL_CLIENTE = ?, DATA_CADASTRO = ?,"
            + "RG_CLIENTE = ?, CPF_CLIENTE = ?, ENDERECO = ?, NUM_CASA = ?, BAIRRO = ?, CEP = ?,"
            + "CODIGO_CIDADE = ? WHERE CODIGO_CLIENTE = ?";
    private static String SQLEXCLUIR = "DELETE FROM CLIENTE WHERE CODIGO_CLIENTE = ?";
    private static String SQLCONSULTAR = "SELECT * FOM CLIENTE WHERE CODIGO_CLIENTE = ?";
    
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
