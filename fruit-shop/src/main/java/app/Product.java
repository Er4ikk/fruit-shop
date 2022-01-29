package app;


public class Product {


  private int productId;
  private String name;
  private int quantity;
  private float price;
  private String type;
  
  public Product () {
      
      
  };
  


  public void setProductId (int newVar) {
    productId = newVar;
  }

  public int getProductId () {
    return productId;
  }

  public void setName (String newVar) {
    name = newVar;
  }

  public String getName () {
    return name;
  }

  
  public void setQuantity (int newVar) {
    quantity = newVar;
  }

  public int getQuantity () {
    return quantity;
  }

  public void setPrice (float newVar) {
    price = newVar;
  }

  public float getPrice () {
    return price;
  }

 
  public void setType (String newVar) {
    type = newVar;
  }

  public String getType () {
    return type;
  }

  

}