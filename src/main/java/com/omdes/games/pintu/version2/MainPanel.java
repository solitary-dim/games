package com.omdes.games.pintu.version2;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/28
 * Time: 20:31
 */
public class MainPanel {
    private static final int LINE_SPACING = 10;

    private final JPanel jPanel = new JPanel();

    protected JPanel createPanel(int width, int height) {
        jPanel.setSize(width, height);

        JPanel leftPanel = new LeftPanel().createPanel();
        JPanel rightPanel = new RightPanel().createPanel();

        GroupLayout layout = new GroupLayout(this.jPanel);
        //设置组件之间自动间距
        layout.setAutoCreateGaps(true);
        this.jPanel.setLayout(layout);

        //创建GroupLayout的垂直连续组，，越先加入的ParallelGroup，优先级级别越高。
        layout.setVerticalGroup(layout.createSequentialGroup().
                        addContainerGap().
                        addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(leftPanel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE).
                                addComponent(rightPanel, GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        //创建GroupLayout的水平连续组，，越先加入的ParallelGroup，优先级级别越高。
        layout.setHorizontalGroup(layout.createSequentialGroup().
                        addGap(LINE_SPACING).
                        addGroup(layout.createParallelGroup().
                                addComponent(leftPanel, GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)).
                        addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).
                        addGroup(layout.createParallelGroup().
                                addComponent(rightPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jPanel.add(leftPanel);
        jPanel.add(rightPanel);
        return jPanel;
    }
}
