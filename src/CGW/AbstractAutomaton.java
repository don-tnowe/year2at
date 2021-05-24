package CGW;

public abstract class AbstractAutomaton {
    public int stateCount;
    public int inputValueCount;

    protected int[][][] instructions;
    protected String inputCharset;

    public AbstractAutomaton(String charset, int[][][] instructions) {
        stateCount = instructions.length;
        inputValueCount = instructions[0].length;
        this.instructions = instructions;
        this.inputCharset = charset;
        }

    public abstract String processString(String string);
}
