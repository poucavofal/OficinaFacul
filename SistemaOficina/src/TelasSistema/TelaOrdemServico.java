
package TelasSistema;

import Componentes.MeuJTextField;


public class TelaOrdemServico extends TelaCadastro {
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, " Codigo ");
    public MeuJTextField campoCliente = new MeuJTextField(true, 15, " Cliente ");
    public MeuJTextField campoPlacaCarro = new MeuJTextField(true, 10, " Placa ");
    public MeuJTextField campoMarca = new MeuJTextField(true, 10, " Marca ");
    public MeuJTextField campoCor = new MeuJTextField(true, 10, " Cor ");
    public MeuJTextField campoStatus = new MeuJTextField(true, 10, " Data");
    
    public TelaOrdemServico(){
        super("Ordem de serviço");
        adicionaComponente(1, 1, 1 , 1, campoCodigo);
        adicionaComponente(1, 3, 1 , 1, campoCliente);
        adicionaComponente(1, 5, 1 , 1, campoPlacaCarro);
        adicionaComponente(3, 3, 1 , 1, campoMarca);
        adicionaComponente(3, 1, 1 , 1, campoCor);
        adicionaComponente(3, 5, 1 , 1, campoStatus);
        pack();
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

    

 
