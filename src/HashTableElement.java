/**name1: Tomer Katee
 id1: 214166027
 username1: tomerkatee
 name2: Ella Kelner
 id2: 316158898
 username2: ellakelner
 */
public class HashTableElement{
	private long key;
	private long value;
	
	public HashTableElement(long key, long value) {
		this.key = key;
		this.value = value;
	}
	
	public long GetKey() { return this.key;}
	
	public long GetValue() { return this.value;}
}