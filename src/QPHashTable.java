import java.util.Random;

public class QPHashTable extends OAHashTable {

	private ModHash hashFunc;

	public QPHashTable(int m, long p) {
		super(m);
		hashFunc = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		return (hashFunc.Hash(x) + i*i) % getSize();
	}
}
