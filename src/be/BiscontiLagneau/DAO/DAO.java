package be.BiscontiLagneau.DAO;

import java.util.List;

public abstract class DAO<T> {
	
	public DAO(){
	}
	
	public abstract boolean ajouter(T obj);
	
	public abstract boolean supprimer(T obj);
	
	public abstract boolean modifier(T obj);
	
	public abstract T chercher(int id);
	
	public abstract List<T> recupererTout();
}
