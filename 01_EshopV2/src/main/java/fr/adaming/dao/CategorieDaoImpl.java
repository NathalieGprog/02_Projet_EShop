package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entite.Categorie;

@Repository
public class CategorieDaoImpl implements IGeneriqueDao<Categorie> {

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
	public Categorie ajouter(Categorie categorie) {
		Session s = sf.getCurrentSession();
		s.save(categorie);
		return categorie;
	}

	@Override
	public List<Categorie> obtenirTous() {
		Session s = sf.getCurrentSession();
		String req = "FROM Categorie";
		Query query = s.createQuery(req);
		@SuppressWarnings("unchecked")
		List<Categorie> listeCategorie = query.list();
		return listeCategorie;
	}

	@Override
	public void modifier(Categorie categorie) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(categorie);
	}

	@Override
	public void supprimer(Categorie categorie) {
		Session s = sf.getCurrentSession();
		s.delete(categorie);
	}

	@Override
	public Categorie obtenirUn(int id) {
		Session s = sf.getCurrentSession();
		return (Categorie) s.get(Categorie.class, id);
	}

}
