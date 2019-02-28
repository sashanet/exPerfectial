import model.Photo;
import model.PhotoToSlidesConverter;
import model.Slide;

import java.util.List;

public class Main {

  public static void main(String[] args) {

    String FILENAME = "d.txt";
    System.out.println("Hello World!");
    ReadFile readFile = new ReadFile();
    List<Photo> photos = readFile.readFile(FILENAME);
    System.out.println("Read file " + photos.size());

    List<Slide> slides = new PhotoToSlidesConverter().convert(photos);
    System.out.println("Converted to slides " + slides.size());

    List<Slide> result = new SlideMaker().createSlide(slides);
    System.out.println("Created film " + result.size());
    SaveFile.save(result);

  }

}
