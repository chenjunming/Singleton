package cn.cjm.single;


/**
 * 
 * @ClassName: Singleton1 
 * @Description:没有考虑到多线程 
 * @author cjm
 * @date 2017年11月20日 下午9:41:35 
 *
 */
public class Singleton1 {
	private static Singleton1 instance = null;
	private Singleton1() {
	}
	public static Singleton1 getInstance() {
		if(instance == null) {
			instance = new Singleton1();
		}
		return instance;
	}
}
