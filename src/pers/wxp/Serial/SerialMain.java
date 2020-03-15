package pers.wxp.Serial;

public class SerialMain {
	public static void main(String[] args) {
		String PORT_NAME = "COM4";
		DSerialPort sp = new DSerialPort();
		sp.listPort();
		sp.selectPort(PORT_NAME);
		sp.write("210.36.16.166");
		sp.write("2");
		sp.startRead(120);
	}
}
