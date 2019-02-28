import model.Photo;
import model.PhotoToSlidesConverter;
import model.Slide;

import java.util.LinkedList;
import java.util.List;

public class Main {

  public static void main(String[] args) {

    String FILENAME = "b.txt";
    System.out.println("Hello World!");
    ReadFile readFile = new ReadFile();
    List<Photo> photos = readFile.readFile(FILENAME);
    System.out.println("Read file " + photos.size());
    int start = 0;
    int end = 10000;
    List<Slide> result = new LinkedList<>();
    while(end < photos.size()) {
      List<Photo> sublist = photos.subList(start, Integer.min(end, photos.size()));
      List<Slide> slides = new PhotoToSlidesConverter().convert(sublist);
      System.out.println("Converted to slides " + slides.size());

      result.addAll (new SlideMaker().createSlide(slides));
      start = end;
      end = end + 10000;
    }
    System.out.println("Created film " + result.size());
    SaveFile.save(result);

  }

}
