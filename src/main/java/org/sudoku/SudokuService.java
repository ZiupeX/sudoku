package org.sudoku;

import org.sudoku.validator.SudokuValidator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class SudokuService {

    public int validateSudokuFile(final String csvFilePath) {
        final int[][] sudokuMatrix;
        try {
            sudokuMatrix = extractSudokuMatrixFromCsvFile(csvFilePath);
        } catch (FileNotFoundException | ArrayIndexOutOfBoundsException e) {
            return 1;
        }
        final SudokuValidator validator = new SudokuValidator();
        return validator.validateSudokuMatrix(sudokuMatrix);
    }

    private int[][] extractSudokuMatrixFromCsvFile(final String csvFilePath) throws FileNotFoundException {
        final Scanner scanner = new Scanner(new File(csvFilePath));
        final int[][] sudokuMatrix = new int[9][9];
        final AtomicInteger index = new AtomicInteger(0);
        while (scanner.hasNext()) {
            int[] line = parseLine(scanner.nextLine());
            sudokuMatrix[index.getAndIncrement()] = line;
        }
        scanner.close();
        return sudokuMatrix;
    }

    private int[] parseLine(String line) {
        return Arrays.stream(line.split(","))
                .mapToInt(Integer::valueOf)
                .toArray();
    }

}
