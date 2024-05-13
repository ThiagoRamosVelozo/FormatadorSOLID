
package ui;

import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.UIManager;

public interface LookAndFeelInitializer {
    
    static void init() {
        
        try {
            UIManager.setLookAndFeel(new FlatDarkLaf());
        } catch (Exception x) {
            
        }
        
    }
    
}
