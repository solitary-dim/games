package com.omdes.games.pintu.version3;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/28
 * Time: 22:07
 */
public class RightFrame implements Serializable {
    private static final long serialVersionUID = 6168785588213414358L;

    private final JFrame jFrame = new JFrame();
    protected final CardLayout layout = new CardLayout();

    protected JFrame createFrame() {
        JPanel panelShow = new RightPanelShow().createPanel();
        JPanel panelHide = new RightPanelHide().createPanel();

        this.jFrame.setLayout(layout);
        this.jFrame.add(panelShow);
        this.jFrame.add(panelHide);

        return this.jFrame;
    }

    public void setLargePicture() {
        layout.next(jFrame.getContentPane());
    }
}
