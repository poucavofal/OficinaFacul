
package TelasSistema;

import Componentes.MeuJTextField;


public class TelaCadastroCidade extends TelaCadastro {
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, "Código: ");
    public MeuJTextField campoNome = new MeuJTextField(true, 30, "Nome: ");
    public MeuJTextField campoEstado = new MeuJTextField(true, 10, "Estado: ");
    public TelaCadastroCidade(){
        super("Cadastro Cidade");
        adicionaComponente(1, 1, 1 , 1, campoCodigo);
        adicionaComponente(2, 1, 1 , 1, campoNome);
        adicionaComponente(2, 3, 1 , 1, campoEstado);
        pack();
    }
}
