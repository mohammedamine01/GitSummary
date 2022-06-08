package cleanCode.Chapter3.videoStore.refactored;

public abstract class Movie {

    private final String title;

    public Movie(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    abstract double determineAmount(int daysRented);

    abstract int determineFrequentRenterPoint(int daysRented);
}
