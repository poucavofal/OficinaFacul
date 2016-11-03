package Componentes;

import bd.Conexao;
import java.awt.FlowLayout;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MeuDBComboBox extends JPanel implements MeuComponente {
    private boolean obrigatorio;
    private String sql;
    private String dica;
    private JComboBox jcb = new JComboBox();
    private List<Object[]> dados;
    
    public MeuDBComboBox(boolean obrigatorio, String sql, String dica) {
        this.obrigatorio = obrigatorio;
        this.sql = sql;
        this.dica = dica;
        setLayout(new FlowLayout());
        add(jcb);
        add(new JButton("..."));
        preencher();
    }
    
    public void preencher() {
        jcb.addItem("<Selecione>");
        dados = Conexao.consultarComboBox(sql);
        for (int i = 0; i < dados.size(); i++) {
            jcb.addItem(dados.get(i)[1]);
        }
    }
    
    public int getValor() {
        if (jcb.getSelectedIndex() > 0) {
            return (int) dados.get(jcb.getSelectedIndex()-1)[0];
        } else {
            return -1;
        }
    }
    
    public void setValor(int valor) {
        for (int i = 0; i < dados.size(); i++) {
            if (valor == (int) dados.get(i)[0]) {
                jcb.setSelectedIndex(i + 1);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, getDica() + " não encontrado(a).");
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
        return (jcb.getSelectedIndex() <= 0);
    }

    @Override
    public boolean eValido() {
        return true;
    }    

    @Override
    public void Limpar() {
        jcb.setSelectedIndex(0);
    }
}

