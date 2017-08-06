package fr.adaming.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entite.Commande;

@Repository
public class CommandeDaoImpl implements IGeneriqueDao<Commande> {

	@Autowired
	private SessionFactory sf;

	/**
	 * @param sf
	 *            the sf to set
	 */
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	@Override
	public void ajouter(Commande commande) {
		Session s = sf.getCurrentSession();
		s.save(commande);
	}

	@Override
	public List<Commande> obtenirTous() {
		Session s = sf.getCurrentSession();
		String req = "FROM Commande";
		Query query = s.createQuery(req);
		@SuppressWarnings("unchecked")
		List<Commande> listeCommandes = query.list();
		return listeCommandes;
	}

	@Override
	public void modifier(Commande commande) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(commande);
	}

	@Override
	public void supprimer(Commande commande) {
		Session s = sf.getCurrentSession();
		s.delete(commande);
	}

	@Override
	public Commande obtenirUn(int id) {
		Session s = sf.getCurrentSession();
		return (Commande) s.get(Commande.class, id);
	}

}
