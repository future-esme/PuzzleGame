package domain;

import java.util.List;
import java.util.Objects;

public abstract class Level {
    public Long levelNumber;
    public Integer puzzleCount;
    public Integer timeLimitForPuzzle;
    public List<Puzzle> puzzles;

    public Level(Long levelNumber, Integer puzzleCount, Integer timeLimitForPuzzle, List<Puzzle> puzzles) {
        this.levelNumber = levelNumber;
        this.puzzleCount = puzzleCount;
        this.timeLimitForPuzzle = timeLimitForPuzzle;
        this.puzzles = puzzles;
    }

    public abstract void hideLetters(Long puzzleId);

    public Puzzle getPuzzleById(Long puzzleId) {
        for (var puzzle : puzzles) {
            if (Objects.equals(puzzle.getId(), puzzleId)) {
                return puzzle;
            }
        }
        throw new RuntimeException();
    }

    public Long getLevelNumber() {
        return this.levelNumber;
    }
}
