package clock;

public class ClockUse {
	public static void main(String[] args) {
		Clock c1 = new Clock(12, 00, 00);
		Clock c2 = new Clock(2, 30, 25);
		
		c1.addClock(c2);
		
		System.out.println(c1);
	}
}
