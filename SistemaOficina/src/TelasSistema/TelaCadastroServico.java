package TelasSistema;

import Componentes.MeuJTextField;


public class TelaCadastroServico extends TelaCadastro {
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, "Codigo: ");
    public MeuJTextField campoNome = new MeuJTextField(true, 20, "Nome serviço: ");
    public TelaCadastroServico(){
        super("Cadastro de Serviço");
        adicionaComponente(1, 1, 1 , 1, campoCodigo);
        adicionaComponente(1, 3, 1 , 1, campoNome);
        pack();
    }
}
