
package Pojo;

public class Endereco {
    private int     Codigo_Endereco;
    private String  Rua;
    private int     Cep;
    private String  Bairro;
    private int     Numero_Casa;
    private String  Complemento;
    private int     Codigo_Cidade;

    public int getCodigo_Endereco() {
        return Codigo_Endereco;
    }

    public void setCodigo_Endereco(int Codigo_Endereco) {
        this.Codigo_Endereco = Codigo_Endereco;
    }

    public String getRua() {
        return Rua;
    }

    public void setRua(String Rua) {
        this.Rua = Rua;
    }

    public int getCep() {
        return Cep;
    }

    public void setCep(int Cep) {
        this.Cep = Cep;
    }

    public String getBairro() {
        return Bairro;
    }

    public void setBairro(String Bairro) {
        this.Bairro = Bairro;
    }

    public int getNumero_Casa() {
        return Numero_Casa;
    }

    public void setNumero_Casa(int Numero_Casa) {
        this.Numero_Casa = Numero_Casa;
    }

    public String getComplemento() {
        return Complemento;
    }

    public void setComplemento(String Complemento) {
        this.Complemento = Complemento;
    }

    public int getCodigo_Cidade() {
        return Codigo_Cidade;
    }

    public void setCodigo_Cidade(int Codigo_Cidade) {
        this.Codigo_Cidade = Codigo_Cidade;
    }
    
}
