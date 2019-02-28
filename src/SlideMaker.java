import model.Slide;

import java.util.BitSet;
import java.util.LinkedList;
import java.util.List;

public class SlideMaker {

  private static int totalScore = 0;
  List<Slide> createSlide(List<Slide> imagesList) {

    LinkedList<Slide> images = new LinkedList<>(imagesList);
    LinkedList<Slide> slide = new LinkedList<>();
    Slide first = images.removeFirst();
    slide.add(first);
    while (images.size() > 0) {
      Slide next = getBestMatch(first, images);
      if (next == null) {
        //shouldn't get here
        return slide;
      }
      images.remove(next);
      slide.add(next);
      first = next;
      if (slide.size() % 10 == 0){
        System.out.println("processed images: " + slide.size());
      }
    }
    System.out.println("TOTAL SCORE: " + totalScore);
    return slide;
  }

  private Slide getBestMatch(Slide first, List<Slide> images) {
    int score = -1;
    Slide second = null;
    int count = 0;
//    LinkedList<Slide> best = new LinkedList<>();
    for (Slide next : images) {
      int c = common(first, next);
      int d = different(first, next);
      int s = Integer.min(c, d / 2);
      if (s > score) {
//        best.addFirst(next);
        second = next;
        score = s;
        count++;
      }
      if (count >= 100){
        break;
      }
    }
   // first.setBestMatch(best)
    totalScore+=score;
    return second;//best.getFirst();
  }

  private int different(Slide first, Slide image) {
    BitSet result = new BitSet(first.getTags().length());
    result.or(first.getTags());
    result.xor(image.getTags());
    return result.cardinality();
  }

  private int common(Slide first, Slide image) {
    BitSet result = new BitSet(first.getTags().length());
    result.or(first.getTags());
    result.and(image.getTags());
    return result.cardinality();
  }

}
