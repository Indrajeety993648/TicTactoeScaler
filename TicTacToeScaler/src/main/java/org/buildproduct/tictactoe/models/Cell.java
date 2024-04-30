package org.buildproduct.tictactoe.models;

import org.buildproduct.tictactoe.enums.CellState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter


public class Cell {
    private int row;
    private int col;
    private Player player;
    private CellState cellState;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
//        this.player = player;
        this.cellState = CellState.EMPTY;
    }




}
