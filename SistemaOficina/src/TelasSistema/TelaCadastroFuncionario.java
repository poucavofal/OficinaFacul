
package TelasSistema;

import Componentes.MeuJTextField;


public class TelaCadastroFuncionario extends TelaCadastro {
    public MeuJTextField campoCodigo = new MeuJTextField(10, "Codigo: ");
    public MeuJTextField campoNome = new MeuJTextField(20, "Nome: ");
    public MeuJTextField campoRG = new MeuJTextField(15, "RG: ");
    public MeuJTextField campoCPF = new MeuJTextField(15, "CPF: ");
    public MeuJTextField campoTelCel = new MeuJTextField(10, "Tel. Celular: ");
    public MeuJTextField campoTelResi = new MeuJTextField(10, "Tel. Residencial: ");
    public MeuJTextField campoEndereco = new MeuJTextField(14, "Endereço:");
    public MeuJTextField campoNCasa = new MeuJTextField(14, "Nº:");
    public MeuJTextField campoBairro = new MeuJTextField(14, "Bairro:");
    public MeuJTextField campoCEP = new MeuJTextField(14, "CEP:");
    public MeuJTextField campoComplemento = new MeuJTextField(14, "Complemento:");
    public MeuJTextField campoCidade = new MeuJTextField(14, "Cidade:");
    public MeuJTextField campoEstado = new MeuJTextField(14, "Estado:");

    public TelaCadastroFuncionario(){
        super("Cadastro Funcionario");
        adicionaComponente(1, 1, campoCodigo);
        adicionaComponente(1, 3, campoNome);
        adicionaComponente(2, 1, campoRG);
        adicionaComponente(2, 3, campoCPF);
        adicionaComponente(3, 1, campoTelCel);
        adicionaComponente(3, 3, campoTelResi);
        adicionaComponente(4, 1, campoEndereco);
        adicionaComponente(4, 3, campoNCasa);
        adicionaComponente(5, 1, campoBairro);
        adicionaComponente(5, 3, campoCEP);
        adicionaComponente(6, 1, campoComplemento);
        adicionaComponente(6, 3, campoCidade);
        adicionaComponente(7, 1, campoEstado);
        pack();
    }
}
