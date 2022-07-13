package pragmatic.testing;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class HelloTest {
    @Test
    public void test() {
        final Hello hello = new Hello();

        final String greeting = hello.getGreeting();

        assertThat(greeting, equalTo("Hello, world!"));
    }
}
