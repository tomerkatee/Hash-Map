import java.util.Random;

public class LPHashTable extends OAHashTable {

	ModHash hashFunc;

	public LPHashTable(int m, long p) {
		super(m);
		hashFunc = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (hashFunc.Hash(x) + i) % getSize();
	}
	
}
