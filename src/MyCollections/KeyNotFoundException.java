package MyCollections;

public class KeyNotFoundException extends RuntimeException {
    private final String value;

    public KeyNotFoundException(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Exception: key not found (" + value + ")";
    }
}
