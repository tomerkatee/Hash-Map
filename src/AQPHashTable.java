/**name1: Tomer Katee
 id1: 214166027
 username1: tomerkatee
 name2: Ella Kelner
 id2: 316158898
 username2: ellakelner
 */
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
