package code;

import sun.security.jca.GetInstance;

/**
 * 懒汉模式
 */
public class SafeDoubleCheckedLocking {
    /**
     * volatile限制在实例化过程中初始化对象操作与指针指向对象内存地址操作的从排序
     */
    private volatile static SafeDoubleCheckedLocking instance;
    public static SafeDoubleCheckedLocking getInstance() {
        if(instance == null) {
            synchronized (SafeDoubleCheckedLocking.class) {
                if(instance == null)
                    instance = new SafeDoubleCheckedLocking();
            }
        }
        return instance;
    }

}

/**
 * 饿汉模式，基于类初始化保护，可能会重排序，但是在初始化时候，线程无法获取到对象，所以安全。
 */
class InstanceFactory {
    private static class InstanceHolder {
        public static InstanceHolder instance = new InstanceHolder();
    }

    public static InstanceHolder getInstance() {
        return InstanceHolder.instance;
    }
}
