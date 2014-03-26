package cmdgui.prgrunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author phpusr
 *         Date: 26.03.14
 *         Time: 16:47
 */

/**
 * Тесты для ProgramRunner
 */
public class TestProgramRunner {

    public static void main(String[] args) {
        testRun();
    }

    /** Проверка запуска программы */
    static void testRun() {
        String program = "cmd";
        List<String> params = new ArrayList<String>() {{
            add("/c");
            add("dir");
        }};

        ProgramRunner programRunner = new ProgramRunner(program, params);
        programRunner.run();
        List<String> outStringList = programRunner.getOutStringList();

        for (String out : outStringList) {
            System.out.println(out);
        }
    }

}
