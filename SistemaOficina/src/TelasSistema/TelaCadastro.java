
package TelasSistema;

import Componentes.MeuJTextField;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class TelaCadastro extends JFrame implements ActionListener {
    public final int PADRAO = 0;
    public final int INCLUINDO = 1;
    public final int ALTERANDO = 2;
    public final int EXCLUINDO = 3;
    public final int CONSULTANDO = 4;
    public int estadoTela = PADRAO;
    public JPanel jpComponentes = new JPanel();
    public JPanel jpbotao = new JPanel();
    public JButton jbIncluir = new JButton("Incluir"); 
    public JButton jbAlterar = new JButton("Altear"); 
    public JButton jbExcluir = new JButton("Excluir");
    public JButton jbConsultar = new JButton("Consultar");
    public JButton jbConfirmar = new JButton("Confirmar");
    public JButton jbCancelar = new JButton ("Cancelar");
    
    
    public TelaCadastro(String titulo){
    setTitle(titulo);
    getContentPane().setLayout(new BorderLayout());
    setVisible(true);
    getContentPane().add("West", jpComponentes);
    getContentPane().add("South", jpbotao);
    jpComponentes.setLayout(new GridBagLayout());
    jpbotao.setLayout(new GridLayout(1,6));
    adicionaBotao(jbIncluir);
    adicionaBotao(jbAlterar);
    adicionaBotao(jbExcluir);
    adicionaBotao(jbConsultar);
    adicionaBotao(jbConfirmar);
    adicionaBotao(jbCancelar);
    pack();
    habilitaBotoes();
}
    public void adicionaComponente(int linha, int coluna, JComponent componente){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = linha;
        gbc.gridx = coluna;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel label = new JLabel (((MeuJTextField) componente).getDica());
        jpComponentes.add(label, gbc);
        gbc.gridx++;
        jpComponentes.add(componente, gbc);
    }
    
    public void adicionaBotao(JButton botao){
        jpbotao.add(botao);
        botao.addActionListener(this);
    }
    
    public void habilitaBotoes(){
        jbIncluir.setEnabled(estadoTela == PADRAO);
        jbAlterar.setEnabled(false);
        jbExcluir.setEnabled(false);
        jbConsultar.setEnabled(estadoTela == PADRAO);
        jbConfirmar.setEnabled(estadoTela != PADRAO);
        jbCancelar.setEnabled(estadoTela != PADRAO);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jbIncluir){
            incluir();
        }
        if (e.getSource() == jbAlterar){
            alterar();
        }
        if (e.getSource() == jbExcluir){
            excluir();
        }
        if (e.getSource() == jbConsultar){
            consultar();
        }
        if (e.getSource() == jbConfirmar){
            confirmar();
        }
        if (e.getSource() == jbCancelar){
            cancelar();
        }
    }
    public void incluir(){
        estadoTela = INCLUINDO;
        habilitaBotoes();
        
    }
    public void alterar(){
        estadoTela = ALTERANDO;
        habilitaBotoes();
        
    }
    public void excluir(){
        estadoTela = EXCLUINDO;
        habilitaBotoes();
        
    }
    public void consultar(){
        estadoTela = CONSULTANDO;
        habilitaBotoes();
        
    }
    public void confirmar(){
        estadoTela = PADRAO;
        habilitaBotoes();
        
    }
    public void cancelar(){
        estadoTela = PADRAO;
        habilitaBotoes();
    }
}
