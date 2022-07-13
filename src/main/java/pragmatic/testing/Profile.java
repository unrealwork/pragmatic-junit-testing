package pragmatic.testing;

import java.util.HashMap;
import java.util.Map;

final class Profile {
    private final Map<String, Answer> answers = new HashMap<>();
    private int score;
    private final String name;

    Profile(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public void add(Answer answer) {
        answers.put(answer.getQuestionText(), answer);
    }

    public boolean matches(Criteria criteria) {
        score = 0;

        boolean kill = false;
        boolean anyMatches = false;
        for (Criterion criterion : criteria) {
            Answer answer = answers.get(
                    criterion.getAnswer().getQuestionText());
            boolean match =
                    criterion.getWeight() == Weight.DONT_CARE
                            || answer.match(criterion.getAnswer());

            if (!match && criterion.getWeight() == Weight.MUST_MATCH) {
                kill = true;
            }
            if (match) {
                score += criterion.getWeight().getValue();
            }
            anyMatches |= match;
        }
        if (kill) {
            return false;
        }
        return anyMatches;
    }

    public int score() {
        return score;
    }
}
