import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // implemented swing for user interface
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SmartPayGUI().setVisible(true);
            }
        });
    }
}
