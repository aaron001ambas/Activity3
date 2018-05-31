package university;

public class Billboard {

	private static boolean voucherPlaced = false;

	public static boolean isVoucherPlaced() {
		return voucherPlaced;
	}

	public static void setVoucherPlaced(boolean voucherPlaced) {
		Billboard.voucherPlaced = voucherPlaced;
	}
}
