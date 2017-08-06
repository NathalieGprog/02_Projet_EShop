package fr.adaming.service;

import java.util.Collection;

import fr.adaming.entite.Client;

public interface IClientService extends IGeneriqueService<Client> {
	public void ajouter(Client t);
	public Collection<Client> obtenirTous();
	public void modifier(Client t);
	public void supprimer(Client t);
	public Client obtenirUn(int id);
		
}
