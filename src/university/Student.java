package university;
import java.util.Random;

public class Student extends Thread implements Person{
	Random r = new Random();
	
	private Billboard billboard;
	private String studentID;
	private String firstName;
	private String lastName;
	private int vouchers;
	
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
				Thread.sleep(r.nextInt(1000-250) + 250);
				checkForVouchers();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public synchronized void checkForVouchers() {
		if (Billboard.isVoucherPlaced()) {
			takeVoucher();
		} else {
			//System.out.println("[STUDENT] The student sees that there is no voucher...");
		}
	}
	
	public void takeVoucher() {
		this.vouchers++;
		System.out.println("[STUDENT] " + this.getFirstName() + " " +
		this.getLastName() + " takes the voucher.");
		System.out.println("[STUDENT] " + this.getFirstName() + " " + this.getLastName() +
		" has " + this.getVouchers() + " voucher(s).");
		Billboard.setVoucherPlaced(false);
	}
}
