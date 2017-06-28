package com.omdes.games.pintu.version2;

import com.omdes.games.pintu.ConfigConstant;

import javax.swing.*;

import java.util.ArrayList;

import static com.omdes.games.pintu.ConfigConstant.*;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/28
 * Time: 20:20
 */
public class Main {
    protected JFrame jFrame = new JFrame();

    private static ArrayList<Thread> threadList = new ArrayList<>();

    public static void main(String[] args) {
        ConfigConstant configConstant = ConfigConstant.getConfig();
        Main main = new Main();
        main.init();
        for (int i = 0 ; i < NUM ; i ++ ) {
            Thread thread = new Thread(new PartOne(MAP.get(String.valueOf(i)), String.valueOf(i)));
            thread.start();
            threadList.add(thread);
        }
    }

    private JFrame init() {
        JPanel jPanel = new MainPanel().createPanel(WIDTH, HEIGHT);

        jFrame.add(jPanel);

        jFrame.setSize(WIDTH, HEIGHT);
        //jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        return jFrame;
    }
}
