package communicator;
import java.net.InetAddress;

public class DummyMessageProcessor implements IMessageProcessor {

    private String name;
    private int receiveCount;
    private String message;

    public DummyMessageProcessor(String name) {
        this.name = name;
    }
    @Override
    public String process(String message, InetAddress address, int port) {
        if (message==null) {
            System.out.println("Null string");
            return null;
        }

        if (address==null) {
            System.out.println("Null address");
            return null;
        }

        System.out.println(String.format("%s received: %s from %s:%d", name, message, address.toString(), port));
        receiveCount++;
        setMessage(message);
        return getMessage();
    }
    
    public String getMessage() {return message;}
    public int ReceiveCount() { return receiveCount; }
    
    public void setMessage(String message) {this.message = message;}
}
