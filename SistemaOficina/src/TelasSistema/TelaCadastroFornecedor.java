package TelasSistema;

import Componentes.MeuDBComboBox;
import Componentes.MeuJTextField;
import Pojo.Fornecedor;
import dao.DaoCidade;
import dao.DaoFornecedor;

public class TelaCadastroFornecedor extends TelaCadastro{
    public Fornecedor fornecedor = new Fornecedor();
    public DaoFornecedor daoFornecedor = new DaoFornecedor(fornecedor);
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, "Codigo ");
    public MeuJTextField campoNome = new MeuJTextField(true, 20, "Nome ");
    public MeuJTextField campoCNPJ = new MeuJTextField(true, 15, "CNPJ ");
    public MeuJTextField campoTelComer = new MeuJTextField(false,10, "Tel. Comercial ");
    public MeuJTextField campoEndereco = new MeuJTextField(false,14, "Endereço");
    public MeuJTextField campoNumero = new MeuJTextField(false,14, "Nº");
    public MeuJTextField campoBairro = new MeuJTextField(false,14, "Bairro");
    public MeuJTextField campoCEP = new MeuJTextField(false,14, "CEP");
    public MeuDBComboBox campoCidade = new MeuDBComboBox(true,DaoCidade.SQLCOMBOBOX, "Cidade");
    public MeuJTextField campoNomeVendedor = new MeuJTextField(true, 14, "Nome do Vendedor");
    public MeuJTextField campoEmail = new MeuJTextField(true, 14, "E-Mail");

    public TelaCadastroFornecedor(){
        super ("Cadastro de Fornecedor");
        adicionaComponente(1, 1, 1 , 1, campoCodigo);
        adicionaComponente(1, 3, 1 , 1, campoNome);
        adicionaComponente(3, 1, 1 , 1, campoCNPJ);
        adicionaComponente(3, 3, 1 , 1, campoTelComer);
        adicionaComponente(5, 1, 1 , 1, campoEndereco);
        adicionaComponente(5, 3, 1 , 1, campoNumero);
        adicionaComponente(7, 1, 1 , 1, campoBairro);
        adicionaComponente(7, 3, 1 , 1, campoCEP);
        adicionaComponente(11, 1, 1 , 1, campoCidade);
        adicionaComponente(9, 1, 1 , 1, campoNomeVendedor);
        adicionaComponente(9, 3, 1 , 1, campoEmail);
        pack();
        habilitaComponentes(false);
    }
    public void setPersistencia() {
        fornecedor.setCodigo_Fornecedor(Integer.parseInt(campoCodigo.getText()));
        fornecedor.setNome_Fornecedor(campoNome.getText());
        fornecedor.setCNPJ(campoCNPJ.getText());
        fornecedor.setTelefone_Comercial(campoTelComer.getText());
        fornecedor.setEndereco(campoEndereco.getText());
        fornecedor.setNum_Estabe(campoNumero.getText());
        fornecedor.setBairro(campoBairro.getText());
        fornecedor.setCep(campoCEP.getText());
        fornecedor.setCodigo_Cidade(campoCidade.getValor());
        fornecedor.setNome_Vendedor(campoNomeVendedor.getText());
        fornecedor.setEmail_Fornecedor(campoEmail.getText());

    }

    @Override
    public boolean incluirBD() {
        setPersistencia();
        return daoFornecedor.incluir();
    }

    @Override
    public boolean alterarBD() {
        setPersistencia();
        return daoFornecedor.alterar();
    }

    @Override
    public boolean excluirBD() {
        setPersistencia();
        return daoFornecedor.excluir();
    }

    @Override
    public boolean consultarBD() {
        fornecedor.setCodigo_Fornecedor(Integer.parseInt(campoCodigo.getText()));
        if (daoFornecedor.consultar()) {
        campoNome.setText(fornecedor.getNome_Fornecedor());
        campoCNPJ.setText(fornecedor.getCNPJ());
        campoTelComer.setText(fornecedor.getTelefone_Comercial());
        campoEndereco.setText(fornecedor.getEndereco());
        campoNumero.setText(fornecedor.getNum_Estabe());
        campoBairro.setText(fornecedor.getBairro());
        campoCEP.setText(fornecedor.getCep());
        campoCidade.setValor(fornecedor.getCodigo_Cidade());
        campoNomeVendedor.setText(fornecedor.getNome_Vendedor());
        campoEmail.setText(fornecedor.getEmail_Fornecedor());
            return true;
        } else {
            return false;
        }
    }
}
