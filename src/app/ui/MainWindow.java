package app.ui;

import app.buffer.BufferReader;
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
    private final JButton messagePusherButton;

    /** Лейбл для вывода сообщений */
    private final JLabel bufferMessagesLabel;

    /** Считыватель буфера */
    private final BufferReader bufferReader;

    public MainWindow() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        Container container = getContentPane();
        container.add(panel);

        //Кнопка подачи сообщений в буфер
        messagePusherButton = new JButton("Push message to buffer");
        panel.add(messagePusherButton);

        //Лейбл для вывода сообщений из буфера
        bufferMessagesLabel = new JLabel("Values from buffer: ");
        panel.add(bufferMessagesLabel);

        //Считыватель буфера
        bufferReader = new BufferReader();
        bufferReader.start();

        //Инициализация экшенов
        initActions();

        setSize(800, 600);
        setVisible(true);
    }

    /** Инициализация экшенов */
    private void initActions() {
        //Экшэн нажатия на кнопку, записывает сообщение в буфер
        messagePusherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int randomValue = (int) (Math.random() * 1000);
                BufferWriter bufferWriter = new BufferWriter(new BufferValue(randomValue));
                bufferWriter.start();
            }
        });

        //Таймер обрабатывающий сообщения из буфера
        final Timer timer = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addValueToLabel(bufferReader.pullValue());
            }
        });
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                timer.start();
            }
        });
        thread.start();
    }

    /** Добавляет новое значение к лейблу */
    private void addValueToLabel(String value) {
        if (value != null) {
            bufferMessagesLabel.setText(bufferMessagesLabel.getText() + value + " ");
        }
    }

}