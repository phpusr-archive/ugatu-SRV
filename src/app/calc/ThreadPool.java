package app.calc;

/**
 * @author phpusr
 *         Date: 21.03.14
 *         Time: 11:04
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Пулл потоков ProcessingThread
 */
public class ThreadPool {

    /** Список потоков для вычисления */
    private List<ProcessingThread> threadList;

    public ThreadPool(int poolSize) {
        threadList = new ArrayList<ProcessingThread>();
        for (int i=0; i< poolSize; i++) {
            threadList.add(new ProcessingThread(i+1));
        }
    }

    /** Возвращает незанятый поток из пула потоков */
    public ProcessingThread getFreeThread() {
        System.out.println(">> getFreeThread()");
        for (ProcessingThread processingThread : threadList) {
            if (!processingThread.isAlive()) {
                System.out.println(processingThread + " NOT alive");
                return processingThread;
            } else {
                System.out.println(processingThread + " alive");
            }
        }

        return null;
    }

}
