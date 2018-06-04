package university;
import java.util.Random;

public class Registrar extends Thread implements Person{
	private static int tempQuantity;
	static Random r = new Random();
	private Billboard billboard;
	private int minReactionTime = 1000; // 1000 = 1 second
	private int maxReactionTime = 4250;
	private static int minRandomVoucher = 1;
	private static int maxRandomVoucher = 5;
	
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
		tempQuantity = r.nextInt(maxRandomVoucher - minRandomVoucher) + minRandomVoucher;
		
		System.out.println("[REGISTRAR] The Registrar has placed " +
		tempQuantity +  " voucher(s) on the billboard.");
		
		Billboard.setVoucherQuantity(tempQuantity);
		Billboard.setVoucherPlaced(true);
	}

	public int react() {
		return r.nextInt(maxReactionTime-minReactionTime) + minReactionTime;
	}
}
