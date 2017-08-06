package fr.adaming.model;

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

@Entity
@Table(name = "produits")
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_produit")
	private int idProduit;
	private String designation;
	private String description;
	private double prix;
	private int quantite;
	@Column(nullable = false, columnDefinition = "TINYINT", length = 1)
	private boolean selectionne;

	@ManyToOne
	@JoinColumn(name = "categorie_id", referencedColumnName = "id_categorie")
	private Categorie categorie;

	@OneToMany(mappedBy = "produit", cascade = CascadeType.ALL)
	private List<LigneCommande> lLignesCommandes;

	/**
	 * Constructeur vide
	 */
	public Produit() {
		super();
	}

	/**
	 * 
	 * @param designation
	 * @param description
	 * @param prix
	 * @param quantite
	 * @param selectionne
	 */
	public Produit(String designation, String description, double prix, int quantite, boolean selectionne) {
		super();
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
	}

	/**
	 * 
	 * @param idProduit
	 * @param designation
	 * @param description
	 * @param prix
	 * @param quantite
	 * @param selectionne
	 */
	public Produit(int idProduit, String designation, String description, double prix, int quantite,
			boolean selectionne) {
		super();
		this.idProduit = idProduit;
		this.designation = designation;
		this.description = description;
		this.prix = prix;
		this.quantite = quantite;
		this.selectionne = selectionne;
	}

	/**
	 * @return the idProduit
	 */
	public int getIdProduit() {
		return idProduit;
	}

	/**
	 * @param idProduit
	 *            the idProduit to set
	 */
	public void setIdProduit(int idProduit) {
		this.idProduit = idProduit;
	}

	/**
	 * @return the designation
	 */
	public String getDesignation() {
		return designation;
	}

	/**
	 * @param designation
	 *            the designation to set
	 */
	public void setDesignation(String designation) {
		this.designation = designation;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 *            the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**
	 * @param prix
	 *            the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/**
	 * @return the quantite
	 */
	public int getQuantite() {
		return quantite;
	}

	/**
	 * @param quantite
	 *            the quantite to set
	 */
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/**
	 * @return the selectionne
	 */
	public boolean isSelectionne() {
		return selectionne;
	}

	/**
	 * @param selectionne
	 *            the selectionne to set
	 */
	public void setSelectionne(boolean selectionne) {
		this.selectionne = selectionne;
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
	 * @return the categorie
	 */
	public Categorie getCategorie() {
		return categorie;
	}

	/**
	 * @param categorie
	 *            the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	// /* (non-Javadoc)
	// * @see java.lang.Object#toString()
	// */
	// @Override
	// public String toString() {
	// return "Produit [designation=" + designation + ", description=" +
	// description + ", prix=" + prix + ", quantite="
	// + quantite + ", selectionne=" + selectionne + ", categorie=" + categorie
	// + ", lLignesCommandes="
	// + lLignesCommandes + "]";
	// }
	//
	//

}
