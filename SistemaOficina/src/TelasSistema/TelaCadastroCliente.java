/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelasSistema;

import Componentes.MeuCampoCPF;
import Componentes.MeuCampoData;
import Componentes.MeuDBComboBox;
import Componentes.MeuJTextField;
import Pojo.Cliente;
import dao.DaoCidade;
import dao.DaoCliente;
import dao.DaoEstado;



public class TelaCadastroCliente extends TelaCadastro {
    public Cliente cliente = new Cliente ();
    public DaoCliente daoCliente= new DaoCliente(cliente);
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, "Código ");
    public MeuJTextField campoNome = new MeuJTextField(true,30, "Nome ");
    public MeuJTextField campoRG = new MeuJTextField(true,12, "RG");
    public MeuCampoCPF campoCPF = new MeuCampoCPF (true, "CPF");
    public MeuJTextField campoEndereco = new MeuJTextField(false, 14, "Endereço");
    public MeuJTextField campoNCasa = new MeuJTextField(false, 14, "Nº");
    public MeuJTextField campoBairro = new MeuJTextField(false, 14, "Bairro");
    public MeuJTextField campoCEP = new MeuJTextField(false, 14, "CEP");
    public MeuJTextField campoComplemento = new MeuJTextField(false, 14, "Complemento");
    public MeuJTextField campoCidade = new MeuJTextField(false, 14, "Cidade");
    public MeuJTextField campoTelCel = new MeuJTextField(false, 10, "Celular ");
    public MeuJTextField campoTelResi = new MeuJTextField(false, 10, "Residencial ");
    public MeuJTextField campoSexo = new MeuJTextField(false, 7, "Sexo ");
    public MeuJTextField campoEmail = new MeuJTextField(false, 20, "E-mail ");
    public MeuCampoData campoDataCadastro = new MeuCampoData(true, "Data de Nascimento");
    
    public TelaCadastroCliente(){
    super("Cadastro Cliente");
    adicionaComponente(1, 1, 1 , 1, campoCodigo);
    adicionaComponente(1, 3, 1 , 1, campoNome);
    adicionaComponente(3, 1, 1 , 1, campoRG);
    adicionaComponente(3, 3, 1 , 1, campoCPF);
    adicionaComponente(5, 1, 1 , 1, campoEndereco);
    adicionaComponente(5, 3, 1 , 1, campoNCasa);
    adicionaComponente(7, 1, 1 , 1, campoBairro);
    adicionaComponente(7, 3, 1 , 1, campoCEP);
    adicionaComponente(9, 1, 1 , 1, campoComplemento);
    adicionaComponente(9, 3, 1 , 1, campoCidade);
    adicionaComponente(11, 3, 1 , 1, campoTelCel);
    adicionaComponente(13, 1, 1 , 1, campoTelResi);
    adicionaComponente(13, 3, 1 , 1, campoSexo);
    adicionaComponente(15, 1, 1 , 1, campoEmail);
    adicionaComponente(15, 3, 1 , 1, campoDataCadastro);
    pack();
    habilitaComponentes(false);
    }
    public void setPersistencia() {
        cliente.setCodigo_Cliente(Integer.parseInt(campoCodigo.getText()));
        cliente.setNome_Cliente(campoNome.getText());
        cliente.setRG_Cliente(campoRG.getText());
        cliente.setCPF_Cliente(campoCPF.getText());
        cliente.setEndereco(campoEndereco.getText());
        cliente.setNum_Casa(campoNCasa.getText());
        cliente.setBairro(campoBairro.getText());
        cliente.setCep(campoCEP.getText());
        cliente.setComplemento(campoComplemento.getText());
        cliente.setCodigo_Cidade(Integer.parseInt(campoCidade.getText()));
        cliente.setNome_Cliente(campoTelCel.getText());
        cliente.setNome_Cliente(campoSexo.getText());
        cliente.setNome_Cliente(campoEmail.getText());
        cliente.setNome_Cliente(campoDataCadastro.getText());
    }

    @Override
    public boolean incluirBD() {
        setPersistencia();
        return daoCliente.incluir();
    }

    @Override
    public boolean alterarBD() {
        setPersistencia();
        return daoCliente.alterar();
    }

    @Override
    public boolean excluirBD() {
        setPersistencia();
        return daoCliente.excluir();
    }

    @Override
    public boolean consultarBD() {
        cliente.setCodigo_Cliente(Integer.parseInt(campoCodigo.getText()));
        if (daoCliente.consultar()) {
            cliente.setNome_Cliente(campoNome.getText());
            cliente.setRG_Cliente(campoRG.getText());
            cliente.setCPF_Cliente(campoCPF.getText());
            cliente.setEndereco(campoEndereco.getText());
            cliente.setNum_Casa(campoNCasa.getText());
            cliente.setBairro(campoBairro.getText());
            cliente.setCep(campoCEP.getText());
            cliente.setComplemento(campoComplemento.getText());
            cliente.setCodigo_Cidade(Integer.parseInt(campoCidade.getText()));
            cliente.setNome_Cliente(campoTelCel.getText());
            cliente.setNome_Cliente(campoSexo.getText());
            cliente.setNome_Cliente(campoEmail.getText());
            cliente.setNome_Cliente(campoDataCadastro.getText());
            return true;
        } else {
            return false;
        }
    }
    
}
