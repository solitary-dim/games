package com.omdes.games.DouDiZhu;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/20
 * Time: 21:46
 */
public final class Main {

    public static void main(String[] args) {
        getGameConfig();
    }

    private static void getGameConfig() {
        Config config = Config.getConfig();
        config.loadPropertiesFromSrc();
        System.out.println(config.getGameName());
    }
}