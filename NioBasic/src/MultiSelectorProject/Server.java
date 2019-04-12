package MultiSelectorProject;

import java.io.IOException;

public class Server {
    public static void main(String[] args) throws IOException {
        int port = 9999;
        new Thread(new ServerReactor(port)).start();;
    }
}
