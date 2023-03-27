public class Main {
    public static void main(String[] args) {

        MovieCatalog catalog = new MovieCatalog();

        catalog.addMovie("Star Wars: Episode V - The Empire Strikes Back", 1980, "Adventure", 8.7);
        catalog.addMovie("The Matrix", 1999, "Sci=fi", 8.6);
        catalog.addMovie("Terminator 2: Judment Day", 1991, "Action", 8.1);

        System.out.println();
        System.out.println("--------------------------------");
        System.out.println(catalog.getMovies());
    }
}