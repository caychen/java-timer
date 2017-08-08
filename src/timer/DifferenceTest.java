package timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;

public class DifferenceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();

		Calendar calendar = Calendar.getInstance();

		System.out.println("当前时间： " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(calendar.getTime()));
		//calendar.add(Calendar.SECOND, -6);// 提前6秒

		//1、首次执行的时间点早于当前时间点：
		//schedule：首次执行的时间定在6秒前，而实际执行的首次时间为当前时间点，然后每隔period秒后执行一次
		/*
		timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(
						"当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(scheduledExecutionTime()));

			}
		}, calendar.getTime(), 2000);
		*/
		
		//scheduleAtFixedRate：首次时间定在6秒前，为了赶上当前时间点，该方法会在开始的时候连续执行多次，当赶上当前时间后，会安装正常时间间隔执行task
		//使用该方法需要考虑线程的同步
		/*timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(
						"当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(scheduledExecutionTime()));

			}
		}, calendar.getTime(), 2000);*/
		
		//2、任务执行时间超出执行周期间隔
		//task执行需要3秒，即首次执行完成任务是3秒后，而task任务的时间间隔是2秒，那么task的时间会不断延后，以上一次执行完成任务的时间点作为基准
		/*timer.schedule(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(
						"当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(scheduledExecutionTime()));

			}
		}, calendar.getTime(), 2000);*/
		
		//scheduleAtFixedRate会以上一次任务开始的时间点作为基准，因此存在并发性
		timer.scheduleAtFixedRate(new TimerTask() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println(
						"当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(scheduledExecutionTime()));

			}
		}, calendar.getTime(), 2000);
	}

}
