package fr.adaming.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import fr.adaming.dao.CategorieDaoImpl;
import fr.adaming.dao.IGeneriqueDao;
import fr.adaming.dao.ProduitDaoImpl;
import fr.adaming.model.Categorie;
import fr.adaming.model.Produit;
import fr.adaming.service.CategorieService;
import fr.adaming.service.ICategorieService;
import fr.adaming.service.IProduitService;
import fr.adaming.service.ProduitService;

public class TestProduitService {

	private IProduitService produitService = new ProduitService();
	private IGeneriqueDao<Produit> pDao = new ProduitDaoImpl();
	private Produit produit1;
	private Produit produit2;
	private Produit produit3;
	private Produit produit4;
	private Produit produit5;
	private Produit produit6;
	private Produit produit7;
	private Produit produit8;
	private Produit produit9;
	private Produit produit10;
	private List<Produit> lProduits1 = new ArrayList<Produit>();
	private List<Produit> lProduits2 = new ArrayList<Produit>();
	private List<Produit> lProduits3 = new ArrayList<Produit>();

	private ICategorieService categorieService = new CategorieService();
	private IGeneriqueDao<Categorie> cDao = new CategorieDaoImpl();
	private Categorie categorie1;
	private Categorie categorie2;
	private Categorie categorie3;
	private Categorie categorie4;
	private Categorie categorie5;

	public void initObjet() {
		System.out.println("coucou");
		produit1 = new Produit("Io", "couleur souffre", 10000000, 1, false);
		produit2 = new Produit("Europe", "couleur souffre", 10000000, 1, false);
		produit3 = new Produit("Ganymède", "couleur souffre", 10000000, 1, false);
		produit4 = new Produit("Callisto", "couleur souffre", 10000000, 1, false);
		produit5 = new Produit("Lune", "couleur argenté", 10000000, 1, false);
		produit6 = new Produit("Jupiter", "gazeuse", 100000000, 1, false);
		produit7 = new Produit("Mars", "couleur rouille", 500000000, 1, false);
		produit8 = new Produit("Saturne", "pourvu de magnifique anneaux", 40000000, 1, false);
		produit9 = new Produit("Soleil", "naine jaune", 1000000000, 1, false);
		produit10 = new Produit("Vega", "géante bleu", 2000000000, 1, false);

		categorie1 = new Categorie("Planète", "Corps céleste de taille moyenne");
		categorie2 = new Categorie("Satellite", "Corps céleste de petite taille");
		categorie3 = new Categorie("Etoile", "Corps céleste abritant des réactions thermonucléaires");

		System.out.println(produit1);
		lProduits1.add(produit1);
		System.out.println(lProduits1);
		lProduits1.add(produit2);
		lProduits1.add(produit3);
		lProduits1.add(produit4);
		lProduits1.add(produit5);

		lProduits2.add(produit6);
		lProduits2.add(produit7);
		lProduits2.add(produit8);

		lProduits3.add(produit9);
		lProduits3.add(produit10);

		categorie1.setlProduits(lProduits1);
		categorie2.setlProduits(lProduits2);
		categorie3.setlProduits(lProduits3);

		System.out.println(categorie1);
		categorieService.ajouter(categorie1);
		categorieService.ajouter(categorie2);
		categorieService.ajouter(categorie3);

		produitService.ajouter(produit1);
		produitService.ajouter(produit2);
		produitService.ajouter(produit3);
		produitService.ajouter(produit4);
		produitService.ajouter(produit5);
		produitService.ajouter(produit6);
		produitService.ajouter(produit7);
		produitService.ajouter(produit8);
		produitService.ajouter(produit9);
		produitService.ajouter(produit10);
	}

	public void obtenirTousProduitsParCategorieTest() {
		Produit p1 = produitService.obtenirUn(1);
		assertEquals(produit1, p1);

	}

}
