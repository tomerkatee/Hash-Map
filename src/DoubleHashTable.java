/**name1: Tomer Katee
 id1: 214166027
 username1: tomerkatee
 name2: Ella Kelner
 id2: 316158898
 username2: ellakelner
 */
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
		return Math.floorMod(hashFunc1.Hash(x) + i * (hashFunc2.Hash(x) + 1), getSize());
	}
}
