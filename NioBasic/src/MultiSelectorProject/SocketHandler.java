package MultiSelectorProject;

import java.io.IOException;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class SocketHandler implements Runnable{

    protected Selector selector;
    protected SocketChannel socketChannel = null;
    protected ServerSocketChannel serverSocketChannel;
    protected ServerDispatcher serverDispatcher;
    private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    public SocketHandler(ServerDispatcher serverDispatcher, ServerSocketChannel serverSocketChannel, Selector selector) {
        this.selector = selector;
        this.serverSocketChannel = serverSocketChannel;
        this.serverDispatcher = serverDispatcher;
    }

    public abstract void runnerExecute(int readyKeyOps) throws IOException;

    @Override
    public final void run() {
        StringBuilder
    }
}
