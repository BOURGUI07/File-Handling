import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        demo1();
    }
    public static void demo1() throws IOException {
        var file = new File("test2.txt");
        file.createNewFile();
        var fileWriter  = new FileWriter(file);
        fileWriter.write("Hello World");
        fileWriter.close();
    }
}