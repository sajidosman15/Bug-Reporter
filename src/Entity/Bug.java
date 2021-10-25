package Entity;

public class Bug {

    private int id;
    private String bugId;
    private String name;
    private String description;
    private String expected;
    private String actual;
    private String date;
    private String comment;
    private String priroty;
    private String status;
    private String testerName;
    private String developerName;

    public Bug(int id, String bugId, String name, String description, String expected, String actual, String date, String comment, String priroty, String status, String testerName) {
        this.id = id;
        this.bugId = bugId.trim();
        this.name = name.trim();
        this.description = description.trim();
        this.expected = expected.trim();
        this.actual = actual.trim();
        this.date = date;
        this.comment = comment.trim();
        this.priroty = priroty;
        this.status = status;
        this.testerName = testerName;
        this.developerName = "Not Assigned";
    }

    public int getId() {
        return id;
    }

    public String getTesterName() {
        return testerName;
    }

    public void setDeveloperName(String developerName) {
        this.developerName = developerName;
    }

    public String getDeveloperName() {
        return developerName;
    }

    public String getBugId() {
        return bugId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getExpected() {
        return expected;
    }

    public String getActual() {
        return actual;
    }

    public String getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }

    public String getPriroty() {
        return priroty;
    }

    public String getStatus() {
        return status;
    }

}
