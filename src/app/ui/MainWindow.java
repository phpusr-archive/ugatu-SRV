package app.ui;

import javax.swing.*;
import java.awt.*;

/**
 * @author phpusr
 *         Date: 14.03.14
 *         Time: 15:45
 */

/**
 * Главное окно
 */
public class MainWindow extends JFrame {

    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        Container container = getContentPane();
        container.add(panel);

        //Кнопка подачи сообщений в буфер
        JButton messagePussherButton = new JButton("Push message to buffer");
        panel.add(messagePussherButton);

        //Лейбл для вывода сообщений из буфера
        JLabel bufferMessagesLabel = new JLabel("Label");
        panel.add(bufferMessagesLabel);


        setSize(800, 600);
        setVisible(true);
    }

}
