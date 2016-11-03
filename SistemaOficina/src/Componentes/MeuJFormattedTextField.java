package Componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JFormattedTextField;

public class MeuJFormattedTextField extends JFormattedTextField implements MeuComponente, FocusListener {

    public boolean obrigatorio;
    public String dica;

    public MeuJFormattedTextField(boolean obrigatorio, String dica) {
        this.obrigatorio = obrigatorio;
        this.dica = dica;
        addFocusListener(this);
        focusLost(null);
    }

    @Override
    public String getDica() {
        return dica;
    }

    @Override
    public boolean eObrigatorio() {
        return obrigatorio;
    }

    @Override
    public void habilitar(boolean status) {
        setEnabled(status);
    }

    @Override
    public boolean eVazio() {
        return false;
    }

    @Override
    public boolean eValido() {
        return true;
    }

    @Override
    public void focusGained(FocusEvent fe) {
        setBackground(Color.green);
    }

    @Override
    public void focusLost(FocusEvent fe) {
        if (eObrigatorio()) {
            setBackground(Color.yellow);
        } else {
            setBackground(Color.white);
        }
    }

    @Override
    public void Limpar() {
        setText("");
    }
}