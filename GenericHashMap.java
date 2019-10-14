package lecture9a22;

import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.xml.ws.spi.http.HttpContext;

import lecture4.array;
import lecture9a21.GenericLinkedList;

public class GenericHashMap<K, V> {
	private class HTPair {
		K key;
		V value;

		HTPair(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public boolean equals(Object other) {
			HTPair op = (HTPair) other; /// how??
			return this.key.equals(op.key);
		}

		public String toString() {
			return "{" + this.key + "-" + this.value + "}";
		}
	}

	public static final int DEFAULT_CAPACITY = 10;
	private GenericLinkedList<HTPair>[] bucketArray;
	private int size;

	public GenericHashMap() {
		this(DEFAULT_CAPACITY);/// means??
	}

	public GenericHashMap(int Capacity) {
		this.bucketArray = new GenericLinkedList[Capacity];
		this.size = 0;
	}

	public void put(K key, V value) throws Exception {
		int bi = HashFunction(key);
		HTPair np = new HTPair(key, value);
		GenericLinkedList<HTPair> bucket = this.bucketArray[bi];
		if (bucket == null) {
			bucket = new GenericLinkedList<>();
			bucket.addLast(np);
			this.size++;
			this.bucketArray[bi] = bucket;
		} else {
			int idx = bucket.find(np);
			if (idx == -1) {
				bucket.addLast(np);
				this.size++;
			} else {
				HTPair getp = bucket.getAt(idx);
				getp.value = value;
				
			}

		}
		double lamda = (this.size*1.0)/this.bucketArray.length;
		if(lamda>0.75)
			rehash();

	}

	private void rehash() throws Exception {
		GenericLinkedList<HTPair>[] oba = this.bucketArray;
		this.bucketArray =  new GenericLinkedList[2*oba.length];
		this.size=0;
		for(GenericLinkedList<HTPair> ob : oba) {
			while(ob!=null && !ob.isEmpty()) {
				HTPair getp = ob.removeFirst();
				this.put(getp.key, getp.value);
			}
		}
		
	}

	private int HashFunction(K key) {
		int hc = key.hashCode();
		int bi = Math.abs(hc) % this.bucketArray.length;
		return bi;
	}

	public void display() {
		for (int i = 0; i < bucketArray.length; i++) {
			GenericLinkedList<HTPair> bucket = bucketArray[i];
			if (bucket == null || bucket.isEmpty())
				System.out.println("NULL");
			else
				bucket.display();
		}
		System.out.println("----------------------------------");
	}

	public V get(K key) throws Exception {
		int bi = HashFunction(key);
		HTPair np = new HTPair(key, null);
		GenericLinkedList<HTPair> bucket = this.bucketArray[bi];
		if (bucket == null) {
			return null;
		} else {
			int idx = bucket.find(np);
			if (idx == -1) {
				return null;
			} else {
				HTPair getp = bucket.getAt(idx);
				return getp.value;
			}

		}
	}
	public V remove(K key) throws Exception {
		int bi = HashFunction(key);
		HTPair np = new HTPair(key, null);
		GenericLinkedList<HTPair> bucket = this.bucketArray[bi];
		if (bucket == null) {
			return null;
		} else {
			int idx = bucket.find(np);
			if (idx == -1) {
				return null;
			} else {
				
				this.size--;
				return (V) bucket.removeAt(idx);
			}

		}
	}
}
