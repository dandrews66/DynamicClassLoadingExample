/**
 * Created by dandrews on 10/11/16.
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InterruptedException {
        while(true){
            ClassReloader cl = new ClassReloader();
            Animal dog = (Animal) cl.loadClass("Dog").newInstance();

            System.out.println(dog.getName());
            System.out.println(dog.getExpectedLife());

            Thread.sleep(5000);
        }

    }
}
