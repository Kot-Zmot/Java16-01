package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void NobodyWins() {
        Game game = new Game();
        Player player01 = new Player(01, "Ivanov", 10);
        Player player02 = new Player(02, "Petrov", 10);

        game.register(player01);
        game.register(player02);

        int actual = game.round("Ivanov", "Petrov");
        int expected = 0;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void FirstWins() {
        Game game = new Game();
        Player player01 = new Player(01, "Ivanov", 20);
        Player player02 = new Player(02, "Petrov", 10);

        game.register(player01);
        game.register(player02);

        int actual = game.round("Ivanov", "Petrov");
        int expected = 1;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void SecondWins() {
        Game game = new Game();
        Player player01 = new Player(01, "Ivanov", 10);
        Player player02 = new Player(02, "Petrov", 20);

        game.register(player01);
        game.register(player02);

        int actual = game.round("Ivanov", "Petrov");
        int expected = 2;

        Assertions.assertEquals(actual, expected);
    }

    @Test
    void SecondNull() {
        Game game = new Game();
        Player player01 = new Player(01, "Ivanov", 20);
//        Player player02 = new Player(02, "Petrov", 10);

        game.register(player01);
//        game.register(player02);

        Assertions.assertThrows(NotFoundException.class, () ->{
            game.round("Ivanov", "Petrov");
        });
    }

    @Test
    void FirstNull() {
        Game game = new Game();
//        Player player01 = new Player(01, "Ivanov", 20);
        Player player02 = new Player(02, "Petrov", 10);

//        game.register(player01);
        game.register(player02);

        Assertions.assertThrows(NotFoundException.class, () ->{
            game.round("Ivanov", "Petrov");
        });
    }

}