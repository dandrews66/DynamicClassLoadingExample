import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by dandrews on 10/11/16.
 */
public class ClassReloader extends ClassLoader {
    private boolean classLoaded;

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        //Since this method is recursive, only the original class through the new class loader. Load any dependencies through the system class loader
        if(classLoaded){
            return super.loadClass(name);
        }
        else{
            classLoaded = true;
        }


        try{
            //Infer the URL of the class from the old class
            Class<?> clazz = Class.forName(name);
            URL url = clazz.getResource(clazz.getSimpleName() + ".class");

            //Load the class file in a byte array
            URLConnection connection = url.openConnection();
            InputStream input = connection.getInputStream();
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();
            int data = input.read();

            while(data != -1){
                buffer.write(data);
                data = input.read();
            }

            input.close();

            byte[] classData = buffer.toByteArray();

            //Load the class. Note: this recursively calls loadClass for any dependencies
            clazz = defineClass(name, classData, 0, classData.length);
            resolveClass(clazz);

            return clazz;
        }
        catch (IOException e) {
            //For whatever reason we ran into an error parsing the class file. Log an error and safely return the system loaded class
            e.printStackTrace();
            return super.loadClass(name);
        }
    }
}
