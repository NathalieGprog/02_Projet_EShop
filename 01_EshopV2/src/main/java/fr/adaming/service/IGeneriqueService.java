package fr.adaming.service;

import java.util.Collection;

public interface IGeneriqueService<T> {

	public T ajouter(T t);
	public Collection<T> obtenirTous();
	public void modifier(T t);
	public void supprimer(T t);
	public T obtenirUn(int id);
	
}
