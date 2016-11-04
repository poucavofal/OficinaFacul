
package TelasSistema;

import Componentes.MeuJTextField;
import Pojo.Estado;
import dao.DaoEstado;


public class TelaCadastroEstado extends TelaCadastro{
    public Estado estado = new Estado();
    public DaoEstado daoEstado = new DaoEstado(estado);
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, "Codigo: ");
    public MeuJTextField campoNEstado = new MeuJTextField(true,15, "Nome: ");
    public MeuJTextField campoSigla = new MeuJTextField(true,2, "Sigla: ");
    public TelaCadastroEstado(){
        super("Cadastro Estado");
        adicionaComponente(1, 1, 1 , 1, campoCodigo);
        adicionaComponente(3, 1, 1 , 1, campoNEstado);
        adicionaComponente(5, 1, 1, 1, campoSigla);
        pack();
        habilitaComponentes(false);
    }
    public void setPersistencia() {
        estado.setCodigo_Estado(Integer.parseInt(campoCodigo.getText()));
        estado.setNome_Estado(campoNEstado.getText());
        estado.setSigla(campoSigla.getText());
        estado.setSigla(campoSigla.getText());
    }

    @Override
    public boolean incluirBD() {
        setPersistencia();
        return daoEstado.incluir();
    }

    @Override
    public boolean alterarBD() {
        setPersistencia();
        return daoEstado.alterar();
    }

    @Override
    public boolean excluirBD() {
        setPersistencia();
        return daoEstado.excluir();
    }

    @Override
    public boolean consultarBD() {
        estado.setCodigo_Estado(Integer.parseInt(campoCodigo.getText()));
        if (daoEstado.consultar()) {
            campoNEstado.setText(estado.getNome_Estado());
            campoSigla.setText(estado.getSigla());
            return true;
        } else {
            return false;
        }
    }
}
