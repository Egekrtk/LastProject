import java.io.*;

public class SyntaxError extends Exception{
    public SyntaxError(){

    }
    public SyntaxError(String message){
        super(message);
    }

    public static void defaultError(String name) throws SyntaxError {
        if (name == null || name.isBlank()|| name.isEmpty()){
            throw new SyntaxError("name syntax Error");
        }
    }

    public static void fileError(ReadFile file) throws SyntaxError, IOException {
        BufferedReader br = new BufferedReader(new FileReader(String.valueOf(file)));
        String line = br.readLine();
        if (line.contains(".")||line.contains("_")||line.contains("-")||line.contains("_")){
            throw  new SyntaxError("Invalid input");
        }
        if (line.startsWith(" TASKTYPES") && (!line.contains("T")||line.contains("J")||line.contains("S"))){
            throw  new SyntaxError("Wrong place");
        }
        if (line.startsWith(" J") && (line.contains("S"))){
            throw new SyntaxError("Wrong place");
        }
        if (line.startsWith(" S") && (line.contains("J"))){
            throw new SyntaxError("Wrong place");
        }
    }
    public static void fileError(ReadJobFile jobFile) throws SyntaxError, IOException {
        BufferedReader br = new BufferedReader(new FileReader(String.valueOf(jobFile)));
        String line = br.readLine();
        if (line.contains(".")||line.contains("_")||line.contains("-")||line.contains("_")){
            throw  new SyntaxError("Invalid input");
        }
        if (line.startsWith(" TASKTYPES") && (!line.contains("T")||line.contains("J")||line.contains("S"))){
            throw  new SyntaxError("Wrong place");
        }
        if (line.startsWith(" J") && (line.contains("S"))){
            throw new SyntaxError("Wrong place");
        }
        if (line.startsWith(" S") && (line.contains("J"))){
            throw new SyntaxError("Wrong place");
        }
    }

}
