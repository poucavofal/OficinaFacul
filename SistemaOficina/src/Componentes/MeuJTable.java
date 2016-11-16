
package Componentes;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class MeuJTable extends JScrollPane implements ActionListener, MeuComponente {
    private boolean obrigatorio;
    private String dica;
    public DefaultTableModel deftablemodel = new DefaultTableModel(
            new Object[][]{},
            new Object[]{"Nome Produto","Fornecedor","Quantidade","Valor do Produto","Valor Total"});
    public JTable tabela = new JTable(deftablemodel);
    
    public MeuJTable(boolean obrigatorio, String dica) {
        this.obrigatorio = obrigatorio;
        this.dica = dica;
        setViewportView(tabela);
        setPreferredSize(new Dimension(800, 300));
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        
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
        tabela.setEnabled(status);
        }

    @Override
    public boolean eVazio() {
        return tabela.getRowCount()== 0;
        }

    @Override
    public boolean eValido() {
        return true;
        }

    @Override
    public void Limpar() {
        while (deftablemodel.getRowCount()>0){
            deftablemodel.removeRow(0);
        }
        }
    
}
