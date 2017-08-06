package fr.adaming.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.adaming.entite.Categorie;
import fr.adaming.entite.Produit;

@Repository
public class ProduitDaoImpl implements IProduitDao {

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
	public void ajouter(Produit produit) {
		Session s = sf.getCurrentSession();
		s.save(produit);
	}

	@Override
	public List<Produit> obtenirTous() {
		Session s = sf.getCurrentSession();
		String req = "FROM Produit";
		Query query = s.createQuery(req);
		@SuppressWarnings("unchecked")
		List<Produit> listeProduit = query.list();
		return listeProduit;
	}

	@Override
	public void modifier(Produit produit) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(produit);
	}

	@Override
	public void supprimer(Produit produit) {
		Session s =  sf.getCurrentSession();
		s.delete(produit);
	}

	@Override
	public Produit obtenirUn(int id) {
		Session s = sf.getCurrentSession();
		return (Produit) s.get(Produit.class, id);
	}

	
	public Map<Produit,Categorie> obtenirCategorieDuProduit() {
		Session s = sf.getCurrentSession();
		String req = "FROM Produit";
		String req2 = "FROM Categorie";
		Query query = s.createQuery(req);
		List<Produit> listeProduits = query.list();
		Query query2 = s.createQuery(req2);
		List<Categorie> listeProduits2 = query2.list();
		
		Map<Produit,Categorie> listeProduit =new HashMap<Produit,Categorie>();
		for (int i = 0 ; i<listeProduits2.size(); i++){
             Produit produit = new Produit();
             
             produit = (Produit) listeProduits.get(i);

             Categorie categorie = listeProduits2.get(i);

             listeProduit.put(produit, categorie);
         }
 		return listeProduit;
		
	}
	
	public int obtenirCleEtrangere(int id){
		Session s = sf.getCurrentSession();
		String req2 = "SELECT idCategorie FROM Produit WHERE id=:idProduit";
		Query query2 = s.createQuery(req2);
		return (int) query2.uniqueResult();
	}
	
	public List<Produit> obtenirProduitParCategorie(){
		Session s = sf.getCurrentSession();
		String req3 = "SELECT p FROM Produit AS p WHERE p.id_cat = pIdCat";
		Query query = s.createQuery(req3);
		@SuppressWarnings("unchecked")
		List<Produit> listeProduit = query.list();
		return listeProduit;
	}
}
