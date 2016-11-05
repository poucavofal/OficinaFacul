
package TelasSistema;

import Componentes.MeuJTextField;
import Pojo.Funcionario;
import dao.DaoFuncionario;


public class TelaCadastroFuncionario extends TelaCadastro {
    public Funcionario funcionario = new Funcionario();
    public DaoFuncionario daoFuncionario = new DaoFuncionario(funcionario);
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, "Codigo ");
    public MeuJTextField campoNome = new MeuJTextField(true, 20, "Nome ");
    public MeuJTextField campoRG = new MeuJTextField(true, 15, "RG ");
    public MeuJTextField campoCPF = new MeuJTextField(true, 15, "CPF ");
    public MeuJTextField campoTelCel = new MeuJTextField(false,10, "Tel. Celular ");
    public MeuJTextField campoTelResi = new MeuJTextField(false,10, "Tel. Residencial ");
    public MeuJTextField campoEndereco = new MeuJTextField(false,14, "Endereço");
    public MeuJTextField campoNCasa = new MeuJTextField(false,14, "Nº");
    public MeuJTextField campoBairro = new MeuJTextField(false,14, "Bairro:");
    public MeuJTextField campoCEP = new MeuJTextField(false,14, "CEP");
    //public MeuJTextField campoComplemento = new MeuJTextField(false,14, "Complemento");
    public MeuJTextField campoCidade = new MeuJTextField(false,14, "Cidade");
    public MeuJTextField campoEspaco = new MeuJTextField(false,0,"");

    public TelaCadastroFuncionario(){
        super("Cadastro Funcionario");
        adicionaComponente(1, 1, 1 , 1, campoCodigo);
        adicionaComponente(1, 3, 1 , 1, campoNome);
        adicionaComponente(3, 1, 1 , 1, campoRG);
        adicionaComponente(3, 3, 1 , 1, campoCPF);
        adicionaComponente(5, 1, 1 , 1, campoTelCel);
        adicionaComponente(5, 3, 1 , 1, campoTelResi);
        adicionaComponente(7, 1, 1 , 1, campoEndereco);
        adicionaComponente(7, 3, 1 , 1, campoNCasa);
        adicionaComponente(9, 1, 1 , 1, campoBairro);
        adicionaComponente(9, 3, 1 , 1, campoCEP);
        //adicionaComponente(11, 1, 1 , 1, campoComplemento);
        adicionaComponente(11, 3, 1 , 1, campoCidade);
        pack();
        habilitaComponentes(false);
    }
    public void setPersistencia() {
        funcionario.setCodigo_Funcionario(Integer.parseInt(campoCodigo.getText()));
        funcionario.setNome_Funcionario(campoNome.getText());
        funcionario.setRG_Funcionario(campoRG.getText());
        funcionario.setCPF_Funcionario(campoCPF.getText());
        funcionario.setTelefone_Celular(campoTelCel.getText());
        funcionario.setTelefone_Residencial(campoTelResi.getText());
        funcionario.setEndereco_Funcionario(campoEndereco.getText());
        funcionario.setNum_Casa(campoNCasa.getText());
        funcionario.setBairro_Funcionario(campoBairro.getText());
        funcionario.setCep(campoCEP.getText());
        //funcionario.set(campoComplemento.getText());
        funcionario.setCodigo_Cidade(Integer.parseInt(campoCidade.getText()));
        
    }

    @Override
    public boolean incluirBD() {
        setPersistencia();
        return daoFuncionario.incluir();
    }

    @Override
    public boolean alterarBD() {
        setPersistencia();
        return daoFuncionario.alterar();
    }

    @Override
    public boolean excluirBD() {
        setPersistencia();
        return daoFuncionario.excluir();
    }

    @Override
    public boolean consultarBD() {
        funcionario.setCodigo_Funcionario(Integer.parseInt(campoCodigo.getText()));
        if (daoFuncionario.consultar()) {
            campoNome.setText(funcionario.getNome_Funcionario());
            campoRG.setText(funcionario.getRG_Funcionario());
            campoCPF.setText(funcionario.getCPF_Funcionario());
            campoTelCel.setText(funcionario.getTelefone_Celular());
            campoTelResi.setText(funcionario.getTelefone_Residencial());
            campoEndereco.setText(funcionario.getEndereco_Funcionario());
            campoNCasa.setText(funcionario.getNum_Casa());
            campoBairro.setText(funcionario.getBairro_Funcionario());
            campoCEP.setText(funcionario.getCep());
            //campoCidade.setText(funcionario.getCodigo_Cidade());
            return true;
        } else {
            return false;
        }
    }
}
