package university;

public class Billboard {

	private static boolean voucherPlaced;
	private static int voucherQuantity;
	
	public static int getVoucherQuantity() {
		return voucherQuantity;
	}
	public static void setVoucherQuantity(int voucherQuantity) {
		Billboard.voucherQuantity = voucherQuantity;
	}
	public static boolean isVoucherPlaced() {
		return voucherPlaced;
	}
	public static void setVoucherPlaced(boolean voucherPlaced) {
		Billboard.voucherPlaced = voucherPlaced;
	}
	
}
