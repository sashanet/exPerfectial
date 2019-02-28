import model.Slide;

import java.util.BitSet;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class SlideMaker {

  List<Slide> createSlide(List<Slide> images) {
    List<Slide> slide = new LinkedList<>();
    Slide first = images.remove(0);
    slide.add(first);
    while (images.size() > 0) {
      Slide next = getBestMatch(first, images);
      if (next == null) {
        return slide;
      }
      images.remove(next);
      slide.add(next);
      first = next;

    }
    return slide;
  }

  private Slide getBestMatch(Slide first, List<Slide> images) {
    int score = -1;
    Slide best = null;
    for (Slide next : images) {
      int c = common(first, next);
      int d = different(first, next);
      int s = Integer.min(c, d / 2);
      if (s > score) {
        best = next;
      }
    }
    return best;
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


  private class Image {
    BitSet getTarget() {
      //should create copy
      return new BitSet();
    }
  }
}
