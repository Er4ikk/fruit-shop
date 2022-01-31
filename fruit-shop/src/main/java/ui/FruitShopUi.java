package ui;

import java.util.Scanner;

import app.Catalogue;
import app.Product;

public class FruitShopUi {

    private Catalogue catalogue;
    public Scanner input;
    public int answer;
    public int response;

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
	    System.out.println(" -------------------------------- ");
	    System.out.println(" MENÙ PRINCIPALE NEGOZIO");
	    System.out.println("1. aggiungi slot");
	    System.out.println("2. modifica slot");
	    System.out.println("3. visualizza elenco slot");
	    System.out.println("4. cancella slot ");
	    // System.out.println("5. vendi slot");
	    // System.out.println("6. visualzza saldo");
	    System.out.println("0. esci");
	    System.out.println(" --------------------------------");

	    while (!input.hasNextInt()) {
		System.out.println("Input errato inserire numero");
		input.next();
	    }
	    answer = input.nextInt();

	    switch (answer) {
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
		System.out.println("uscita in corso.. ");
		break;

	    default:
		System.out.println("Opzione non valida");

	    }
	} while (answer != 0);

	System.out.println("Arrivederci");

    }

    public void insertProduct() {
	System.out.println(" ");
	Product product = new Product();
	System.out.println("INSERIMENTO NUOVO SLOT PRODOTTI");
	System.out.println(" ");

	System.out.println("Inserire id prodotto");
	while (!input.hasNextInt()) {
	    System.out.println("Input errato inserire numero");
	    input.next();
	}
	product.setProductId(input.nextInt());

	System.out.println("Inserire nome prodotto");
	product.setName(input.next());

	System.out.println("Inserire quantità prodotto");
	while (!input.hasNextInt()) {
	    System.out.println("Input errato inserire numero");
	    input.next();
	}
	product.setQuantity(input.nextInt());

	System.out.println("Inserire prezzo prodotto");
	while (!input.hasNextFloat()) {
	    System.out.println("Input errato inserire numero");
	    input.next();
	}
	product.setPrice(input.nextFloat());

	System.out.println("Inserire tipo prodotto");
	product.setType(input.next());

	response = this.catalogue.insertProduct(product);
	if (response == 1) {
	    System.out.println("Inserimento avvenuto con successo");
	} else {
	    System.out.println("Inserimento fallito id già presente");
	}
	System.out.println(" ");
    }

    public void deleteProduct() {
	System.out.println(" ");
	System.out.println("ELIMINA SLOT PRODOTTI");
	System.out.println(" ");
	System.out.println("Inserire id lotto da eliminare :");

	while (!input.hasNextInt()) {
	    System.out.println("Input errato inserire numero");
	    input.next();
	}
	response = this.catalogue.deleteProduct(input.nextInt());

	if (response == 1) {
	    System.out.println("Cancellazione avvenuta con successo");
	} else {
	    System.out.println("Cancellazione fallita elemento non esistente");
	}
	System.out.println(" ");
    }

    public void showProducts() {
	System.out.println(" ");
	System.out.println(" ELENCO LOTTI ");
	System.out.println(" ");
	System.out.println("N° " + "NOME " + "PREZZO " + "ID " + "QTN " + "TIPO ");
	for (int i = 0; i < this.catalogue.getProductList().size(); i++) {
	    System.out.println(i + 1 + ") " + this.catalogue.getProductList().get(i).getName() + " "
		    + this.catalogue.getProductList().get(i).getPrice() + " "
		    + this.catalogue.getProductList().get(i).getProductId() + " "
		    + this.catalogue.getProductList().get(i).getQuantity() + " "
		    + this.catalogue.getProductList().get(i).getType());
	}
	System.out.println(" ");
    }

    public void modifyProduct() {
	System.out.println(" ");
	System.out.println("MODIFICA SLOT PRODOTTI");
	System.out.println(" ");
	System.out.println("Inserire id slot:");

	while (!input.hasNextInt()) {
	    System.out.println("Input errato inserire numero");
	    input.next();
	}

	answer = input.nextInt();
	int index = this.catalogue.search(answer);
	if (index == -1) {
	    System.out.println("Elemento nn esistente");
	} else {

	    System.out.println("Inserire id prodotto");
	    while (!input.hasNextInt()) {
		System.out.println("Input errato inserire numero");
		input.next();
	    }
	    this.catalogue.getProductList().get(index).setProductId(input.nextInt());

	    System.out.println("Inserire nome prodotto");
	    this.catalogue.getProductList().get(index).setName(input.next());

	    System.out.println("Inserire quantità prodotto");
	    while (!input.hasNextInt()) {
		System.out.println("Input errato inserire numero");
		input.next();
	    }
	    this.catalogue.getProductList().get(index).setQuantity(input.nextInt());

	    System.out.println("Inserire prezzo prodotto");
	    while (!input.hasNextFloat()) {
		System.out.println("Input errato inserire numero");
		input.next();
	    }
	    this.catalogue.getProductList().get(index).setPrice(input.nextFloat());

	    System.out.println("Inserire tipo prodotto");
	    this.catalogue.getProductList().get(index).setType(input.next());
	}
	System.out.println(" ");
    }

    public void sellProduct() {
	System.out.println("VENDITA SLOT ");
	System.out.println(" ");

	System.out.println("Inserire  id slot da vendere");
	while (!input.hasNextInt()) {
	    System.out.println("Input errato inserire numero");
	    input.next();
	}
	this.catalogue.setMoney_earned(this.catalogue.getMoney_earned() + this.catalogue.sellProduct(input.nextInt()));

    }

    public void getMoney_earned() {
	System.out.println(" SALDO ");
	System.out.println(" ");
	System.out.println(this.catalogue.getMoney_earned() + "euro");
	System.out.println("IMPOSTE STATO");
	System.out.println(this.catalogue.getMoney_earned() * this.catalogue.getIva() + "euro");
    }

}