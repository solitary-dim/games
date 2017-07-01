package com.omdes.games.pintu.version3;

import com.omdes.games.pintu.ConfigConstant;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static com.omdes.games.pintu.ConfigConstant.*;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/28
 * Time: 20:20
 */
public class MainExe {
    protected JFrame jFrame = new JFrame();
    protected static LeftPanel leftPanel;
    protected static RightPanel rightPanel;

    private static ArrayList<Thread> threadList = new ArrayList<>();

    public static void main(String[] args) {
        ConfigConstant configConstant = ConfigConstant.getConfig();
        MainExe main = new MainExe();
        main.init();
        for (int i = 0 ; i < NUM ; i ++ ) {
            PartOne partOne = new PartOne(MAP.get(String.valueOf(i)), String.valueOf(i));
            partOne.setSuspend(false);
            Thread thread = new Thread(partOne);
            thread.start();
            threadList.add(thread);
        }
    }

    private JFrame init() {
        MainPanel mainPanel = new MainPanel();
        JPanel jPanel = mainPanel.createPanel(WIDTH, HEIGHT);

        //得到RightPanel中存放有9张小图和一张大图的JFrame
        leftPanel = mainPanel.getLeftPanel();
        rightPanel = mainPanel.getRightPanel();

        jFrame.add(jPanel);

        jFrame.setSize(WIDTH, HEIGHT);
        //jFrame.setResizable(false);
        jFrame.setVisible(true);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //为左侧栏中按钮加上监听
        buttonListeners();

        return jFrame;
    }

    private void buttonListeners() {
        leftPanel.getStart().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("right panel reset test");
                rightPanel.getLayout().show(rightPanel.getjPanel(), PANEL_START);
            }
        });

        leftPanel.getSuspend().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("suspend all thread");
                //TODO
                for (int i = 0 ; i < NUM ; i ++ ) {
                    threadList.get(i).suspend();
                }
            }
        });

        leftPanel.getGoon().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("restart all thread");
                //TODO
                for (int i = 0 ; i < NUM ; i ++ ) {
                    threadList.get(i).resume();
                }
            }
        });

        leftPanel.getReset().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("restart the game");
                rightPanel.getLayout().show(rightPanel.getjPanel(), PANEL_START);
            }
        });
    }
}
