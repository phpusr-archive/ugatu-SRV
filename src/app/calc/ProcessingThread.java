package app.calc;

/**
 * @author phpusr
 *         Date: 21.03.14
 *         Time: 11:15
 */

import app.buffer.BufferValue;

/**
 * Поток для обработки значений из буфера
 */
public class ProcessingThread extends Thread {

    /** Кол-во мс. для обработки значения */
    private static final int PROCESSING_MILLIS = 2000;
    /** № потока */
    private int number;
    /** Выражение для обработки */
    private BufferValue processingValue;

    private boolean free = true;

    public ProcessingThread(int number, BufferValue bufferValue) {
        this.number = number;
        processingValue = bufferValue;
    }

    public ProcessingThread(int number) {
        this(number, null);
    }

    @Override
    public void run() {
        while(!isInterrupted()) {
            try {
                sleep(PROCESSING_MILLIS);
                System.out.println(this + " finish processing value " + processingValue);
                yield();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void setProcessingValue(BufferValue processingValue) {
        this.processingValue = processingValue;
    }

    @Override
    public String toString() {
        return "ProcessingThread: " + number;
    }
}
