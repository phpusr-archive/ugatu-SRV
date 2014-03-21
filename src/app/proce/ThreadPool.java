package app.proce;

/**
 * @author phpusr
 *         Date: 21.03.14
 *         Time: 11:04
 */

import app.main.Const;

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
        if (Const.LOG_THREAD_POOL) System.out.println(">>getFreeThread()");
        for (ProcessingThread processingThread : threadList) {
            if (processingThread.isFree()) {
                if (Const.LOG_THREAD_POOL) System.out.println(processingThread + " FREE!");
                return processingThread;
            } else {
                if (Const.LOG_THREAD_POOL) System.out.println(processingThread + " busy");
            }
        }

        return null;
    }

}
