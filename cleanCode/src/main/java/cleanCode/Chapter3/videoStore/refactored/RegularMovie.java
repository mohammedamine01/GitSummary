package cleanCode.Chapter3.videoStore.refactored;

public class RegularMovie extends Movie {
    public RegularMovie(String title) {
        super(title);
    }

    @Override
    double determineAmount(int daysRented) {
        double rentalAmount = 2;
        if (daysRented > 2)
            rentalAmount += (daysRented - 2) * 1.5;

        return rentalAmount;
    }

    @Override
    int determineFrequentRenterPoint(int daysRented) {
        return 1;
    }
}
