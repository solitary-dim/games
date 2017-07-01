package com.omdes.games.pintu;

import javax.swing.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/28
 * Time: 20:53
 */
public final class ConfigConstant implements Serializable {
    private static final long serialVersionUID = -2661747294015409836L;

    private static volatile ConfigConstant configConstant;

    private ConfigConstant() {
    }

    public static ConfigConstant getConfig() {
        if (null == configConstant) {
            synchronized (ConfigConstant.class) {
                if (null == configConstant) {
                    configConstant = new ConfigConstant();
                }
            }
        }
        return configConstant;
    }

    public static final int WIDTH = 500;
    public static final int HEIGHT = 600;

    public static final String PANEL_START = "0";
    public static final String PANEL_ONE = "1";

    public static final int NUM = 9;
    public static int[] RAND_INT = new int[9];
    public static String[] RAND_STRING = new String[9];

    private static ImageIcon IMG_ICON = new ImageIcon(ConfigConstant.class.getResource("images/9/one_0.jpg"));
    public static int IMG_WIDTH = IMG_ICON.getIconWidth() + 3;
    public static int IMG_HEIGHT = IMG_ICON.getIconHeight() + 3;

    public static Integer X_LOCATION = 0;
    public static Integer Y_LOCATION = 0;
    public static String[] CORRECT = {"0", "1", "2", "3", "4", "5", "6", "7", "8"};

    public static Map<String, JLabel> MAP = new HashMap<>();

    //步数
    public static int CLICK_COUNT = 0;
}
