package com.omdes.games.pintu.version3;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

import static com.omdes.games.pintu.ConfigConstant.IMG_HEIGHT;
import static com.omdes.games.pintu.ConfigConstant.IMG_WIDTH;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/28
 * Time: 20:13
 */
public final class LeftPanel implements Serializable {
    private static final long serialVersionUID = -6057723427691240900L;

    private final JPanel jPanel = new JPanel();

    private final JButton start = new JButton("开始");
    private final JButton suspend = new JButton("暂停");
    private final JButton goon = new JButton("继续");
    private final JButton reset = new JButton("重新开始");

    private final JLabel labelCount = new JLabel("步数：0");

    public JPanel getjPanel() {
        return jPanel;
    }

    public JButton getStart() {
        return start;
    }

    public JButton getSuspend() {
        return suspend;
    }

    public JButton getGoon() {
        return goon;
    }

    public JButton getReset() {
        return reset;
    }

    public JLabel getLabelCount() {
        return labelCount;
    }

    public LeftPanel() {
        this.labelCount.setFont(new Font("宋体", 1, 24));
        this.labelCount.setForeground(Color.BLACK);
        this.labelCount.setVisible(true);
        this.labelCount.setBackground(null);
        this.labelCount.setFocusable(false);
        this.labelCount.setSize(IMG_WIDTH, IMG_HEIGHT);
        this.start.setSize(IMG_WIDTH, IMG_HEIGHT);
        this.suspend.setSize(IMG_WIDTH, IMG_HEIGHT);

        final Box box = Box.createVerticalBox();
        box.setSize(IMG_WIDTH, IMG_HEIGHT*3);
        box.add(labelCount);
        box.add(Box.createHorizontalStrut(IMG_WIDTH));
        box.add(Box.createVerticalStrut(IMG_WIDTH));
        box.add(start);
        box.add(suspend);
        box.add(goon);
        box.add(reset);
        this.jPanel.add(box);

        this.jPanel.setSize(IMG_WIDTH, IMG_HEIGHT*3);
        this.jPanel.setBackground(null);
        this.jPanel.setVisible(true);
    }
}
