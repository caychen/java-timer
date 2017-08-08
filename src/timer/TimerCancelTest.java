package timer;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;

public class TimerCancelTest {

	public static void main(String[] args) throws Exception {
		Timer timer = new Timer();
		MyTimerTask task1 = new MyTimerTask("task1");
		MyTimerTask task2 = new MyTimerTask("task2");
		
		timer.schedule(task1, 1000L, 2000L);
		timer.schedule(task2, 2000L, 2000L);
		
		Thread.sleep(5000L);
		
		//timer.cancel();//取消timer下所有的task
		//System.out.println("Cancel Time: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		
		//purge：从timer定时器中移除已经取消的任务，并返回移除的任务数
		task2.cancel();
		System.out.println("当前取消的任务数：" + timer.purge());
	}
}
