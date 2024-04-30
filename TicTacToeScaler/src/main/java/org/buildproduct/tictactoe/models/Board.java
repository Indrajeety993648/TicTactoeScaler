package org.buildproduct.tictactoe.models;

import lombok.Getter;
import lombok.Setter;
import org.buildproduct.tictactoe.enums.CellState;
import org.buildproduct.tictactoe.models.Cell;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Board {
    private int size;
    private List<List<Cell>> board;

    public Board(int size){
        this.size = size;
        board = new ArrayList<>();
        for(int i=0;i<size; i++){
            List<Cell> row = new ArrayList<>();
            for(int j=0; j<size; j++){
                row.add(new Cell(i, j));
            }
            board.add(row);
        }




    }

    public void printBoard() {
        for(List<Cell> row: board){
            for(Cell cell: row){
                if(cell.getCellState().equals(CellState.EMPTY)){
                    System.out.print("| -- |");
                }else{
                    System.out.print("| "+cell.getPlayer().getSymbol().getSymbol()+" |");

                }
            }
            System.out.println();
        }

    }


}
