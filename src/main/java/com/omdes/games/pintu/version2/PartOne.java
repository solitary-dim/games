package com.omdes.games.pintu.version2;

import com.omdes.games.pintu.ConfigConstant;

import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import static com.omdes.games.pintu.ConfigConstant.*;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2016/7/22
 * Time: 18:50
 */
public class PartOne extends Main implements Runnable {
	
	private static Integer clickNum = 0;
	private JLabel jl;
	private String order = null;
	private static String change = null;
	
	public PartOne (JLabel jl, String order) {
		this.jl = jl;
		this.order = order;
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

	@Override
	public void run() {
		jl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
				if (!order.equals(change)) {
            		clickNum++;
            		Point p = jl.getLocation();
            		int x = p.x;
            		int y = p.y;
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
                		if ((xTo == IMG_WIDTH && yTo == 0) || (xTo == 0 && yTo == IMG_HEIGHT)) {
                			JLabel jLabel = MAP.get(change);
                    		Point pl = jLabel.getLocation();
                    		
                    		p.x = pl.x;
                    		p.y = pl.y;
        					jl.setLocation(p);
        					jl.validate();
        					jl.setVisible(true);
        					
        					pl.x = x;
        					pl.y = y;
							jLabel.setLocation(pl);
							jLabel.validate();
							jLabel.setVisible(true);
        					
        					changeOrder(change, order);
        					
        					if (arrayEqualsArray(RAND_STRING, CORRECT)) {
        				    	final JLabel jb = new JLabel();
        				    	jb.setIcon(new ImageIcon(ConfigConstant.class.getResource("images/9/one.jpg")));
        				    	jb.setBounds(0, 0, IMG_WIDTH*3, IMG_HEIGHT*3);
        				    	//jRightHide.add(jb);
        	            		//cardLayout.next(jRight);
								System.out.println(jFrame.getContentPane());
        	            	} else {
        	            	}
                    		
        					change = null;
							X_LOCATION = 0;
							Y_LOCATION = 0;
                    		clickNum = 0;
                		} else {
                			change = order;
							X_LOCATION = x;
							Y_LOCATION = y;
                    		clickNum = 1;
                		}
                	}
                }
        	}	
        });
	}

}
