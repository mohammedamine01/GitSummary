package cleanCode.Chapter2.refactored;

public class GuessStatisticsMessage {

    private String number;
    private String verb;
    private String pluralModifier;

    public String make(char candidate, int count){
        createPluralDependentMessageParts(count);
        return String.format("There %s %s %s%s", verb,number,candidate,pluralModifier);
    }

    private void createPluralDependentMessageParts(int count) {
        if(count == 0){
            thereAreNoLetters();
        }else if(count ==1){
            thereAreOneLetter();
        }else {
            thereAreManyLetters(count);
        }
    }

    private void thereAreNoLetters() {
        number="no";
        verb="are";
        pluralModifier="s";
    }

    private void thereAreOneLetter() {
        number="1";
        verb="is";
        pluralModifier=" ";
    }

    private void thereAreManyLetters(int count) {
        number=Integer.toString(count);
        verb="are";
        pluralModifier="s";
    }

    public static void main(String[] args) {
        GuessStatisticsMessage guessStatisticsMessage = new GuessStatisticsMessage();
        System.out.println(guessStatisticsMessage.make('a', 0));
    }

}
