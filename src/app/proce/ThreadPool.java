package app.proce;

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
            ProcessingThread thread = new ProcessingThread(i + 1);
            threadList.add(thread);
            thread.start();
        }
    }

    /** Возвращает незанятый поток из пула потоков */
    public ProcessingThread getFreeThread() {
        System.out.println(">> getFreeThread()");
        for (ProcessingThread processingThread : threadList) {
            if (processingThread.isFree()) {
                System.out.println(processingThread + " free");
                return processingThread;
            } else {
                System.out.println(processingThread + " NOT free");
            }
        }

        return null;
    }

}
