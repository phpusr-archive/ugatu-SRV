package cmdgui.run;

import cmdgui.gui.MainForm;

import javax.swing.*;

/**
 * @author phpusr
 *         Date: 26.03.14
 *         Time: 14:50
 */

/**
 * Запускающий класс
 */
public class Main {

    /** Запуск программы */
    public static void main(String[] args) {
        // Установка темы оформления
        try {
            UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
        } catch (Exception e1) {
            e1.printStackTrace();
        }

        // Создание и запуск главной формы
        new MainForm();
    }

    /** Выводит установленные LookAndFeels */
    private static void printInstalledLookAndFeels() {
        for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
            System.out.println(info.getName() + ": " + info.getClassName());
        }
    }

    /** Системный LookAndFeel */
    private static String getSystemLookAndFeel() {
        return UIManager.getSystemLookAndFeelClassName();
    }
}
