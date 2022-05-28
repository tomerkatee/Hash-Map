import java.util.Random;

public class AQPHashTable extends OAHashTable {

	private ModHash hashFunc;
	public AQPHashTable(int m, long p) {
		super(m);
		hashFunc = ModHash.GetFunc(m, p);
	}
	
	@Override
	public int Hash(long x, int i) {
		int preMod = (hashFunc.Hash(x) + (i%2==0 ? 1 : -1) * i*i) % getSize();
		return preMod < 0 ? getSize() + preMod : preMod;
	}
}
