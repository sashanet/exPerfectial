package model;

import java.util.List;
import java.util.Set;

/**
 * @author Oleksandr Buryk
 */
public class Photo {

    private int id;
    private Set<String> tags;
    private boolean vertical;

    public Set<String> getTags() {

        return tags;
    }

    public void setTags(Set<String> tags) {

        this.tags = tags;
    }

    public boolean isVertical() {

        return vertical;
    }

    public void setVertical(boolean vertical) {

        this.vertical = vertical;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



}
