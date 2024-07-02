package unit9;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class NonBlockingClient {
    public static void main(String[] args) throws IOException {
        InetSocketAddress address = new InetSocketAddress("localhost", 8080);
        SocketChannel client = SocketChannel.open(address);

        String message = "Hello from client";
        ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
        client.write(buffer);
        buffer.clear();
        client.close();
    }
}