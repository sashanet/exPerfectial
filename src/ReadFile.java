import model.Photo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * @author Oleksandr Buryk
 */
public class ReadFile {
    private static final String FILENAME = "a.txt";


    public List<Photo> readFile(){
        List<Photo> photos = new ArrayList<>();

        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader(FILENAME);
            br = new BufferedReader(fr);

            String sCurrentLine;
            br.readLine(); // read first line
            while ((sCurrentLine = br.readLine()) != null) {
                String[] raws = sCurrentLine.split(" ");
                System.out.println(sCurrentLine);
                Photo photo = new Photo();
                photo.setVertical(raws[0].equals("H"));
                int size = Integer.parseInt(raws[1]) + 2;
                photo.setTags(new HashSet(Arrays.asList(raws).subList(2, size)));
                photos.add(photo);
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
        return photos;
    }
}
