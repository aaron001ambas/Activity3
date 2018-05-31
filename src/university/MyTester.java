package university;

public class MyTester extends Thread{

	public static void main(String[] args) {
		
		Billboard b1 = new Billboard();
		
		Student s1 = new Student(b1);
		s1.setFirstName("John");
		s1.setLastName("Sumitsu");
		s1.setStudentID("2014-100438");
		Student s2 = new Student(b1);
		s2.setFirstName("Moriuchi");
		s2.setLastName("Takahiro");
		s2.setStudentID("2014-100192");
		Student s3 = new Student(b1);
		s3.setFirstName("Toru");
		s3.setLastName("Yamashita");
		s3.setStudentID("2014-100291");
		Student s4 = new Student(b1);
		s4.setFirstName("Ryota");
		s4.setLastName("Kohama");
		s4.setStudentID("2014-100121");
		Student s5 = new Student(b1);
		s5.setFirstName("Masafumi");
		s5.setLastName("Gotou");
		s5.setStudentID("1976-100122");
		Student s6 = new Student(b1);
		s6.setFirstName("Hachiman");
		s6.setLastName("Hikigaya");
		s6.setStudentID("2014-100101");
		Student s7 = new Student(b1);
		s7.setFirstName("Tomoya");
		s7.setLastName("Kanki");
		s7.setStudentID("2014-100441");
		Student s8 = new Student(b1);
		s8.setFirstName("Kensuke");
		s8.setLastName("Kita");
		s8.setStudentID("1977-100124");
		Student s9 = new Student(b1);
		s9.setFirstName("Takahiro");
		s9.setLastName("Yamada");
		s9.setStudentID("1977-100819");
		Student s10 = new Student(b1);
		s10.setFirstName("Kiyoshi");
		s10.setLastName("Ijichi");
		s10.setStudentID("1977-100925");
		
		
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		Thread t3 = new Thread(s3);
		Thread t4 = new Thread(s4);
		Thread t5 = new Thread(s5);
		Thread t6 = new Thread(s6);
		Thread t7 = new Thread(s7);
		Thread t8 = new Thread(s8);
		Thread t9 = new Thread(s9);
		Thread t10 = new Thread(s10);
		Thread t11 = new Thread(new Registrar(b1));
		
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();
		t6.start();
		t7.start();
		t8.start();
		t9.start();
		t10.start();
		t11.start();
		
	}

}
