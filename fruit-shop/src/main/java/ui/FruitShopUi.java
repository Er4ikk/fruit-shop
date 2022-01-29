package ui;

import java.util.Scanner;

import app.Catalogue;
import app.Product;

public class FruitShopUi {

  
  private Catalogue catalogue;
  public Scanner input;
  
  
  public FruitShopUi () {
      this.catalogue=new Catalogue();
      this.input =new Scanner(System.in);
  };
  
 
  public void setCatalogue (Catalogue newVar) {
    catalogue = newVar;
  }

  
  public Catalogue getCatalogue () {
    return catalogue;
  }
  
  


    
    public void insertProduct()
    {	
	Product product=this.getCatalogue().getProduct();
	System.out.println("INSERIMENTO NUOVO SLOT PRODOTTI");
	System.out.println("Inserire id prodotto");
	product.setProductId(input.nextInt());
	System.out.println("Inserire nome prodotto");
	product.setName(input.next());
	System.out.println("Inserire quantità prodotto");
	product.setQuantity(input.nextInt());
	System.out.println("Inserire prezzo prodotto");
	product.setPrice(input.nextFloat());
	System.out.println("Inserire tipo prodotto");
	product.setType(input.next());
    }


    
    public void deleteProduct(int productId)
    {
    }


    
    public void showProducts()
    {
	
    }


    
    public void modifyProduct(int productId)
    {
    }


    
    public float sellProduct(int productId)
    {
	return productId;
        
    }





  public float getMoney_earned() {
      return getMoney_earned();
  }
 

}