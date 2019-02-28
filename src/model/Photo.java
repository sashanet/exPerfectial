package model;

import java.util.List;

/**
 * @author Oleksandr Buryk
 */
public class Photo {

    private int id;
    private List<String> tags;
    private Boolean isVertical;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public Boolean getVertical() {
        return isVertical;
    }

    public void setVertical(Boolean vertical) {
        isVertical = vertical;
    }
}
