public class StudyMaterial {
    private String title;
    private String link;
    private MaterialType type;

    public StudyMaterial(String title, String link, MaterialType type) {
        this.title = title;
        this.link = link;
        this.type = type;
    }

    public MaterialType getType() {
        return type;
    }
}
