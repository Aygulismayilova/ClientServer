package main;

import workspace.store.AppStorage;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileReadAndWrite {
    private static final String file = "app.txt";

    public static void writeObject(Object obj) {
        try (ObjectOutputStream os =
                     new ObjectOutputStream(
                             Files.newOutputStream(Paths.get(file), StandardOpenOption.APPEND)
                     )
        ) {
            os.writeObject(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AppStorage readObject() {
        try (ObjectInputStream objectInputStream =
                     new ObjectInputStream(
                             Files.newInputStream(Paths.get(file), StandardOpenOption.READ)
                     )
        ) {
            return (AppStorage) objectInputStream.readObject();
        } catch (Exception e) {
            return new AppStorage();
        }
    }  /*
    public static AppStorage read(){
        File file=new File("Applicaton.txt");
        try {
            Scanner scanner=new Scanner(file);
            while (scanner.hasNextLine()){
                System.out.println(scanner.nextLine());
            }
            return new AppStorage;
        } catch (Exception e) {
            e.printStackTrace();
        }*/

   /* }

    public static AppStorage readNio() {
        Path path = Paths.get("src/main/resources/shakespeare.txt");
        try {

            Files.lines(path)
                    .filter(line -> line.startsWith("Love")) // this line filters any line out which does not meet the condition
                    .forEach(System.out::println);//print each line

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return new AppStorage();
    }*/
}