
package TelasSistema;

import Componentes.MeuCampoData;
import Componentes.MeuComponente;
import Componentes.MeuDBComboBox;
import Componentes.MeuJTable;
import Componentes.MeuJTextField;
import Pojo.Itens_Ordem_Servico;
import dao.DaoCliente;
import dao.DaoCor;
import dao.DaoFornecedor;
import dao.DaoFuncionario;
import dao.DaoMarca;
import dao.DaoProduto;
import dao.DaoServico;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;


public class TelaOrdemServico extends TelaCadastro {
    public Itens_Ordem_Servico Itens_servico = new Itens_Ordem_Servico();
    public MeuJTextField campoCodigoOS = new MeuJTextField(true, 10, "Codigo ");
    private MeuDBComboBox campoCliente = new MeuDBComboBox(true, DaoCliente.SQLCOMBOBOX, "Cliente");
    public MeuCampoData campoData = new MeuCampoData(true,"Data da OS");
    public MeuJTextField campoPlacaCarro = new MeuJTextField(true, 10, "Placa ");
    private MeuDBComboBox campoMarca = new MeuDBComboBox(true, DaoMarca.SQLCOMBOBOX, "Marca");
    public MeuJTextField campoModelo = new MeuJTextField(true, 10, "Modelo");
    private MeuDBComboBox campoCor = new MeuDBComboBox(true, DaoCor.SQLCOMBOBOX, "Cor");
    private MeuDBComboBox campoNomeProduto = new MeuDBComboBox(true, DaoProduto.SQLCOMBOBOX, "Produto");
    public MeuJTextField campoQntd = new MeuJTextField(true, 10, "Quantidade");
    private MeuDBComboBox campoFornecedor = new MeuDBComboBox(true, DaoFornecedor.SQLCOMBOBOX, "Fornecedor");
    private MeuDBComboBox campoResponsavel = new MeuDBComboBox(true, DaoFuncionario.SQLCOMBOBOX, "Responsavel");
    private MeuDBComboBox campoTipoServico = new MeuDBComboBox(true, DaoServico.SQLCOMBOBOX, "Tipo de Serviço");
    private MeuJTable JTTabelaVenda = new MeuJTable(true, "Itens de Venda");
    public TelaOrdemServico(){
        super("Ordem de serviço");
        adicionaComponente(1, 1, 1 , 1, campoCodigoOS);
        adicionaComponente(1, 2, 1 , 1, campoCliente);
        adicionaComponente(1, 3, 1 , 1, campoData);
        adicionaComponente(1, 4, 1 , 1, campoResponsavel);
        adicionaComponente(3, 1, 1 , 1, campoPlacaCarro);
        adicionaComponente(3, 2, 1 , 1, campoMarca);
        adicionaComponente(3, 3, 1 , 1, campoModelo);
        adicionaComponente(3, 4, 1 , 1, campoCor);
        adicionaComponente(5, 1, 1 , 1, campoNomeProduto);
        adicionaComponente(5, 2, 1 , 1, campoQntd);
        adicionaComponente(5, 3, 1 , 1, campoFornecedor);
        adicionaComponente(5, 4, 1 , 1, campoTipoServico);
        adicionaComponente(17, 1, 1, 9, JTTabelaVenda);
        pack();
        habilitaComponentes(false);
        adicionaBotao(jbIncluirItem);
        adicionaBotao(jbExcluirItem);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbIncluirItem){
            IncluirItem();
        }
        if (e.getSource() == jbExcluirItem){
            ExcluirItem();
        }
        if (e.getSource() == jbIncluir){
            incluir();
        }
        if (e.getSource() == jbAlterar){
            alterar();
        }
        if (e.getSource() == jbExcluir){
            excluir();
        }
        if (e.getSource() == jbConsultar){
            consultar();
        }
        if (e.getSource() == jbConfirmar){
            confirmar();
        }
        if (e.getSource() == jbCancelar){
            cancelar();
        }
    }
        public void IncluirItem() {
        if("".equals(campoCodigoOS.getText())){
            JOptionPane.showMessageDialog(JTTabelaVenda, "Nao é possivel inserir uma linha");
        }else{
           JTTabelaVenda.deftablemodel.addRow(new Object[]{campoCodigoOS.getText(), "", "", "", ""});
        }      
    }
        
    public void ExcluirItem() {
        if (JTTabelaVenda.tabela.getSelectedRow() >= 0) {
            JTTabelaVenda.deftablemodel.removeRow(JTTabelaVenda.tabela.getSelectedRow());
        } else {
            JOptionPane.showMessageDialog(JTTabelaVenda, "Selecione uma linha para ser excluida");
        }
    }
    }
    
//    public void setPersistencia() {
//        estado.setCodigo_Estado(Integer.parseInt(campoCodigo.getText()));
//        estado.setNome_Estado(campoNEstado.getText());
//        estado.setSigla(campoSigla.getText());
//        estado.setSigla(campoSigla.getText());
//    }
//
//    @Override
//    public boolean Incluiritem() {
//        setPersistencia();
//        return daoEstado.incluir();
//    }
//
//    @Override
//    public boolean alterarBD() {
//        setPersistencia();
//        return daoEstado.alterar();
//    }
//
//    @Override
//    public boolean excluirBD() {
//        setPersistencia();
//        return daoEstado.excluir();
//    }
//
//    @Override
//    public boolean consultarBD() {
//        estado.setCodigo_Estado(Integer.parseInt(campoCodigo.getText()));
//        if (daoEstado.consultar()) {
//            campoNEstado.setText(estado.getNome_Estado());
//            campoSigla.setText(estado.getSigla());
//            return true;
//        } else {
//            return false;
//        }
//    }



    

 
