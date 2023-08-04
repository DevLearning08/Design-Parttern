import javax.swing.SwingUtilities;

import presentation.view.ManagementApp;


public class TestDriver {
    public static void main(String[] args) {
<<<<<<< HEAD
        
=======
<<<<<<< HEAD
        ManagementApp app = new ManagementApp();
        app.initialize();
=======
        SwingUtilities.invokeLater(() -> {
>>>>>>> ba893979af0674baf4c1f90e8152ec920e5f6033
            try {
                new ManagementApp().initialize();
            } catch (Exception e) {
                e.printStackTrace();
            }
<<<<<<< HEAD
        };
    
=======
        });
>>>>>>> 999ef153febda5c7d8705ab0dddcd99978df2237
    }
>>>>>>> ba893979af0674baf4c1f90e8152ec920e5f6033
}
