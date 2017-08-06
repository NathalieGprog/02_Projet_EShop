package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.dao.LigneCommandeDaoImpl;
import fr.adaming.entite.LigneCommande;

@Service("ligneCommandeServiceBean")
@Transactional
public class LigneCommandeService implements ILigneCommandeService {

	@Autowired
	private IGeneriqueDao<LigneCommande> ligneCommandeDaoImpl;
	/**
	 * @param ligneCommandeDao the ligneCommandeDao to set
	 */
	public void setLigneCommandeDao(LigneCommandeDaoImpl ligneCommandeDao) {
		this.ligneCommandeDaoImpl = ligneCommandeDao;
	}
	

	@Override
	public void ajouter(LigneCommande ligneCommande) {
		ligneCommandeDaoImpl.ajouter(ligneCommande);
	}

	@Override
	public List<LigneCommande> obtenirTous() {
		return (List<LigneCommande>) ligneCommandeDaoImpl.obtenirTous();
	}

	@Override
	public void modifier(LigneCommande ligneCommande) {
		ligneCommandeDaoImpl.modifier(ligneCommande);
	}

	@Override
	public void supprimer(LigneCommande ligneCommande) {
		ligneCommandeDaoImpl.supprimer(ligneCommande);
	}

	@Override
	public LigneCommande obtenirUn(int id) {
		return ligneCommandeDaoImpl.obtenirUn(id);
	}

	
}
