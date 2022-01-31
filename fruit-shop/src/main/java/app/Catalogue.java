package app;

import java.util.ArrayList;

public class Catalogue {

    private Product product = new Product();
    private ArrayList<Product> productList = new ArrayList<Product>();
    private float money_earned;
    public int searchValue;
    private double iva = 0.22;

    public Catalogue() {

    };

    public void setProductList(ArrayList<Product> newVar) {
	productList = newVar;
    }

    public ArrayList<Product> getProductList() {
	return productList;
    }

    public int insertProduct(Product product) {
	searchValue = search(product.getProductId());

	if (searchValue == -1) {
	    this.productList.add(product);
	    return 1;
	}
	return 0;

    }

    public int deleteProduct(int productId) {
	searchValue = search(productId);
	if (searchValue != -1) {
	    this.productList.remove(searchValue);
	    return 1;
	}
	return 0;
    }

    /*
     * public void modifyProduct(int productId) { }
     */

    public int search(int productId) {
	for (int i = 0; i < this.productList.size(); i++) {

	    if (this.productList.get(i).getProductId() == productId) {
		return i;
	    }

	}
	return -1;
    }

    public float sellProduct(int productId) {
	if (search(productId) != -1) {
	    return this.productList.get(productId).getPrice() * this.productList.get(productId).getQuantity();
	} else {
	    return 0;
	}

    }

    public float getMoney_earned() {
	return money_earned;
    }

    public void setMoney_earned(float money_earned) {
	this.money_earned = money_earned;
    }

    public void setProduct(Product product) {
	this.product = product;
    }

    public Product getProduct() {
	return this.product;
    }

    public double getIva() {
	return iva;
    }

    public void setIva(double iva) {
	this.iva = iva;
    }

}
