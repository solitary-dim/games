package com.omdes.games.DouDiZhu;

/**
 * Created with IntelliJ IDEA.
 * User: Solitary.Wang
 * Date: 2017/6/22
 * Time: 20:18
 */
public final class Player extends BaseProperties {
    private static final long serialVersionUID = -8371600836426074807L;

    private int score;
    private int money;
    //纸牌数量
    private int cardsCountTotal;
    private int cardsCountLast;
    //纸牌
    private String[] cardsGet;
    private String[] cardsKeep;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getCardsCountTotal() {
        return cardsCountTotal;
    }

    public void setCardsCountTotal(int cardsCountTotal) {
        this.cardsCountTotal = cardsCountTotal;
    }

    public int getCardsCountLast() {
        return cardsCountLast;
    }

    public void setCardsCountLast(int cardsCountLast) {
        this.cardsCountLast = cardsCountLast;
    }

    public String[] getCardsGet() {
        return cardsGet;
    }

    public void setCardsGet(String[] cardsGet) {
        this.cardsGet = cardsGet;
    }

    public String[] getCardsKeep() {
        return cardsKeep;
    }

    public void setCardsKeep(String[] cardsKeep) {
        this.cardsKeep = cardsKeep;
    }
}
