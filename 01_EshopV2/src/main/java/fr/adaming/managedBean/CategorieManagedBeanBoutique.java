package fr.adaming.managedBean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import fr.adaming.entite.Categorie;
import fr.adaming.service.IGeneriqueService;

@ManagedBean(name = "categorieMBBoutique")
@RequestScoped
public class CategorieManagedBeanBoutique implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Categorie categorieB;
//	private Produit produit;
	private List<Categorie> lCategoriesB;


	@ManagedProperty(value = "#{categorieServiceBean}")
	private IGeneriqueService<Categorie> categorieService;

	/**
	 * Constructeur vide
	 */
	public CategorieManagedBeanBoutique() {
		this.categorieB = new Categorie();
	}

	@PostConstruct // la méthode sera exécutée après
	public void init() {
		lCategoriesB = (List<Categorie>) categorieService.obtenirTous();
	}

	/*************************************************
	 * Setters et Getters
	 *************************************************/

	/**
	 * @param categorieService
	 *            the categorieService to set
	 */
	public void setCategorieService(IGeneriqueService<Categorie> categorieService) {
		this.categorieService = categorieService;
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
	 * @return the lCategoriesB
	 */
	public List<Categorie> getlCategoriesB() {
		return lCategoriesB;
	}

	/**
	 * @param lCategoriesB the lCategoriesB to set
	 */
	public void setlCategoriesB(List<Categorie> lCategoriesB) {
		this.lCategoriesB = lCategoriesB;
	}

	/*************************************************
	 * Les méthodes services
	 *************************************************/

	public String listeCategoriesBoutique() {
		this.lCategoriesB = (List<Categorie>) categorieService.obtenirTous();
		return "categoriesBoutique";
	}

	public int taille(){
		
		taille =  categorieService.obtenirTous().size();
		
	}

	// public String associerCategorie() {
	// categorieService.associer(categorie);
	// }

//	@Override
//	public List<Produit> obtenirTousProduitsParCategorie(Categorie categorie) {
//
//		List<Produit> lProduits = (List<Produit>) produitDaoImpl.obtenirTous();
//		List<Produit> lProduitsParCat = new ArrayList<Produit>();
//		int i = 0;
//		for (Produit p : lProduits) {
//			System.out.println(p.getCategorie());
//			if (categorie.equals(p.getCategorie())) {
//				lProduitsParCat.add(p);
//				i++;
//			}
//		}
//		if (i > 0) {
//			return lProduitsParCat;
//		} else {
//			return null;
//		}
//	}

}
