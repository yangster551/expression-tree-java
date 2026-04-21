import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        //infinite loop to allow multiple expressions until user exits
        while (true) {
            System.out.println("Type your expression:");
            String infix = scanner.nextLine();

            //step 1: convert to postfix
            Converter converter = new Converter(infix);
            String postfix = converter.toPostFix();

            //step 2: build tree
            ExpressionTree<String> tree = new ExpressionTree<>(postfix);

            //step 3: print traversals ONLY
            System.out.println("Prefix: " + tree.prefix());
            System.out.println("Infix: " + tree.infix());
            System.out.println("Postfix: " + tree.postfix());

            System.out.println();
        }
    }
}