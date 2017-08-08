package fr.adaming.service;

import java.util.Collection;

/**
 * Interface g�n�rique de la couche service
 * @author INTI2017FORMATION
 *
 * @param <T> objet g�n�rique � toutes les interfaces qui �tende de celle-ci
 */
public interface IGeneriqueService<T> {
	
	/**
	 * M�thode ajouter de la couche service
	 * @param t objet � ajouter
	 * @return retourne l'objet ajout� avec son identifiant en base de donn�es
	 */
	public T ajouter(T t);

	/**
	 * M�thode obtenir tous de la couche service
	 * @return la Liste des objets de la bd
	 */
	public Collection<T> obtenirTous();

	/**
	 * m�thode modifier de la couche service
	 * @param t objet � modifier
	 */
	public void modifier(T t);

	/**
	 * m�thode supprimer de la couche service
	 * @param t objet � supprimer
	 */
	public void supprimer(T t);

	/**
	 * m�thode obtenir un objet avec l'id de la couche service
	 * @param id de l'objet � r�cup�rer
	 * @return l'objet issu de la base de donn�es
	 */
	public T obtenirUn(int id);

}
