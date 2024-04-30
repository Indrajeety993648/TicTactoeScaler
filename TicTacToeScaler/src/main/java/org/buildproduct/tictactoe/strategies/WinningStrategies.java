package org.buildproduct.tictactoe.strategies;

import org.buildproduct.tictactoe.models.Board;
import org.buildproduct.tictactoe.models.Move;

import java.util.HashMap;

public class WinningStrategies {
    static HashMap<Integer, HashMap<Character, Integer>> rowMaps = new HashMap<>();
    static HashMap<Integer, HashMap<Character, Integer>> columnMaps = new HashMap<>();
    static HashMap<Character, Integer> rightDiagonalMap = new HashMap<>();
    static HashMap<Character, Integer> leftDiagonalMap = new HashMap<>();


    public static boolean checkWinner(Board board, Move move){
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        char symbol = move.getPlayer().getSymbol().getSymbol();

        if(!rowMaps.containsKey(row)){
            rowMaps.put(row, new HashMap<>());
        }
        HashMap<Character, Integer> currRowMap = rowMaps.get(row);
        if(!currRowMap.containsKey(symbol)){
            currRowMap.put(symbol, 1);
        }
        else
            currRowMap.put(symbol, currRowMap.get(symbol)+1);

        if(currRowMap.get(symbol) == board.getSize()){
            return true;
        }

        if(!columnMaps.containsKey(col)){
            columnMaps.put(col, new HashMap<>());
        }
        HashMap<Character, Integer> currColMap = columnMaps.get(col);
        if(!currColMap.containsKey(symbol)){
            currColMap.put(symbol, 1);
        }
        else
            currColMap.put(symbol, currColMap.get(symbol)+1);

        if(currColMap.get(symbol) == board.getSize()){
            return true;
        }
        //left diagonal
        if(leftDiagonalMap.containsKey(symbol)){
            leftDiagonalMap.put(symbol, leftDiagonalMap.get(symbol)+1);
        }
        else
            leftDiagonalMap.put(symbol, 1);

        if(leftDiagonalMap.get(symbol) == board.getSize()){
            return true;
        }

        //right diagonal
        if(rightDiagonalMap.containsKey(symbol)){
            rightDiagonalMap.put(symbol, rightDiagonalMap.get(symbol)+1);
        }
        else
            rightDiagonalMap.put(symbol, 1);

        if(rightDiagonalMap.get(symbol) == board.getSize()){
            return true;

        }

        return false;

    }


}
