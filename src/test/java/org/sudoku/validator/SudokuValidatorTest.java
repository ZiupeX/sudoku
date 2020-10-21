package org.sudoku.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.stream.Stream;

class SudokuValidatorTest {

    @DisplayName("Should return 0 when vaild sudoku matrix")
    @ParameterizedTest(name = "{index} => a={0}")
    @MethodSource("getVaildSudokuMatrix")
    public void shouldReturn0WhenCorrectSudokuMatrix(int[][] sudokuMatrix) {
        final SudokuValidator validator = new SudokuValidator();
        assertEquals(0, validator.validateSudokuMatrix(sudokuMatrix));
    }

    @DisplayName("Should return 1 when invaild sudoku matrix")
    @ParameterizedTest(name = "{index} => a={0}")
    @MethodSource("getInvaildSudokuMatrix")
    public void shouldReturn1WhenIncorrectSudokuMatrix(int[][] sudokuMatrix) {
        final SudokuValidator validator = new SudokuValidator();
        assertEquals(1, validator.validateSudokuMatrix(sudokuMatrix));
    }

    private static Stream<int[][]> getVaildSudokuMatrix() {
        final int[][] matrix1 = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        final int[][] matrix2 = {
                {7, 2, 6, 4, 9, 3, 8, 1, 5},
                {3, 1, 5, 7, 2, 8, 9, 4, 6},
                {4, 8, 9, 6, 5, 1, 2, 3, 7},
                {8, 5, 2, 1, 4, 7, 6, 9, 3},
                {6, 7, 3, 9, 8, 5, 1, 2, 4},
                {9, 4, 1, 3, 6, 2, 7, 5, 8},
                {1, 9, 4, 8, 3, 6, 5, 7, 2},
                {5, 6, 7, 2, 1, 4, 3, 8, 9},
                {2, 3, 8, 5, 7, 9, 4, 6, 1}
        };

        final int[][] matrix3 = {
                {7, 2, 6, 4, 9, 3, 8, 1, 5},
                {4, 8, 9, 6, 5, 1, 2, 3, 7},
                {3, 1, 5, 7, 2, 8, 9, 4, 6},
                {8, 5, 2, 1, 4, 7, 6, 9, 3},
                {6, 7, 3, 9, 8, 5, 1, 2, 4},
                {9, 4, 1, 3, 6, 2, 7, 5, 8},
                {1, 9, 4, 8, 3, 6, 5, 7, 2},
                {5, 6, 7, 2, 1, 4, 3, 8, 9},
                {2, 3, 8, 5, 7, 9, 4, 6, 1}
        };
        return Stream.of(matrix1, matrix2, matrix3);
    }

    private static Stream<int[][]> getInvaildSudokuMatrix() {
        final int[][] matrix1 = {
                {4, 3, 4, 6, 7, 8, 9, 1, 2},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        final int[][] matrix2 = {
                {2, 2, 6, 4, 9, 3, 8, 1, 5},
                {4, 8, 9, 6, 5, 1, 2, 3, 7},
                {8, 5, 2, 1, 4, 7, 6, 9, 3},
                {6, 7, 3, 9, 8, 5, 1, 2, 4},
                {3, 1, 5, 7, 2, 8, 9, 4, 6},
                {9, 4, 1, 3, 6, 2, 7, 5, 8},
                {1, 9, 4, 8, 3, 6, 5, 7, 2},
                {5, 6, 7, 2, 1, 4, 3, 8, 9},
                {2, 3, 8, 5, 7, 9, 4, 6, 1}
        };
        final int[][] matrix3 = {
                {2, 2, 6, 4, 9, 3, 8, 1, 5, 5},
                {4, 8, 9, 6, 5, 1, 2, 3, 7, 5},
                {8, 5, 2, 1, 4, 7, 6, 9, 3, 5},
                {6, 7, 3, 9, 8, 5, 1, 2, 4, 5},
                {3, 1, 5, 7, 9, 8, 9, 4, 6, 5},
                {9, 4, 1, 3, 6, 2, 7, 5, 8, 5},
                {1, 9, 4, 8, 3, 6, 5, 7, 2, 5},
                {5, 6, 7, 2, 1, 4, 3, 8, 9, 5},
                {2, 3, 8, 5, 7, 9, 4, 6, 1, 5}
        };
        return Stream.of(matrix1, matrix2, matrix3);
    }

}