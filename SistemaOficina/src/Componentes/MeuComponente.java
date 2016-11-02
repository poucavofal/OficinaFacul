package componentes;

public interface MeuComponente {
   public String getDica();    
   public boolean eObrigatorio();
   public void habilitar(boolean status);
   public boolean eVazio();
   public boolean eValido();
}