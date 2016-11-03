package Componentes;

import java.text.SimpleDateFormat;
import javax.swing.text.MaskFormatter;

public class MeuCampoData extends MeuJFormattedTextField {
    public MeuCampoData(boolean obrigatorio, String dica) {
        super(obrigatorio, dica);
        try {
            MaskFormatter mf = new MaskFormatter("##/##/####");
            mf.install(this);
            setColumns(10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean eVazio() {
        return getText().equals("  /  /    ");
    }
    
    @Override
    public boolean eValido() {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            sdf.setLenient(false);
            sdf.parse(getText());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}