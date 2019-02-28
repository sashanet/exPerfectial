package model;

import java.util.List;
import java.util.Set;

/**
 * @author Oleksandr Buryk
 */
public class Photo {

    private int id;
    private Set<String> tags;
    private String tagsNames;
    private boolean vertical;

    public Set<String> getTags() {

        return tags;
    }




    public void setTags(Set<String> tags) {

        this.tags = tags;
        this.tagsNames = tags.toString();
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

    public String getTagsNames() {
        return tagsNames;
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", tags=" + tags +
                ", vertical=" + vertical +
                '}';
    }
}
