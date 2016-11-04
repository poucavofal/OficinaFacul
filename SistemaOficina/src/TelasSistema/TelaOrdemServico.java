
package TelasSistema;

import Componentes.MeuJTextField;


public class TelaOrdemServico extends TelaCadastro {
    public MeuJTextField campoCodigo = new MeuJTextField(true, 10, " Codigo: ");
    public MeuJTextField campoCliente = new MeuJTextField(true, 15, " Cliente: ");
    public MeuJTextField campoPlacaCarro = new MeuJTextField(true, 10, " Placa: ");
    public MeuJTextField campoMarca = new MeuJTextField(true, 10, " Marca: ");
    public MeuJTextField campoCor = new MeuJTextField(true, 10, " Cor: ");
    public MeuJTextField campoStatus = new MeuJTextField(true, 10, " Data:");
    
    public TelaOrdemServico(){
        super("Ordem de serviço");
        adicionaComponente(1, 1, 1 , 1, campoCodigo);
        adicionaComponente(1, 3, 1 , 1, campoCliente);
        adicionaComponente(1, 5, 1 , 1, campoPlacaCarro);
        adicionaComponente(2, 3, 1 , 1, campoMarca);
        adicionaComponente(2, 1, 1 , 1, campoCor);
        adicionaComponente(2, 5, 1 , 1, campoStatus);
        pack();
    }
}

    

 
