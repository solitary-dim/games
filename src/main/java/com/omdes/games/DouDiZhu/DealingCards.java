package com.omdes.games.doudizhu;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created with IntelliJ IDEA.
 * User: solitary.wang
 * Date: 2017/6/21
 * Time: 15:29
 */
public final class DealingCards {

    private static final int total = Config.getConfig().getCardsCount();

    private static final int min = Config.getConfig().getMin();

    private static final int max = Config.getConfig().getMax();

    private static final int group = Config.getConfig().getPlayersCount();

    /**
     * A*=> 红桃
     * B*=> 红方
     * C*=> 黑桃
     * D*=> 黑梅
     * Z=> 大王
     * z=> 小王
     *
     * @param total 纸牌总张数
     * @param min   其中牌最少的人拥有的纸牌张数
     * @param max   其中牌最多的人拥有的纸牌张数
     * @param group 参与人数
     * @return
     */
    public List<Player> dealingCards(final List<Player> playerList) {
        String[] base = new String[total];
        List<Integer> list = new ArrayList<>(total);
        int i;
        for (i = 0; i < 13; i++) {
            base[i] = "A" + (i + 1);
        }
        for (; i < 26; i++) {
            base[i] = "B" + (i - 12);
        }
        for (; i < 39; i++) {
            base[i] = "C" + (i - 25);
        }
        for (; i < 52; i++) {
            base[i] = "D" + (i - 38);
        }
        base[i] = "z";
        i++;
        base[i] = "Z";

        i = 1;
        Random random = new Random();
        do {
            int m = random.nextInt(1024);
            if (m < total && !list.contains(m)) {
                list.add(m);
            }
            i++;
        } while (list.size() < total);

        String[] a = new String[min];
        String[] b = new String[min];
        String[] c = new String[max];
        i = 0;
        for (int index : list) {
            if (i < min) {
                a[i] = base[index];
            } else if (i < min * 2) {
                b[i - min] = base[index];
            } else {
                c[i - min * 2] = base[index];
            }
            i++;
        }

        playerList.get(0).setCardsGet(a);
        playerList.get(1).setCardsGet(b);
        playerList.get(2).setCardsGet(c);

        playerList.get(2).setFlag("D");

        return playerList;
    }
}
