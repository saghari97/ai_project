import java.lang.reflect.Array;
import java.util.ArrayList;

public class GameMap {

    int columns;
    int rows;
    ArrayList<ArrayList<MapCell>> mapcells;

    public GameMap(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        mapcells = new ArrayList<>(10);

        for (int i = 0; i < rows; i++) {
            ArrayList<MapCell> temp = new ArrayList<>();
            for (int j = 0; j < columns; j++)
                temp.add(new MapCell());
            mapcells.add(temp);
        }
    }

    public ArrayList<ArrayList<MapCell>> getmapCells() {
        return mapcells;
    }
}
