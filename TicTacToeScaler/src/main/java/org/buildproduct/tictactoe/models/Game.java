package org.buildproduct.tictactoe.models;

import org.buildproduct.tictactoe.enums.CellState;
import org.buildproduct.tictactoe.enums.GameState;
import lombok.Getter;
import lombok.Setter;
import org.buildproduct.tictactoe.exception.InvalidMoveException;
import org.buildproduct.tictactoe.strategies.WinningStrategies;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Game {
    private org.buildproduct.tictactoe.models.Board Board;
    private List<Player> players;
    private int nextPlayerMoveIndex;
    private Player winner;
    private List<Move> move;
    private GameState gameState;
    private WinningStrategies winningStrategies;

    public Game(int dimension, List<Player> players) {
        this.Board = new Board(dimension);
        this.players = players;
        this.nextPlayerMoveIndex = 0;
        this.move = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        this.winner = null;

    }
    public void printBoard(){
        this.Board.printBoard();




    }
    public void makeMove(Game game) throws InvalidMoveException{
        Player currentPlayer = this.players.get(nextPlayerMoveIndex);
        System.out.println("Player "+currentPlayer.getName()+"'s turn");
        Move move_var = currentPlayer.makeMove(Board);

        //game will validate the move
        if(!validateMove(move_var)){
            throw new InvalidMoveException("Invalid Move by"+ currentPlayer.getName());



        }
        int row = move_var.getCell().getRow();
        int col = move_var.getCell().getCol();
        Cell cellToChange = Board.getBoard().get(row).get(col);
        cellToChange.setPlayer(currentPlayer);
        cellToChange.setCellState(CellState.FILLED);

        Move finalMove = new Move(cellToChange, currentPlayer);
        this.move.add(finalMove);
        nextPlayerMoveIndex = (nextPlayerMoveIndex + 1) % players.size();
        // mod taken because we want to keep the index within the range of the players

        //check if current move is the winning move
        if(WinningStrategies.checkWinner(Board, finalMove)){
            this.gameState = GameState.ENDED;
            this.winner = currentPlayer;

        }











    }
    public boolean validateMove(Move move){
        //check if the cell is empty
        //check if the cell is within the board
        //check if the move is made by the correct player

        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        if(row < 0 || row >= this.Board.getSize() || col < 0 || col >= this.Board.getSize()){
            return false;
        }

        return Board.getBoard().get(row).get(col).getCellState().equals(CellState.EMPTY);

    }



}
