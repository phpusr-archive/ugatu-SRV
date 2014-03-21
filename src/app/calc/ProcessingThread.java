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

    /** Свободен ли поток, для повторного запуска */
    private volatile Boolean free;

    /** Выполнил ли обработку поток */
    private volatile Boolean completeProcessing;

    /** Конструктор */
    public ProcessingThread(int number, BufferValue bufferValue) {
        free = true;
        completeProcessing = true;
        this.number = number;
        processingValue = bufferValue;
    }

    /** Конструктор */
    public ProcessingThread(int number) {
        this(number, null);
    }

    @Override
    public void run() {
        while(!isInterrupted()) {
            try {
                //Засыпание потока, пока не появится новая задача
                while (completeProcessing) sleep(100);

                //Выполнение задачи потока
                doTask();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Установка флага завершения потока
            completeProcessing = true;

            //Освобождение потока
            synchronized (free) { free = true; }
        }
    }

    /**  Выполнение задачи потока */
    private void doTask() throws InterruptedException {
        sleep(PROCESSING_MILLIS);
        System.out.println(this + " finish processing value " + processingValue);
    }

    /** Запуск потока */
    public synchronized void start(BufferValue processingValue) {
        this.processingValue = processingValue;
        free = false;
        completeProcessing = false;
    }

    /** Проверка, свободен-ли поток */
    public boolean isFree() {
        synchronized (free) { return free; }
    }

    @Override
    public String toString() {
        return "ProcessingThread: " + number;
    }

}
