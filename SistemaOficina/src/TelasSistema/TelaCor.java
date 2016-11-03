
package TelasSistema;

import Componentes.MeuJTextField;


public class TelaCor extends TelaCadastro {
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, "Codigo");
    public MeuJTextField campoNome = new MeuJTextField(true, 20, "Nome");
    public TelaCor(){
        super("Cadastro de Cor");
        adicionaComponente(1, 1, campoCodigo);
        adicionaComponente(1, 3, campoNome);
        pack();
    }
    
}
