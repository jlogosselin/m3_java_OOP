package Assignment_DVDCollection.dto;


public class DVDItem {

    //these methods will be invoked in the VIEW class

    private String titleID;
    private String releaseDate; // https://www.w3schools.com/java/java_date.asp
    private String mpaRating; //G, PG, PG-13, R
    private String directorName;
    private String studioName;
    private String userRating;

    public DVDItem(String t) {
        this.titleID = t;
    }

    public String getTitle() {
        return this.titleID;
    }
    public void setTitle(String t) {
        this.titleID = t;
    }

    public String getReleaseDate() {
        return this.releaseDate;
    }
    public void setReleaseDate(String d) {
        this.releaseDate = d;
    }

    public String getMpaRating() {
        return this.mpaRating;
    }
    public void setMpaRating(String mpa) {
        this.mpaRating = mpa;
    }

    public String getDirectorName() {
        return this.directorName;
    }
    public void setDirectorName(String dir) {
        this.directorName = dir;
    }

    public String getStudioName() {
        return this.studioName;
    }
    public void setStudioName(String st) { this.studioName = st;}

    public String getUserRating() {
        return this.userRating;
    }
    public void setUserRating(String ur) {
        this.userRating = ur;
    }
}
