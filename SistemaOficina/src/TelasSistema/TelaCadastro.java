
package TelasSistema;

import Componentes.MeuComponente;
import Componentes.MeuJTable;
import Componentes.MeuJTextField;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class TelaCadastro extends JInternalFrame implements ActionListener {
    public final int PADRAO = 0;
    public final int INCLUINDO = 1;
    public final int ALTERANDO = 2;
    public final int EXCLUINDO = 3;
    public final int CONSULTANDO = 4;
    public int estadoTela = PADRAO;
    public boolean temDadosNaTela = false;
    public JButton jbIncluir = new JButton("Incluir"); 
    public JButton jbAlterar = new JButton("Altear"); 
    public JButton jbExcluir = new JButton("Excluir");
    public JButton jbConsultar = new JButton("Consultar");
    public JButton jbConfirmar = new JButton("Confirmar");
    public JButton jbCancelar = new JButton ("Cancelar");
    public JButton jbIncluirItem = new JButton ("Add. Item");
    public JButton jbExcluirItem = new JButton ("Remove Item");
    public JPanel jpComponentes = new JPanel();
    public JPanel jpbotao = new JPanel();
    public List<MeuComponente> componentes = new ArrayList();
    
    public TelaCadastro(String titulo){
    super(titulo, false, true, false, true);
    getContentPane().setLayout(new BorderLayout());
    setVisible(true);
    getContentPane().add("Center", jpComponentes);
    getContentPane().add("South", jpbotao);
    jpComponentes.setLayout(new GridBagLayout());
    jpbotao.setLayout(new GridLayout(1,8));
    adicionaBotao(jbIncluir);
    adicionaBotao(jbAlterar);
    adicionaBotao(jbExcluir);
    adicionaBotao(jbConsultar);
    adicionaBotao(jbConfirmar);
    adicionaBotao(jbCancelar);
    pack();
    habilitaBotoes();
}
    public void adicionaComponente(int linha, int coluna, int linhas, int colunas,
            JComponent componente) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = linha;
        gbc.gridx = coluna;
        gbc.gridheight = linhas;
        gbc.gridwidth = colunas;
        gbc.anchor = GridBagConstraints.WEST;
        String texto = "<html><body>" + ((MeuComponente) componente).getDica();
        if (((MeuComponente) componente).eObrigatorio()) {
            texto = texto + "*";
        }
        texto = texto + ":</body></html>";
        JLabel rotulo = new JLabel(texto);
        jpComponentes.add(rotulo, gbc);
        gbc.gridy++;
        jpComponentes.add(componente, gbc);
        componentes.add((MeuComponente) componente);
    }
    
    public void habilitaComponentes(boolean status) {
        for (int i = 0; i < componentes.size(); i++) {
            componentes.get(i).habilitar(status);
        }
    }
        public void LimpaComponentes() {
        for (int i = 0; i < componentes.size(); i++) {
            componentes.get(i).Limpar();
        }
    }
    
    public boolean validaComponentes() {
        String errosObrigatorios = "", errosInvalidos = "", errosTotal = "";
        for (int i = 0; i < componentes.size(); i++) {
            if (componentes.get(i).eObrigatorio() && componentes.get(i).eVazio()) {
                errosObrigatorios = errosObrigatorios + componentes.get(i).getDica() + "\n";
            }
            if (!componentes.get(i).eValido()) {
                errosInvalidos = errosInvalidos + componentes.get(i).getDica() + "\n";
            }
        }
        if (!errosObrigatorios.isEmpty()) {
            errosTotal = "Os campos abaixo são obrigatórios e não foram preenchidos:\n\n"
                    + errosObrigatorios;
        }
        if (!errosInvalidos.isEmpty()) {
            errosTotal = errosTotal + "\n\n\n"
                    + "Os campos abaixo estão inválidos:\n\n"
                    + errosInvalidos;
        }
        if (!errosTotal.isEmpty()) {
            JOptionPane.showMessageDialog(null, errosTotal);
            return false;
        }
        return errosTotal.isEmpty();
    }
    
    public void adicionaBotao(JButton botao){
        jpbotao.add(botao);
        botao.addActionListener(this);
    }
    
    
    public void habilitaBotoes(){
        jbIncluir.setEnabled(estadoTela == PADRAO);
        jbAlterar.setEnabled(estadoTela == PADRAO && temDadosNaTela);
        jbExcluir.setEnabled(estadoTela == PADRAO && temDadosNaTela);
        jbConsultar.setEnabled(estadoTela == PADRAO);
        jbConfirmar.setEnabled(estadoTela != PADRAO);
        jbCancelar.setEnabled(estadoTela != PADRAO);
        jbIncluirItem.setEnabled(estadoTela == INCLUINDO || estadoTela == ALTERANDO);
        jbExcluirItem.setEnabled(estadoTela == INCLUINDO || estadoTela == ALTERANDO);
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
        habilitaComponentes(true);
        LimpaComponentes();
        }

    public void alterar(){
        estadoTela = ALTERANDO;
        habilitaBotoes();
        habilitaComponentes(true); 

        }
    public void excluir(){
            estadoTela = EXCLUINDO;
            habilitaBotoes();

        }
        public void consultar(){
            estadoTela = CONSULTANDO;
            habilitaBotoes();
            habilitaComponentes(true);
            LimpaComponentes();

        }
        public void confirmar(){
            if (estadoTela == INCLUINDO) {
                
                if (!validaComponentes()) {
                    return;
                }
                if (!incluirBD()) {
                    return;
                }
                temDadosNaTela = false;
                estadoTela = PADRAO;
                LimpaComponentes();
            } else if (estadoTela == ALTERANDO) {
                if (!validaComponentes()) {
                    return;
                }
                if (!alterarBD()) {
                    return;
                }
            } else if (estadoTela == EXCLUINDO) {
                if (!excluirBD()) {
                    return;
                }
                temDadosNaTela = false;
                LimpaComponentes();
            } else if (estadoTela == CONSULTANDO) {
                if (!consultarBD()) {
                    return;
                }
                temDadosNaTela = true;
                
            }
            estadoTela = PADRAO;
            habilitaBotoes();
            habilitaComponentes(false);
            
        }

        public void cancelar(){
        estadoTela = PADRAO;
        temDadosNaTela = false;
        habilitaBotoes();
        habilitaComponentes(false);
        LimpaComponentes();
        }
    
        public boolean incluirBD() {
            return true;
            //Método a ser redefinido nas sub-classes
        }

        public boolean alterarBD() {
            return true;
            //Método a ser redefinido nas sub-classes
        }

        public boolean excluirBD() {
            return true;
            //Método a ser redefinido nas sub-classes
        }

        public boolean consultarBD() {
            return true;
            //Método a ser redefinido nas sub-classes
        }    
        public boolean Incluiritem(){
            return true;
        }
    }
     


