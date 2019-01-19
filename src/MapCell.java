import java.util.ArrayList;

public class MapCell {

    ArrayList<String> scents = new ArrayList<>(); // we can smell multi smells in a single map cell
    entitiy object;
    public boolean vacancy =true;

    enum entitiy { //a cell can have only one entity at the moment
        person, stick, wolf, cow, barn,vacant;
    }

    public void showState(){
        switch (object){
            case person: System.out.print(" p "); break;
            case stick: System.out.print(" S "); break;
            case wolf: System.out.print(" W "); break;
            case cow: System.out.print(" C "); break;
            case barn: System.out.print(" B "); break;
            case vacant: System.out.print(" * "); break;
            default: System.out.print(" e "); break;
        }
    }
}
