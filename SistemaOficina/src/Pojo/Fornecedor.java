
package Pojo;

public class Fornecedor {
    private int     Codigo_Fornecedor;
    private String  Nome_Fornecedor;
    private String  Telefone_Comercial;
    private String  Nome_Vendedor;
    private int     Codigo_Endereco;
    private String  CNPJ;

    public int getCodigo_Fornecedor() {
        return Codigo_Fornecedor;
    }

    public void setCodigo_Fornecedor(int Codigo_Fornecedor) {
        this.Codigo_Fornecedor = Codigo_Fornecedor;
    }

    public String getNome_Fornecedor() {
        return Nome_Fornecedor;
    }

    public void setNome_Fornecedor(String Nome_Fornecedor) {
        this.Nome_Fornecedor = Nome_Fornecedor;
    }

    public String getTelefone_Comercial() {
        return Telefone_Comercial;
    }

    public void setTelefone_Comercial(String Telefone_Comercial) {
        this.Telefone_Comercial = Telefone_Comercial;
    }

    public String getNome_Vendedor() {
        return Nome_Vendedor;
    }

    public void setNome_Vendedor(String Nome_Vendedor) {
        this.Nome_Vendedor = Nome_Vendedor;
    }

    public int getCodigo_Endereco() {
        return Codigo_Endereco;
    }

    public void setCodigo_Endereco(int Codigo_Endereco) {
        this.Codigo_Endereco = Codigo_Endereco;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }
   
}
