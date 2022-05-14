package connection;

import lombok.Getter;

@Getter
public class ProxyClientConnected implements ConnectionClientServer {

    private String ipAddress;
    private ClientConnected clientConnected;
    public ProxyClientConnected(String ipAddress){
        this.ipAddress = ipAddress;
    }
    @Override
    public void grantConnection() {
        if(ipAddress.equals("127.0.0.1")){
            this.clientConnected = new ClientConnected(this.ipAddress);
            clientConnected.grantConnection();
        }else{
            System.out.println("PROXY: Client with ipAddress "+this.ipAddress+" no acces granted to server");
        }
    }
}
