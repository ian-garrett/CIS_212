//Ian Garrett, igarrett@uoregon.edu
//Generic class structure for future projects involving occurrence lists and other such data structures
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class OccurrenceSet<T> implements Set<T> {
	
private HashMap<T, Integer> hashmap = new HashMap<T, Integer>();

@Override
public int size() {
	// TODO Auto-generated method stub
	return hashmap.size();
}

@Override
public boolean isEmpty() {
	// TODO Auto-generated method stub
	if (hashmap.isEmpty()){
		return true;
	}
	else{
		return false;
	}
}

@Override
public boolean contains(Object o) {
	// TODO Auto-generated method stub
	return hashmap.keySet().contains(o);
}

//used for both toArrays methods and toString method
private ArrayList<T> keyset_array(){
	ArrayList<T> array = new ArrayList<T>(hashmap.keySet());
	
	Collections.sort(array, new Comparator<T>(){
		
		public int compare(T o1, T o2){
			if (hashmap.get(o1) == hashmap.get(o2))
				return 0;
			else if (hashmap.get(o1) > hashmap.get(o2))
				return -1;
			else
				return 1;
		}
	});
	return array;
}



@Override
public Iterator<T> iterator() {
	// TODO Auto-generated method stub
		class Iter<T> implements Iterator {

			ArrayList<T> arr;
			int position = 0;

			public Iter() {
				arr = new ArrayList(hashmap.keySet());
			}

			@Override
			public boolean hasNext() {
				// TODO Auto-generated method stub
				position++;
				if (position == arr.size()) {
					return false;
				} else {
					return true;
				}
			}

			@Override
			public Object next() {
				// TODO Auto-generated method stub
				position++;
				if (arr.get(position) != null) {
					return hashmap.get(position);
				}
				return null;
			}

			@Override
			public void remove() {
				// TODO Auto-generated method stub
				if (arr.get(position) != null) {
					hashmap.remove(position);
					arr.remove(position);
				}
			}

		}
	Iter<T> iterater = new Iter<T>();
	return iterater;

}


@Override
public Object[] toArray() {
	// TODO Auto-generated method stub
	return keyset_array().toArray();
}

@Override
public <T> T[] toArray(T[] a) {
	// TODO Auto-generated method stub
	return keyset_array().toArray(a);
}

@Override
public boolean add(T e) {
	// TODO Auto-generated method stub
	Integer current_entry = hashmap.get(e);
	if (current_entry==null){
		hashmap.put(e, 1);
	}
	else {
		hashmap.put(e, current_entry+1);
	}

	return hashmap.keySet().contains(e);
}

@Override
public boolean remove(Object o) {
	// TODO Auto-generated method stub
	Integer current_entry = hashmap.get(o);
	if (current_entry!=null){ 
		hashmap.remove(o); 
	} 

	return !hashmap.keySet().contains(o);
}

@Override
public boolean containsAll(Collection<?> c) {
	// TODO Auto-generated method stub
	return hashmap.keySet().containsAll(c); 
}

@Override
public boolean addAll(Collection<? extends T> c) {
	// TODO Auto-generated method stub
	Integer begin_size = hashmap.size();
	for (T element: c){
		add(element);
	}
	Integer end_size = hashmap.size();
	if (begin_size != end_size){ //Used size check
		return true;
	}
	return false;
	
}

@Override
public boolean retainAll(Collection<?> c) {
	// TODO Auto-generated method stub
	Integer begin_size = hashmap.size();
	HashMap<T, Integer> new_hashmap = new HashMap<T, Integer>();
	for (Object element: c){
		if (hashmap.keySet().contains(element)){
			new_hashmap.put((T) element,hashmap.get(element));
		}
	}
	Integer end_size = new_hashmap.size();
	hashmap=new_hashmap;
	if (begin_size != end_size){ //Used size check
		return true;
	}
	return false;
}

@Override
public boolean removeAll(Collection<?> c) {
	// TODO Auto-generated method stub
	Integer begin_size = hashmap.size();
	for (Object element: c){
		hashmap.remove(element);
	}
	Integer end_size = hashmap.size();
	if (begin_size != end_size){ //Used size check
		return true;
	}
	return false;
}

@Override
public void clear() {
	// TODO Auto-generated method stub
	hashmap.clear();
	
}

public String toString(){
	return keyset_array().toString();
}
}