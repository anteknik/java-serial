import gnu.io.*;
import java.util.*;

public class SerialDemo {

    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        		
        Enumeration<CommPortIdentifier> ports = CommPortIdentifier.getPortIdentifiers();
        while ( ports.hasMoreElements()) 
        {
            CommPortIdentifier info = ports.nextElement();
            System.out.println(info.getName());
        }   
    }
}
