package com.omdes.games.pintu.version1;

import com.omdes.games.pintu.version1.MainRun;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2016/7/22
 * Time: 19:37
 */
public class WholeOne extends MainRun implements Runnable {
	
	private Integer clickNum = 0;
	private JPanel jp;
	private JFrame jf;
	
	/*public WholeOne (JPanel jp) {
		this.jp = jp;
	}*/

	public WholeOne (JFrame jf) {
		this.jf = jf;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		/*jf.addKeyListener(new KeyAdapter(){
            @Override
			public void keyPressed(KeyEvent e) {
            	switch(e.getKeyCode()){
                case KeyEvent.VK_SPACE: 
                	clickNum++;
                	break;
                }
            	if (clickNum%2 == 0) {
            		System.out.println("pressed twice time");
            	}
            }
		});*/
		jf.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	clickNum++;
            	if (clickNum%2 == 0) {
            		System.out.println("pressed twice time");
            	}
            }
        });
	}

}
