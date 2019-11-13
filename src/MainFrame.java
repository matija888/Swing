import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private Toolbar toolbar;
    private TextPanel textPanel;

    public MainFrame() {
        super("Hello");

        // instatiate new components
        toolbar = new Toolbar();
        textPanel = new TextPanel();

        // set Layout for main frame
        setLayout(new BorderLayout());

        toolbar.setTextPanel(textPanel);

        // add components to the frame
        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
