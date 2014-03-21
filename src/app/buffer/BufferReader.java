package app.buffer;

/**
 * @author phpusr
 *         Date: 14.03.14
 *         Time: 15:14
 */

import app.main.Const;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Поток, читающий буфер
 */
public class BufferReader extends Thread {

    /** Буфер для хранения нескольких сообщений */
    private final List<BufferValue> bufferValueList;

    /** TODO */
    private Runnable bufferAction;

    public BufferReader() {
        bufferValueList = new ArrayList<BufferValue>();
        bufferAction = new Runnable() {
            @Override
            public void run() {
                System.out.println("bufferAction initialize");
            }
        };

    }

    @Override
    public void run() {
        //Таймер запускется каждые 100 мс
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkBuffer();
            }
        });
        timer.start();
    }

    /** Вытаскивает значение буфера и помещает в список */
    private void checkBuffer() {
        BufferValue bufferValue = Buffer.pullValue();
        if (bufferValue != null) {
            if (Const.LOG_BUFFER_READER) System.out.println("BufferedReader:: found new value = " + bufferValue);
            bufferValueList.add(bufferValue);
            runAction();
        }
    }

    /** TODO */
    private void runAction() {
        synchronized (bufferAction) {
            if (bufferAction != null && bufferValueList.size() > 0) {
                bufferAction.run();
            }
        }
    }

    /** Вытаскивает первое значение из буфера в виде строки */
    public synchronized BufferValue pullValue() {
        if (bufferValueList.size() > 0) {
            return bufferValueList.remove(0);
        } else {
            return null;
        }
    }

    /** Установка экшена появления сообщений в буфере BufferReader'а */
    public void setBufferAction(Runnable runnable) {
        synchronized (bufferAction) {
            bufferAction = runnable;
        }
    }

}
