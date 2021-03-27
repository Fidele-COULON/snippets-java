package fr.fidtec.demos;

public class DoubleCheckingLockingSingleton {
	
	private static volatile DoubleCheckingLockingSingleton instance;
    
	private DoubleCheckingLockingSingleton() {
        System.out.println("Cr�ation du Singleton au premier appel");
    }
	
	public static DoubleCheckingLockingSingleton getInstance() {
        
		if (instance == null) {
            synchronized (DoubleCheckingLockingSingleton .class) {
                if (instance == null) {
                    instance = new DoubleCheckingLockingSingleton();
                }
            }
        }
        
        return instance;
    }
}
