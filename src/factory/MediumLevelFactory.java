package factory;

import domain.Level;
import domain.MediumLevel;
import domain.Puzzle;

import java.util.List;

public class MediumLevelFactory implements LevelFactory {
    public Level createLevel(Long levelNumber, List<Puzzle> puzzles) {
        Integer puzzleCount = 5;
        Integer timeLimit = 180;
        return new MediumLevel(levelNumber, puzzleCount, timeLimit, puzzles);
    }
}
