
package Pojo;

public class Ordem_Servico {
    private int     Codigo_Os;
    private int     Codigo_Cliente;
    private String  Data_Os;
    private int     Codigo_Carro;

    public int getCodigo_Os() {
        return Codigo_Os;
    }

    public void setCodigo_Os(int Codigo_Os) {
        this.Codigo_Os = Codigo_Os;
    }

    public int getCodigo_Cliente() {
        return Codigo_Cliente;
    }

    public void setCodigo_Cliente(int Codigo_Cliente) {
        this.Codigo_Cliente = Codigo_Cliente;
    }

    public String getData_Os() {
        return Data_Os;
    }

    public void setData_Os(String Data_Os) {
        this.Data_Os = Data_Os;
    }

    public int getCodigo_Carro() {
        return Codigo_Carro;
    }

    public void setCodigo_Carro(int Codigo_Carro) {
        this.Codigo_Carro = Codigo_Carro;
    }
    
}
