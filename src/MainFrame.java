import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class MainFrame extends JFrame {

    private Toolbar toolbar;
    private TextPanel textPanel;
    private FormPanel formPanel;

    private JMenuBar createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("File");
        JMenuItem exportData = new JMenuItem("Export data ...");
        JMenuItem importData = new JMenuItem("Import data ...");
        JMenuItem exit = new JMenuItem("Exit");
        fileMenu.add(exportData);
        fileMenu.add(importData);
        fileMenu.add(exit);

        JMenu windowMenu = new JMenu("Window");
        JMenu showFormItem = new JMenu("Show");

        JCheckBoxMenuItem personForm = new JCheckBoxMenuItem("Person form");
        personForm.setSelected(true);

        showFormItem.add(personForm);
        windowMenu.add(showFormItem);

        menuBar.add(fileMenu);
        menuBar.add(windowMenu);

        personForm.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JCheckBoxMenuItem menuItem = (JCheckBoxMenuItem) e.getSource();
                formPanel.setVisible(menuItem.isSelected());
            }
        });

        fileMenu.setMnemonic(KeyEvent.VK_F);
        exit.setMnemonic(KeyEvent.VK_X);
        exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        return menuBar;
    }

    public MainFrame() {
        super("Hello");

        // instatiate new components
        toolbar = new Toolbar();
        textPanel = new TextPanel();
        formPanel = new FormPanel();

        setJMenuBar(createMenuBar());

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
                        + "; Age category: " + event.getAgeCategory() + "; Employee category: "
                        + event.getEmpoloyeeCategory() + "; Gender: " + event.getGender() + "\n";
                textPanel.appendText(msgOutput);
            }
        });

        // add components to the frame
        add(formPanel, BorderLayout.WEST);
        add(textPanel, BorderLayout.CENTER);
        add(toolbar, BorderLayout.NORTH);

        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
