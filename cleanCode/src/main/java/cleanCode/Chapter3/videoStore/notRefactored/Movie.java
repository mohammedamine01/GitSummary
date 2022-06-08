package cleanCode.Chapter3.videoStore.notRefactored;

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
}
