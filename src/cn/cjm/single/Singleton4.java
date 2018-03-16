package cn.cjm.single;
/**
 * 
 * @ClassName: Singleton4 
 * @Description: 饿汉模式 
 * @author cjm
 * @date 2017年11月20日 下午11:01:43 
 *
 */
public class Singleton4 {
	private static Singleton4 instance = new Singleton4();
	private Singleton4() {}
	public static Singleton4 getInstance() {
		return instance;
	}
}
