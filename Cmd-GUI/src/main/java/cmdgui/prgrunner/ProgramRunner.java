package cmdgui.prgrunner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author phpusr
 *         Date: 26.03.14
 *         Time: 13:32
 */

/**
 * Запускатор внешних программ
 */
public class ProgramRunner implements Runnable {

    /** Программа для запуска */
    private final String programName;

    /** Аргументы для запуска */
    private final List<String> args;

    /** Команда для запуска с аргументами */
    private final List<String> command;

    /** Список строк вывода */
    private final List<String> outStringList;

    /** Конструктор */
    public ProgramRunner(String programName, List<String> args) {
        this.programName = programName;
        this.args = args;

        command = new ArrayList<String>();
        command.add(programName);
        command.addAll(args);

        outStringList = new ArrayList<String>();
    }


    /** Запускатор программы */
    @Override
    public void run() {
        try {
            Process process = new ProcessBuilder(command).start();
            InputStream is = process.getInputStream();
            InputStreamReader isr = new InputStreamReader(is, "866");
            BufferedReader br = new BufferedReader(isr);

            System.out.printf("Command: %s\n", command);

            String line;
            while ((line = br.readLine()) != null) {
                outStringList.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /** Возвращает имя запускаемой программы */
    public String getProgramName() {
        return programName;
    }

    /** Возвращает аргументы запускаемой программы */
    public List<String> getArgs() {
        return args;
    }

    /** Возвращает вывод запускаемой программы */
    public List<String> getOutStringList() {
        return outStringList;
    }
}
