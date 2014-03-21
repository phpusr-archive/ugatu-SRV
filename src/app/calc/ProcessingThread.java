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

    public ProcessingThread(int number, BufferValue bufferValue) {
        this.number = number;
        processingValue = bufferValue;
    }

    @Override
    public void run() {
        try {
            sleep(PROCESSING_MILLIS);
            System.out.println("Thread: " + number + " finish processing value " + processingValue);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
