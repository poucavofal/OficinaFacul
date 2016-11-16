
package dao;


import Pojo.Funcionario;
import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class DaoFuncionario {
    
    public Funcionario funcionario;
    private static String SQLINCLUIR = "INSERT INTO FUNCIONARIO VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static String SQLALTERAR = "UPDATE FUNCIONARIO SET NOME_FUNCIONARIO = ?, TELEFONE_CELULAR = ?,"
            + "TELEFONE_RESIDENCIAL = ?,RG_FUNCIONARIO = ?, CPF_FUNCIONARIO = ?, ENDERECO_FUNCIONARIO = ?, "
            + "NUM_CASA = ?, BAIRRO_FUNCIONARIO = ?,CODIGO_CIDADE = ?, CEP = ? WHERE CODIGO_FUNCIONARIO = ?";
    private static String SQLEXCLUIR = "DELETE FROM FUNCIONARIO WHERE CODIGO_FUNCIONARIO = ?";
    private static String SQLCONSULTAR = "SELECT * FROM FUNCIONARIO WHERE CODIGO_FUNCIONARIO = ?";
    public static final String SQLCOMBOBOX = "SELECT CODIGO_FUNCIONARIO, NOME_FUNCIONARIO FROM FUNCIONARIO ORDER BY NOME_FUNCIONARIO";
    
    public DaoFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }
    public boolean incluir(){
            try {
                PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
                ps.setInt(   1, funcionario.getCodigo_Funcionario());
                ps.setString(2, funcionario.getNome_Funcionario());
                ps.setString(3, funcionario.getTelefone_Celular());
                ps.setString(4, funcionario.getTelefone_Residencial());
                ps.setString(5, funcionario.getRG_Funcionario());
                ps.setString(6, funcionario.getCPF_Funcionario());
                ps.setString(7, funcionario.getEndereco_Funcionario());
                ps.setString(8, funcionario.getNum_Casa());
                ps.setString(9, funcionario.getBairro_Funcionario());
                ps.setInt(   10, funcionario.getCodigo_Cidade());
                ps.setString(11, funcionario.getCep());
                ps.executeUpdate();
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
                ps.setString(1, funcionario.getNome_Funcionario());
                ps.setString(2, funcionario.getTelefone_Celular());
                ps.setString(3, funcionario.getTelefone_Residencial());
                ps.setString(4, funcionario.getRG_Funcionario());
                ps.setString(5, funcionario.getCPF_Funcionario());
                ps.setString(6, funcionario.getEndereco_Funcionario());
                ps.setString(7, funcionario.getNum_Casa());
                ps.setString(8, funcionario.getBairro_Funcionario());
                ps.setInt(   9, funcionario.getCodigo_Cidade());
                ps.setString(10, funcionario.getCep());
                ps.setInt(   11, funcionario.getCodigo_Funcionario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível alterar o funcionario.");
            return false;
        }
    }

    public boolean excluir() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
            ps.setInt(1, funcionario.getCodigo_Funcionario());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o funcionario.");
            return false;
        }
    }

    public boolean consultar() {
        try {
            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLCONSULTAR);
            ps.setInt(1, funcionario.getCodigo_Funcionario());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                funcionario.setNome_Funcionario(rs.getString(2));
                funcionario.setTelefone_Celular(rs.getString(3));
                funcionario.setTelefone_Residencial(rs.getString(4));
                funcionario.setRG_Funcionario(rs.getString(5));
                funcionario.setCPF_Funcionario(rs.getString(6));
                funcionario.setEndereco_Funcionario(rs.getString(7));
                funcionario.setNum_Casa(rs.getString(8));
                funcionario.setBairro_Funcionario(rs.getString(9));
                funcionario.setCodigo_Cidade(rs.getInt(10));
                funcionario.setCep(rs.getString(11));
            } else {
                JOptionPane.showMessageDialog(null, "funcionario não encontrado.");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível consultar o funcionario.");
            return false;
        }
    }
}
