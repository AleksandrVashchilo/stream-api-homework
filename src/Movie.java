public class Movie {

    private String title;
    private int releaseDate;
    private String genre;
    private double rating;

    public Movie(String title, int releaseDate, String genre, double rating) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.genre = genre;
        this.rating = rating;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "\ntitle: '" + title + "', " +
                "releaseDate: " + releaseDate + ", " +
                "genre:" + genre + ", " +
                ", " +
                "rating:" + rating;
    }
}
