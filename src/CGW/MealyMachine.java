package CGW;

public class MealyMachine extends AbstractAutomaton{

    public MealyMachine(String charset, int[][][] instructions) {
        super(charset, instructions);
    }

    @Override
    public String processString(String string) {
        char[] chars = string.toCharArray();
        StringBuilder returnValue = new StringBuilder();
        int state = 0;

        for (int i = 0; i < chars.length; i++) {
            int cur = inputCharset.indexOf(chars[i]);
            returnValue.append((char)instructions[state][cur][0]);
            state = instructions[state][cur][1];
        }

        return returnValue.toString();
    }
}
