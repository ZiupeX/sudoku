package org.sudoku.validator;

import java.util.Arrays;

public class SudokuValidator {

    public int validateSudokuMatrix(final int[][] sudokuMatrix) {
        for (int i = 0; i < 9; i++) {

            final int[] row = new int[9];
            final int[] square = new int[9];
            final int[] column = sudokuMatrix[i].clone();

            for (int j = 0; j < 9; j++) {
                row[j] = sudokuMatrix[j][i];
                square[j] = sudokuMatrix[(i / 3) * 3 + j / 3][i * 3 % 9 + j % 3];
            }
            if (!(validate(column) && validate(row) && validate(square)))
                return 1;
        }
        return 0;
    }

    private boolean validate(final int[] check) {
        int i = 0;
        Arrays.sort(check);
        for (int number : check) {
            if (number != ++i)
                return false;
        }
        return true;
    }

}
