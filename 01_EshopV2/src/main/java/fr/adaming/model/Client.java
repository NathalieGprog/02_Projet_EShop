package fr.adaming.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "clients")
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_client")
	private int idClient;
	@Column(name = "nom_client")
	private String nomClient;
	private String adresse;
	private String email;
	private String tel;

	@OneToMany(mappedBy = "client", cascade = CascadeType.ALL)
	private List<Commande> lCommandes;

	/**
	 * Constructeur vide
	 */
	public Client() {
		super();
	}

	/**
	 * @param nomClient
	 * @param adresse
	 * @param email
	 * @param tel
	 */
	public Client(String nomClient, String adresse, String email, String tel) {
		super();
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	/**
	 * @param idClient
	 * @param nomClient
	 * @param adresse
	 * @param email
	 * @param tel
	 */
	public Client(int idClient, String nomClient, String adresse, String email, String tel) {
		super();
		this.idClient = idClient;
		this.nomClient = nomClient;
		this.adresse = adresse;
		this.email = email;
		this.tel = tel;
	}

	/**
	 * @return the idClient
	 */
	public int getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient
	 *            the idClient to set
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return the nomClient
	 */
	public String getNomClient() {
		return nomClient;
	}

	/**
	 * @param nomClient
	 *            the nomClient to set
	 */
	public void setNomClient(String nomClient) {
		this.nomClient = nomClient;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the tel
	 */
	public String getTel() {
		return tel;
	}

	/**
	 * @param tel
	 *            the tel to set
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}

	/**
	 * @return the lCommandes
	 */
	public List<Commande> getlCommandes() {
		return lCommandes;
	}

	/**
	 * @param lCommandes
	 *            the lCommandes to set
	 */
	public void setlCommandes(List<Commande> lCommandes) {
		this.lCommandes = lCommandes;
	}

}
