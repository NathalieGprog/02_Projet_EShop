package fr.adaming.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.adaming.dao.ClientDaoImpl;
import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.entite.Client;

@Service("clientServiceBean")
@Transactional
public class ClientService implements IClientService {

	@Autowired
	private IGeneriqueDao<Client> clientDaoImpl;
	/**
	 * @param clientDao the clientDao to set
	 */
	public void setClientDao(ClientDaoImpl clientDao) {
		this.clientDaoImpl = clientDao;
	}
	

	@Override
	public Client ajouter(Client client) {
		clientDaoImpl.ajouter(client);
		return client;
	}

	@Override
	public List<Client> obtenirTous() {
		return (List<Client>) clientDaoImpl.obtenirTous();
	}

	@Override
	public void modifier(Client client) {
		clientDaoImpl.modifier(client);
	}

	@Override
	public void supprimer(Client client) {
		clientDaoImpl.supprimer(client);
	}

	@Override
	public Client obtenirUn(int id) {
		return clientDaoImpl.obtenirUn(id);
	}

	
}
