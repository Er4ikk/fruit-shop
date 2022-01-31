package ui;

import java.util.Scanner;

import app.Catalogue;
import app.Product;

public class FruitShopUi {

    private Catalogue catalogue;
    public Scanner input;

    public FruitShopUi() {
	this.catalogue = new Catalogue();
	this.input = new Scanner(System.in);
    };

    public void setCatalogue(Catalogue newVar) {
	catalogue = newVar;
    }

    public Catalogue getCatalogue() {
	return catalogue;
    }

    public void mainLoopUi() {
	do {
	    System.out.println(" MENÙ PRINCIPALE NEGOZIO");
	    System.out.println("1. aggiungi slot");
	    System.out.println("2. modifica slot");
	    System.out.println("3. visualizza elenco slot");
	    System.out.println("4. cancella slot ");
	    System.out.println("0. esci");

	    switch (input.nextInt()) {
	    case 1:
		insertProduct();
		break;

	    case 2:
		modifyProduct();
		break;

	    case 3:
		showProducts();
		break;

	    case 4:
		deleteProduct();
		break;

	    case 0:

		break;

	    default:
		System.out.println("Opzione non valida");

	    }
	} while (input.nextInt() != 0);

	System.out.println("Arrivederci");

    }

    public void insertProduct() {
	Product product = this.getCatalogue().getProduct();
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

	this.catalogue.getProductList().add(product);
    }

    public void deleteProduct() {
	System.out.println("ELIMINA SLOT PRODOTTI");
	System.out.println("Inserire id lotto da eliminare :");
	this.catalogue.deleteProduct(input.nextInt());
    }

    public void showProducts() {
	System.out.println(" ELENCO LOTTI ");
	System.out.println("N° " + "NOME " + "PREZZO " + "ID " + "QUANTITÀ " + "TIPO ");
	for (int i = 0; i < this.catalogue.getProductList().size(); i++) {
	    System.out.println(i + 1 + ") " + this.catalogue.getProductList().get(i).getName() + " "
		    + this.catalogue.getProductList().get(i).getPrice() + " "
		    + this.catalogue.getProductList().get(i).getProductId() + " "
		    + this.catalogue.getProductList().get(i).getQuantity() + " "
		    + this.catalogue.getProductList().get(i).getType());
	}

    }

    public void modifyProduct() {
	System.out.println("MODIFICA SLOT PRODOTTI");

    }

    public void sellProduct() {
	System.out.println("VENDITA SLOT ");
	System.out.println("Inserire  id slot da vendere");
	this.catalogue.setMoney_earned(this.catalogue.getMoney_earned() + this.catalogue.sellProduct(input.nextInt()));

    }

    public void getMoney_earned() {
	System.out.println(" SALDO ");
	System.out.println(this.catalogue.getMoney_earned() + "euro");
	System.out.println("IMPOSTE STATO");
	System.out.println(this.catalogue.getMoney_earned() * this.catalogue.getIva() + "euro");
    }

}