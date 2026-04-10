import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {
    private static final String FILE_NAME = "students.dat";

    public static List<Student> read() throws Exception {
        File file = new File(FILE_NAME);
        if (!file.exists()) return new ArrayList<>();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
        List<Student> students = (List<Student>) ois.readObject();
        ois.close();
        return students;
    }

    public static void write(List<Student> students) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        oos.writeObject(students);
        oos.close();
    }
}