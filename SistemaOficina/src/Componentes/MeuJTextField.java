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
public class MeuJTextField extends JTextField implements FocusListener {
    public String dica;
    
    public MeuJTextField (int tamanho, String dica){
        this.dica = dica;
        setColumns (tamanho);
        addFocusListener(this);
    }
   

    public String getDica(){
        return dica;
    }
    
    @Override
    public void focusGained(FocusEvent e) {//Foco quando vc esta clicado dentro do campo texto
        setBackground(Color.yellow);//o campo fica amarelo quando vc esta com o cursor dentro
    }

    @Override
    public void focusLost(FocusEvent e) {//Foco quando vc sai de dentro do campo texto
        setBackground(Color.white);//o campo fica branco quando vc tira o foco dele
    }
}
