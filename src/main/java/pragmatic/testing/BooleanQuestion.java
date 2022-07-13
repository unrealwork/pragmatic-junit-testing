package pragmatic.testing;

final class BooleanQuestion extends BaseQuestion {
    BooleanQuestion(int id, String text) {
        super(id, text, new String[] {"No", "Yes"});
    }

    @Override
    public boolean match(int expected, int actual) {
        return expected == actual;
    }
}
