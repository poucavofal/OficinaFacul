package TelasSistema;

import Componentes.MeuJTextField;


public class TelaCadastroServico extends TelaCadastro {
    public MeuJTextField campoCodigo = new MeuJTextField(10, "Codigo: ");
    public MeuJTextField campoNome = new MeuJTextField(20, "Nome serviço: ");
    public TelaCadastroServico(){
        super("Cadastro de Serviço");
        adicionaComponente(1, 1, campoCodigo);
        adicionaComponente(1, 3, campoNome);
        pack();
    }
}
