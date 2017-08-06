package fr.adaming.managedBean;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import fr.adaming.entite.Produit;
import fr.adaming.service.ProduitService;

@ManagedBean
@RequestScoped
public class ProduitConverter implements Converter, Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;



    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        if(value.trim().equals("")){
            return null;
        }
        else{
        try{
            int id = Integer.parseInt(value);
            List<Produit> myProduit = new ArrayList<>();//
            myProduit = new ProduitService().obtenirTous();
            for(Produit cat : myProduit){
                if(cat.getIdProduit() == id){
                    return cat;
                }
            }
        }
        catch(Exception e){

        e.printStackTrace();
        }
    }
        return  null;
    }



    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if(value == null || value ==""){
            return null;
        }
        else
        {
            return String.valueOf(((Produit)value).getIdProduit());
        }
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}