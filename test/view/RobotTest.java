package view;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import common.*;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import org.junit.Assert;
import org.junit.Test;
import view.savingaccount.SavingAccountWithdrawnFrm;

/**
 *
 * @author ASUS
 */
public class RobotTest {

    private SavingAccountWithdrawnFrm frm;
    private Robot robot;

    public RobotTest() {
        try {
            this.robot = new Robot();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void leftClick(int x, int y) {
        robot.mouseMove(x, y);
        robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        robot.delay(200);
        robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
    }

    private void pressKey(int keyCode) {
        robot.keyPress(keyCode);
        robot.keyRelease(keyCode);
    }
    
    private boolean testSearchInterface() {
        robot.delay(1000);
//        robot.mouseMove(0, 0);
//        leftClick(0, 0);
//        robot.delay(500);
        pressKey(KeyEvent.VK_1);
        pressKey(KeyEvent.VK_2);
        pressKey(KeyEvent.VK_3);
        pressKey(KeyEvent.VK_4);
        pressKey(KeyEvent.VK_5);
        pressKey(KeyEvent.VK_6);
        pressKey(KeyEvent.VK_7);
        pressKey(KeyEvent.VK_8);
        pressKey(KeyEvent.VK_9);
        pressKey(KeyEvent.VK_0);

        robot.delay(500);
        leftClick(720, 260);
        robot.delay(500);
        int row = frm.getNumberOfTableElement();
        if (row == 4) {
            return true;
        }
        return false;
    }
    @Test
    public void test() {
        robot.mouseMove(0,0);
        frm = new SavingAccountWithdrawnFrm();
        Assert.assertEquals(true, testSearchInterface());
    }
}
