import parsing.ParseFile;
import model.MowerSystem;

public class Main {
    public static void main(String[] args) {
        String filePath = args[0];
        MowerSystem mowerSystem = ParseFile.parseFile(filePath);
        mowerSystem.startAll();
    }
}
