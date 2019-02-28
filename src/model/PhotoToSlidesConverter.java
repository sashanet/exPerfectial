package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
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

        LinkedList<Photo> verticalSortedPhotos =
                sortedPhotos.get(true).stream().sorted(Comparator.comparingInt(p -> p.getTags().size())).collect(
                        Collectors.toCollection(LinkedList::new));



        while (true) {

            Photo photo1, photo2 = null;

           photo1 = verticalSortedPhotos.getFirst();

            Iterator<Photo> lastIterator = verticalSortedPhotos.descendingIterator();

            boolean wasFound = false;
            while (lastIterator.hasNext()) {

                photo2 = lastIterator.next();

                if (!photo1.getTags().containsAll(photo2.getTags())) {
                    slides.add(createSlide(photo1, photo2));
                    wasFound = true;
                    break;
                }

            }

            if (!wasFound) {

                photo2 = verticalSortedPhotos.getLast();

                if (photo1 == photo2) {
                    break;
                }
            }

            slides.add(createSlide(photo1, photo2));

            verticalSortedPhotos.removeAll(Arrays.asList(photo1, photo2));

            if (verticalSortedPhotos.isEmpty()) {
                break;
            }

        }

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

        //TODO comment on prod
        slide.setTagNames(tagNames);

        slide.setTags(toBitSet(tagNames));

        return slide;

    }

    private BitSet toBitSet(Set<String> tagNames) {

        BitSet tags = new BitSet(uniqueTags.size());

        for (String tag : tagNames) {
            tags.set(uniqueTags.indexOf(tag));
        }
        return tags;
    }

}
