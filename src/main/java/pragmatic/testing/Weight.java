package pragmatic.testing;

enum Weight {
    /**
     * Must match state.
     */
    MUST_MATCH,
    /**
     * Don't care state.
     */
    DONT_CARE;

    private static final int ZERO = 0;

    public int getValue() {
        return ZERO;
    }
}
