import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        //Arraylisti constructorda nasıl kullanabilirim
        //Joba özel task arrayi nasıl ekliyebilirim
        //Dosyayı okuduktan sonra oluşan objelere nasıl ulaşabilirim

        ReadJobFile jobFile = new ReadJobFile("jobList.txt");
        ReadFile file = new ReadFile("deneme.txt");


    }
}