package com.omdes.games.pintu.version2;

import javax.swing.*;
import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/28
 * Time: 21:26
 */
public final class RightPanelHide implements Serializable {
    private static final long serialVersionUID = -578866126379556074L;

    private final JPanel jPanel = new JPanel();

    protected JPanel createPanel() {
        return jPanel;
    }
}
