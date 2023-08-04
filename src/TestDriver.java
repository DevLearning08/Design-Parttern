import javax.swing.SwingUtilities;

import presentation.view.ManagementApp;


public class TestDriver {
    public static void main(String[] args) {
        
            try {
                new ManagementApp().initialize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        };
    
}
