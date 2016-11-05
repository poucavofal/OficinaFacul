package TelasSistema;

import Componentes.MeuJTextField;
import Pojo.Fornecedor;
import dao.DaoFornecedor;

public class TelaCadastroFornecedor extends TelaCadastro{
    public Fornecedor fornecedor = new Fornecedor();
    public DaoFornecedor daoFornecedor = new DaoFornecedor(fornecedor);
    public MeuJTextField campoCodigo = new MeuJTextField(false, 10, "Codigo: ");
    public MeuJTextField campoNome = new MeuJTextField(false, 20, "Nome: ");
    public MeuJTextField campoCNPJ = new MeuJTextField(false, 15, "CNPJ: ");
    public MeuJTextField campoTelComer = new MeuJTextField(false,10, "Tel. Comercial: ");
    public MeuJTextField campoEndereco = new MeuJTextField(false,14, "Endereço:");
    public MeuJTextField campoNumero = new MeuJTextField(false,14, "Nº:");
    public MeuJTextField campoBairro = new MeuJTextField(false,14, "Bairro:");
    public MeuJTextField campoCEP = new MeuJTextField(false,14, "CEP:");
    public MeuJTextField campoComplemento = new MeuJTextField(false,14, "Complemento:");
    public MeuJTextField campoCidade = new MeuJTextField(false,14, "Cidade:");
    public MeuJTextField campoEstado = new MeuJTextField(false,14, "Estado:");
    public MeuJTextField campoNomeVendedor = new MeuJTextField(false, 14, "Nome do Vendedor:");

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
        adicionaComponente(9, 1, 1 , 1, campoComplemento);
        adicionaComponente(9, 3, 1 , 1, campoCidade);
        adicionaComponente(11, 1, 1 , 1, campoEstado);
        adicionaComponente(11, 3, 1 , 1, campoNomeVendedor);
        pack();
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
        fornecedor.setComplemento(campoComplemento.getText());
        fornecedor.setNome_Vendedor(campoNomeVendedor.getText());

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
        fornecedor.setNome_Fornecedor(campoNome.getText());
        fornecedor.setCNPJ(campoCNPJ.getText());
        fornecedor.setTelefone_Comercial(campoTelComer.getText());
        fornecedor.setEndereco(campoEndereco.getText());
        fornecedor.setNum_Estabe(campoNumero.getText());
        fornecedor.setBairro(campoBairro.getText());
        fornecedor.setCep(campoCEP.getText());
        fornecedor.setComplemento(campoComplemento.getText());
        fornecedor.setNome_Vendedor(campoNomeVendedor.getText());
            return true;
        } else {
            return false;
        }
    }
}
