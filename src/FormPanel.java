import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton submit;
    private JList ageList;

    private FormListener formListener;

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

        ageList = new JList();
        DefaultListModel ageModel = new DefaultListModel();
        ageModel.addElement(new AgeCategory(1, "Under 18"));
        ageModel.addElement(new AgeCategory(2, "18 ot 65"));
        ageModel.addElement(new AgeCategory(3, "65 or over"));
        ageList.setModel(ageModel);
        ageList.setPreferredSize(new Dimension(110, 70));
        ageList.setBorder(BorderFactory.createEtchedBorder());
        ageList.setSelectedIndex(2);

        gc.gridx = 1;
        gc.gridy = 2;
        gc.insets = new Insets(0, 0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(ageList, gc);

        ////////////////////////// FOURTH ROW //////////////////////////
        gc.weightx = 1;
        gc.weighty = 1;

        submit = new JButton("Submit");
        gc.gridx = 1;
        gc.gridy = 3;
        gc.insets = new Insets(0, 0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submit, gc);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String occupation = occupationField.getText();
                AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
                int ageCatId = ageCat.getId();

                FormEvent event = new FormEvent(this, name, occupation, ageCatId);

                if (formListener != null) {
                    formListener.formEventOccurred(event);
                }

            }
        });

    }

    public void setFormListener(FormListener listener) {
        this.formListener = listener;
    }
}

class AgeCategory {
    private int id;

    public int getId() {
        return id;
    }

    private String text;
    public AgeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}
