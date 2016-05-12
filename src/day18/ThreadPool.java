package day18;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * 线程池  让一个线程池里的线程去执行某些任务，不管做多少次 总是调用线程池里的线程不会每次任务分配一个进程
 */
public class ThreadPool {
	public static void main(String[] args) {
		ExecutorService threadpool = Executors.newFixedThreadPool(100); 		// 创建100个线程的线程池---假如  合理设置应该是2个 因為知道 任務合理分配方式
		ExecutorService threadpool2 = Executors.newCachedThreadPool();        //缓存线程池当用的时候根据合理的分配自动分配线程数量
		for (int i = 0; i < 4; i++) {																		// 多少个任务  可能某个线程会多做几个任务 先做完先接任務 而某些线程不会用到因为做完了
			final int task = i;
			threadpool2.execute(new Runnable() {  											    //释放线程池
				@Override
				public void run() {
					for (int j = 0; j < 4; j++) {
						System.out.println(Thread.currentThread().getName() + ":线程任务分支:" + j + "总任务:" + task); // 每个线程的任务
					}
				}
			});
		}
		threadpool2.shutdown();         												 				//做完关闭线程池。
		
		
		//有返回值的线程
		ExecutorService threadpool3 = Executors.newSingleThreadExecutor();
		Future<Integer> future = (Future<Integer>) threadpool3.submit(new Callable<Integer>() {
			@Override
			public Integer call() throws Exception {
				System.out.println("我有返回值");
				return 1000;
			}
		});
		try {
			System.out.println(future.get());
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}
