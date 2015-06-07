
import gnu.io.*;
import java.io.*;

public class ReadDataSerial {

    public static void main(String[] args) {
        String portName = "COM12"; // ganti COM ini
        SerialPort serialPort = null;

        try {
            CommPortIdentifier port = CommPortIdentifier.getPortIdentifier(portName);
            if (port != null) {
                CommPort commPort = port.open("Myport", 10000);

                if (commPort instanceof SerialPort) {
                    serialPort = (SerialPort) commPort;
                    serialPort.setSerialPortParams(9600,
                            SerialPort.DATABITS_8,
                            SerialPort.STOPBITS_1,
                            SerialPort.PARITY_NONE);


                    BufferedReader reader =
                            new BufferedReader(new InputStreamReader(
                            serialPort.getInputStream()));
                    while (true) {
                        String line = "";
                        while ((reader.ready()) && (line = reader.readLine()) != null) {                            
                            System.out.println("Data dari Arduino: " + line);
                        }
                    }

                } else {
                    System.out.println("Can't access serial port");
                }
            } else {
                System.out.println("Can't find serial port");
            }

        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        } finally {
            if (serialPort != null) {
                serialPort.close();
            }
        }
    }
}
