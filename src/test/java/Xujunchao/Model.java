package Xujunchao;

import java.util.List;

public class Model {
    private String name;
    private String type;
    private String length;
    private String description;
    private List<Model> children;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Model> getChildren() {
        return children;
    }

    public void setChildren(List<Model> children) {
        this.children = children;
    }
}
