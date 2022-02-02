package cleanCode.Chapter3.videoStore.refactored;

public class Movie {
    public static final int NEW_RELEASE = 2;
    public static final int CHILDRENS = 0;
    public static final int REGULAR = 1;

    private String title;
    private int priceCode;

    public Movie(String title, int priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public int getPriceCode() {
        return priceCode;
    }

    double determineAmount(int daysRented) {
        double rentalAmount = 0;
        switch (priceCode) {
            case Movie.REGULAR:
                rentalAmount += 2;
                if (daysRented > 2)
                    rentalAmount += (daysRented - 2) * 1.5;
                break;
            case Movie.NEW_RELEASE:
                rentalAmount += daysRented * 3;
                break;
            case Movie.CHILDRENS:
                rentalAmount += 1.5;
                if (daysRented > 3)
                    rentalAmount += (daysRented - 3) * 1.5;
                break;
        }
        return rentalAmount;
    }

    int determineFrequentRenterPoint(int daysRented) {
        boolean bonusIsEarned = (priceCode == Movie.NEW_RELEASE && daysRented > 1);
        if (bonusIsEarned)
            return 2;

        return 1;
    }
}
