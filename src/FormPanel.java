import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.BorderFactory;
import javax.swing.border.Border;
import java.awt.*;

public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton submit;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        Border innerBorder = BorderFactory.createTitledBorder("Add person");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
//        gc.fill = GridBagConstraints.NONE;

        ////////////////////////// FIRST ROW //////////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        nameLabel = new JLabel("Name: ");
        gc.gridx = 0;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(nameLabel, gc);

        nameField = new JTextField(10);
        gc.gridx = 1;
        gc.gridy = 0;
        gc.insets = new Insets(0, 0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(nameField, gc);

        ////////////////////////// SECOND ROW //////////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        occupationLabel = new JLabel("Occupation: ");
        gc.gridx = 0;
        gc.gridy = 1;
        gc.insets = new Insets(0, 0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(occupationLabel, gc);

        occupationField = new JTextField(10);
        gc.gridx = 1;
        gc.gridy = 1;
        gc.insets = new Insets(0, 0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(occupationField, gc);

        ////////////////////////// THIRD ROW //////////////////////////
        gc.weightx = 1;
        gc.weighty = 1;

        submit = new JButton("Submit");
        gc.gridx = 1;
        gc.gridy = 2;
        gc.insets = new Insets(0, 0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submit, gc);

    }
}
