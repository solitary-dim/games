package com.omdes.games.pintu.version3;

import com.omdes.games.pintu.ConfigConstant;

import javax.swing.*;
import java.io.Serializable;

import static com.omdes.games.pintu.ConfigConstant.IMG_HEIGHT;
import static com.omdes.games.pintu.ConfigConstant.IMG_WIDTH;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/28
 * Time: 21:26
 */
public final class RightPanelHide implements Serializable {
    private static final long serialVersionUID = 1635009494485328536L;

    private final JPanel jPanel = new JPanel();

    protected JPanel createPanel() {
        final JLabel jLabel = new JLabel();
        jLabel.setIcon(new ImageIcon(ConfigConstant.class.getResource("images/9/one.jpg")));
        jLabel.setBounds(0, 0, IMG_WIDTH*3, IMG_HEIGHT*3);
        jPanel.add(jLabel);
        return jPanel;
    }
}
