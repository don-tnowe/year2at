package CGW;
import java.util.Arrays;

public class TuringMachine extends AbstractAutomaton{

    public TuringMachine(String charset, int[][][] instructions) {
        super(charset, instructions);
    }

    @Override
    public String processString(String string) {
        char[] chars = string.toCharArray();
        int caretPos = 0;
        int state = 0;

        while (true) {
            try {
                int cur = inputCharset.indexOf(chars[caretPos]);
                chars[caretPos] = (char)instructions[state][cur][0];
                caretPos += instructions[state][cur][1];
                state = instructions[state][cur][2];
            }
            catch (ArrayIndexOutOfBoundsException x) {
                break;
            }
        }

        return new String(chars);
    }
}
