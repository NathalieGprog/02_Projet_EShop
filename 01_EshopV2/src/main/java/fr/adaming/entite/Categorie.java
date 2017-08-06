package fr.adaming.entite;

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
@Table(name = "categories")
public class Categorie implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categorie")
	private int idCategorie;
	@Column(name = "nom_categorie")
	private String nomCategorie;
	@Column(name = "description_cat")
	private String description;

	@OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
	private List<Produit> lProduits;

	public Categorie() {
		super();
	}

	/**
	 * 
	 * @param nomCategorie
	 * @param description
	 */
	public Categorie(String nomCategorie, String description) {
		super();
		this.nomCategorie = nomCategorie;
		this.description = description;
	}

	/**
	 * 
	 * @param idCategorie
	 * @param nomCategorie
	 * @param description
	 */
	public Categorie(int idCategorie, String nomCategorie, String description) {
		super();
		this.idCategorie = idCategorie;
		this.nomCategorie = nomCategorie;
		this.description = description;
	}

	/**
	 * @return the idCategorie
	 */
	public int getIdCategorie() {
		return idCategorie;
	}

	/**
	 * @param idCategorie
	 *            the idCategorie to set
	 */
	public void setIdCategorie(int idCategorie) {
		this.idCategorie = idCategorie;
	}

	/**
	 * @return the nomCategorie
	 */
	public String getNomCategorie() {
		return nomCategorie;
	}

	/**
	 * @param nomCategorie
	 *            the nomCategorie to set
	 */
	public void setNomCategorie(String nomCategorie) {
		this.nomCategorie = nomCategorie;
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
	 * @return the lProduits
	 */
	public List<Produit> getlProduits() {
		return lProduits;
	}

	/**
	 * @param lProduits
	 *            the lProduits to set
	 */
	public void setlProduits(List<Produit> lProduits) {
		this.lProduits = lProduits;
	}

}
