package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {

    private JButton helloBtn;
    private JButton goodbyeBtn;

    private StringListener stringListener;

    public void setStringListener(StringListener stringListener) {
        this.stringListener = stringListener;
    }

    public Toolbar() {
        setBorder(BorderFactory.createEtchedBorder());
        helloBtn = new JButton("Hello");
        goodbyeBtn = new JButton("Goodbye");

        helloBtn.addActionListener(this);
        goodbyeBtn.addActionListener(this);

        setLayout(new FlowLayout(FlowLayout.LEFT));

        add(helloBtn);
        add(goodbyeBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton clickedBtn = (JButton) e.getSource();

        if (clickedBtn == helloBtn) {
            if (stringListener != null) {
                stringListener.textEmitted("Hello btn is clicked.\n");
            }
        } else if (clickedBtn == goodbyeBtn) {
            if (stringListener != null) {
                stringListener.textEmitted("Goodbye btn is clicked.\n");
            }
        }
    }
}
