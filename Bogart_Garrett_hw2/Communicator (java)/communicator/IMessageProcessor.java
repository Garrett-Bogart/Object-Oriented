package communicator;
import java.net.InetAddress;

public interface IMessageProcessor {
    String process(String message, InetAddress address, int port);
}
