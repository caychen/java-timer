package robot;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Executor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		System.out.println("当前时间：" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));

		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println(
						"跳舞..." + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(scheduledExecutionTime()));
			}
		}, new Date(), 2000);

		timer.schedule(new TimerTask() {
			// 最大容量为5L
			private Integer bucketCapacity = 0;

			@Override
			public void run() {
				// TODO Auto-generated method stub
				if (bucketCapacity < 5) {
					System.out.println("灌水1L...");
					bucketCapacity++;
					//throw new RuntimeException();
				} else {
					System.out.println("移除数量：" + timer.purge());
					cancel();// 停止灌水
					System.out.println("移除数量：" + timer.purge());
					System.out.println("停止灌水...,容量为：" + bucketCapacity);
					try {
						Thread.sleep(2000L);// 等待2秒
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} finally {
						timer.cancel();
					}
				}
			}
		}, new Date(), 1000);
	}

}
