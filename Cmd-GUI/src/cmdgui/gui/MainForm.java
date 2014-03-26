package cmdgui.gui;

import cmdgui.prgrunner.ProgramRunner;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

/**
 * @author phpusr
 *         Date: 26.03.14
 *         Time: 13:49
 */

/**
 * Главная форма
 */
public class MainForm extends JFrame {
    /** Корневая панель */
    private JPanel rootPanel;
    /** Компонент для вывода списка */
    private JList outList;
    /** Модель для вывода списка */
    private DefaultListModel outListModel;
    /** Поле для ввода команды */
    private JTextField cmdLine;
    /** Кнопка запуска команды */
    private JButton runButton;

    /** Конструктор */
    public MainForm() {
        super("Main Form");
        if (false) System.out.println(">> constructor");

        setContentPane(rootPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Добавление обработчиков событий
        addActions();

        setVisible(true);
    }

    /** Добавление обработчиков событий */
    void addActions() {
        // Обработчик нажатия кнопки запуска команды
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Извлечение введенных команд
                String cmdLineString = cmdLine.getText();
                String[] strings = cmdLineString.split(" ");
                List<String> commandList = new LinkedList<String>(Arrays.asList(strings));

                // Запуск команды
                String programName = commandList.remove(0);
                ProgramRunner programRunner = new ProgramRunner(programName, commandList);
                programRunner.run();

                // Добавление разделителя
                addSeparator();

                // Получение вывода программы
                List<String> outStringList = programRunner.getOutStringList();

                // Отображение вывода программы
                for (String out : outStringList) {
                    outListModel.addElement(out);
                }
            }
        });
    }

    /** Добавление разделителя в вывод */
    private void addSeparator() {
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy a h:mm");
        outListModel.addElement("-");
        String separator = "-----------------------------------";
        outListModel.addElement(separator + df.format(new Date()) + separator);
        outListModel.addElement("-");
    }

    /** Ручное создание компонентов */
    private void createUIComponents() {
        if (false) System.out.println(">> createUIComponents");

        // Установка модели для компонента вывода списка
        outListModel = new DefaultListModel();
        outList = new JList(outListModel);
    }
}
