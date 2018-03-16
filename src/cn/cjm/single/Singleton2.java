package cn.cjm.single;
/**
 * 
 * @ClassName: Singleton2 
 * @Description:考虑到多线程，但是效率太低了 
 * @author cjm
 * @date 2017年11月20日 下午9:45:57 
 *
 */
public class Singleton2 {
	private static Singleton2 instance = null;
	private static Object lockObj = new Object();
	private Singleton2() {}
	public static Singleton2 getInstance() {
		synchronized(lockObj) {
			if(instance==null) {
				instance =  new Singleton2();
			}
			return instance;
		}
	}
}
