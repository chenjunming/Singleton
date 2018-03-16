package cn.cjm.single;
/**
 * 
 * @ClassName: Singleton3 
 * @Description:  在新建单例的时候才加锁，加快速度
 * @author cjm
 * @date 2017年11月20日 下午10:15:25 
 *
 */
public class Singleton3 {
	private static Singleton3 instance = null;
	private static Object lockObj = new Object();
	private Singleton3() {}
	public static Singleton3 getInstance() {
		if(instance == null) {
			synchronized (lockObj) {
				if(instance == null)
				instance = new Singleton3();
			}
		}
		return instance;
	}
}
