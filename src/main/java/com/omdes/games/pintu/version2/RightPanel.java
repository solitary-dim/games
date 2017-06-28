package com.omdes.games.pintu.version2;

import com.omdes.games.pintu.ConfigConstant;
import com.omdes.games.pintu.version1.MainRun;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.Random;

import static com.omdes.games.pintu.ConfigConstant.*;
/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/28
 * Time: 20:13
 */
public final class RightPanel implements Serializable {
    private static final long serialVersionUID = 8338971198989562228L;

    private final JPanel jPanel = new JPanel();

    private Random ranDom = new Random();

    protected JPanel createPanel() {
        randString();

        jPanel.setLayout(new GridLayout(3, 3, 3, 3));
        for (int i = 0 ; i < NUM ; i ++ ) {
            JLabel jLabel = new JLabel();
            jLabel.setIcon(new ImageIcon(new ImageIcon(ConfigConstant.class.getResource("images/9/one_" +RAND_INT[i]+".jpg")).getImage()));
            MAP.put(String.valueOf(i), jLabel);
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
