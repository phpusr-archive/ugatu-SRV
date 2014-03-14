package app.buffer;

/**
 * @author phpusr
 *         Date: 14.03.14
 *         Time: 15:22
 */

/**
 * Значение для записи в буфер
 */
public class BufferValue {

    private int value = 0;

    public BufferValue(int value) {
        this.value = value;
    }

    public String getStringValue() { return "" + value; }

    @Override
    public String toString() {
        return "BufferValue{" +
                "value=" + value +
                '}';
    }
}
