package CGW;

public class MooreMachine extends AbstractAutomaton{
    private char[] stateOutputs;

    public MooreMachine(String charset, String stateOutputs, int[][][] instructions) {
        super(charset,instructions);
        this.stateOutputs = stateOutputs.toCharArray();
    }

    @Override
    public String processString(String string) {
        char[] chars = string.toCharArray();
        StringBuilder returnValue = new StringBuilder();
        int state = 0;

        for (int i = 0; i < chars.length; i++) {
            int cur = inputCharset.indexOf(chars[i]);
            state = instructions[state][cur][0];
            returnValue.append(stateOutputs[state]);
        }

        return returnValue.toString();
    }
}
