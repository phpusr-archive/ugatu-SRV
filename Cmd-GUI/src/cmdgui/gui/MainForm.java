package cmdgui.gui;

import cmdgui.prgrunner.ProgramRunner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author phpusr
 *         Date: 26.03.14
 *         Time: 13:49
 */
public class MainForm extends JFrame {
    private JPanel panel1;
    private JList outList;
    private JTextField cmdLine;
    private JButton runButton;

    public MainForm() {
        super("Main Form");

        setContentPane(panel1);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //pack();
        setSize(600, 400);

        // Actions...
        addActions();

        setVisible(true);
    }

    // Обработчики событий
    void addActions() {
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String program = cmdLine.getText();
                String[] strings = program.split(" ");
                List<String> list = new LinkedList<String>(Arrays.asList(strings));

                String prg = list.remove(0);
                ProgramRunner programRunner = new ProgramRunner(prg, list);
                programRunner.run();
                List<String> outStringList = programRunner.getOutStringList();

                DefaultListModel model = (DefaultListModel) outList.getModel();
                model.clear();

                for (String out : outStringList) {
                    model.addElement(out);
                }

                // TODO допилить
            }
        });
    }

    // Ручное создание компонентов
    private void createUIComponents() {
        System.out.println(">> createUIComponents");

        DefaultListModel listModel = new DefaultListModel();
        outList = new JList(listModel);
    }
}
