package com.omdes.games.pintu.version2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/28
 * Time: 22:07
 */
public class RightFrame implements Serializable {
    private static final long serialVersionUID = -6704764973238298968L;

    private final JFrame jFrame = new JFrame();

    protected JFrame createFrame() {
        final CardLayout layout = new CardLayout();

        JPanel panelShow = new RightPanelShow().createPanel();
        JPanel panelHide = new RightPanelHide().createPanel();

        jFrame.setLayout(layout);
        jFrame.add(panelShow);
        jFrame.add(panelHide);

        LeftPanel.reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                layout.next(jFrame.getContentPane());
            }
        });

        return jFrame;
    }
}
