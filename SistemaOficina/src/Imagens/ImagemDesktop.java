/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Imagens;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author Jean Max
 */
public class ImagemDesktop extends JDesktopPane {
    private Image imagem = new ImageIcon(getClass().getResource("/Imagens/OficinaVirtual.png")).getImage();

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension dimension = this.getSize();
        int x = (int) (dimension.getWidth() - imagem.getWidth(this));
        int y = (int) (dimension.getHeight() - imagem.getHeight(this));
        g.drawImage(imagem, 400, 100, 1200, 800, this);
    }
    
    
}

