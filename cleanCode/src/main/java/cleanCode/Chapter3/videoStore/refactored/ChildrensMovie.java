package cleanCode.Chapter3.videoStore.refactored;

public class ChildrensMovie extends Movie {
    public ChildrensMovie(String title) {
        super(title);
    }

    @Override
    double determineAmount(int daysRented) {
        double rentalAmount =  1.5;
        return (daysRented > 3) ? (daysRented - 3) * rentalAmount : rentalAmount;
    }

    @Override
    int determineFrequentRenterPoint(int daysRented) {
        return 1;
    }
}
