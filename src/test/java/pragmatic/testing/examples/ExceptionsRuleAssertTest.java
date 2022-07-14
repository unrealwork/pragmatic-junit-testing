package pragmatic.testing.examples;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.function.ThrowingRunnable;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertThrows;

public final class ExceptionsRuleAssertTest {
    static class InsufficientFundsException extends RuntimeException {
        InsufficientFundsException(String message) {
            super(message);
        }
    }

    static class Account {
        private int balance;
        private String name;

        Account(String accountName) {
            this.name = accountName;
        }

        void withdraw(int dollars) {
            if (balance < dollars) {
                throw new InsufficientFundsException("balance only " + balance);
            }
            balance -= dollars;
        }
    }

    private Account account;

    @Before
    public void createAccount() {
        account = new Account("an account name");
    }

    @Rule
    @SuppressWarnings("deprecation")
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void testExceptionRule() {
        thrown.expect(InsufficientFundsException.class);
        thrown.expectMessage("balance only 0");
        account.withdraw(100);
    }

    @Test
    public void testAssertThrows() {
        ThrowingRunnable code = () -> account.withdraw(100);
        assertThrows("balance only 0", InsufficientFundsException.class, code);
    }
}
