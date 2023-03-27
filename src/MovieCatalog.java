import java.util.*;

public class MovieCatalog {

    private List<Movie> movies;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies (List<Movie> movies) {
        this.movies = movies;
    }

   public MovieCatalog() {
        movies = new ArrayList<>();
   }

    /**Добавление фильма**/
    public void addMovie(String title, int releaseData, String genre, double rating) {
        if (!movies.contains(new Movie(title, releaseData, genre, rating))) {
            movies.add(new Movie(title, releaseData, genre, (rating)));
        }
    }

    /**Удаление фильма по названию**/
    public void remove(String title) {
        List<Movie> newList = movies.stream()
                .filter(movie -> !movie.getTitle().equals(title))
                .toList();
        setMovies(newList);
    }

    /**Обновление названия фильа**/
    public void updateTitle(String oldTitle, String newTitle) {
        movies.stream()
                .filter(m -> m.getTitle().equals(oldTitle))
                .forEach(m -> {
                    System.out.println(m.getTitle() + ": title changer to'" + newTitle + "'");
                    m.setTitle(newTitle);
                });
    }

    /**Обновление рейтинга фильма**/
    public void updateRating(String title, double newRating) {
        movies.stream()
                .filter(m -> m.getTitle().equals(title))
                .forEach(m -> {
                    m.setRating(newRating);
                    System.out.println(m.getTitle() + ": rating changed to" + newRating);
                });
    }

    /**Обновление даты выхода**/
    public void updateReleasDate(String title, int newReleasDate) {
        movies.stream()
                .filter(m -> m.getTitle().equals(title))
                .forEach(m -> {
                    m.setReleaseDate(newReleasDate);
                    System.out.println(m.getTitle() + ": release date changed to" + newReleasDate);
                });
    }

    /**Обновление жанра**/
    public void updateGenre(String title, String newGenre) {
        movies.stream()
                .filter(m -> m.getTitle().equals(title))
                .forEach(m -> {
                    m.setGenre(newGenre);
                    System.out.println(m.getTitle() + ": genre changed to" + newGenre);
                });
    }

    /**Поиск по названию, указать хотя бы одно слово**/
    public void searchByTitle(String word) {
        movies.stream()
                .filter(m -> m.getTitle()
                        .toLowerCase()
                        .matches(".*\\b" + word.toLowerCase() + "\\b.*"))
                .forEach(System.out::print);
    }

    /**Поиск по дате выхода**/
    public void searchByReleaseDate(int year) {
        movies.stream()
                .filter(m -> m.getReleaseDate() == year)
                .forEach(System.out::print);
    }

    /**Поиск по дате выхода (от до)**/
    public void searchByReleaseDate(int from, int to) {
        movies.stream()
                .filter(m -> m.getReleaseDate() >= from && m.getReleaseDate() <= to)
                .forEach(System.out::print);
    }

    /**Поиск по жанру**/
    public void searchByGenre(String genre) {
        movies.stream()
                .filter(m -> m.getGenre().equals(genre))
                .forEach(System.out::print);
    }

    /**Поиск по рейтингу (от до)**/
    public void searchByRating(double from, double to) {
        movies.stream()
                .sorted(Comparator.comparing(Movie::getRating))
                .filter(m -> m.getRating() >= from && m.getRating() <= to)
                .forEach(System.out::print);
    }

    /**Поиск по рейтингу от заданного значения до масимального**/
    public void searchByRating(double rating) {
        movies.stream()
                .sorted(Comparator.comparing(Movie::getRating).reversed())
                .takeWhile(m -> m.getRating() >= rating)
                .forEach(System.out::print);
    }
}
