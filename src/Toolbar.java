import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Toolbar extends JPanel implements ActionListener {

    private JButton helloBtn;
    private JButton goodbyeBtn;

    private TextPanel textPanel;

    public Toolbar() {
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
            textPanel.appendText("Hello btn is clicked\n");
        } else if (clickedBtn == goodbyeBtn) {
            textPanel.appendText("Goodbye btn is clicked\n");
        }
    }

    public void setTextPanel(TextPanel textPanel) {
        this.textPanel = textPanel;
    }
}
