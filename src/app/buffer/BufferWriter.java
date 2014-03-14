package app.buffer;

/**
 * @author phpusr
 *         Date: 14.03.14
 *         Time: 15:11
 */

import app.main.Const;

/**
 * Поток пищущий в буфер
 */
public class BufferWriter extends Thread {

    /** Значение для записи в буфер */
    private BufferValue writeValue;

    /** Конструктор */
    public BufferWriter(BufferValue writeValue) {
        this.writeValue = writeValue;
    }

    /** Пишет в буфер значение: writeValue */
    @Override
    public void run() {
        System.out.println("--------------------------------");
        if (Const.LOG_BUFFER_WRITER) System.out.println("BufferWriter:: write value = " + writeValue);
        Buffer.pushValue(writeValue);
    }
}
