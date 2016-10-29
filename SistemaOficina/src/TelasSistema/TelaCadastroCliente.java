/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TelasSistema;

import Componentes.MeuJTextField;


/**
 *
 * @author Jean
 */
public class TelaCadastroCliente extends TelaCadastro {
    public MeuJTextField campoCodigo = new MeuJTextField(10, "Código: ");
    public MeuJTextField campoNome = new MeuJTextField(30, "Nome: ");
    public MeuJTextField campoRG = new MeuJTextField(12, "RG:");
    public MeuJTextField campoCPF = new MeuJTextField(14, "CPF:");
    public MeuJTextField campoEndereco = new MeuJTextField(14, "Endereço:");
    public MeuJTextField campoNCasa = new MeuJTextField(14, "Nº:");
    public MeuJTextField campoBairro = new MeuJTextField(14, "Bairro:");
    public MeuJTextField campoCEP = new MeuJTextField(14, "CEP:");
    public MeuJTextField campoComplemento = new MeuJTextField(14, "Complemento:");
    public MeuJTextField campoCidade = new MeuJTextField(14, "Cidade: ");
    public MeuJTextField campoEstado = new MeuJTextField(14, "Estado: : ");
    public MeuJTextField campoTelCel = new MeuJTextField(10, "Celular: ");
    public MeuJTextField campoTelResi = new MeuJTextField(10, "Residencial: ");
    public MeuJTextField campoSexo = new MeuJTextField(7, "Sexo: ");
    public MeuJTextField campoEmail = new MeuJTextField(20, "E-mail: ");
    public MeuJTextField campoDataCadastro = new MeuJTextField(10, "Data do Cadastro: ");
    
    public TelaCadastroCliente(){
        super("Cadastro Cliente");
    adicionaComponente(1, 1, campoCodigo);
    adicionaComponente(1, 3, campoNome);
    adicionaComponente(2, 1, campoRG);
    adicionaComponente(2, 3, campoCPF);
    adicionaComponente(3, 1, campoEndereco);
    adicionaComponente(3, 3, campoNCasa);
    adicionaComponente(4, 1, campoBairro);
    adicionaComponente(4, 3, campoCEP);
    adicionaComponente(5, 1, campoComplemento);
    adicionaComponente(5, 3, campoCidade);
    adicionaComponente(6, 1, campoEstado);
    adicionaComponente(6, 3, campoTelCel);
    adicionaComponente(7, 1, campoTelResi);
    adicionaComponente(7, 3, campoSexo);
    adicionaComponente(8, 1, campoEmail);
    adicionaComponente(8, 3, campoDataCadastro);
    pack();
}
    
}
