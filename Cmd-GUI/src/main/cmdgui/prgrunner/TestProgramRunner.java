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
 * Опция компилятору для assert: -ea
 * TODO переделать на тест
 */
public class TestProgramRunner {

    public static void main(String[] args) {
        testRun();
    }

    /** Проверка запуска программы */
    static void testRun() {
        String program = "git";
        List<String> params = new ArrayList<String>() {{
            add("--version");
        }};

        ProgramRunner programRunner = new ProgramRunner(program, params);
        programRunner.run();
        List<String> outStringList = programRunner.getOutStringList();

        for (String out : outStringList) {
            System.out.println(out);
        }

        assert outStringList.get(0).equals("git version 1.8.4.msysgit.0");
    }

}
