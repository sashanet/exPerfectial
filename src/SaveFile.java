import model.Slide;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @author Oleksandr Buryk
 */

public class SaveFile {

    public static void save(List<Slide> slides){
        String str = "Hello";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("result.txt"));
            writer.append(String.valueOf(slides.size()));
            slides.forEach(slide->{
                int[] ids = slide.getPhotoIds();
                String line = new String("\n");
                for(int i = 0; i<ids.length; i++){
                    line += ids[i] + " ";
                }
                try {

                    writer.append(line.substring(0, line.length()-1));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
