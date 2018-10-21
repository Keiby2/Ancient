package sample.Model;

/**
 * Created by lushi on 27.06.2018.
 */
public class Factory {
    public  static Unit createUnit(String unit){
        switch (unit){
            case "Warrior": return new Warrior(5,5,5,5);
            default:return null;
        }
    }
}
