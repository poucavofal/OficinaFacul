
package TelasSistema;

import Componentes.MeuJTextField;


public class TelaCadastroEstado extends TelaCadastro{
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, "Codigo: ");
    public MeuJTextField campoNEstado = new MeuJTextField(true,30, "Nome: ");
    public TelaCadastroEstado(){
        super("Cadastro Estado");
        adicionaComponente(1, 1, campoCodigo);
        adicionaComponente(2, 1, campoNEstado);
        pack();
    }
}
