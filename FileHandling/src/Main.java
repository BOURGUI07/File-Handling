import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Map.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  throws IOException{
        demo11();
    }

    public static void demo() throws IOException{
        var file = new FileInputStream("a.txt");
        var letter = file.read();
        while(letter!=-1){
            System.out.println(((char) letter));
            letter = file.read();
        }
        file.close();
    }

    public static void demo2() throws IOException{
        var file = new File("a.txt");
        var fis = new FileInputStream(file);
        byte [] x = new byte[(int) file.length()];
        System.out.println(((char) fis.read(x)));
        fis.close();
    }

    public static void demo3() throws IOException{
        var fos = new FileOutputStream("test.txt");
        fos.write("Hello World".getBytes());
        fos.close();
        var fis = new FileInputStream("test.txt");
        var letter = fis.read();
        while(letter!=-1){
            System.out.print(((char) letter));
            letter = fis.read();
        }
        fis.close();
    }

    public static void demo4() throws IOException{
        var file = new File("test.txt");
        var fis = new FileInputStream(file);
        var bytes = new byte[(int) file.length()];
        fis.read(bytes);
        for(int i=0; i<bytes.length; i++){
            System.out.print((char) bytes[i]);
        }
        fis.close();
    }

    public static void demo5() throws IOException {
        var file = new File("test1.txt"); // doesn't create a file automatically
        System.out.println(file.exists()); // false in the 1st run
        file.createNewFile();
        System.out.println(file.exists()); // true

        Map<String, Object> map = Map.of(
                "File Name", file.getName(),
                "File Absolute Path", file.getAbsolutePath(),
                "File Path", file.getPath(),
                "File Writable", file.canWrite(),
                "File Readable", file.canRead(),
                "File Size in Bytes", file.length(),
                "File Is File", file.isFile(),
                "File Is Directory", file.isDirectory(),
                "File Last Modified", file.lastModified(),
                "File Can Execute", file.canExecute()
        );

        // Print the map
        map.forEach((k, v) -> System.out.println(k + ": " + v));
    }

    public static void demo6() throws IOException{
        var file = new File("folder");
        System.out.println(file.exists());
        file.mkdir(); // create one folder name folder
        System.out.println(file.exists());
    }

    public static void demo7() throws IOException{
        var file = new File("folder1/subfolder1/subsubfolder1");
        file.mkdirs(); // make folder1, subfolder1, subsubfolder1 directories
        file.delete(); // delete subsubfolder1
    }

    public static void demo8() throws IOException{
        var file = new File("New Folder");
        if(file.isDirectory()){
            var array = file.list();
            Stream.of(array).forEach(System.out::println);
        }
    }

    public static void demo9() throws IOException{
        var file = new File("folder","test.txt");
        file.createNewFile();//will create file test.txt in folder directory

        var file1 = new File("folder1");
        var file2 = new File(file1,"test1.txt");
        file2.createNewFile();// will create test1.txt in folder1
    }

    public static void demo10() throws IOException{
        var fos = new FileOutputStream("folder1/test1.txt");
        fos.write("Hello World".getBytes());
        fos.close();
    }

    public static void demo11() throws IOException{
        var file = new File("folder1/test1.txt");
        var fis = new FileInputStream(file);
        var bytes = new byte[(int) file.length()];
        int letter;
        while((letter=fis.read())!=-1){
            System.out.println(((char) letter));
        }
        fis.close();
    }
}