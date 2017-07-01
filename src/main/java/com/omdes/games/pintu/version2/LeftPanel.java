package com.omdes.games.pintu.version2;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

import static com.omdes.games.pintu.ConfigConstant.IMG_WIDTH;
import static com.omdes.games.pintu.ConfigConstant.IMG_HEIGHT;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/28
 * Time: 20:13
 */
public final class LeftPanel implements Serializable {
    private static final long serialVersionUID = -5689182950558158307L;

    private final JPanel jPanel = new JPanel();

    protected final JButton jStart = new JButton("start");
    protected final JButton jSuspend = new JButton("suspend");
    protected static final JButton reset = new JButton("reset");

    protected JPanel createPanel() {
        JLabel jLabel = new JLabel("成功!");
        jLabel.setFont(new Font("宋体", 1, 24));
        jLabel.setForeground(Color.BLACK);
        jLabel.setVisible(true);
        jLabel.setBackground(null);
        jLabel.setFocusable(false);
        jLabel.setSize(IMG_WIDTH, IMG_HEIGHT);
        jStart.setSize(IMG_WIDTH, IMG_HEIGHT);
        jSuspend.setSize(IMG_WIDTH, IMG_HEIGHT);

        final Box box = Box.createVerticalBox();
        box.setSize(IMG_WIDTH, IMG_HEIGHT*3);
        box.add(jStart);
        box.add(Box.createHorizontalStrut(IMG_WIDTH));
        box.add(Box.createVerticalStrut(IMG_HEIGHT));
        box.add(jSuspend);
        box.add(Box.createVerticalStrut(IMG_HEIGHT));
        box.add(jLabel);
        jPanel.add(box);

        jPanel.setSize(IMG_WIDTH, IMG_HEIGHT*3);
        jPanel.setBorder(BorderFactory.createLineBorder(Color.RED));
        jPanel.setBackground(null);
        jPanel.setVisible(true);
        return jPanel;
    }
}
