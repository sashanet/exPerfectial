package model;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class PhotoToSlidesConverter {

    private List<String> uniqueTags;

    public List<Slide> convert(List<Photo> photos) {

        final Map<Boolean, List<Photo>> sortedPhotos =
                photos.stream().collect(Collectors.groupingBy(Photo::isVertical));

        uniqueTags = photos.stream().map(Photo::getTags).flatMap(Set::stream).collect(Collectors.toList());

        List<Slide> slides = new ArrayList<>();

        //horizontal
        slides.addAll(sortedPhotos.get(false).stream().map(this::createSlide).collect(Collectors.toList()));

        return slides;


    }

    private Slide createSlide(Photo... photos) {

        Slide slide = new Slide();

        slide.setPhotoIds(new int[photos.length]);

        Set<String> tagNames = new HashSet<>();

        for (int i = 0; i < photos.length; i++) {

            Photo photo = photos[i];
            slide.getPhotoIds()[i] = photo.getId();

            tagNames.addAll(photo.getTags());

        }

        BitSet tags = new BitSet(uniqueTags.size());

        //TODO comment on prod
        slide.setTagNames(tagNames);

        for (String tag : tagNames) {
            tags.set(uniqueTags.indexOf(tag));
        }

        slide.setTags(tags);

        return slide;

    }

}
