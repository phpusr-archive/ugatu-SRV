package app.ui;

import app.buffer.BufferValue;
import app.buffer.BufferWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author phpusr
 *         Date: 14.03.14
 *         Time: 15:45
 */

/**
 * Главное окно
 */
public class MainWindow extends JFrame {

    /** Кнопка подачи сообщений в буфер */
    JButton messagePussherButton = null;

    public MainWindow() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        Container container = getContentPane();
        container.add(panel);

        //Кнопка подачи сообщений в буфер
        messagePussherButton = new JButton("Push message to buffer");
        panel.add(messagePussherButton);

        //Лейбл для вывода сообщений из буфера
        JLabel bufferMessagesLabel = new JLabel("Label");
        panel.add(bufferMessagesLabel);

        //Инициализация экшенов
        initActions();

        setSize(800, 600);
        setVisible(true);
    }

    /** Инициализация экшенов */
    private void initActions() {
        //Экшэн нажатия на кнопку, записывает сообщение в буфер
        messagePussherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int randomValue = (int) (Math.random() * 1000);
                BufferWriter bufferWriter = new BufferWriter(new BufferValue(randomValue));
                bufferWriter.start();
            }
        });
    }

}
