package ru.netology;

import java.util.ArrayList;

public class Game {

    ArrayList<Player> players = new ArrayList<>();

    public void register(Player player) {

        players.add(player);

    }

    public int round(String playerName1, String playerName2) {
        Player player01 = null;
        Player player02 = null;
        for (Player player : players) {
            if (player.getName().equals(playerName1)) {
                player01 = player;
            }
            if (player.getName().equals(playerName2)) {
                player02 = player;
            }

        }

        if (player01 == null) {
            throw new NotFoundException(playerName1);
        }

        if (player02 == null) {
            throw new NotFoundException(playerName2);
        }

        if (player01.getStrength() == player02.getStrength()) {
            return 0;
        }
        if (player01.getStrength() > player02.getStrength()) {
            return 1;
        }
        return 2;
    }
}


