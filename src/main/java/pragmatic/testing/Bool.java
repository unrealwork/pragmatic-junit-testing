package pragmatic.testing;

enum Bool {
    False(0),
    True(1);
    static final int FALSE = 0;
    static final int TRUE = 1;
    private int value;

    Bool(int val) {
        this.value = val;
    }

    public int getValue() {
        return value;
    }
}
