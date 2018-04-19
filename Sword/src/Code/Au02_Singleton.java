package Code;
import java.util.Vector;
public class Au02_Singleton {
	private Au02_Singleton() {
	};
	
	private static Au02_Singleton instance = new Au02_Singleton();
	
	public static Au02_Singleton getInstance() {
		return instance;
	}
}
