package cn.cjm.single;
// 静态内部类实现
public class Singleton5 {
	private Singleton5() {}
	public static Singleton5 getInstance() {
		System.out.println("single:"+System.currentTimeMillis());
		return Nested.instance;
	}
	private static class Nested{
		static Singleton5 instance = new Singleton5();
		static {
			System.out.println("nestd:"+System.currentTimeMillis());
		}
	}
}
