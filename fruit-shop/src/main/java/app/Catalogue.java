package app;

import java.util.ArrayList;
import java.util.Iterator;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.UpdateResult;

public class Catalogue {

    private Product product = new Product();
    private ArrayList<Product> productList = new ArrayList<Product>();
    private float money_earned;
    double totalEarns;
    public int searchValue;
    private double iva = 0.22;
    MongoClient mongoClient;
    MongoDatabase db;
    MongoCollection<Document> collection;
    Document doc;
    MongoCollection<Document> transactions;
    MongoCursor<Document> results;

    public Catalogue() {
	databaseInitConnection();
    };

    public void databaseInitConnection() {
	mongoClient = new MongoClient("localhost", 27017);
	db = mongoClient.getDatabase("fruit-shop");
	collection = db.getCollection("products");
	transactions = db.getCollection("transactions");
    }

    public void setProductList(ArrayList<Product> newVar) {
	productList = newVar;
    }

    public ArrayList<Product> getProductList() {
	return productList;
    }

    public int insertProduct(Product product) {

	doc = new Document("id", product.getProductId());
	doc.append("name", product.getName());
	doc.append("price", product.getPrice());
	doc.append("quantity", product.getQuantity());
	doc.append("type", product.getType());
	collection.insertOne(doc);

	return 1;

    }

    public int deleteProduct(int productId) {
	DeleteResult result = collection.deleteOne(Filters.eq("id", productId));
	return (int) result.getDeletedCount();
    }

    public int modifyProduct(int productId, String name, int quantity, float price, String type) {

	UpdateResult result = collection.updateOne(Filters.eq("id", productId),
		Updates.combine(Updates.set("name", name), Updates.set("quantity", quantity),
			Updates.set("price", price), Updates.set("type", type)));
	return (int) result.getModifiedCount();
	// ?
    }

    public int search(int productId) {

	for (int i = 0; i < this.productList.size(); i++) {

	    if (this.productList.get(i).getProductId() == productId) {
		return i;
	    }

	}
	return -1;
    }

    public float sellProduct(int productId) {

	results = collection.find(Filters.eq("id", productId)).iterator();
	if (results.hasNext() == false)
	    return 0;

	while (results.hasNext()) {
	    doc = results.next();

	}
	float value = (float) (doc.getInteger("quantity") * doc.getDouble("price"));
	setMoney_earned(value);
	Document transaction = new Document("value", value);
	transactions.insertOne(transaction);
	deleteProduct(productId);
	return getMoney_earned();

    }

    public Iterator<Document> showElements() {

	FindIterable<Document> iterDoc = collection.find();

	System.out.println("Listing All Mongo Documents");

	Iterator<Document> it = iterDoc.iterator();
	return it;

    }

    public float getMoney_earned() {
	return money_earned;
    }

    public double getTotalSell() {
	results = transactions.find().iterator();
	this.totalEarns = 0;
	while (results.hasNext()) {
	    this.totalEarns += (results.next().getDouble("value"));
	}
	return this.totalEarns;
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
