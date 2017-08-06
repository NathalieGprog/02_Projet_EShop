package fr.adaming.entite;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "commandes")
public class Commande implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_commande")
	private int idCommande;
	@Temporal(TemporalType.DATE)
	@Column(name = "date_commande")
	private Date dateCommande;

	@OneToMany(mappedBy = "commande", cascade = CascadeType.ALL)
	private List<LigneCommande> lLignesCommandes;

	@ManyToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id_client")
	private Client client;

	/**
	 * Constructeur vide
	 */
	public Commande() {
		super();
	}

	/**
	 * @param dateCommande
	 */
	public Commande(Date dateCommande) {
		super();
		this.dateCommande = dateCommande;
	}

	/**
	 * @param idCommande
	 * @param dateCommande
	 */
	public Commande(int idCommande, Date dateCommande) {
		super();
		this.idCommande = idCommande;
		this.dateCommande = dateCommande;
	}

	/**
	 * @return the idCommande
	 */
	public int getIdCommande() {
		return idCommande;
	}

	/**
	 * @param idCommande
	 *            the idCommande to set
	 */
	public void setIdCommande(int idCommande) {
		this.idCommande = idCommande;
	}

	/**
	 * @return the dateCommande
	 */
	public Date getDateCommande() {
		return dateCommande;
	}

	/**
	 * @param dateCommande
	 *            the dateCommande to set
	 */
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	/**
	 * @return the lLignesCommandes
	 */
	public List<LigneCommande> getlLignesCommandes() {
		return lLignesCommandes;
	}

	/**
	 * @param lLignesCommandes
	 *            the lLignesCommandes to set
	 */
	public void setlLignesCommandes(List<LigneCommande> lLignesCommandes) {
		this.lLignesCommandes = lLignesCommandes;
	}

	/**
	 * @return the client
	 */
	public Client getClient() {
		return client;
	}

	/**
	 * @param client
	 *            the client to set
	 */
	public void setClient(Client client) {
		this.client = client;
	}

}
