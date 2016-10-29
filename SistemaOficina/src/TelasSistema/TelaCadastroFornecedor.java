package TelasSistema;

import Componentes.MeuJTextField;

public class TelaCadastroFornecedor extends TelaCadastro{
    public MeuJTextField campoCodigo = new MeuJTextField(10, "Codigo: ");
    public MeuJTextField campoNome = new MeuJTextField(20, "Nome: ");
    public MeuJTextField campoRG = new MeuJTextField(15, "CNPJ: ");
    public MeuJTextField campoTelComer = new MeuJTextField(10, "Tel. Comercial: ");
    public MeuJTextField campoEndereco = new MeuJTextField(14, "Endereço:");
    public MeuJTextField campoNumero = new MeuJTextField(14, "Nº:");
    public MeuJTextField campoBairro = new MeuJTextField(14, "Bairro:");
    public MeuJTextField campoCEP = new MeuJTextField(14, "CEP:");
    public MeuJTextField campoComplemento = new MeuJTextField(14, "Complemento:");
    public MeuJTextField campoCidade = new MeuJTextField(14, "Cidade:");
    public MeuJTextField campoEstado = new MeuJTextField(14, "Estado:");
    public MeuJTextField campoNomeVendedor = new MeuJTextField(14, "Nome do Vendedor:");

    public TelaCadastroFornecedor(){
        super ("Cadastro de Fornecedor");
        adicionaComponente(1, 1, campoCodigo);
        adicionaComponente(1, 3, campoNome);
        adicionaComponente(2, 1, campoRG);
        adicionaComponente(2, 3, campoTelComer);
        adicionaComponente(3, 1, campoEndereco);
        adicionaComponente(3, 3, campoNumero);
        adicionaComponente(4, 1, campoBairro);
        adicionaComponente(4, 3, campoCEP);
        adicionaComponente(5, 1, campoComplemento);
        adicionaComponente(5, 3, campoCidade);
        adicionaComponente(6, 1, campoEstado);
        adicionaComponente(6, 3, campoNomeVendedor);
        pack();
    }
}
