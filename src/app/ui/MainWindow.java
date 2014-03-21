package app.ui;

import app.buffer.BufferReader;
import app.buffer.BufferValue;
import app.buffer.BufferWriter;
import app.proce.ProcessingListener;
import app.proce.ProcessingThread;
import app.proce.ThreadPool;

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

    /** Пул потоков обработчиков сообщений */
    private final ThreadPool processingPool;

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

        //Пул потоков обработчиков сообщений
        processingPool = new ThreadPool(4);

        //Инициализация экшенов
        initActions();

        setSize(800, 600);
        setVisible(true);
    }

    /** Инициализация экшенов */
    private void initActions() {
        //Слушатель нажатия на кнопку, записывает сообщение в буфер
        messagePusherButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int randomValue = (int) (Math.random() * 1000);
                BufferWriter bufferWriter = new BufferWriter(new BufferValue(randomValue));
                bufferWriter.start();
            }
        });

        //Слушатель завершения обработки потока
        final ProcessingListener processingListener = new ProcessingListener() {
            @Override
            public synchronized void processingDone(String value) {
                if (value != null) {
                    bufferMessagesLabel.setText(bufferMessagesLabel.getText() + value + " ");
                }
            }
        };

       //Слушатель появления сообщений в буфере BufferReader'а
       bufferReader.setBufferListener(new Runnable() {
           @Override
           public void run() {
               final ProcessingThread processing = processingPool.getFreeThread();
               if (processing != null) {
                   processing.start(bufferReader.pullValue(), processingListener);
               } else {
                   System.out.println("No free threads");
               }
           }
       });

    }

}
