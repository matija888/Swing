import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private Toolbar toolbar;
    private TextPanel textPanel;
    private FormPanel formPanel;

    public MainFrame() {
        super("Hello");

        // instatiate new components
        toolbar = new Toolbar();
        textPanel = new TextPanel();
        formPanel = new FormPanel();

        // set Layout for main frame
        setLayout(new BorderLayout());

        toolbar.setStringListener(new StringListener() {
            public void textEmitted(String text) {
                textPanel.appendText(text);
            }
        });

        formPanel.setFormListener(new FormListener() {
            public void formEventOccurred(FormEvent event) {
                String msgOutput = "Name: " + event.getName() + "; Occupation: " + event.getOccupation()
                        + "; " + event.getAgeCategory() + "\n";
                textPanel.appendText(msgOutput);
            }
        });

        // add components to the frame
        add(formPanel, BorderLayout.WEST);
        add(toolbar, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
