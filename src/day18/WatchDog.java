package day18;

import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//dog原型
public class WatchDog {

	public static void main(String[] args) {
		/*
		 * 四个参数 任务 第一次执行时间 间隔时间 时间类型
		 */
		ScheduledThreadPoolExecutor dog = new ScheduledThreadPoolExecutor(1); // 参数设置几只狗(线程数量)
		ScheduledThreadPoolExecutor dog2 = new ScheduledThreadPoolExecutor(1);
		/*
		 * 只会汪汪汪的狗	 没有返回值
		 */
		dog.scheduleAtFixedRate(new Runnable() {
			@Override
			public void run() {
				System.out.println("寻找敌人..."+Thread.currentThread().getName());             //当前狗的名字 即线程的名字
				if (dog.getTaskCount() == 1) { 															    // 特定条件 关闭 这里是dog执行任务10次后关闭
					dog.shutdown();
				}
			}
		}, 0, 5, TimeUnit.SECONDS);
		
		/*
		 * 有骨头叼回来的狗 	有返回值
		 */
		ScheduledFuture<String> message = dog2.schedule(new Callable<String>() { 
			@Override
			public String call() throws Exception {
				System.out.println("寻找敌人..."+Thread.currentThread().getName());              //当前狗的名字 即线程的名字
				if (dog2.getTaskCount() == 1) { 															   		 // 特定条件 关闭 这里是dog执行任务10次后关闭
					dog2.shutdown();
					return "发现敌人";
				}
				return "没有发现敌人";
			}
		}, 2, TimeUnit.SECONDS);
		
		try {
			System.out.println("我"+message.get());																//骨头信息
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
