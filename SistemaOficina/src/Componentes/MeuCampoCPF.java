
package Componentes;

import java.text.SimpleDateFormat;
import javax.swing.text.MaskFormatter;


public class MeuCampoCPF extends MeuJFormattedTextField {
    public MeuCampoCPF(boolean obrigatorio, String dica) {
        super(obrigatorio, dica);
        try {
            MaskFormatter mf = new MaskFormatter("###.###.###-##");
            mf.install(this);
            setColumns(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean eVazio() {
        return getText().equals("   .   .   -  ");
    }
    
    @Override
    public boolean eValido(){
        return true;
    } 
        }
   

