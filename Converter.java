import java.util.List;

public class Converter {

    private String infix;

    //constructor
    public Converter(String infix) {
        this.infix = infix;
    }

    //precedence helper
    private int precedence(String op) {
        if (op.equals("^")) return 3;
        if (op.equals("*") || op.equals("/")) return 2;
        if (op.equals("+") || op.equals("-")) return 1;
        return 0;
    }

    //checks if token is operator
    private boolean isOperator(String s) {
        return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("^");
    }

    //MAIN METHOD
    public String toPostFix() {
        List<String> tokens =
            ParserHelper.parse(infix.toCharArray());

        ArrayStack<String> stack = new ArrayStack<>();
        StringBuilder output = new StringBuilder();

        //Go through every element inside tokens, one at a time.
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);

            //operand
            if (Character.isDigit(token.charAt(0))) {
                output.append(token).append(" ");
            }

            //open parenthesis
            else if (token.equals("(")) {
                stack.push(token);
            }

            //close parenthesis
            else if (token.equals(")")) {
                while (!stack.isEmpty() && !stack.top().equals("(")) {
                    output.append(stack.pop()).append(" ");
                }
                stack.pop(); //remove (
            }

            //operator
            else if (isOperator(token)) {
                while (!stack.isEmpty() && isOperator(stack.top()) && precedence(stack.top()) >= precedence(token)) {
                    output.append(stack.pop()).append(" ");
                }
                stack.push(token);
            }
        }

        //pop remaining operators
        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }

        return output.toString().trim();
    }
}