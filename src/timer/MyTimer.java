package timer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/*
 *	schedule(TimerTask task, long delay): 
 *		delay秒后执行一次task任务(一次任务)
 *
 *	schedule(TimerTask task, Date time):
 *		在time时间点执行一次task任务(一次任务)
 *
 *	schedule(TimerTask task, long delay, long period):
 *		delay秒后，执行task任务，且以后每隔period秒后，执行一次task(循环任务)
 *
 *	schedule(TimerTask task, Date firstTime, long period):
 *		在firstTime时间点执行一次task任务，之后每隔period秒后执行一次task任务(循环任务)
 *
 *	scheduleAtFixedRate(TimerTask task, long delay, long period):
 *		同schedule(TimerTask task, long delay, long period)
 *
 *	scheduleAtFixedRate(TimerTask task, Date firstTime, long period):
 *		同schedule(TimerTask task, Date firstTime, long period)
 */



public class MyTimer {

	public static void main(String[] args) {
		//创建timer实例
		Timer timer = new Timer();
		
		//创建一个task实例
		MyTimerTask timerTask = new MyTimerTask("No.1");
		
		//Calendar calendar = Calendar.getInstance();
		//calendar.add(Calendar.SECOND, 5);//5秒之后
		//timerTask.setName("Schedule-1");
		//timer.schedule(timerTask, calendar.getTime());//在calendar指定的时间点执行一次task
		
		//calendar.add(Calendar.SECOND, 10);
		//timerTask.setName("Schedule-2");
		//timer.schedule(timerTask, calendar.getTime(), 1000l);
		
		timerTask.setName("Schedule-3");
		timer.schedule(timerTask, 5000L);
		
		//通过timer定时定频率，调用task的业务逻辑(run方法)
		//即第一次执行是在当前时间的2秒后，之后每隔1秒后执行一次
		//timerTask.setName("Schedule-4");
		//timer.schedule(timerTask, 2000L, 1000L);
		
		//timerTask.setName("scheduleAtFixedRate-1");
		//calendar.add(Calendar.SECOND, 5);
		//timer.scheduleAtFixedRate(timerTask, calendar.getTime(), 2000L);//同schedule(TimerTask task, Date firstTime, long period)
		
		//timerTask.setName("scheduleAtFixedRate-2");
		//timer.scheduleAtFixedRate(timerTask, 1000L, 2000L);//同schedule(TimerTask task, long delay, long period)
		
		//scheduledExecutionTime返回当前task执行的最近的时间点
		System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(timerTask.scheduledExecutionTime()));
		
	}
}
