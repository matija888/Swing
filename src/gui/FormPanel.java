package gui;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class FormPanel extends JPanel {

    private JLabel nameLabel;
    private JLabel occupationLabel;
    private JTextField nameField;
    private JTextField occupationField;
    private JButton submit;
    private JList ageList;
    private JComboBox comboBox;
    private JLabel checkCitizenshipLabel;
    private JCheckBox checkCitizenship;
    private JLabel taxIdLabel;
    private JTextField taxIdField;
    private JRadioButton maleGender;
    private JRadioButton femaleGender;
    private ButtonGroup genderGroup;
    private JLabel genderLabel;

    private FormListener formListener;

    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);

        Border innerBorder = BorderFactory.createTitledBorder("Add person");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder, innerBorder));

        layoutComponents();

        submit.setMnemonic(KeyEvent.VK_O);
        // define mnemonic on nameLabel (ALT+N)
        nameLabel.setDisplayedMnemonic(KeyEvent.VK_N);
        nameLabel.setLabelFor(nameField);

        submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String occupation = occupationField.getText();
                AgeCategory ageCat = (AgeCategory) ageList.getSelectedValue();
                EmployeeCategory empoloyeeCategory = (EmployeeCategory) comboBox.getSelectedItem();

                String genderCommand = genderGroup.getSelection().getActionCommand();

                int ageCatId = ageCat.getId();
                int employeeCat = empoloyeeCategory.getId();
                boolean isCitizen = checkCitizenship.isSelected();

                FormEvent event = new FormEvent(this, name, occupation, ageCatId, employeeCat, genderCommand, isCitizen);

                if (formListener != null) {
                    formListener.formEventOccurred(event);
                }

            }
        });

        // disable zip code field until user check checkbox
        disableZipCodeFields();

        checkCitizenship.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                boolean isChecked = checkCitizenship.isSelected();
                taxIdLabel.setEnabled(isChecked);
                taxIdField.setEnabled(isChecked);
            }
        });

    }

    public void disableZipCodeFields() {
        taxIdLabel.setEnabled(false);
        taxIdField.setEnabled(false);
    }

    public void layoutComponents() {
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

        ////////////////////////// COMBO BOX ROW //////////////////////////
        gc.weightx = 1;
        gc.weighty = 1;

        comboBox = new JComboBox();
        DefaultComboBoxModel comboModel = new DefaultComboBoxModel();
        comboModel.addElement(new EmployeeCategory(1, "unemployed"));
        comboModel.addElement(new EmployeeCategory(2, "self-employed"));
        comboModel.addElement(new EmployeeCategory(3, "employed"));
        comboBox.setModel(comboModel);
        comboBox.setPreferredSize(new Dimension(110, 25));
        comboBox.setBorder(BorderFactory.createEtchedBorder());
        comboBox.setSelectedIndex(2);

        gc.gridx = 1;
        gc.gridy = 3;
        gc.insets = new Insets(0, 0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(comboBox, gc);

        ////////////////////////// CITIZENSHIP ROW //////////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        checkCitizenshipLabel = new JLabel("US Citizen: ");
        gc.gridx = 0;
        gc.gridy = 4;
        gc.insets = new Insets(0, 0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(checkCitizenshipLabel, gc);

        checkCitizenship = new JCheckBox();
        gc.gridx = 1;
        gc.gridy = 4;
        gc.insets = new Insets(0, 0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(checkCitizenship, gc);

        ////////////////////////// ZIP CODE ROW //////////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        taxIdLabel = new JLabel("Tax ID: ");
        gc.gridx = 0;
        gc.gridy = 5;
        gc.insets = new Insets(0, 0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(taxIdLabel, gc);

        taxIdField = new JTextField(10);
        gc.gridx = 1;
        gc.gridy = 5;
        gc.insets = new Insets(0, 0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(taxIdField, gc);

        ////////////////////////// GENDER BUTTONS GROUP //////////////////////////
        genderGroup = new ButtonGroup();
        maleGender = new JRadioButton("Male");
        maleGender.setActionCommand("male");
        maleGender.setSelected(true);

        femaleGender = new JRadioButton("Female");
        femaleGender.setActionCommand("female");
        genderGroup.add(maleGender);
        genderGroup.add(femaleGender);

        ////////////////////////// MALE GENDER RADIO BUTTON ROW //////////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        genderLabel = new JLabel("Gender: ");
        gc.gridx = 0;
        gc.gridy = 6;
        gc.insets = new Insets(0, 0,0,5);
        gc.anchor = GridBagConstraints.LINE_END;
        add(genderLabel, gc);

        gc.gridx = 1;
        gc.gridy = 6;
        gc.insets = new Insets(0, 0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(maleGender, gc);

        ////////////////////////// MALE GENDER RADIO BUTTON ROW //////////////////////////
        gc.weightx = 1;
        gc.weighty = 0.1;

        gc.gridx = 1;
        gc.gridy = 7;
        gc.insets = new Insets(0, 0,0,0);
        gc.anchor = GridBagConstraints.LINE_START;
        add(femaleGender, gc);

        ////////////////////////// SUBMIT ROW //////////////////////////
        gc.weightx = 1;
        gc.weighty = 1;

        submit = new JButton("Submit");
        gc.gridx = 1;
        gc.gridy = 8;
        gc.insets = new Insets(0, 0,0,0);
        gc.anchor = GridBagConstraints.FIRST_LINE_START;
        add(submit, gc);
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

class EmployeeCategory {
    private int id;
    private String text;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public EmployeeCategory(int id, String text) {
        this.id = id;
        this.text = text;
    }

    public String toString() {
        return text;
    }
}
