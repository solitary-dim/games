package com.omdes.games.DouDiZhu;

import java.io.*;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/20
 * Time: 21:46
 */
public final class Config {
    private static final String ENCODING = "UTF-8";
    /**
     * 配置文件名
     */
    private static final String FILE_NAME = "DDZConfig.properties";

    /**
     * 操作对象.
     */
    private volatile static Config config;
    public static Config getConfig() {
        if (null == config) {
            synchronized (Config.class) {
                if (null == config) {
                    config = new Config();
                }
            }
        }
        return config;
    }

    /**
     * 属性文件对象.
     */
    private Properties properties;

    private static final String GAME_AUTHOR = "game.author";

    private static final String GAME_NAME = "game.name";

    private static final String GAME_PLAYERS_COUNT = "game.players.count";

    private static final String GAME_CARDS_COUNT = "game.cards.count";

    private String gameAuthor;

    private String gameName;

    private int playersCount;

    private int cardsCount;

    public String getGameAuthor() {
        return gameAuthor;
    }

    public void setGameAuthor(String gameAuthor) {
        this.gameAuthor = gameAuthor;
    }

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public int getPlayersCount() {
        return playersCount;
    }

    public void setPlayersCount(int playersCount) {
        this.playersCount = playersCount;
    }

    public int getCardsCount() {
        return cardsCount;
    }

    public void setCardsCount(int cardsCount) {
        this.cardsCount = cardsCount;
    }

    public void loadProperties(Properties pro) {
        String value = null;
        System.out.println("配置项：");

        value = pro.getProperty(GAME_AUTHOR);
        if (!"".equals(value) && null != value) {
            this.gameAuthor = value.trim();
            System.out.println("游戏开发者==>" + GAME_AUTHOR + "==>" + value);
        }

        value = pro.getProperty(GAME_NAME);
        if (!"".equals(value) && null != value) {
            this.gameName = value.trim();
            System.out.println("游戏名称==>" + GAME_NAME + "==>" + value);
        }

        value = pro.getProperty(GAME_PLAYERS_COUNT);
        if (!"".equals(value) && null != value) {
            this.playersCount = Integer.parseInt(value.trim());
            System.out.println("玩家人数==>" + GAME_PLAYERS_COUNT + "==>" + value);
        }

        value = pro.getProperty(GAME_CARDS_COUNT);
        if (!"".equals(value) && null != value) {
            this.cardsCount = Integer.parseInt(value.trim());
            System.out.println("纸牌数量==>" + GAME_CARDS_COUNT + "==>" + value);
        }
        System.out.println("已加载");
    }

    public void loadPropertiesFromPath(String rootPath) {
        if (!"".equals(rootPath) && null != rootPath) {
            File file = new File(rootPath + File.separator + FILE_NAME);
            InputStream in = null;
            if (file.exists()) {
                try {
                    in = new FileInputStream(file);
                    final BufferedReader bf = new BufferedReader(new InputStreamReader(in, ENCODING));
                    properties = new Properties();
                    properties.load(bf);
                    loadProperties(properties);
                    bf.close();
                } catch (UnsupportedEncodingException e) {
                    System.out.println("UnsupportedEncodingException!" + e);
                } catch (FileNotFoundException e) {
                    System.out.println("FileNotFoundException!" + e);
                } catch (IOException e) {
                    System.out.println("IOException!" + e);
                } finally {
                    if (null != in) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            System.out.println("IOException!" + e);
                        }
                    }
                }
            } else {
                //由于此时可能还没有完成LOG的加载，因此采用标准输出来打印日志信息
                System.out.println(rootPath + FILE_NAME + "不存在,加载参数失败");
            }
        } else {
            loadPropertiesFromSrc();
        }

    }

    /**
     * 从classpath路径下加载配置参数
     */
    public void loadPropertiesFromSrc() {
        InputStream in = Config.class.getClassLoader().getResourceAsStream(FILE_NAME);
        if (null != in) {
            try {
                final BufferedReader bf = new BufferedReader(new InputStreamReader(in, ENCODING));
                properties = new Properties();
                properties.load(bf);
                loadProperties(properties);
                bf.close();
            } catch (UnsupportedEncodingException e) {
                System.out.println("UnsupportedEncodingException!" + e);
            } catch (IOException e) {
                System.out.println("IOException!" + e);
            } finally {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println("IOException!" + e);
                }
            }
        } else {
            System.out.println(FILE_NAME + "属性文件未能在classpath指定的目录下 " + Config.class.getClassLoader().getResource("").getPath() + " 找到!");
        }
    }
}
