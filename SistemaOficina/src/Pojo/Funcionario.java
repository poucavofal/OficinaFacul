
package Pojo;


public class Funcionario {
    private int     Codigo_Funcionario;
    private String  Nome_Funcionario;
    private String  Telefone_Celular;
    private String  Telefone_Residencial;
    private String  RG_Funcionario;
    private String  CPF_Funcionario;

    public int getCodigo_Funcionario() {
        return Codigo_Funcionario;
    }

    public void setCodigo_Funcionario(int Codigo_Funcionario) {
        this.Codigo_Funcionario = Codigo_Funcionario;
    }

    public String getNome_Funcionario() {
        return Nome_Funcionario;
    }

    public void setNome_Funcionario(String Nome_Funcionario) {
        this.Nome_Funcionario = Nome_Funcionario;
    }

    public String getTelefone_Celular() {
        return Telefone_Celular;
    }

    public void setTelefone_Celular(String Telefone_Celular) {
        this.Telefone_Celular = Telefone_Celular;
    }

    public String getTelefone_Residencial() {
        return Telefone_Residencial;
    }

    public void setTelefone_Residencial(String Telefone_Residencial) {
        this.Telefone_Residencial = Telefone_Residencial;
    }

    public String getRG_Funcionario() {
        return RG_Funcionario;
    }

    public void setRG_Funcionario(String RG_Funcionario) {
        this.RG_Funcionario = RG_Funcionario;
    }

    public String getCPF_Funcionario() {
        return CPF_Funcionario;
    }

    public void setCPF_Funcionario(String CPF_Funcionario) {
        this.CPF_Funcionario = CPF_Funcionario;
    }
    
}
