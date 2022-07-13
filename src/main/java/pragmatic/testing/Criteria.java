package pragmatic.testing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author unrealwork
 */
public final class Criteria implements Iterable<Criterion> {

    private final List<Criterion> criterions = new ArrayList<>();

    public void add(Criterion criterion) {
        criterions.add(criterion);
    }

    @Override
    public Iterator<Criterion> iterator() {
        return criterions.iterator();
    }

    public int arithmeticMean() {
        throw new UnsupportedOperationException();
    }

    public double geometricMean(int[] numbers) {
        int totalProduct = Arrays.stream(numbers).reduce(1, (product, number) -> product * number);
        return Math.pow(totalProduct, 1.0 / numbers.length);
    }
}
