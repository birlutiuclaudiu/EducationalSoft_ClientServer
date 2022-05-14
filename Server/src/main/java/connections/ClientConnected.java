package connections;

import connections.ConnectionClientServer;

public class ClientConnected implements ConnectionClientServer {

    private String ipAddress;
    public ClientConnected(String ipAddress){
        this.ipAddress = ipAddress;
    }

    @Override
    public void grantConnection() {
        System.out.println("PROXY: Client with ipAddress "+this.ipAddress+" is connected");
    }
}
