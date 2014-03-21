package experiment;

/**
 * @author phpusr
 *         Date: 21.03.14
 *         Time: 19:12
 */

/**
 * Слушатель обработки процесаа
 */
public interface ProcessingListener {

    /** Процесс завершен */
    public abstract void processingDone(String value);

}
