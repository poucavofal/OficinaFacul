/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Pojo.Marca;
import Pojo.Produto;
import bd.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Jean Max
 */
public class DaoProduto {
     public Produto produto = new Produto();
    private static String SQLINCLUIR = "INSERT INTO PRODUTO VALUES (?,?)";
    private static String SQLALTERAR = "UPDATE PRODUTO SET NOME_PRODUTO = ? WHERE CODIGO_PRODUTO = ?";
    private static String SQLEXCLUIR = "DELETE FROM PRODUTO WHERE CODIGO_PRODUTO = ?";
    private static String SQLCONSULTAR = "SELECT * FROM PRODUTO WHERE CODIGO_PRODUTO = ?";
    
    public DaoProduto (Produto produto){
        this.produto = produto;
    }
//    public boolean incluir() {
//        try {
//            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLINCLUIR);
//            ps.setInt(1, marca.getCodigo_Marca());
//            ps.setString(2, marca.getNome_Marca());
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Não foi possível incluir a marca.");
//            return false;
//        }
//    }
//
//    public boolean alterar() {
//        try {
//            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLALTERAR);
//            ps.setString(1, marca.getNome_Marca());
//            ps.setInt(2, marca.getCodigo_Marca());
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Não foi possível alterar a marca.");
//            return false;
//        }
//    }
//
//    public boolean excluir() {
//        try {
//            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLEXCLUIR);
//            ps.setInt(1, marca.getCodigo_Marca());
//            ps.executeUpdate();
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Não foi possível excluir a marca.");
//            return false;
//        }
//    }
//
//    public boolean consultar() {
//        try {
//            PreparedStatement ps = Conexao.getConexao().prepareStatement(SQLCONSULTAR);
//            ps.setInt(1, marca.getCodigo_Marca());
//            ResultSet rs = ps.executeQuery();
//            if (rs.next()) {
//                marca.setNome_Marca(rs.getString(2));
//                
//            } else {
//                JOptionPane.showMessageDialog(null, "Marca não encontrada.");
//            }
//            return true;
//        } catch (SQLException e) {
//            e.printStackTrace();
//            JOptionPane.showMessageDialog(null, "Não foi possível consultar a marca.");
//            return false;
//        }
//    }
}
