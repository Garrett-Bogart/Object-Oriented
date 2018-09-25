package observer;

import java.net.InetAddress;

abstract public class Observers {
	protected int port;
	protected InetAddress ip;
	public int getPort() {return port;}
	public InetAddress getIP() {return ip;}
	
	public void setPort(int endpoint) {this.port = endpoint;}
	public void setIP(InetAddress ip) {this.ip = ip;}
}
