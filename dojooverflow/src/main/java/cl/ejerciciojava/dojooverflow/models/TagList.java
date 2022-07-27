package cl.ejerciciojava.dojooverflow.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TagList {
    private List<String> tags = new ArrayList<>();

    public TagList() {
    }

    public TagList(String tags) {
        String tag = "";
        for (int i = 0; i < tags.length(); i++) {
            if (tags.charAt(i) != ' ' && tags.charAt(i) != ',') {
                tag += tags.charAt(i);
            }
            if (tags.charAt(i) == ',' || i == tags.length() - 1) {
                this.tags.add(tag.toLowerCase());
                tag = "";
            }
        }
        Set<String> hash = new HashSet<>();
        hash.addAll(this.tags);
        this.tags.clear();
        this.tags.addAll(hash);
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
