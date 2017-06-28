package com.omdes.games.pintu.version1;

import com.omdes.games.pintu.ConfigConstant;
import com.omdes.games.pintu.version2.PartOne;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import static com.omdes.games.pintu.ConfigConstant.*;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2016/7/22
 * Time: 18:41
 */
public class MainRun {

	protected static JFrame jf = new JFrame("PinTu");
    protected static CardLayout cardLayout = new CardLayout();
    
    private static JPanel jp = new JPanel();
    private static JPanel jRightShow = new JPanel();
    private static Map<String, JLabel> nap = new HashMap<>();
	private static ArrayList<Thread> threadList = new ArrayList<>();
	private Random ranDom = new Random();
    
    //Left
	protected static JButton jStart = new JButton("start");
    protected static JButton jSuspend = new JButton("suspend");
	
    //partOne
    protected static JPanel jLeft = new JPanel();
    protected static JPanel jRight = new JPanel();
    protected static JPanel jRightHide = new JPanel();
    protected static String change = null;
    
    private int[] randString () {
        RAND_INT[0] = ranDom.nextInt(9);
    	int num = 1;
    	boolean flag = true;
    	while (num < NUM) {
    		int r = ranDom.nextInt(9);
    		for (int i = 0 ; i < num ; i++) {
    			if (RAND_INT[i] == r) {
    				flag = false;
    			}
    		}
    		if (flag) {
                RAND_INT[num] = r;
				num++;
    		}
			flag = true;
    	}
		for (int i = 0 ; i < NUM ; i ++ ) {
            RAND_STRING[i] = String.valueOf(RAND_INT[i]);
		}
    	return RAND_INT;
    }
    
    private void alertJPanel(){
    	jRightHide.setLayout(null);
    	//jRightHide.setBackground(Color.WHITE);
    	//jPanel.setLayout(null);
    	//jRightHide.setOpaque(false);
    	//jRightHide.setVisible(false);
    	//jRightHide.setSize(IMG_WIDTH*3, IMG_HEIGHT*3);
    	jRightHide.setVisible(true);
    }
    
    private static void leftPanel () {
    	final JLabel jl = new JLabel("成功!");
    	jl.setFont(new Font("宋体",1,24));
    	jl.setForeground(Color.BLACK);
    	jl.setVisible(true);
    	jl.setBackground(null);
    	jl.setFocusable(false);
    	jl.setBounds(0, 0, IMG_WIDTH, IMG_HEIGHT*3);
    	jStart.setBounds(20, 100, IMG_WIDTH, IMG_HEIGHT);
    	jSuspend.setBounds(20, 200, IMG_WIDTH, IMG_HEIGHT);
    	
    	final Box  box = Box.createVerticalBox();
    	box.setSize(IMG_WIDTH, IMG_HEIGHT*3);
    	box.add(jStart);
    	box.add(Box.createHorizontalStrut(IMG_WIDTH));
    	box.add(Box.createVerticalStrut(IMG_HEIGHT));
    	box.add(jSuspend);
    	box.add(Box.createVerticalStrut(IMG_HEIGHT));
    	box.add(jl);
    	jLeft.add(box);
    	
    	//jLeft.setLayout(null);
    	//jLeft.add(jStart);
    	//jLeft.add(jl);
    	jLeft.setSize(IMG_WIDTH, IMG_HEIGHT*3);
    	//jLeft.setBounds(0, 0, IMG_WIDTH, IMG_HEIGHT*3);
    	//jLeft.setSize(IMG_WIDTH, IMG_HEIGHT*3);
    	jLeft.setBorder(BorderFactory.createLineBorder(Color.RED));
    	jLeft.setBackground(null);
    	jLeft.setVisible(true);
    }
    
    private static void rightPanel () {
    	new MainRun().alertJPanel();
    	new MainRun().randString();
    	
    	jRightShow.setLayout(new GridLayout(3, 3, 3, 3));
        for (int i = 0 ; i < NUM ; i ++ ) {
            JLabel jl = new JLabel();
            jl.setIcon(new ImageIcon(new ImageIcon(ConfigConstant.class.getResource("images/9/one_" +RAND_INT[i]+".jpg")).getImage()));
            //jl.setBorder(BorderFactory.createLineBorder(Color.red));
            MAP.put(String.valueOf(i), jl);
            /*final int order = i;
            jl.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    clickNum++;
                    if (clickNum == 1) {
                        change = String.valueOf(order);
                    } else if (clickNum == 2) {
                        System.out.println("change: " + change + "||| order: " + order);
                        String temp = String.valueOf(order);

                        nap.put(change, map.get(change));
                        nap.put(temp, map.get(temp));
                        map.remove(change);
                        map.put(change, nap.get(temp));
                        map.remove(temp);
                        map.put(temp, nap.get(change));

                        jRightShow.removeAll();
                        for (int j = 0 ; j < NUM ; j ++ ) {
                            jRightShow.add(map.get(String.valueOf(j)));
                        }
                        jRightShow.repaint();

                        nap.remove(change);
                        nap.remove(temp);
                        change = null;
                        nap = null;
                        clickNum = 0;
                    }
                }
            });*/
        }
        for (int i = 0 ; i < NUM ; i ++ ) {
        	jRightShow.add(MAP.get(String.valueOf(i)));
        }
    }

    public static void randPictures () { 
    	leftPanel();
    	rightPanel();
        jRight.setLayout(cardLayout);
        jRight.add(jRightShow);
        jRight.add(jRightHide);
        jp.setBackground(Color.WHITE);
        jf.setLayout(new BorderLayout(0, 0));
        jp.add(jLeft, BorderLayout.WEST);
        jp.add(jRight, BorderLayout.CENTER);
        
        /*jp.setLayout(null);
        jLeft.setBounds(0, 0, IMG_WIDTH, IMG_HEIGHT*3);
        jRight.setBounds(IMG_WIDTH, 0, IMG_WIDTH*3, IMG_HEIGHT*3);
        jp.setSize(IMG_WIDTH*4, IMG_HEIGHT*3);
        jp.add(jLeft);
        jp.add(jRight);*/
        
        jf.add(jp);
        jf.pack();
        jf.setResizable(false);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main (String[] args) {
        ConfigConstant configConstant = ConfigConstant.getConfig();
        randPictures();
        for (int i = 0 ; i < NUM ; i ++ ) {
        	Thread thread = new Thread(new PartOne(MAP.get(String.valueOf(i)), String.valueOf(i)));
        	thread.start();
			threadList.add(thread);
        }
        /*Thread thread = new Thread(new WholeOne(jf));
        thread.start();
        threadList.add(thread);*/
    }


}
