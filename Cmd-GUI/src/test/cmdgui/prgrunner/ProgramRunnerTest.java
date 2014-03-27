package cmdgui.prgrunner;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author phpusr
 *         Date: 27.03.14
 *         Time: 18:37
 */

/**
 * Тесты для ProgramRunner
 */
public class ProgramRunnerTest {

    ProgramRunner programRunner;

    @Before
    public void setUp() {
        String program = "git";
        List<String> params = new ArrayList<String>() {{
            add("--version");
        }};

        programRunner = new ProgramRunner(program, params);
    }

    @Test
    public void testRun() {
        programRunner.run();
        List<String> outStringList = programRunner.getOutStringList();

        for (String out : outStringList) {
            System.out.println(out);
        }

        assert outStringList.get(0).equals("git version 1.8.4.msysgit.0");
    }

}
