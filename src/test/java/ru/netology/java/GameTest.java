package ru.netology.java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    @Test
    public void shouldWinPlayer1WhenMoreStr() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 15);
        Player player2 = new Player(2, "Petr", 13);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Ivan", "Petr");
        int expected = 1;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinPlayer2WhenMoreStr() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 15);
        Player player2 = new Player(2, "Petr", 20);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Ivan", "Petr");
        int expected = 2;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldWinFriendShip() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 5);
        Player player2 = new Player(2, "Petr", 5);
        game.register(player1);
        game.register(player2);

        int actual = game.round("Ivan", "Petr");
        int expected = 0;
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void player2NotAllowedToPlay() {
        Game game = new Game();
        Player player1 = new Player(1, "Ivan", 15);

        game.register(player1);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Petr");
        });
    }

    @Test
    public void player1NotAllowedToPlay() {
        Game game = new Game();

        Player player2 = new Player(2, "Petr", 13);

        game.register(player2);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Petr");
        });
    }

    @Test
    public void playersNotAllowedToPlay() {
        Game game = new Game();

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            game.round("Ivan", "Petr");
        });
    }
}