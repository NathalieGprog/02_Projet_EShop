package fr.adaming.dao;

import java.util.Collection;

/**
 * Interface g�n�rique pour le DAO, permet de r�aliser les fonctions de base du CRUD
 * @author INTI2017FORMATION
 *
 * @param <T> T est l'objet � manipuler dans la DAO
 */
public interface IGeneriqueDao<T> {
	
	/**
	 * Permet l'ajout d'un Objet T dans la base de donn�es
	 * @param t Ce param�tre est � rentrer dans la base de donn�es
	 * @return retourne l'objet avec la cl� qui lui a �t� assign� par Hibernate
	 */
	public T ajouter(T t);
	
	/**
	 * M�thode retournant la liste des objets T pr�sent en base de donn�es
	 * @return Liste Object T : objet pr�sent en base de donn�es
	 */
	public Collection<T> obtenirTous();

	/**
	 * M�thode permettant de modifier l'objet T en base de donn�es
	 * @param t Objet T qui doit �tre modifi�
	 */
	public void modifier(T t);
	
	/**
	 * M�thode permettant de supprimer un objet T en base de donn�es
	 * @param t Objet T � supprimer de la base de donn�es
	 */
	public void supprimer(T t);
	
	/**
	 * Methode permettant de r�cup�rer un objet T en base de donn�es.
	 * @param id de l'objet � r�cup�rer
	 * @return l'objet r�cup�rer en base de donn�es
	 */
	public T obtenirUn(int id);

}
