package MyCollections;

public class DuplicateKeyException extends RuntimeException {
    private final String value;

    public DuplicateKeyException(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Exception: item with specified key already exists (" + value + ")";
    }
}
