
package ui;

import com.formdev.flatlaf.FlatLightLaf;
import javax.swing.UIManager;

public interface LookAndFeelInitializer {
    
    static void init() {
        
        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception x) {
            
        }
        
    }
    
}
