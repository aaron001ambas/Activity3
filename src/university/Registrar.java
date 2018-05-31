package university;
import java.util.Random;

public class Registrar extends Thread implements Person{
	Random r = new Random();
	private Billboard billboard;
	
	public Registrar(Billboard billboard) {
		this.billboard = billboard;
	}
	
	public void run() {
		while (true) {
			try {
				Thread.sleep(r.nextInt(6000-1000) + 1000);
				checkForVouchers();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void checkForVouchers() {
		if (!Billboard.isVoucherPlaced()) {
			placeVoucher();
		}
	}
	public static void placeVoucher() {
		System.out.println("[REGISTRAR] The Registrar places a voucher on the billboard.");
		Billboard.setVoucherPlaced(true);
	}
}
