package app;

/**
 * @author phpusr
 *         Date: 14.03.14
 *         Time: 15:13
 */

/**
 * Буфер, который хранит одно сообщение
 */
public class Buffer {

    /** Значение буфера */
    private static BufferValue value;

    /** Вытаскивает значение из буфера */
    public static BufferValue pullValue() {
        BufferValue retValue = value;
        value = null;

        return retValue;
    }

    /** Устанавливает значение буфера */
    public static void pushValue(BufferValue value) {
        Buffer.value = value;
    }
}
