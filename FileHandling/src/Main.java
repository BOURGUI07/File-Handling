import java.io.*;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static java.util.Map.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args)  throws IOException,ClassNotFoundException {
        demo27();
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

    public static void demo12() throws IOException{
        var fileWriter = new FileWriter("test2.txt");
        fileWriter.write("Hello Youness!");
        fileWriter.close();
    }

    public static void demo13() throws IOException{
        var fileWriter = new FileWriter("test2.txt",true);
        // He will append the new data inserted
        fileWriter.write("\nWhat's the first line?");
        fileWriter.close();
    }

    public static void demo14() throws IOException{
        var fileWriter = new FileWriter("test2.txt",false);
        // he will make the file empty then write in it
        fileWriter.write("Delete All Existing Data");
        fileWriter.close();
    }

    public static void demo15() throws IOException{
        var fileWriter = new FileWriter("test2.txt",false);
        fileWriter.write("Java Word",0,4);
        // where to begin, how many characters to write
        //Java
        fileWriter.close();
    }

    public static void demo16() throws IOException{
        var file = new File("test2.txt");
        var fileReader = new FileReader(file);
        int letter;
        while((letter=fileReader.read())!=-1){
            System.out.println(((char) letter));
        }

        var chars = new char[(int)file.length()];
        fileReader.read(chars);
        for(var x:chars){
            System.out.print((char)x);
        }
        fileReader.close();
    }

    public static void demo17() throws IOException{
        var bw = new BufferedWriter(new FileWriter("test2.txt",true));
        bw.newLine();
        bw.write("Is The Best Language");
        bw.newLine();
        bw.write("In The World");
        bw.close();
    }

    public static void demo18() throws IOException{
        var file = new File("test2.txt");
        var br = new BufferedReader(new FileReader(file));
        String line;
        while((line=br.readLine())!=null){
            System.out.println(line);
        }
        br.close();
    }

    public static void demo19() throws IOException{
        var file = new File("test2.txt");
        var fileWriter = new FileWriter(file,false);
        var printWriter = new PrintWriter(fileWriter);
        printWriter.println(112.17);
        printWriter.println(true);
        printWriter.flush();
        printWriter.close();
    }

    public static void demo20() throws IOException{
        var file = new File("test2.txt");
        var scanner = new Scanner(file);
        //line by line
        while(scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
    }

    public static void demo21() throws IOException{
        var file = new File("test2.txt");
        var scanner = new Scanner(file);
        //word by word
        scanner.useDelimiter(" ");
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }

    }

    public static void demo22() throws IOException{
        var file = new File("test2.txt");
        var scanner = new Scanner(file);
        //word by word
        scanner.useDelimiter("\\z");
            System.out.print(scanner.next());


    }

    public static void demo23() throws IOException{
        var file = new File("test2.txt");
        var scanner = new Scanner(file);
        scanner.useDelimiter("\\D+");
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }

    }

    public static void demo24() throws IOException{
        var scanner = new Scanner("Java,Kotlin,Golang");
        scanner.useDelimiter(Pattern.compile(","));
        while(scanner.hasNext()){
            System.out.println(scanner.next());
        }
        System.out.println("Delimiter: " + scanner.delimiter());
    }

    public static void demo25() throws IOException{
        var scanner = new Scanner(new File("test3.txt"));
        String name, language, age;
        while(scanner.hasNextLine()){
            var line = scanner.nextLine();
            var lineScanner = new Scanner(line);
            lineScanner.useDelimiter(",");
            while(lineScanner.hasNext()){
                name = lineScanner.next();
                language = lineScanner.next();
                age = lineScanner.next();
                System.out.println("name: " + name + ", language: " + language + ", age: " + age);
            }
        }
    }

    public static void demo26() throws IOException{
        var file = new File("student.txt");
        var oos = new ObjectOutputStream(new FileOutputStream(file));
        var student = new Student(14,"Youness",18.59);
        // if we try to write student to the file, we gonna get the exception of
        // noserilizable exception
        // for that the student class has to implement Serializable
        oos.writeObject(student);
    }

    public static void demo27() throws IOException, ClassNotFoundException {
        var file = new File("student.txt");
        var ois = new ObjectInputStream(new FileInputStream(file));
        var student = (Student) ois.readObject();
        System.out.println(student);
    }


}