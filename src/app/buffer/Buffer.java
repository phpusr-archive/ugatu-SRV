package app.buffer;

/**
 * @author phpusr
 *         Date: 14.03.14
 *         Time: 15:13
 */

import app.main.Const;

/**
 * Буфер, который хранит одно сообщение
 */
public class Buffer {

    /** Значение буфера */
    private static BufferValue value;

    /** Вытаскивает значение из буфера */
    public synchronized static BufferValue pullValue() {
        BufferValue retValue = value;
        value = null;

        return retValue;
    }

    /** Устанавливает значение буфера */
    public synchronized static void pushValue(BufferValue value) {
        Buffer.value = value;
        if (Const.LOG_BUFFER) System.out.println("Buffer:: value = " + value);
    }
}
