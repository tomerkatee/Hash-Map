public abstract class OAHashTable implements IHashTable {
	
	private HashTableElement [] table;
	private final HashTableElement DELETED = new HashTableElement(0, 0);
	//private int deletedCount = 0;
	private final double MAX_DELETED_PERCENT = 0.5;

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
			else if(table[probeIndex].GetKey() == key && table[probeIndex] != DELETED){
				return table[probeIndex];
			}
		}
		return null;
	}
	
	@Override
	public void Insert(HashTableElement hte) throws TableIsFullException,KeyAlreadyExistsException {
		if(Find(hte.GetKey()) != null){
			throw new KeyAlreadyExistsException(hte);
		}
		for (int i = 0; i < table.length; i++) {
			int probeIndex = Hash(hte.GetKey(), i);
			if(table[probeIndex] == null || table[probeIndex] == DELETED){
//				if(table[probeIndex] == DELETED){
//					deletedCount--;
//				}
				table[probeIndex] = hte;
				return;
			}
		}
		throw new TableIsFullException(hte);
	}
//	private void Rehash() {
//		HashTableElement[] fullTable = table;
//		table = new HashTableElement[table.length];
//		for(HashTableElement element : fullTable){
//			if(element != null && element != DELETED){
//				try {
//					Insert(element);
//				} catch(Exception ignored) {
//					return;
//				}
//			}
//		}
//	}
	@Override
	public void Delete(long key) throws KeyDoesntExistException {
		for (int i = 0; i < table.length; i++) {
			int probeIndex = Hash(key, i);
			if(table[probeIndex] == null){
				throw new KeyDoesntExistException(key);
			}
			if(table[probeIndex].GetKey() == key && table[probeIndex] != DELETED){
				table[probeIndex] = DELETED;
//				if((++deletedCount/(float)table.length) > MAX_DELETED_PERCENT){
//					//Rehash();
//					deletedCount = 0;
//				}
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
