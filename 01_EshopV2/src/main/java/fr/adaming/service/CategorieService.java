package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.CategorieDaoImpl;
import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.entite.Categorie;

@Service("categorieServiceBean")
@Transactional
public class CategorieService implements ICategorieService{

	@Autowired
	private IGeneriqueDao<Categorie> categorieDaoImpl;
	/**
	 * @param categorieDao the categorieDao to set
	 */
	public void setCategorieDao(CategorieDaoImpl categorieDao) {
		this.categorieDaoImpl = categorieDao;
	}
	

	@Override
	public void ajouter(Categorie categorie) {
		categorieDaoImpl.ajouter(categorie);
	}

	@Override
	public List<Categorie> obtenirTous() {
		return (List<Categorie>) categorieDaoImpl.obtenirTous();
	}

	@Override
	public void modifier(Categorie categorie) {
		categorieDaoImpl.modifier(categorie);
	}

	@Override
	public void supprimer(Categorie categorie) {
		categorieDaoImpl.supprimer(categorie);
	}


	@Override
	public Categorie obtenirUn(int id) {
		return categorieDaoImpl.obtenirUn(id);
	}



	
	
}
