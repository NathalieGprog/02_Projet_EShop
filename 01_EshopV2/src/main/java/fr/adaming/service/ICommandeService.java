package fr.adaming.service;

import java.util.Collection;

import fr.adaming.entite.Commande;

public interface ICommandeService extends IGeneriqueService<Commande> {
	public Commande ajouter(Commande t);
	public Collection<Commande> obtenirTous();
	public void modifier(Commande t);
	public void supprimer(Commande t);
	public Commande obtenirUn(int id);
		
}
