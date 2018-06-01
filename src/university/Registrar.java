package university;
import java.util.Random;

public class Registrar extends Thread implements Person{
	private static int tempQuantity;
	static Random r = new Random();
	private Billboard billboard;
	
	public Registrar(Billboard billboard) {
		this.billboard = billboard;
	}
	public void run() {
		while (true) {
			try {
				Thread.sleep(react());
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
		tempQuantity = r.nextInt(5 - 1) + 1;
		System.out.println("[REGISTRAR] The Registrar has placed " +
		tempQuantity +  " voucher(s) on the billboard.");
		Billboard.setVoucherQuantity(tempQuantity);
		Billboard.setVoucherPlaced(true);
	}

	public int react() {
		return r.nextInt(5000-1000) + 1000;
	}
}
