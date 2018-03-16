package cn.cjm.single;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractSingleton {
	// 这个map用来存储继承这个父类的子类的实例，key为Class.getName,value为实例
	public static Map<String, AbstractSingleton> registMap = new HashMap<>();

	public AbstractSingleton() {
		String clazzName = this.getClass().getName();
		// 如果已经有了这个实例，不能创建
		if (registMap.containsKey(clazzName)) {
			throw new RuntimeException("请通过getInstance()方法获得该实例");
		} else {
			// 如果还没有，同步创建该实例对象
			synchronized (registMap) {
				// 避免出现线程抢到锁之后，之前已经有线程创建了该对象，导致破坏了单例模式
				if (registMap.containsKey(clazzName)) {
					throw new RuntimeException("请通过getInstance()方法获得该实例");
				} else {
					registMap.put(clazzName, this);
				}

			}
		}
	}

	@SuppressWarnings("unchecked")
	public static <T extends AbstractSingleton> T getInstance(final Class<T> clazz)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException,
			NoSuchMethodException, SecurityException {
		String clazzName = clazz.getName();
		// 如果registMap中不包含这个实例，创建之
		if (!registMap.containsKey(clazzName)) {
			synchronized (registMap) {
				if (!registMap.containsKey(clazzName)) {
					// jdk新特性，以前的clazz.newInstance()已经被废弃
					T instance = clazz.getDeclaredConstructor().newInstance();
					return (T) instance;
				}
			}
		}
		// 如果包含这个实例，直接返回该实例
		return (T) registMap.get(clazzName);
	}
}
