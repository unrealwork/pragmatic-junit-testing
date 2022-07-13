package pragmatic.testing;

enum Bool {
    FALSE(0),
    TRUE(1);
    private int value;

    Bool(int val) {
        this.value = val;
    }

    public int getValue() {
        return value;
    }
}
