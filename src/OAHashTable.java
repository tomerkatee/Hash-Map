/**name1: Tomer Katee
 id1: 214166027
 username1: tomerkatee
 name2: Ella Kelner
 id2: 316158898
 username2: ellakelner
 */
public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	private final HashTableElement DELETED = new HashTableElement(0, 0);

	public OAHashTable(int m) {
		this.table = new HashTableElement[m];
	}


	public int getSize(){
		return table.length;
	}

	@Override
	public HashTableElement Find(long key) {
		for (int i = 0; i < table.length; i++) {
            int probeIndex = Hash(key, i);
            if(table[probeIndex] == null){
                return null;
            }
            else if(table[probeIndex].GetKey() == key && table[probeIndex] != DELETED) {
                return table[probeIndex];
            }
		}
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		for (int i = 0; i < table.length; i++) {
			int probeIndex = Hash(hte.GetKey(), i);
			if(table[probeIndex] == DELETED){
				if(Find(hte.GetKey()) != null){
					throw new KeyAlreadyExistsException(hte);
				}
				table[probeIndex] = hte;
				return;
			}
			else if(table[probeIndex] == null){
				table[probeIndex] = hte;
				return;
			}
			else if(table[probeIndex].GetKey() == hte.GetKey()){
				throw new KeyAlreadyExistsException(hte);
			}
		}
		throw new TableIsFullException(hte);
	}

	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		for (int i = 0; i < table.length; i++) {
			int probeIndex = Hash(key, i);
			if(table[probeIndex] == null){
				throw new KeyDoesntExistException(key);
			}
			if(table[probeIndex].GetKey() == key && table[probeIndex] != DELETED){
				table[probeIndex] = DELETED;
				return;
			}
		}
		throw new KeyDoesntExistException(key);
	}

	/**
	 * 
	 * @param x - the key to hash
	 * @param i - the index in the probing sequence
	 * @return the index into the hash table to place the key x
	 */
	public abstract int Hash(long x, int i);
}
