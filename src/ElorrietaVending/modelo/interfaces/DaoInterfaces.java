package ElorrietaVending.modelo.interfaces;

import java.util.ArrayList;

public interface DaoInterfaces <T> {

	public ArrayList<T> getAll();
	public T getById(int id);
	public void insert(T log);
	
}
