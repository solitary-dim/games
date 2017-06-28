package com.omdes.games.pintu.version2;

import com.omdes.games.pintu.ConfigConstant;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import static com.omdes.games.pintu.ConfigConstant.*;
import static com.omdes.games.pintu.ConfigConstant.RAND_INT;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/28
 * Time: 21:25
 */
public final class RightPanelShow {

    private final JPanel jPanel = new JPanel();

    private Random ranDom = new Random();

    protected JPanel createPanel() {
        randString();

        jPanel.setLayout(new GridLayout(3, 3, 3, 3));
        for (int i = 0 ; i < NUM ; i ++ ) {
            JLabel jl = new JLabel();
            jl.setIcon(new ImageIcon(new ImageIcon(ConfigConstant.class.getResource("images/9/one_" +RAND_INT[i]+".jpg")).getImage()));
            //jl.setBorder(BorderFactory.createLineBorder(Color.red));
            MAP.put(String.valueOf(i), jl);
            /*final int order = i;
            jl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    clickNum++;
                    if (clickNum == 1) {
                        change = String.valueOf(order);
                    } else if (clickNum == 2) {
                        System.out.println("change: " + change + "||| order: " + order);
                        String temp = String.valueOf(order);

                        nap.put(change, MAP.get(change));
                        nap.put(temp, MAP.get(temp));
                        MAP.remove(change);
                        MAP.put(change, nap.get(temp));
                        MAP.remove(temp);
                        MAP.put(temp, nap.get(change));

                        jPanel.removeAll();
                        for (int j = 0 ; j < NUM ; j ++ ) {
                            jPanel.add(MAP.get(String.valueOf(j)));
                        }
                        jPanel.repaint();

                        nap.remove(change);
                        nap.remove(temp);
                        change = null;
                        nap = null;
                        clickNum = 0;
                    }
                }
            });*/
        }
        for (int i = 0 ; i < NUM ; i ++ ) {
            jPanel.add(MAP.get(String.valueOf(i)));
        }

        return jPanel;
    }

    private int[] randString () {
        RAND_INT[0] = ranDom.nextInt(9);
        int num = 1;
        boolean flag = true;
        while (num < NUM) {
            int r = ranDom.nextInt(9);
            for (int i = 0 ; i < num ; i++) {
                if (RAND_INT[i] == r) {
                    flag = false;
                }
            }
            if (flag) {
                RAND_INT[num] = r;
                num++;
            }
            flag = true;
        }
        for (int i = 0 ; i < NUM ; i ++ ) {
            RAND_STRING[i] = String.valueOf(RAND_INT[i]);
        }
        return RAND_INT;
    }
}
