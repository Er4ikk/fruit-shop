package app;

import java.util.ArrayList;

import org.junit.Test;

public class CataogueTest {
    Catalogue testCatalaogue = new Catalogue();

    @Test
    public void testCatalogue() {

    }

    @Test
    public void testSetProductList() {
	this.testCatalaogue.setProductList(new ArrayList<Product>());
    }

    @Test
    public void testGetProductList() {
	this.testCatalaogue.getProductList();
    }

    @Test
    public void testInsertProduct() {
	this.testCatalaogue.insertProduct(new Product());
    }

    @Test
    public void testDeleteProduct() {
	this.testCatalaogue.deleteProduct(0);
    }

    @Test
    public void testSearch() {
	this.testCatalaogue.search(0);
    }

    @Test
    public void testSellProduct() {
	this.testCatalaogue.sellProduct(0);
    }

    @Test
    public void testGetMoney_earned() {
	this.testCatalaogue.getMoney_earned();
    }

    @Test
    public void testSetMoney_earned() {
	this.testCatalaogue.setMoney_earned(0);
    }

    @Test
    public void testSetProduct() {
	this.testCatalaogue.setProduct(new Product());
    }

    @Test
    public void testGetProduct() {
	this.testCatalaogue.getProduct();
    }

    @Test
    public void testGetIva() {
	this.testCatalaogue.getIva();
    }

    @Test
    public void testSetIva() {
	this.testCatalaogue.setIva(0);
    }

}
