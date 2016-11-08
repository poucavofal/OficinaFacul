
package TelasSistema;

import Componentes.MeuJTextField;
import Pojo.Produto;
import dao.DaoProduto;

public class TelaCadastroProduto extends TelaCadastro {
    public Produto produto = new Produto ();
    public DaoProduto daoProduto = new DaoProduto(produto);
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, "Codigo ");
    public MeuJTextField campoNomePeca = new MeuJTextField(true, 20, "Nome da peça ");
    public MeuJTextField campoQtde = new MeuJTextField(true, 5, "Quantidade ");
    public MeuJTextField campoCor = new MeuJTextField(true, 10, "Cor ");

    public TelaCadastroProduto(){
        super("Cadastro de Produtos");
        adicionaComponente(1, 1, 1 , 1, campoCodigo);
        adicionaComponente(1, 3, 1 , 1, campoNomePeca);
        adicionaComponente(3, 1, 1 , 1, campoQtde);
        adicionaComponente(3, 3, 1 , 1, campoCor);
        pack();
    }
//    public void setPersistencia() {
//        produto.setCodigo_Estado(Integer.parseInt(campoCodigo.getText()));
//        produto.setNome_Estado(campoNEstado.getText());
//        produto.setSigla(campoSigla.getText());
//        produto.setSigla(campoSigla.getText());
//    }
//
//    @Override
//    public boolean incluirBD() {
//        setPersistencia();
//        return daoEstado.incluir();
//    }
//
//    @Override
//    public boolean alterarBD() {
//        setPersistencia();
//        return daoEstado.alterar();
//    }
//
//    @Override
//    public boolean excluirBD() {
//        setPersistencia();
//        return daoEstado.excluir();
//    }
//
//    @Override
//    public boolean consultarBD() {
//        estado.setCodigo_Estado(Integer.parseInt(campoCodigo.getText()));
//        if (daoEstado.consultar()) {
//            campoNEstado.setText(estado.getNome_Estado());
//            campoSigla.setText(estado.getSigla());
//            return true;
//        } else {
//            return false;
//        }
//    }
}
