import java.util.*;
class Philosopher implements Runnable{
	private List<Philosopher> philosophers;
	private int left = 0;
	private int right = 0;
	private static int noodle = 100;
	public void setThread(List<Philosopher> philosophers){
		this.philosophers = philosophers;
	}
	public void run(){
		while(noodle > 0){
			this.think();
			this.left();
			this.right();
			if(philosophers.get(0).left == 1 && philosophers.get(1).left == 1 && philosophers.get(2).left == 1 && philosophers.get(3).left == 1 && philosophers.get(4).left == 1){
				philosophers.get(0).left = 0;
			}
			if(left == 1 && right == 1){
				this.eat();
				synchronized (this){
					left = 0;
				    right = 0;
					noodle -= 2;
				}
			}
		}
	}
	public void eat(){
		try{
			System.out.println(Thread.currentThread().getName() + "正在吃饭");
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName() + "吃饱了");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public void think(){
		try{
			System.out.println(Thread.currentThread().getName() + "正在思考哲♂学问题");
			Thread.sleep(500);
			System.out.println(Thread.currentThread().getName() + "饿了");
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public synchronized void left(){
		if(philosophers.indexOf(this) == 0){
			if(philosophers.get(4).right == 0){
				left = 1;
				System.out.println(Thread.currentThread().getName() + "拿起了左手的筷子");
			}
		}
		else{
			if(philosophers.get(philosophers.indexOf(this)-1).right == 0){
				left = 1;
				System.out.println(Thread.currentThread().getName() + "拿起了左手的筷子");
			}
		}
	}
	public synchronized void right(){
		if(philosophers.indexOf(this) == 4){
			if(philosophers.get(0).left == 0){
				right = 1;
				System.out.println(Thread.currentThread().getName() + "拿起了右手的筷子");
			}
		}
		else{
			if(philosophers.get(philosophers.indexOf(this)+1).left == 0){
				right = 1;
				System.out.println(Thread.currentThread().getName() + "拿起了右手的筷子");
			}
		}
	}
	public void attackLeft(){
		philosophers.get(philosophers.indexOf(this)-1).right = 0;
	}
	public void attackRight(){
		philosophers.get(philosophers.indexOf(this)+1).left = 0;
	}
}