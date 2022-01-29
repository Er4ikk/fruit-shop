package app;

import java.util.ArrayList;

public class Catalogue {

    private Product product = new Product();
    private ArrayList<Product> productList = new ArrayList<Product>();
    private float   money_earned;

    public Catalogue () {

    };





    private void setProductList (ArrayList<Product> newVar) {
	productList = newVar;
    }


    private ArrayList<Product> getProductList () {
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





    public float getMoney_earned() {
	return money_earned;
    }





    public void setMoney_earned(float money_earned) {
	this.money_earned = money_earned;
    }
    
    public void setProduct(Product product) {
	this.product=product;
    }
    public Product getProduct() {
	return this.product;
    }


}
