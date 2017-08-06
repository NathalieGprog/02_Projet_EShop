package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.CommandeDaoImpl;
import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.entite.Commande;

@Service("commandeServiceBean")
@Transactional
public class CommandeService implements ICommandeService {

	@Autowired
	private IGeneriqueDao<Commande> commandeDaoImpl;
	/**
	 * @param commandeDao the commandeDao to set
	 */
	public void setCommandeDao(CommandeDaoImpl commandeDao) {
		this.commandeDaoImpl = commandeDao;
	}
	

	@Override
	public Commande ajouter(Commande commande) {
		commandeDaoImpl.ajouter(commande);
		return commande;
	}

	@Override
	public List<Commande> obtenirTous() {
		return (List<Commande>) commandeDaoImpl.obtenirTous();
	}

	@Override
	public void modifier(Commande commande) {
		commandeDaoImpl.modifier(commande);
	}

	@Override
	public void supprimer(Commande commande) {
		commandeDaoImpl.supprimer(commande);
	}

	@Override
	public Commande obtenirUn(int id) {
		return commandeDaoImpl.obtenirUn(id);
	}

	
}
