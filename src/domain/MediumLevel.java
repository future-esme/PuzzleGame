package domain;

import java.util.List;

public class MediumLevel extends Level {
    public MediumLevel(Long levelNumber,
                       Integer puzzleCount,
                       Integer timeLimitForPuzzle,
                       List<Puzzle> puzzles) {
        super(levelNumber, puzzleCount, timeLimitForPuzzle, puzzles);
    }

    @Override
    public void hideLetters(Long puzzleId) {
        var puzzle = getPuzzleById(puzzleId);
        var hideLettersMatrix = puzzle.getMatrix().clone();
        for (var i = puzzle.getMatrix().length - 1; i >= 0; i--) {
            hideLettersMatrix[i][puzzle.getMatrix()[0].length - 1 - i] = '$';
        }
        var matrixPrint = new StringBuilder();
        for (Character[] characters : hideLettersMatrix) {
            for (int j = 0; j < hideLettersMatrix[0].length; j++) {
                matrixPrint.append(characters[j]).append(" ");
            }
            matrixPrint.append("\n");
        }
        System.out.println(matrixPrint);
    }
}
