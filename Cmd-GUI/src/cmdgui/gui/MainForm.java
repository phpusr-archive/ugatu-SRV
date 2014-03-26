package cmdgui.gui;

import javax.swing.*;

/**
 * @author phpusr
 *         Date: 26.03.14
 *         Time: 13:49
 */
public class MainForm extends JFrame {
    private JButton OKGoogleButton;
    private JPanel panel1;

    public MainForm() {
        super("Main Form");
        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();

        // Actions...

        setVisible(true);
    }

}
