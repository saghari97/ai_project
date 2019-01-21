package far;
import java.util.ArrayList;
import java.util.Random;
import far.Environment.Action;
import far.Environment.Element;
import far.Environment.Perception;


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
                map.getmapCells().get(i).get(j).showState();
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
        for (ArrayList<MapCell> cells :
                map.getmapCells()) {
            for (MapCell item : cells) {
                if (item.vacancy)
                    item.object = MapCell.entitiy.vacant;
            }
        }
    }

    private static void setWolf(GameMap map) {
        boolean done = false;
        int i;
        int j;
        while (!done) {
            i = (int) (Math.random() * (map.rows));
            j = (int) (Math.random() * (map.columns));
            if (map.getmapCells().get(i).get(j).vacancy) {
                map.getmapCells().get(i).get(j).object = MapCell.entitiy.wolf;
                map.getmapCells().get(i).get(j).vacancy = false;
                done = true;
            }
        }
    }

    private static void setBarn(GameMap map) {
        boolean done = false;
        int i;
        int j;
        while (!done) {
            i = (int) (Math.random() * (map.rows));
            j = (int) (Math.random() * (map.columns));
            if (map.getmapCells().get(i).get(j).vacancy) {
                map.getmapCells().get(i).get(j).object = MapCell.entitiy.barn;
                map.getmapCells().get(i).get(j).vacancy = false;
                done = true;
            }
        }
    }

    private static void setSticks(GameMap map, int sticksNumber) {
        int i;
        int j;
        boolean done;
        for (int k = 0; k < sticksNumber; k++) {
            done = false;
            while (!done) {
                i = (int) (Math.random() * (map.rows));
                j = (int) (Math.random() * (map.columns));
                if (map.getmapCells().get(i).get(j).vacancy) {
                    map.getmapCells().get(i).get(j).object = MapCell.entitiy.stick;
                    map.getmapCells().get(i).get(j).vacancy = false;
                    done = true;
                }
            }
        }
    }

    private static void setCows(GameMap map, int cowsNumber) {
        int i;
        int j;
        boolean done;
        for (int k = 0; k < cowsNumber; k++) {
            done = false;
            i = (int) (Math.random() * (map.rows));
            j = (int) (Math.random() * (map.columns));
            while (!done) {
                if (map.getmapCells().get(i).get(j).vacancy) {
                    map.getmapCells().get(i).get(j).object = MapCell.entitiy.cow;
                    map.getmapCells().get(i).get(j).vacancy = false;
                    done = true;
                }
            }
        }

    }

}
