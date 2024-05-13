
package main;

import javax.swing.SwingUtilities;
import ui.Janela;
import ui.LookAndFeelInitializer;

public class Main {

    public static void main(String[] args) {
        
        LookAndFeelInitializer.init();
        
        SwingUtilities.invokeLater(()->{Janela.getInstance().setVisible(true);});
        
    }
    
}
