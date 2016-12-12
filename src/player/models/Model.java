package player.models;

import java.io.File;

public class Model {
	
	Level levels[];
	
	public Level[] getLevels() {
		return levels;
	}

	public void setLevels(Level[] levels) {
		this.levels = levels;
	}

	public Model() {
		// STUB
		String targetDir = "../cobalt-lettercraze/levels";
		File dir = new File(targetDir);
		File[] files = dir.listFiles();
		
		for (File f: files) {
			Puzzle puzzle = new Puzzle(f);
			System.out.println(puzzle.toString());
		}
	}
}
