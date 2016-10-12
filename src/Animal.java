/**
 * Created by dandrews on 10/11/16.
 */
public class Animal {
    private String name;
    private int expectedLife;


    public Animal(String name, int life){
        this.name = name;
        this.expectedLife = life;

    }

    public String getName() {
        return name;
    }

    public int getExpectedLife() {
        return expectedLife;
    }

    public void setExpectedLife(int expectedLife) {
        this.expectedLife = expectedLife;
    }

    public void setName(String name) {
        this.name = name;
    }
}
