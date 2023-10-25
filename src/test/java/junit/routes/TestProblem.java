package junit.routes;

public class TestProblem {


    public static void main(String[] args) {

        //"I like QA automation" -> "automation QA like I"

        String text = "I like QA automation";
        String[] splittedText = text.split(" ");

        for (int i = splittedText.length - 1; i >= 0; i--) {
            System.out.print(splittedText[i].concat(" "));
        }

    }
}
