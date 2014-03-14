package app;

/**
 * @author phpusr
 *         Date: 14.03.14
 *         Time: 15:11
 */

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
        Buffer.setValue(writeValue);
    }
}
