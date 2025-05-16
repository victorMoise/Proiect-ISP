package proiect;

public class StudyMaterial {
    private String title;
    private String link;
    private MaterialType type;
    StudyGroup group;

    public StudyMaterial(String title, String link, MaterialType type, StudyGroup group) {
        this.title = title;
        this.link = link;
        this.type = type;
        this.group = group;
    }

    public MaterialType getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }
}
