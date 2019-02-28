import model.Photo;
import model.PhotoToSlidesConverter;
import model.Slide;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        ReadFile readFile = new ReadFile();
        List<Photo> photos = readFile.readFile();


        List<Slide> slides =  new PhotoToSlidesConverter().convert(photos);
        List<Slide> result = new SlideMaker().createSlide(slides);

        SaveFile.save(result);

    }

}
