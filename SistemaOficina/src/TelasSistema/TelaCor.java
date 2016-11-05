
package TelasSistema;

import Componentes.MeuJTextField;
import Pojo.Cor;
import dao.DaoCor;


public class TelaCor extends TelaCadastro {
    public Cor cor = new Cor ();
    public DaoCor  daoCor = new DaoCor(cor);
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, "Codigo");
    public MeuJTextField campoNome = new MeuJTextField(true, 20, "Nome");
    public TelaCor(){
        super("Cadastro de Cor");
        adicionaComponente(1, 1, 1 , 1, campoCodigo);
        adicionaComponente(1, 3, 1 , 1, campoNome);
        pack();
    }
    public void setPersistencia() {
        cor.setCodigo_Cor(Integer.parseInt(campoCodigo.getText()));
        cor.setNome_Cor(campoNome.getText());
    }

    @Override
    public boolean incluirBD() {
        setPersistencia();
        return daoCor.incluir();
    }

    @Override
    public boolean alterarBD() {
        setPersistencia();
        return daoCor.alterar();
    }

    @Override
    public boolean excluirBD() {
        setPersistencia();
        return daoCor.excluir();
    }

    @Override
    public boolean consultarBD() {
        cor.setCodigo_Cor(Integer.parseInt(campoCodigo.getText()));
        if (daoCor.consultar()) {
            campoNome.setText(cor.getNome_Cor());
            return true;
        } else {
            return false;
        }
    }
    
}
