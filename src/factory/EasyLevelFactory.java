package factory;

import domain.EasyLevel;
import domain.Level;
import domain.Puzzle;

import java.util.List;

public class EasyLevelFactory implements LevelFactory {
    public Level createLevel(Long levelNumber, List<Puzzle> puzzles) {
        Integer puzzleCount = 3;
        Integer timeLimit = 120;
        return new EasyLevel(levelNumber, puzzleCount, timeLimit, puzzles);
    }
}
