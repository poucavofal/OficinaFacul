
package TelasSistema;

import Componentes.MeuJTextField;

public class TelaCadastroProduto extends TelaCadastro {
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, "Codigo: ");
    public MeuJTextField campoNomePeca = new MeuJTextField(true, 20, "Nome da peça: ");
    public MeuJTextField campoQtde = new MeuJTextField(true, 5, "Quantidade: ");
    public MeuJTextField campoCor = new MeuJTextField(true, 10, "Cor: ");

    public TelaCadastroProduto(){
        super("Cadastro de Produtos");
        adicionaComponente(1, 1, 1 , 1, campoCodigo);
        adicionaComponente(1, 3, 1 , 1, campoNomePeca);
        adicionaComponente(2, 1, 1 , 1, campoQtde);
        adicionaComponente(2, 3, 1 , 1, campoCor);
        pack();
    }
}
