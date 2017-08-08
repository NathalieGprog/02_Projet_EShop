package fr.adaming.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import fr.adaming.dao.IProduitDao;
import fr.adaming.dao.ProduitDaoImpl;
import fr.adaming.entite.Categorie;
import fr.adaming.entite.Produit;

@Service("produitServiceBean")
@Transactional
public class ProduitService implements IProduitService {

	@Autowired
	private IProduitDao produitDaoImpl;
	/**
	 * @param produitDao the produitDao to set
	 */
	public void setProduitDao(ProduitDaoImpl produitDao) {
		this.produitDaoImpl = produitDao;
	}
	

	@Override
	public Produit ajouter(Produit produit) {
		produitDaoImpl.ajouter(produit);
		return produit;
	}

	@Override
	public List<Produit> obtenirTous() {
		return produitDaoImpl.obtenirTous();
	}

	@Override
	public void modifier(Produit produit) {
		produitDaoImpl.modifier(produit);
	}

	@Override
	public void supprimer(Produit produit) {
		produitDaoImpl.supprimer(produit);
	}

	@Override
	public Produit obtenirUn(int id) {
		return produitDaoImpl.obtenirUn(id);
	}


	@Override
	public List<Produit> obtenirTousProduitsParCategorie(Categorie categorie) {
		
		List<Produit> lProduits = (List<Produit>) produitDaoImpl.obtenirTous();
		List<Produit> lProduitsParCat = new ArrayList<Produit>();
		int i = 0;
		for (Produit p : lProduits){
			System.out.println(p.getCategorie());
			if (categorie.equals(p.getCategorie())){
				lProduitsParCat.add(p);
				i++;
			}
		}
		if (i>0){
			return lProduitsParCat;
		}else{
		return null;
		}
	}
	
	@Override
	public Map<Produit,Categorie> obtenirCategorieDuProduit(){
		return produitDaoImpl.obtenirCategorieDuProduit();
		
	}
	
}
