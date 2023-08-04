
import view.ManagementApp;
public class TestDriver {
    public static void main(String[] args) {

        ManagementApp app = new ManagementApp();
        app.initialize();
<<<<<<< HEAD

        SwingUtilities.invokeLater(() -> {
            try {
                new ManagementApp().initialize();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

=======
>>>>>>> 3ffdeab03fc49c851a88f953545973cb77c8b88a
    }
}
