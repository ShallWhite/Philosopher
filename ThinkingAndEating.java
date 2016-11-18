import java.util.*;
public class ThinkingAndEating{
	public static void main(String args []){
		Philosopher p00 = new Philosopher();
		Philosopher p01 = new Philosopher();
		Philosopher p02 = new Philosopher();
		Philosopher p03 = new Philosopher();
		Philosopher p04 = new Philosopher();
		Thread p0 = new Thread(p00,"越♂神");
		Thread p1 = new Thread(p01,"东♂神");
		Thread p2 = new Thread(p02,"马尾♀学长");
		Thread p3 = new Thread(p03,"郑♂学长");
		Thread p4 = new Thread(p04,"曾♂学长");
		List<Philosopher> philosophers = new ArrayList<Philosopher>();
		philosophers.add(p00);
		philosophers.add(p01);
		philosophers.add(p02);
		philosophers.add(p03);
		philosophers.add(p04);
		p00.setThread(philosophers);
		p01.setThread(philosophers);
		p02.setThread(philosophers);
		p03.setThread(philosophers);
		p04.setThread(philosophers);
		p0.start();
		p1.start();
		p2.start();
		p3.start();
		p4.start();
	}
}