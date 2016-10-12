/**
 * Created by dandrews on 10/11/16.
 */
public class Dog extends Animal{
    public boolean isPet() {
        return isPet;
    }

    public boolean isPet = true;

    public Dog(){
        super("dog", 10);
    }
}
