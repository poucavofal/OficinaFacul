
package TelasSistema;

import Componentes.MeuJTextField;


public class TelaCadastroFuncionario extends TelaCadastro {
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, "Codigo: ");
    public MeuJTextField campoNome = new MeuJTextField(true, 20, "Nome: ");
    public MeuJTextField campoRG = new MeuJTextField(true, 15, "RG: ");
    public MeuJTextField campoCPF = new MeuJTextField(true, 15, "CPF: ");
    public MeuJTextField campoTelCel = new MeuJTextField(false,10, "Tel. Celular: ");
    public MeuJTextField campoTelResi = new MeuJTextField(false,10, "Tel. Residencial: ");
    public MeuJTextField campoEndereco = new MeuJTextField(false,14, "Endereço:");
    public MeuJTextField campoNCasa = new MeuJTextField(false,14, "Nº:");
    public MeuJTextField campoBairro = new MeuJTextField(false,14, "Bairro:");
    public MeuJTextField campoCEP = new MeuJTextField(false,14, "CEP:");
    public MeuJTextField campoComplemento = new MeuJTextField(false,14, "Complemento:");
    public MeuJTextField campoCidade = new MeuJTextField(false,14, "Cidade:");
    public MeuJTextField campoEstado = new MeuJTextField(false,14, "Estado:");

    public TelaCadastroFuncionario(){
        super("Cadastro Funcionario");
        adicionaComponente(1, 1, 1 , 1, campoCodigo);
        adicionaComponente(1, 3, 1 , 1, campoNome);
        adicionaComponente(2, 1, 1 , 1, campoRG);
        adicionaComponente(2, 3, 1 , 1, campoCPF);
        adicionaComponente(3, 1, 1 , 1, campoTelCel);
        adicionaComponente(3, 3, 1 , 1, campoTelResi);
        adicionaComponente(4, 1, 1 , 1, campoEndereco);
        adicionaComponente(4, 3, 1 , 1, campoNCasa);
        adicionaComponente(5, 1, 1 , 1, campoBairro);
        adicionaComponente(5, 3, 1 , 1, campoCEP);
        adicionaComponente(6, 1, 1 , 1, campoComplemento);
        adicionaComponente(6, 3, 1 , 1, campoCidade);
        adicionaComponente(7, 1, 1 , 1, campoEstado);
        pack();
    }
}
