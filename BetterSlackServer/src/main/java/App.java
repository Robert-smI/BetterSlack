import java.io.IOException;

public class App {

    public static void main(String[] args) throws IOException {
        ServerSimple serverSimple = new ServerSimple();


        serverSimple.serverStart(3024);

    }


}
