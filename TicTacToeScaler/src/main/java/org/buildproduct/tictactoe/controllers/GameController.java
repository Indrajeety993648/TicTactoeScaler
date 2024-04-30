package org.buildproduct.tictactoe.controllers;

import org.buildproduct.tictactoe.enums.GameState;
import org.buildproduct.tictactoe.exception.InvalidMoveException;
import org.buildproduct.tictactoe.models.Game;
import org.buildproduct.tictactoe.models.Player;

import java.util.List;

public class GameController {
    public Game startGame(int dimensions, List<Player> players) {
        ///validate if the two players have same symbols then throw exception

        return new Game(dimensions, players);

    }
    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove(game);
    }
    public GameState checkState(Game game){
        return game.getGameState();

    }
    public Player checkWinner(Game game){
        return game.getWinner();
    }
    public void printBoard(Game game){
        game.printBoard();

    }

}
