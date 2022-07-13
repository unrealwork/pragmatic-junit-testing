package pragmatic.testing;

final class Criterion implements Scoreable {
    private final Weight weight;
    private final Answer answer;
    private int score;

    Criterion(Answer ans, Weight w) {
        this.answer = ans;
        this.weight = w;
    }

    public Answer getAnswer() {
        return answer;
    }

    public Weight getWeight() {
        return weight;
    }

    public void setScore(int s) {
        this.score = s;
    }

    public int getScore() {
        return score;
    }
}
