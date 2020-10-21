package org.sudoku;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SudokuMain {

    final static Logger logger = Logger.getLogger(SudokuMain.class.getSimpleName());

    public static void main(String[] args) throws FileNotFoundException {
        final SudokuService sudokuService = new SudokuService();
        final int result = sudokuService.validateSudokuFile(args[0]);
        logger.log(Level.ALL, "Given csv file is {}", result);
        System.out.printf("Given csv file is %d", result);

    }
}
