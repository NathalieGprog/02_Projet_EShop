package fr.adaming.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entite.Client;

@Repository
public class ClientDaoImpl implements IGeneriqueDao<Client> {

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
	public void ajouter(Client client) {
		Session s = sf.getCurrentSession();
		s.save(client);
	}

	@Override
	public List<Client> obtenirTous() {
		Session s = sf.getCurrentSession();
		String req = "FROM Client";
		Query query = s.createQuery(req);
		@SuppressWarnings("unchecked")
		List<Client> listeClients = query.list();
		return listeClients;
	}

	@Override
	public void modifier(Client client) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(client);
	}

	@Override
	public void supprimer(Client client) {
		Session s = sf.getCurrentSession();
		s.delete(client);
	}

	@Override
	public Client obtenirUn(int id) {
		Session s = sf.getCurrentSession();
		return (Client) s.get(Client.class, id);
	}

}
