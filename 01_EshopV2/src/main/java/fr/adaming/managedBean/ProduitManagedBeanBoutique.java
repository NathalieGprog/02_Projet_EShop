package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;

import fr.adaming.entite.Categorie;
import fr.adaming.entite.Produit;
import fr.adaming.service.CategorieService;
import fr.adaming.service.IGeneriqueService;
import fr.adaming.service.IProduitService;

@ManagedBean(name = "produitMBBoutique")
@ViewScoped
public class ProduitManagedBeanBoutique implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Produit produitB;
	private Categorie categorieB;
	private List<Produit> lProduitsB;
	private List<Categorie> lCategorieB;
//	private Map<Produit,Categorie> mapProduitCat;

	@ManagedProperty(value = "#{produitServiceBean}")
	private IProduitService produitService;

//	private IGeneriqueService<Categorie> categorieService = new CategorieService();
	/**
	 * Constructeur vide
	 */
	public ProduitManagedBeanBoutique() {
		this.produitB = new Produit();
//		this.categorie = new Categorie();
	}
	
	@PostConstruct // la méthode sera exécutée après
	public void init() {
		this.lProduitsB = (List<Produit>) produitService.obtenirTous();
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
	 * @return the produitB
	 */
	public Produit getProduitB() {
		return produitB;
	}

	/**
	 * @param produitB the produitB to set
	 */
	public void setProduitB(Produit produitB) {
		this.produitB = produitB;
	}

	/**
	 * @return the categorieB
	 */
	public Categorie getCategorieB() {
		return categorieB;
	}

	/**
	 * @param categorieB the categorieB to set
	 */
	public void setCategorieB(Categorie categorieB) {
		this.categorieB = categorieB;
	}

	/**
	 * @return the lProduitsB
	 */
	public List<Produit> getlProduitsB() {
		return lProduitsB;
	}

	/**
	 * @param lProduitsB the lProduitsB to set
	 */
	public void setlProduitsB(List<Produit> lProduitsB) {
		this.lProduitsB = lProduitsB;
	}

	/**
	 * @return the lCategorieB
	 */
	public List<Categorie> getlCategorieB() {
		return lCategorieB;
	}

	/**
	 * @param lCategorieB the lCategorieB to set
	 */
	public void setlCategorieB(List<Categorie> lCategorieB) {
		this.lCategorieB = lCategorieB;
	}





	/*************************************************
	 * Les méthodes services
	 *************************************************/
	public String listeProduitsBoutique() {
		this.lProduitsB = (List<Produit>) produitService.obtenirTous();
		return "produitsBoutique.xhtml";
	}
	
	
	 public List<Produit> completeProduitB (String query){

	        List<Produit> suggestions = new ArrayList<>();//an instance of list
	        for(Produit prod : this.lProduitsB){
		        if(prod.getDesignation().startsWith(query)){
		           suggestions.add(prod);
		         }
		    }
		    return suggestions;
	    }
	 
	 public String afficheProduit(){
		 return "produitTrouveBoutique.xhtml";
	 }
	 
	 public String rechercherProduit(){
		 return "produitTrouveBoutique.xhtml";
	 }
	
//	public String obtenirCategorieDuProduitAffche(){
//		Map<Produit,Categorie> mapProduitCat = produitService.obtenirCategorieDuProduit();
//		return "test";
//	}

}
