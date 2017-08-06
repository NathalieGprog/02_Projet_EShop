package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.adaming.entite.Categorie;
import fr.adaming.entite.Produit;
import fr.adaming.service.IProduitService;

@ManagedBean(name = "produitMB")
@RequestScoped
public class ProduitManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Produit produit;
	private List<Produit> lProduits;
	private Categorie categorie;
	// private Map<String, Categorie> mapCatParNom;

	@ManagedProperty(value = "#{produitServiceBean}")
	private IProduitService produitService;
	// @ManagedProperty(value = "#{categorieServiceBean}")
	// private ICategorieService categorieService;

	// private IGeneriqueService<Categorie> categorieService = new
	// CategorieService();
	/**
	 * Constructeur vide
	 */
	public ProduitManagedBean() {
		this.produit = new Produit();
		this.categorie = new Categorie();
	}

	@PostConstruct // la méthode sera exécutée après
	public void init() {
		this.lProduits = (List<Produit>) produitService.obtenirTous();
		// this.setMapCatParNom(categorieService.MapCategoriesParNom());
	}

	/*************************************************
	 * Setters et Getters
	 *************************************************/

	/**
	 * @param produitService
	 *            the produitService to set
	 */
	public void setProduitService(IProduitService produitService) {
		this.produitService = produitService;
	}

	/**
	 * @return the produit
	 */
	public Produit getProduit() {
		return produit;
	}

	/**
	 * @param produit
	 *            the produit to set
	 */
	public void setProduit(Produit produit) {
		this.produit = produit;
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

	// public Map<String, Categorie> getMapCatParNom() {
	// return mapCatParNom;
	// }

	// public void setMapCatParNom(Map<String, Categorie> mapCatParNom) {
	// this.mapCatParNom = mapCatParNom;
	// }

	/*************************************************
	 * Les méthodes services
	 *************************************************/
	public String listeProduits() {
		this.lProduits = (List<Produit>) produitService.obtenirTous();
		return "produitsAdmin";
	}

	public String ajouterProduit() {
		// System.out.println("cat " + categorie + " produit" + produit);
		// produit.setCategorie(this.categorie);
		produitService.ajouter(produit);
		this.lProduits = (List<Produit>) produitService.obtenirTous();
		return "produitsAdmin";

	}

	public String supprProduit() {
		produitService.supprimer(produit);
		return "produitParCategorie";
	}

	public String modifProduit() {
		produitService.modifier(produit);
		return "produitParCategorie";
	}

}
