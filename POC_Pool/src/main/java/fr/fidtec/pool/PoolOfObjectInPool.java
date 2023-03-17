package fr.fidtec.pool;

import nf.fr.eraasoft.pool.ObjectPool;
import nf.fr.eraasoft.pool.PoolException;
import nf.fr.eraasoft.pool.PoolSettings;

// Pattern Singleton
public class Pool_ObjectInPool {

	// Valeurs par d�faut de PoolSettings
	private static final int MIN_SIZE = 1;
	private static final int MAX_SIZE = 10;
	private static final boolean MODE_DEBUG = false;
	private static final int MAX_IDLES = 5;
	private static final int MAX_WAIT = 5;
	private static final boolean VALIDATE_WHEN_RETURN = false;
	
	// Valeur partag�e par toutes les instances de PoolSettings
	private static final int TIME_BETWEEN_TWO_CONTROLE = 30;
	
	private static PoolSettings<ObjectInPool> poolSettings = null;	
	private static int size = MIN_SIZE;
	

	private Pool_ObjectInPool() {
		// Create a new PoolSetting instance with a Poolable object, ici ObjectInPool
		// la gestion du pool est effectu�e par PoolableObject_ObjectInPool
		poolSettings = new PoolSettings<ObjectInPool>(new PoolableObject_ObjectInPool());
		
		// Param�trage du pool
		poolSettings.min(MIN_SIZE)       // taille min du pool, cr�e min instance au d�marrage du pool(make), DEFAULT_MIN = 1
				    .max(MAX_SIZE)       // taille max du pool, apr�s retourne des null, DEFAULT_MAX = 10
				    .debug(MODE_DEBUG)   // affiche ou non les sysout du code, par d�fault false			
					.maxIdle(MAX_IDLES)  // nombre max d'�lements dispos, si idles > maxIdles alors le pool est nettoy� des idles en trop (par d�faut = DEFAULT_MIN)
					.maxWait(MAX_WAIT)   // temps d'attente d'un �l�ment disponible (en secondes) sinon renvoie null, DEFAUL_MAX_WAIT = 5
					.validateWhenReturn(VALIDATE_WHEN_RETURN); // faut-il appeler validate quand l'objet en remit dans le pool, par d�faut false
					
		PoolSettings.timeBetweenTwoControls(TIME_BETWEEN_TWO_CONTROLE); // Temps en secondes entre chaque v�rification du pool (nettoyage des idles), par d�faut 30 s
	}
	
	private static ObjectPool<ObjectInPool> getPoolInstance() {
		if (poolSettings == null ) {
			new Pool_ObjectInPool();
		}
		
		return poolSettings.pool();
	}	
	
	public static ObjectInPool getObj() throws PoolException {
		ObjectInPool o = getPoolInstance().getObj();
		if (o != null) {
			size ++;
		}
		return o;		
	}
	
	public static void returnObj(ObjectInPool objectInPool) throws PoolException {
		size --;
		getPoolInstance().returnObj(objectInPool);		
	}
	
	public static int getSize() throws PoolException {
		return size;		
	}
	
	public static String getStatut() throws PoolException {
		return poolSettings.max() + " - Idle:" + poolSettings.maxIdle() + " - Max:" + poolSettings.max() + " - MaxWait:" + poolSettings.maxWait();		
	}
	
	public static void cleanPool() {
		poolSettings.clearCurrentPool();
		size = 0;
	}
	
}
