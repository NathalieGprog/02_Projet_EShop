package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.adaming.entite.Categorie;
import fr.adaming.entite.Produit;
import fr.adaming.service.CategorieService;
import fr.adaming.service.IGeneriqueService;
import fr.adaming.service.IProduitService;

@ManagedBean(name = "produitMB")
@RequestScoped
public class ProduitManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Produit produit;
	private Categorie categorie;
	private List<Produit> lProduits;
	private List<Categorie> lCategorie;
//	private Map<Produit,Categorie> mapProduitCat;

	@ManagedProperty(value = "#{produitServiceBean}")
	private IProduitService produitService;

//	private IGeneriqueService<Categorie> categorieService = new CategorieService();
	/**
	 * Constructeur vide
	 */
	public ProduitManagedBean() {
		this.produit = new Produit();
//		this.categorie = new Categorie();
	}
	
	@PostConstruct // la méthode sera exécutée après
	public void init() {
		this.lProduits = (List<Produit>) produitService.obtenirTous();
//		this.mapProduitCat = produitService.obtenirCategorieDuProduit();
//		this.lCategorie = (List<Categorie>) categorieService.obtenirTous();
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
	 * @param categorie the categorie to set
	 */
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

//	/**
//	 * @return the lCategorie
//	 */
//	public List<Categorie> getlCategorie() {
//		return lCategorie;
//	}
//
//	/**
//	 * @param lCategorie the lCategorie to set
//	 */
//	public void setlCategorie(List<Categorie> lCategorie) {
//		this.lCategorie = lCategorie;
//	}

	/*************************************************
	 * Les méthodes services
	 *************************************************/
	public String listeProduits() {
		this.lProduits = (List<Produit>) produitService.obtenirTous();
		return "produitsAdmin.xhtml";
	}
	
	public String ajouterProduit() {
		System.out.println("cat " + categorie +" produit" + produit);
		produit.setCategorie(this.categorie);
		produitService.ajouter(produit);
		this.lProduits = (List<Produit>) produitService.obtenirTous();
		return "ajout";

	}
	
	public String supprProduit() {
		produitService.supprimer(produit);
		return "produitParCategorie";
	}
	
	public String modifProduit() {
		produitService.modifier(produit);
		return "produitParCategorie";
	}
	
//	public String obtenirCategorieDuProduitAffche(){
//		Map<Produit,Categorie> mapProduitCat = produitService.obtenirCategorieDuProduit();
//		return "test";
//	}

}
