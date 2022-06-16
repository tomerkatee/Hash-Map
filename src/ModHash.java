/**name1: Tomer Katee
 id1: 214166027
 username1: tomerkatee
 name2: Ella Kelner
 id2: 316158898
 username2: ellakelner
 */
public class ModHash {

	private int m;
	private long a, b, p;

	public ModHash(long a, long b, int m, long p) {
		this.m = m;
		this.a = a;
		this.b = b;
		this.p = p;
	}

	public static ModHash GetFunc(int m, long p){
		return new ModHash(generateRandomLong(1, p), generateRandomLong(0, p), m, p);
	}
	private static long generateRandomLong(long inclusiveLower, long exclusiveUpper){
		return inclusiveLower + (long)(Math.random()*(exclusiveUpper - inclusiveLower));
	}
	
	public int Hash(long key) {
		return (int)((a*key + b) % p) % m;
	}
}
