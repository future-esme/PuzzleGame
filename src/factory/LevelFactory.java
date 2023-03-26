package factory;

import domain.Level;
import domain.Puzzle;

import java.util.List;

public interface LevelFactory {
    Level createLevel(Long levelNumber, List<Puzzle> puzzles);
}
