package fr.adaming.dao;


import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entite.LigneCommande;

@Repository
public class LigneCommandeDaoImpl implements IGeneriqueDao<LigneCommande>{

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
	public void ajouter(LigneCommande ligneCommande) {
		Session s = sf.getCurrentSession();
		s.save(ligneCommande);
	}

	@Override
	public List<LigneCommande> obtenirTous() {
		Session s = sf.getCurrentSession();
		String req = "FROM LigneCommande";
		Query query = s.createQuery(req);
		@SuppressWarnings("unchecked")
		List<LigneCommande> listeLigneCommandes = query.list();
		return listeLigneCommandes;
	}

	@Override
	public void modifier(LigneCommande ligneCommande) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(ligneCommande);
	}

	@Override
	public void supprimer(LigneCommande ligneCommande) {
		Session s = sf.getCurrentSession();
		s.delete(ligneCommande);
	}

	@Override
	public LigneCommande obtenirUn(int id) {
		Session s = sf.getCurrentSession();
		return (LigneCommande) s.get(LigneCommande.class, id);
	}

}
