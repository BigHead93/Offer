package MultiSelectorProject;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.spi.SelectorProvider;

public class ServerDispatcher {

    private ServerSocketChannel serverSocketChannel;
    private Selector[] selectors = new Selector[3];

    private SelectorProvider selectorProvider;

    public ServerDispatcher(ServerSocketChannel serverSocketChannel, SelectorProvider selectorProvider) throws IOException {
        this.serverSocketChannel = serverSocketChannel;
        this.selectorProvider = selectorProvider;
        for(int i = 0; i < 3; i++) {
            selectors[i] = selectorProvider.openSelector();
        }
    }

    public Selector getAcceptSelector() {
        return selectors[0];
    }

    public Selector getReadSelector() {
        return selectors[1];
    }

    public Selector getWriteSelector() {
        return selectors[2];
    }

    public void execute() throws IOException {
        SocketHandler socketHandler = new SocketAcceptHandler(this, serverSocketChannel, getAcceptSelector());

    }
}
