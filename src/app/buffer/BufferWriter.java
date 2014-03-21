package app.buffer;

/**
 * @author phpusr
 *         Date: 14.03.14
 *         Time: 15:11
 */

import app.main.Const;

/**
 * Поток пишущий в буфер
 */
public class BufferWriter {

    /** Значение для записи в буфер */
    private final BufferValue writeValue;

    /** Конструктор */
    public BufferWriter(BufferValue writeValue) {
        this.writeValue = writeValue;
    }

    /**
     * Запустить Запись в буфер
     * Метод оставлен, чтобы класс вел себя как поток
     * !!! При добавлении наследования от Thread, удалить этот метод
     */
    public void start() {
        run();
    }

    /** Пишет в буфер значение: writeValue */
    public void run() {
        System.out.println("-------------------------------->>");
        if (Const.LOG_BUFFER_WRITER) System.out.println("BufferWriter:: write value = " + writeValue);
        Buffer.pushValue(writeValue);
    }
}
