import javax.swing.JPanel;
import java.awt.Dimension;

public class FormPanel extends JPanel {
    public FormPanel() {
        Dimension dim = getPreferredSize();
        dim.width = 250;
        setPreferredSize(dim);
    }
}
