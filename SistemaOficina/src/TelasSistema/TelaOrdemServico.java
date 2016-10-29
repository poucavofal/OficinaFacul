
package TelasSistema;

import Componentes.MeuJTextField;


public class TelaOrdemServico extends TelaCadastro {
    public MeuJTextField campoCodigo = new MeuJTextField(10, "Codigo: ");
    public MeuJTextField campoCliente = new MeuJTextField(15, "Cliente: ");
    public MeuJTextField campoPlacaCarro = new MeuJTextField(10, "Placa: ");
    public MeuJTextField campoMarca = new MeuJTextField(15, "Marca: ");
    public MeuJTextField campoCor = new MeuJTextField(10, "Cor: ");
    public MeuJTextField campoStatus = new MeuJTextField(10, "Data:");
    public MeuJTextField campo = new MeuJTextField(0, "  Itens OS");
    public MeuJTextField campoQtde = new MeuJTextField(0, "   Quantidade");
    public MeuJTextField campoValor = new MeuJTextField(0, "   Valor");
    public MeuJTextField campoTotal = new MeuJTextField(0, "   Total");
    public MeuJTextField campo2 = new MeuJTextField(15, "");
    public MeuJTextField campo3 = new MeuJTextField(15, "");
    public MeuJTextField campo4 = new MeuJTextField(15, "");
    public MeuJTextField campo5 = new MeuJTextField(15, "");
    public MeuJTextField campo6 = new MeuJTextField(15, "");
    public MeuJTextField campo7 = new MeuJTextField(15, "");
    public MeuJTextField campo8 = new MeuJTextField(15, "");
    public MeuJTextField campo9 = new MeuJTextField(15, "");
    public MeuJTextField campo10 = new MeuJTextField(15, "");
    public MeuJTextField campo11 = new MeuJTextField(15, "");
    public MeuJTextField campo12 = new MeuJTextField(15, "");
    public MeuJTextField campo13 = new MeuJTextField(15, "");
    public MeuJTextField campo14 = new MeuJTextField(15, "");
    public MeuJTextField campo15 = new MeuJTextField(15, "");
    public MeuJTextField campo16 = new MeuJTextField(15, "");
    public MeuJTextField campo17 = new MeuJTextField(15, "");
    public MeuJTextField campo18 = new MeuJTextField(15, "");
    
    public TelaOrdemServico(){
        super("Ordem de serviço");
        adicionaComponente(1, 1, campoCodigo);
        adicionaComponente(2, 1, campoCliente);
        adicionaComponente(3, 1, campoPlacaCarro);
        adicionaComponente(4, 1, campoMarca);
        adicionaComponente(5, 1, campoCor);
        adicionaComponente(6, 1, campoStatus);
        adicionaComponente(7, 2, campo);
        adicionaComponente(7, 3, campoQtde);
        adicionaComponente(7, 5, campoValor);
        adicionaComponente(7, 6, campoTotal);
        adicionaComponente(8, 1, campo2);
        adicionaComponente(8, 2, campo3);
        adicionaComponente(8, 4, campo4);
        adicionaComponente(8, 5, campo5);
        adicionaComponente(9, 1, campo6);
        adicionaComponente(9, 2, campo7);
        adicionaComponente(9, 4, campo8);
        adicionaComponente(9, 5, campo9);
        adicionaComponente(10, 1, campo10);
        adicionaComponente(10, 2, campo11);
        adicionaComponente(10, 4, campo12);
        adicionaComponente(10, 5, campo13);
        adicionaComponente(11, 1, campo14);
        adicionaComponente(11, 2, campo15);
        adicionaComponente(11, 4, campo16);
        adicionaComponente(11, 5, campo17);
        adicionaComponente(12, 5, campo18);
        pack();
    }
}
