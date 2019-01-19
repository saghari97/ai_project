import java.util.Random;


public class Main {

    static Random random;

    public static void main(String[] args) {
        GameMap map = new GameMap(10, 10);
        random = new Random(map.columns * map.rows - 1);
        initMap(map);
        printmap(map);
    }

    private static void printmap(GameMap map) {
        for (int i = 0; i < map.rows; i++) {
            for (int j = 0; j < map.columns; j++) {
                map.getmapCells().get(i*(map.rows)+j).showState();
            }
            System.out.println(" ");
        }
    }

    private static void initMap(GameMap map) {
        setBarn(map);
        setCows(map, 4);
        setSticks(map, 5);
        setWolf(map);
        setVacantCells(map);
    }

    private static void setVacantCells(GameMap map) {
        for (MapCell cell :
                map.getmapCells()) {
            if (cell.vacancy)
                cell.object = MapCell.entitiy.vacant;
        }
    }

    private static void setWolf(GameMap map) {
        boolean done = false;
        int instance;
        while (!done) {
            instance = (int) (Math.random() * (map.rows * map.columns + 1) + 1);
            if (map.getmapCells().get(instance).vacancy) {
                map.getmapCells().get(instance).object = MapCell.entitiy.wolf;
                map.getmapCells().get(instance).vacancy = false;
                done = true;
            }
        }
    }

    private static void setBarn(GameMap map) {
        boolean done = false;
        int instance;
        while (!done) {
            instance = (int) (Math.random() * (map.rows * map.columns) + 1);
            if (map.getmapCells().get(instance).vacancy) {
                map.getmapCells().get(instance).object = MapCell.entitiy.barn;
                map.getmapCells().get(instance).vacancy = false;
                done = true;
            }
        }
    }

    private static void setSticks(GameMap map, int sticksNumber) {
        int instance;
        boolean done;
        for (int i = 0; i < sticksNumber; i++) {
            done = false;
            while (!done) {
                instance = (int) (Math.random() * (map.rows * map.columns)+1);
                if (map.getmapCells().get(instance).vacancy) {
                    map.getmapCells().get(instance).object = MapCell.entitiy.stick;
                    map.getmapCells().get(instance).vacancy = false;
                    done = true;
                }
            }
        }
    }

    private static void setCows(GameMap map, int cowsNumber) {
        int instance;
        boolean done;
        for (int i = 0; i < cowsNumber; i++) {
            done = false;
            while (!done) {
                instance = (int) (Math.random() * (map.rows * map.columns) + 1);
                if (map.getmapCells().get(instance).vacancy) {
                    map.getmapCells().get(instance).object = MapCell.entitiy.cow;
                    map.getmapCells().get(instance).vacancy = false;
                    done = true;
                }
            }
        }

    }

}
