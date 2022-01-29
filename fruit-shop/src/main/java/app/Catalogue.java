package app;


public class Catalogue {

  private Product product;
  private Product productList;
  
  public Catalogue () { };
 


 
  
  private void setProductList (Product newVar) {
    productList = newVar;
  }

  
  private Product getProductList () {
    return productList;
  }

  
  public void insertProduct()
  {
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
      return this.product.getPrice();
      }


}
