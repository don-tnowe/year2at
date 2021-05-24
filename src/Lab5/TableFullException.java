package Lab5;

public class TableFullException extends RuntimeException {
    public String toString() {
        return "Exception: capacity full. Can't insert new element in table";
    }
}
