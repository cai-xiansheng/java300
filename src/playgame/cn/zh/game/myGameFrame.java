package playgame.cn.zh.game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author 张辉
 * @Description 飞机游戏的主窗口
 * @create 2020-04-06 14:14
 */
public class myGameFrame extends JFrame {

    @Override
    public void paint(Graphics g) {
        g.drawLine(100, 100, 300, 300);
        g.drawRect(100, 100, 300, 300);
        g.drawOval(100, 100, 300, 300);
        g.fillRect(100, 100, 40, 40);
        g.setColor(Color.red);
    }

    /**
     * 初始化窗口
     */
    public void launchFrame() {
        this.setTitle("飞机大战");
        this.setSize(500, 500);
        this.setLocation(150, 150);
        this.setVisible(true);

        this.addWindowFocusListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    public static void main(String[] args) {
        myGameFrame f = new myGameFrame();
        f.launchFrame();
    }
}
