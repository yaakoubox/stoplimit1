//
package stoplimit1;

import java.awt.event.MouseEvent;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
//import javafx.scene.input.KeyCode;
import static javafx.scene.input.KeyCode.PERIOD;

public class CoinRobot {

    public static Robot r;

////////////////////////////////////////////////////////////////////////////////
    public CoinRobot() throws AWTException {
        this.r = new Robot();
    }

////////////////////////////////////////////////////////////////////////////////
    public void oneLeftClickWithMouse(int x, int y) {
        r.mouseMove(x, y);
        r.delay(1000);
        r.mousePress(InputEvent.BUTTON1_MASK);
        r.mouseRelease(InputEvent.BUTTON1_MASK);
        //r.mousePress(InputEvent.BUTTON1_MASK);
        //r.mouseRelease(InputEvent.BUTTON1_MASK);
    }

////////////////////////////////////////////////////////////////////////////////
    public void Typing(String s) {

        byte[] bytes = s.getBytes();

        for (byte b : bytes) {
            int code = b;
            if (code > 96 && code < 123) {
                code = code - 32;
                r.delay(5);
                r.keyPress(code);
                r.keyRelease(code);
            } else if (code == 45) {
                try {
                    r.delay(5);
                    r.keyPress(KeyEvent.VK_6);
                    r.keyRelease(KeyEvent.VK_6);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            } else if (code == 46) {
                try {
                    r.delay(5);
                    r.keyPress(KeyEvent.VK_SHIFT);
                    r.keyPress(KeyEvent.VK_SEMICOLON);
                    r.keyRelease(KeyEvent.VK_SEMICOLON);
                    r.keyRelease(KeyEvent.VK_SHIFT);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            } else if (code == 47) {
                try {
                    r.delay(5);
                    r.keyPress(KeyEvent.VK_SHIFT);
                    r.keyPress(KeyEvent.VK_COLON);
                    r.keyRelease(KeyEvent.VK_COLON);
                    r.keyRelease(KeyEvent.VK_SHIFT);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            } else if (code == 58) {
                try {
                    r.delay(5);
                    //r.keyPress(KeyEvent.VK_SHIFT);
                    r.keyPress(KeyEvent.VK_COLON);
                    r.keyRelease(KeyEvent.VK_COLON);
                    //r.keyRelease(KeyEvent.VK_SHIFT);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                }
            }
            if (code == 95) {
                try {
                    r.delay(5);
                    //r.keyPress(KeyEvent.VK_SHIFT);
                    
                    r.keyPress(KeyEvent.VK_8);
                    r.keyRelease(KeyEvent.VK_8);
                    //r.keyRelease(KeyEvent.VK_SHIFT);
                } catch (IllegalArgumentException e) {
                    e.printStackTrace();
                    //System.out.println("");
                }
            }
            

        }
    }

////////////////////////////////////////////////////////////////////////////////
    public void wait(int time) {
        r.delay(time);
    }

////////////////////////////////////////////////////////////////////////////////
    public void pressKeybord(int keyevent) {
        r.keyPress(keyevent);
        r.keyRelease(keyevent);

    }

    public void HoldKeybord(int keyevent) {
        r.keyPress(keyevent);
    }

    public void LetHoldKeybord(int keyevent) {
        r.keyRelease(keyevent);

    }

    public void MouseMove(int x, int y) {
        r.mouseMove(x, y);
    }

    public void oneLeftPressWithMouse(int x, int y) {
        r.mouseMove(x, y);
        r.mousePress(InputEvent.BUTTON1_MASK);

    }

    public void LetHoldMouse() {

        r.mouseRelease(InputEvent.BUTTON1_MASK);
    }
    public void HoldMouse() {

        r.mousePress(InputEvent.BUTTON1_MASK);
    }

    public void OneRightClickWithMouse() {
        r.mousePress(InputEvent.BUTTON3_MASK);
        r.mouseRelease(InputEvent.BUTTON3_MASK);
    }

    public void PressCopy() {
        try {
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_C);
            r.keyRelease(KeyEvent.VK_C);
            r.keyRelease(KeyEvent.VK_CONTROL);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    public void PressPaste() {
        try {
            r.keyPress(KeyEvent.VK_CONTROL);
            r.keyPress(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_V);
            r.keyRelease(KeyEvent.VK_CONTROL);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

}
