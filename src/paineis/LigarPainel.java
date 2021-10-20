/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paineis;

/**
 *
 * @author RojeruSan
 */
import javax.swing.JPanel;

public class LigarPainel {
    //
    private JPanel container;
    private JPanel content;


   /**
     *
     * <h1>Classe reponsável por realizar a ligação entre telas.</h1>
     * 
     *
     * @author Henrique
     *
     * @see calcular
     */
    public LigarPainel(JPanel container, JPanel content) {
        
        this.container = container;
        this.content = content;
        this.container.removeAll();
        this.container.revalidate();
        this.container.repaint();
        
        this.container.add(this.content);
        this.container.revalidate();
        this.container.repaint();
        
    }

}
