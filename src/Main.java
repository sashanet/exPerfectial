import model.Photo;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ReadFile readFile = new ReadFile();
        List<Photo> result = readFile.readFile();
    }

}
