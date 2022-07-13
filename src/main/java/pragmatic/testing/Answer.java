package pragmatic.testing;

final class Answer {
    private final int index;
    private final BaseQuestion question;

    Answer(final BaseQuestion q, final int i) {
        this.question = q;
        this.index = i;
    }

    Answer(final BaseQuestion characteristic,
           final String matchingValue) {
        this.question = characteristic;
        this.index = characteristic.indexOf(matchingValue);
    }

    public String getQuestionText() {
        return question.getText();
    }

    @Override
    public String toString() {
        return String.format("%s %s", question.getText(), question.getAnswerChoice(index));
    }

    public boolean match(final int expected) {
        return question.match(expected, index);
    }

    public boolean match(final Answer otherAnswer) {
        return question.match(index, otherAnswer.index);
    }

    public BaseQuestion getCharacteristic() {
        return question;
    }
}
