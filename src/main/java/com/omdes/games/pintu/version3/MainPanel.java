package com.omdes.games.pintu.version3;

import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/28
 * Time: 20:31
 */
public final class MainPanel {
    private static final int LINE_SPACING = 10;

    private final JPanel jPanel = new JPanel();
    private final RightPanel rightPanel = new RightPanel();
    private final LeftPanel leftPanel = new LeftPanel();

    public LeftPanel getLeftPanel() {
        return leftPanel;
    }

    public RightPanel getRightPanel() {
        return rightPanel;
    }

    protected JPanel createPanel(int width, int height) {
        jPanel.setSize(width, height);

        GroupLayout layout = new GroupLayout(this.jPanel);
        //设置组件之间自动间距
        layout.setAutoCreateGaps(true);
        this.jPanel.setLayout(layout);

        //创建GroupLayout的垂直连续组，，越先加入的ParallelGroup，优先级级别越高。
        layout.setVerticalGroup(layout.createSequentialGroup().
                        addContainerGap().
                        addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE).
                                addComponent(leftPanel.getjPanel(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE).
                                addComponent(rightPanel.getjPanel(), GroupLayout.Alignment.BASELINE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        //创建GroupLayout的水平连续组，，越先加入的ParallelGroup，优先级级别越高。
        layout.setHorizontalGroup(layout.createSequentialGroup().
                        addGap(LINE_SPACING).
                        addGroup(layout.createParallelGroup().
                                addComponent(leftPanel.getjPanel(), GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)).
                        addPreferredGap(LayoutStyle.ComponentPlacement.RELATED).
                        addGroup(layout.createParallelGroup().
                                addComponent(rightPanel.getjPanel(), GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
        );

        jPanel.add(leftPanel.getjPanel());
        jPanel.add(rightPanel.getjPanel());
        return jPanel;
    }
}
