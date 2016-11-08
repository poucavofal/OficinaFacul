package TelasSistema;

import Componentes.MeuJTextField;
import Pojo.Servico;
import dao.DaoServico;


public class TelaCadastroServico extends TelaCadastro {
    public Servico servico = new Servico();
    public DaoServico daoServico = new DaoServico(servico);
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, "Codigo ");
    public MeuJTextField campoNome = new MeuJTextField(true, 20, "Nome serviço ");
    public TelaCadastroServico(){
        super("Cadastro de Serviço");
        adicionaComponente(1, 1, 1 , 1, campoCodigo);
        adicionaComponente(1, 3, 1 , 1, campoNome);
        pack();
        habilitaComponentes(false);
    }
    public void setPersistencia() {
        servico.setCodigo_Servico(Integer.parseInt(campoCodigo.getText()));
        servico.setNome_Servico(campoNome.getText());
    }

    @Override
    public boolean incluirBD() {
        setPersistencia();
        return daoServico.incluir();
    }

    @Override
    public boolean alterarBD() {
        setPersistencia();
        return daoServico.alterar();
    }

    @Override
    public boolean excluirBD() {
        setPersistencia();
        return daoServico.excluir();
    }

    @Override
    public boolean consultarBD() {
        servico.setCodigo_Servico(Integer.parseInt(campoCodigo.getText()));
        if (daoServico.consultar()) {
            campoNome.setText(servico.getNome_Servico());
            return true;
        } else {
            return false;
        }
    }
}
