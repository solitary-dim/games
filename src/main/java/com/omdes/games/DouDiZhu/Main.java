package com.omdes.games.doudizhu;

import java.util.ArrayList;
import java.util.List;

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

        /*final int total = config.getCardsCount();
        final int group = config.getPlayersCount();
        final int min = (total - group) / group;
        final int max = min + group;*/

        /*创建玩家*/
        List<Player> list = new ArrayList<>(config.getPlayersCount());
        for (int i = 0; i < config.getPlayersCount(); i++) {
            Player player = new Player();
            player.setFlag("N");
            list.add(player);
        }

        /*为玩家发牌*/
        DealingCards dc = new DealingCards();
        final List<Player> playerList = dc.dealingCards(list);
        for (Player player : playerList) {
            if ("N".equals(player.getFlag())) {
                System.out.println("农民");
            } else if ("D".equals(player.getFlag())) {
                System.out.println("地主");
            }
            for (String str: player.getCardsGet()) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }
}