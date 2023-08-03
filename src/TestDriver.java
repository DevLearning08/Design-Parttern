import javax.swing.SwingUtilities;

import presentation.ManagementApp;


public class TestDriver {
    public static void main(String[] args) {
<<<<<<< HEAD
        ManagementApp app = new ManagementApp();
        app.initialize();
=======
        SwingUtilities.invokeLater(() -> {
            try {
                new ManagementApp().initialize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
>>>>>>> 999ef153febda5c7d8705ab0dddcd99978df2237
    }
}
