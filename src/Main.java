import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, SyntaxError {

        System.out.println("Enter Job list file ");
        ReadJobFile jobFile = new ReadJobFile();

        System.out.println("Enter Workflow file ");
        try {
            ReadFile file = new ReadFile();
            SyntaxError.fileError(file);

        } catch (IOException | NumberFormatException | SyntaxError e) {
            //System.err.println("Syntax error: " + e.getMessage());
        }
    }

}