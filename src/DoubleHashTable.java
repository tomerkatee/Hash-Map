import java.util.Random;

public class DoubleHashTable extends OAHashTable {

	ModHash hashFunc1, hashFunc2;
	public DoubleHashTable(int m, long p) {
		super(m);
		hashFunc1 = ModHash.GetFunc(m, p);
		hashFunc2 = ModHash.GetFunc(m-1, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (int)((hashFunc1.Hash(x) + (long)i*(hashFunc2.Hash(x)+1)) % getSize());
	}
	
}
