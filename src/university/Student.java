package university;
import java.util.Random;

public class Student extends Thread implements Person{
	static Random r = new Random();
	
	private Billboard billboard;
	private String studentID;
	private String firstName;
	private String lastName;
	private int vouchers;
	private int minReactionTime = 1000; // 1000 = 1 second
	private int maxReactionTime = 3500;
	
	public int getVouchers() {
		return vouchers;
	}

	public void setVouchers(int counter) {
		this.vouchers = counter;
	}

	public Student(Billboard billboard) {
		this.billboard = billboard;	
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getStudentID() {
		return studentID;
	}
	public void setStudentID(String studentID) {
		this.studentID = studentID;
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
		if (Billboard.isVoucherPlaced()) {
			takeVoucher();
		} else {
			//System.out.println("[STUDENT] The student sees that there is no voucher...");
		}
	}
	
	public synchronized void takeVoucher() {
		this.vouchers++;
		
		System.out.println("[STUDENT] " + this.getFirstName() + " " +
		this.getLastName() + " takes a voucher. He now has " + this.getVouchers()
		+ " voucher(s).");
		
		if (Billboard.getVoucherQuantity() > 0) {
			Billboard.setVoucherQuantity(Billboard.getVoucherQuantity() - 1);
			if (Billboard.getVoucherQuantity() == 0) {
				Billboard.setVoucherPlaced(false);
				System.out.println("[STATUS] The billboard has run out of vouchers!\n");
			}
		}
	}
	
	public int react() {
		return r.nextInt(maxReactionTime - minReactionTime) + minReactionTime;
	}
}
