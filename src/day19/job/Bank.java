package day19.job;
/**
 * 同个线程同个银行 不同线程不同银行
 * @author Tom
 *
 */
public class Bank {
	private static ThreadLocal<Bank> tl = new ThreadLocal<Bank>();   
	private static Bank bank;
	private double money = 10000;        //默认存款10000

	private Bank() {
	}

	public synchronized static Bank getInstance() {
		if (tl.get() == null) {
			bank = new Bank();
			tl.set(bank);
		}
		return tl.get();
	}
	public double getMoney() {
		return money;
	}
	public synchronized void add(double money) {
		this.money = this.money + money;
	}

	public synchronized void sub(double money) {
		this.money = this.money - money;
	}

}
