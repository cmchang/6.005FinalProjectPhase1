package pingball;

import java.io.BufferedReader;
import java.io.IOException;
import pingball.BoardsHandler.Orientation;

public class ServerReader implements Runnable{
    private BoardsHandler boardHandler;
    private Object lock;
    private BufferedReader stream;
    
    ServerReader(BufferedReader stream, Object lock, BoardsHandler boardHandler){
        this.stream = stream;
        this.lock = lock;
        this.boardHandler = boardHandler;
    }
    
    public void run() {
         // contains join messages
        String userInput="";              
        try {
          if (stream.ready()) userInput = stream.readLine();
      } catch (IOException e1) {
          e1.printStackTrace();
      }
        String[] cmds = userInput.split(" ");
        if (cmds.length==3){
            Orientation o = null;
            if (cmds[0].equals("v")) o = Orientation.VERTICAL;
            if (cmds[0].equals("h")) o = Orientation.HORIZONTAL;
            synchronized(lock){
                if (!o.equals(null)) boardHandler.addConnection(cmds[1], cmds[2], o);
            }
        }
        
    }

}
