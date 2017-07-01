package com.omdes.games.pintu.version3;

import javax.swing.*;
import java.awt.*;
import java.io.Serializable;

import static com.omdes.games.pintu.ConfigConstant.PANEL_START;
import static com.omdes.games.pintu.ConfigConstant.PANEL_ONE;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/28
 * Time: 20:13
 */
public final class RightPanel implements Serializable {
    private static final long serialVersionUID = -4427589089500671745L;

    private final JPanel jPanel = new JPanel();
    private final CardLayout layout = new CardLayout();

    public JPanel getjPanel() {
        return jPanel;
    }

    public CardLayout getLayout() {
        return layout;
    }

    public RightPanel() {
        JPanel panelShow = new RightPanelShow().createPanel();
        JPanel panelHide = new RightPanelHide().createPanel();

        this.jPanel.setLayout(layout);
        this.jPanel.add(PANEL_START, panelShow);
        this.jPanel.add(PANEL_ONE, panelHide);
    }
}
