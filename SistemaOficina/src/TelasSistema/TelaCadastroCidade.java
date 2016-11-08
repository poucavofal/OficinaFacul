
package TelasSistema;

import Componentes.MeuDBComboBox;
import Componentes.MeuJTextField;
import Pojo.Cidade;
import dao.DaoCidade;
import dao.DaoEstado;


public class TelaCadastroCidade extends TelaCadastro {
    public Cidade cidade = new Cidade();
    public DaoCidade daoCidade = new DaoCidade(cidade);
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, "Código: ");
    public MeuJTextField campoNome = new MeuJTextField(true, 30, "Nome: ");
    private MeuDBComboBox campoEstado = new MeuDBComboBox(true, DaoEstado.SQLCOMBOBOX, "Estado");
    public TelaCadastroCidade(){
        super("Cadastro Cidade");
        adicionaComponente(1, 1, 1 , 1, campoCodigo);
        adicionaComponente(3, 1, 1 , 1, campoNome);
        adicionaComponente(5, 1, 1 , 1, campoEstado);
        pack();
        habilitaComponentes(false);
    }
    public void setPersistencia() {
        cidade.setCodigo_Cidade(Integer.parseInt(campoCodigo.getText()));
        cidade.setNome_Cidade(campoNome.getText());
        cidade.setCodigo_Estado(campoEstado.getValor());
    }

    @Override
    public boolean incluirBD() {
        setPersistencia();
        return daoCidade.incluir();
    }

    @Override
    public boolean alterarBD() {
        setPersistencia();
        return daoCidade.alterar();
    }

    @Override
    public boolean excluirBD() {
        setPersistencia();
        return daoCidade.excluir();
    }

    @Override
    public boolean consultarBD() {
        cidade.setCodigo_Cidade(Integer.parseInt(campoCodigo.getText()));
        if (daoCidade.consultar()) {
            campoNome.setText(cidade.getNome_Cidade());
            campoEstado.setValor(cidade.getCodigo_Estado());
            return true;
        } else {
            return false;
        }
    }
}
