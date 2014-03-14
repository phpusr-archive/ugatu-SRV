package app.buffer;

/**
 * @author phpusr
 *         Date: 14.03.14
 *         Time: 15:14
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Поток, читающий буфер
 */
public class BufferReader extends Thread {

    List<BufferValue> bufferValueList;

    public BufferReader() {
        bufferValueList = new ArrayList<BufferValue>();
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
            System.out.println("BufferedReader:: found new value=" + bufferValue);
            bufferValueList.add(bufferValue);
        }
    }

}
