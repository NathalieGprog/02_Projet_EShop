package fr.adaming.service;

import java.util.Collection;

import fr.adaming.entite.LigneCommande;

public interface ILigneCommandeService extends IGeneriqueService<LigneCommande> {
	public LigneCommande ajouter(LigneCommande t);

	public Collection<LigneCommande> obtenirTous();

	public void modifier(LigneCommande t);

	public void supprimer(LigneCommande t);

	public LigneCommande obtenirUn(int id);

}
