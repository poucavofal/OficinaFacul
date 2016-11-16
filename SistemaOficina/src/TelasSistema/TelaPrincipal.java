
package TelasSistema;

import Imagens.ImagemDesktop;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class TelaPrincipal extends JFrame implements ActionListener{
    public ImagemDesktop jdp = new ImagemDesktop();
    public JMenuBar menu = new JMenuBar();//Cria a barra de menu do sistema.
    public JMenu jmCadastros = new JMenu("Cadastros");//cria o item de menu.
    public JMenu jmOS = new JMenu("Serviço");//cria o item de menu.
    public JMenuItem jmiCadastroCliente = new JMenuItem("Cliente");//cria o item de submenu.
    public JMenuItem jmiCadastroFornecedor = new JMenuItem("Fornecedor");//cria o item de submenu.
    public JMenuItem jmiCadastroProduto = new JMenuItem("Produto");//cria o item de submenu.
    public JMenuItem jmiCadastroCidade = new JMenuItem("Cidade");//cria o item de submenu.
    public JMenuItem jmiCadastroEstado = new JMenuItem("Estado");//cria o item de submenu.
    public JMenuItem jmiCadastroFuncionario = new JMenuItem("Funcionário");//cria o item de submenu.
    public JMenuItem jmiCadastroServico = new JMenuItem("Serviço");//cria o item de submenu.
    public JMenuItem jmiCadastroCor = new JMenuItem("Cor");//cria o item de submenu.
    public JMenuItem jmiOS = new JMenuItem("Ordem Serviço");//cria o item de submenu.
    
public TelaPrincipal(){
    setTitle("Oficina Virtual");//Coloca o Titulo na tela do sistema.
    setExtendedState(MAXIMIZED_BOTH);//Maximisa a tela do sitema.
    setDefaultCloseOperation(EXIT_ON_CLOSE);//Fecha o programa por completo.
    getContentPane().add(jdp);
    setJMenuBar(menu);//seta a barra de menu na tela do sistema.
    setVisible(true);//Torna a tela do sistema visivel.
    menu.add(jmCadastros);//adiciona o item cadastro na barra de menu.
    menu.add(jmOS);//adiciona o item de movimentos na barra de menu.
    jmCadastros.add(jmiCadastroCliente);//adiciona o item de Cadastro de Cliente no item de cadastro no menu.
    jmCadastros.add(jmiCadastroFornecedor);//adiciona o item de Cadastro de fornecedor no item de cadastro no menu.
    jmCadastros.add(jmiCadastroFuncionario);
    jmCadastros.add(jmiCadastroProduto);//adiciona o item de Cadastro de Produto no item de cadastro no menu.
    jmCadastros.add(jmiCadastroCidade);
    jmCadastros.add(jmiCadastroEstado);
    jmCadastros.add(jmiCadastroServico);
    jmCadastros.add(jmiCadastroCor);
    jmiCadastroCliente.addActionListener(this);//implementa ação no submenu.
    jmiCadastroFornecedor.addActionListener(this);//implementa ação no submenu.
    jmiCadastroProduto.addActionListener(this);//implementa ação no submenu.
    jmiCadastroFuncionario.addActionListener(this);//implementa ação no submenu.
    jmiCadastroCidade.addActionListener(this);//implementa ação no submenu.
    jmiCadastroEstado.addActionListener(this);//implementa ação no submenu.
    jmiCadastroServico.addActionListener(this);//implementa ação no submenu.
    jmiCadastroCor.addActionListener(this);//implementa ação no submenu.
    jmOS.add(jmiOS);
    jmiOS.addActionListener(this);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        //Quando o subitem CadastroCliente for Clicado executa a ação chamando a tela de 
        //cadastro de Cliente.
        if (e.getSource()== jmiCadastroCliente){
            TelaCadastroCliente telaCadastroCliente = new TelaCadastroCliente(); 
            jdp.add(telaCadastroCliente);
        }
        //Quando o subitem CadastroFornecedor for Clicado executa a ação chamando a tela de 
        //cadastro de Fornecedor.
        else if (e.getSource()== jmiCadastroFornecedor){
            TelaCadastroFornecedor telaCadastroFornecedor = new TelaCadastroFornecedor(); 
            jdp.add(telaCadastroFornecedor);
        }
        //Quando o subitem CadastroProduto for Clicado executa a ação chamando a tela de 
        //cadastro de Produto.
        else if (e.getSource()== jmiCadastroProduto){
            TelaCadastroProduto telaCadastroProduto = new TelaCadastroProduto(); 
            jdp.add(telaCadastroProduto);
        }
        else if (e.getSource()== jmiCadastroFuncionario){
            TelaCadastroFuncionario telaCadastroFuncionario = new TelaCadastroFuncionario(); 
            jdp.add(telaCadastroFuncionario);
        }
        else if (e.getSource()== jmiCadastroCidade){
            TelaCadastroCidade telaCadastroCidade = new TelaCadastroCidade();
            jdp.add(telaCadastroCidade);
        }
        else if (e.getSource()== jmiCadastroEstado){
            TelaCadastroEstado telaCadastroEstado = new TelaCadastroEstado(); 
            jdp.add(telaCadastroEstado);
        }
        else if (e.getSource()== jmiCadastroServico){
            TelaCadastroServico telaCadastroServico = new TelaCadastroServico(); 
            jdp.add(telaCadastroServico);
        }
         else if (e.getSource()== jmiOS){
            TelaOrdemServico telaCadastroServico = new TelaOrdemServico();
            jdp.add(telaCadastroServico);
        }
         else if (e.getSource()== jmiCadastroCor){
            TelaCor telaCor = new TelaCor(); 
            jdp.add(telaCor);
        }
    }
}
