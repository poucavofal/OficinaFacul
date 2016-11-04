package TelasSistema;

import Componentes.MeuJTextField;

public class TelaCadastroFornecedor extends TelaCadastro{
    public MeuJTextField campoCodigo = new MeuJTextField(false, 10, "Codigo: ");
    public MeuJTextField campoNome = new MeuJTextField(false, 20, "Nome: ");
    public MeuJTextField campoRG = new MeuJTextField(false, 15, "CNPJ: ");
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
        adicionaComponente(2, 1, 1 , 1, campoRG);
        adicionaComponente(2, 3, 1 , 1, campoTelComer);
        adicionaComponente(3, 1, 1 , 1, campoEndereco);
        adicionaComponente(3, 3, 1 , 1, campoNumero);
        adicionaComponente(4, 1, 1 , 1, campoBairro);
        adicionaComponente(4, 3, 1 , 1, campoCEP);
        adicionaComponente(5, 1, 1 , 1, campoComplemento);
        adicionaComponente(5, 3, 1 , 1, campoCidade);
        adicionaComponente(6, 1, 1 , 1, campoEstado);
        adicionaComponente(6, 3, 1 , 1, campoNomeVendedor);
        pack();
    }
}
