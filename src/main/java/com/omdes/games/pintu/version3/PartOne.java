package com.omdes.games.pintu.version3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static com.omdes.games.pintu.ConfigConstant.*;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2016/7/22
 * Time: 18:50
 */
public final class PartOne extends MainExe implements Runnable {

	private boolean suspend;

	private static Integer clickNum = 0;
	private JLabel jLabel;
	private String order = null;
	private static String change = null;

	public void setSuspend(boolean suspend) {
		this.suspend = suspend;
	}
	
	public PartOne(JLabel jl, String order) {
		this.jLabel = jl;
		this.order = order;
	}

	@Override
	public void run() {
		synchronized(this) {
			while (suspend) {
				try {
					wait();
					//恢复用notify();
				} catch (InterruptedException e) {
					System.out.println("线程暂停失败！\n" + e);
				}
			}
			labelListener();
		}
	}

	private void labelListener() {
		this.jLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (!order.equals(change)) {
					clickNum++;

					Point point = jLabel.getLocation();
					int x = point.x;
					int y = point.y;

					if (clickNum%2 == 1) {
						change = order;
						X_LOCATION = x;
						Y_LOCATION = y;
					} else if (clickNum%2 == 0) {
						int xTo = x - X_LOCATION;
						xTo = xTo >= 0 ? xTo : -xTo;
						int yTo = y - Y_LOCATION;
						yTo = yTo >= 0 ? yTo : -yTo;
						System.out.println(xTo);System.out.println(yTo);
						//判断前后两次点击的小图是否为相邻的两张（上下或左右相邻）
						if ((xTo > 0 && yTo == 0) || (xTo == 0 && yTo > 0)) {
							//是相邻的两张小图，交换位置
							JLabel label = MAP.get(change);
							Point pl = label.getLocation();

							point.x = pl.x;
							point.y = pl.y;
							jLabel.setLocation(point);
							jLabel.validate();
							jLabel.setVisible(true);

							pl.x = x;
							pl.y = y;
							label.setLocation(pl);
							label.validate();
							label.setVisible(true);

							changeOrder(change, order);

							if (arrayEqualsArray(RAND_STRING, CORRECT)) {
								CardLayout layout = rightPanel.getLayout();
								layout.show(rightPanel.getjPanel(), PANEL_ONE);
								System.out.println("success!");
							} else {
							}

							//交换小图位置后，重置已经记录的信息
							change = null;
							X_LOCATION = 0;
							Y_LOCATION = 0;
							clickNum = 0;
						} else {
							//不是相邻的两张小图，将第二次点击的图片作为下一次点击的第一次图片
							change = order;
							X_LOCATION = x;
							Y_LOCATION = y;
							clickNum = 1;
						}
					}
					CLICK_COUNT++;
				} else {
					CLICK_COUNT++;
				}
				//TODO 记录点击次数，并修改左侧栏中步数
				//changeStep(CLICK_COUNT);
				System.out.println("step: " + CLICK_COUNT);
			}
		});
	}

	private String[] changeOrder (String str1, String str2) {
		int m = 0;
		int n = 0;
		for (int i = 0 ; i < NUM ; i++ ) {
			if (RAND_STRING[i].equals(str1)) {
				m = i;
			}
			if (RAND_STRING[i].equals(str2)) {
				n = i;
			}
		}
		RAND_STRING[m] = str2;
		RAND_STRING[n] = str1;
		return RAND_STRING;
	}

	private boolean arrayEqualsArray(String[] old, String[] changed){
		boolean flag = true;
		for (int i = 0 ; i < NUM ; i++ ) {
			if (!old[i].equals(changed[i])) {
				flag = false;
			}
		}
		return flag;
	}

	private void changeStep(int num) {
		leftPanel.getLabelCount().setText("步数：" + num);
	}

}
