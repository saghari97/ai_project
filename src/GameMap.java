import java.util.ArrayList;

public class GameMap {

    int columns;
    int rows;
    ArrayList<MapCell> mapcells;

    public GameMap(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        mapcells = new ArrayList<>(100);
        for (int i = 0; i < rows * columns; i++) {
            mapcells.add(new MapCell());
        }
    }

    public ArrayList<MapCell> getmapCells() {
        return mapcells;
    }
}
