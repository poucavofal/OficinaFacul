/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentes;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

/**
 *
 * @author Jean
 */
public class MeuJTextField extends JTextField implements FocusListener, MeuComponente {
    private boolean obrigatorio;
    public String dica;
    
    public MeuJTextField (boolean obrigatorio, int tamanho, String dica){
        this.obrigatorio = obrigatorio;
        this.dica = dica;
        setColumns (tamanho);
        addFocusListener(this);
        focusLost(null);
    }
   

    public String getDica(){
        return dica;
    }   
    
   public boolean eObrigatorio(){
       return obrigatorio;
   }
   
   public void habilitar(boolean status){
       setEnabled(status);
   }
   
   public boolean eVazio(){
       return getText().trim().isEmpty();
   }
   
   public boolean eValido(){
       return true;
   }
    
    @Override
    public void focusGained(FocusEvent e) {
        if(eObrigatorio()){
            setBackground(Color.white);

        }else{
            setBackground(Color.yellow);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (eObrigatorio()){
            setBackground(Color.yellow);
        }else{
            setBackground(Color.white);
        }
        
    }
    @Override
    public void Limpar() {
        setText("");
    }
}
