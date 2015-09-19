package fr.ase.cow.socket;

import fr.ase.cow.socket.constantes.ISocketConstantes;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by axels on 03/09/2015.
 */
public final class SocketManager {

    /**
     * Socket manager instance
     */
    private static volatile SocketManager socketManagerInstance = null;

    /**
     * Attribut which allow you to communicate with a socket
     */
    private Socket socket;

    /**
     * Private Constructor
     */
    private SocketManager() {
        super();
    }

    /**
     * Method that allow to return the current socketManagerInstance of SocketManager class
     *
     * @return SocketManager
     */
    public final static SocketManager getInstance() {

        if (SocketManager.socketManagerInstance == null) {

            synchronized (SocketManager.class) {
                SocketManager.socketManagerInstance = new SocketManager();
            }
        }

        return SocketManager.socketManagerInstance;
    }

    /**
     * Allow you to connect to the server on locahost with bindpoint 8127
     *
     * @throws IOException
     */
    public void connectToServer() throws IOException {
        this.socket = new Socket(ISocketConstantes.SOCKET_HOST, ISocketConstantes.SOCKET_BINDPOINT);
    }

    /**
     * Allow you to know if you're connected to the server
     *
     * @return boolean
     */
    public boolean isConnectedToServer() {
        return this.socket.isConnected();
    }


}
