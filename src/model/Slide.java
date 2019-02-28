package model;

import java.util.BitSet;
import java.util.Set;

import sun.security.util.BitArray;

public class Slide {

    private int[] photoIds;

    private BitSet tags;

    private Set<String> tagNames;

    public int[] getPhotoIds() {

        return photoIds;
    }

    public void setPhotoIds(int[] photoIds) {

        this.photoIds = photoIds;
    }

    public BitSet getTags() {

        return tags;
    }

    public void setTags(BitSet tags) {

        this.tags = tags;
    }

    public Set<String> getTagNames() {

        return tagNames;
    }

    public void setTagNames(Set<String> tagNames) {

        this.tagNames = tagNames;
    }

}
