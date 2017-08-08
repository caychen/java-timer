package timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

public class MyTimerTask extends TimerTask {

	private String name;
	private Integer count;

	public MyTimerTask(String name) {
		super();
		count = 0;
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	@Override
	public void run() {
		System.out.println(".........");
		// TODO Auto-generated method stub
		if (count < 5) {
			count++;
			System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
			System.out.println("Current exec name is: " + name);
		}else{
			//cancel();//取消task任务，会取消run方法的调用，即当前线程终止
			//System.out.println("任务取消");
		}
	}

}
