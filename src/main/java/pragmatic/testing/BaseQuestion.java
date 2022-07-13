package pragmatic.testing;

abstract class BaseQuestion {
    private final String text;
    private final String[] answerChoices;
    private final int identity;

    BaseQuestion(int id, String s, String[] choices) {
        this.identity = id;
        this.text = s;
        this.answerChoices = choices;
    }

    public final String getText() {
        return text;
    }

    public final String getAnswerChoice(int i) {
        return answerChoices[i];
    }

    public final boolean match(Answer answer) {
        throw new UnsupportedOperationException();
    }

    /**
     * Does question match?
     *
     * @param expected expected result
     * @param actual   actual result
     * @return whether expected matches actual.
     */
    public abstract boolean match(int expected, int actual);

    public final int indexOf(String matchingAnswerChoice) {
        for (int i = 0; i < answerChoices.length; i++) {
            if (answerChoices[i].equals(matchingAnswerChoice)) {
                return i;
            }
        }
        return -1;
    }

    public int getIdentity() {
        return identity;
    }
}

