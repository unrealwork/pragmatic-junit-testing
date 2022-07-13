package pragmatic.testing;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ProfileTest {
    @Test
    public void matchAnswersTrueForAnyDontCareCriteria() {
        Profile profile = new Profile("Bull Hockey, Inc.");
        BaseQuestion question = new BooleanQuestion(1, "Got milk?");
        Answer profileAnswer = new Answer(question, Bool.FALSE);
        profile.add(profileAnswer);
        Criteria criteria = new Criteria();
        Answer criteriaAnswer = new Answer(question, Bool.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer, Weight.DONT_CARE);
        criteria.add(criterion);

        boolean matches = profile.matches(criteria);
        assertTrue(matches);
    }

    @Test
    public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
        Profile profile = new Profile("Bull Hockey, Inc.");
        BaseQuestion question = new BooleanQuestion(1, "Got bonuses?");
        Answer profileAnswer = new Answer(question, Bool.FALSE);
        profile.add(profileAnswer);
        Criteria criteria = new Criteria();
        Answer criteriaAnswer = new Answer(question, Bool.TRUE);
        Criterion criterion = new Criterion(criteriaAnswer, Weight.MUST_MATCH);
        criteria.add(criterion);

        boolean matches = profile.matches(criteria);
        assertFalse(matches);
    }
}
