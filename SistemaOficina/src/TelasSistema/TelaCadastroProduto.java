
package TelasSistema;

import Componentes.MeuDBComboBox;
import Componentes.MeuJTextField;
import Pojo.Produto;
import dao.DaoCor;
import dao.DaoMarca;
import dao.DaoProduto;

public class TelaCadastroProduto extends TelaCadastro {
    public Produto produto = new Produto ();
    public DaoProduto daoProduto = new DaoProduto(produto);
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, "Codigo ");
    public MeuJTextField campoNomePeca = new MeuJTextField(true, 20, "Nome da peça ");
    public MeuJTextField campoQtde = new MeuJTextField(true, 5, "Quantidade ");
    public MeuDBComboBox campoCor = new MeuDBComboBox(true, DaoCor.SQLCOMBOBOX, "Cor ");
    public MeuDBComboBox campoMarca = new MeuDBComboBox(true, DaoMarca.SQLCOMBOBOX, "Marca ");

    public TelaCadastroProduto(){
        super("Cadastro de Produtos");
        adicionaComponente(1, 1, 1 , 1, campoCodigo);
        adicionaComponente(1, 3, 1 , 1, campoNomePeca);
        adicionaComponente(1, 5, 1 , 1, campoQtde);
        adicionaComponente(5, 1, 1 , 1, campoCor);
        adicionaComponente(5, 3, 1, 1, campoMarca);
        pack();
        habilitaComponentes(false);
    }
    public void setPersistencia() {
        produto.setCodigo_Produto(Integer.parseInt(campoCodigo.getText()));
        produto.setNome_Peca(campoNomePeca.getText());
        produto.setQntd(Integer.parseInt(campoQtde.getText()));
        produto.setCodigo_Cor(campoCor.getValor());
        produto.setCodigo_Marca(campoMarca.getValor());
    }

    @Override
    public boolean incluirBD() {
        setPersistencia();
        return daoProduto.incluir();
    }

    @Override
    public boolean alterarBD() {
        setPersistencia();
        return daoProduto.alterar();
    }

    @Override
    public boolean excluirBD() {
        setPersistencia();
        return daoProduto.excluir();
    }

    @Override
    public boolean consultarBD() {
        produto.setCodigo_Produto(Integer.parseInt(campoCodigo.getText()));
        if (daoProduto.consultar()) {
            campoNomePeca.setText(produto.getNome_Peca());
            campoQtde.setText(""+produto.getQntd());
            campoCor.setValor(produto.getCodigo_Cor());
            campoMarca.setValor(produto.getCodigo_Marca());
            return true;
        } else {
            return false;
        }
    }
}
