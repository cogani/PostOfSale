package com.holatdd;

public class PointOfSale {

	private Catalog catalog;
	private Screen screen;

	public PointOfSale(Catalog catalog, Screen screen) {
		this.catalog = catalog;
		this.screen = screen;
	 
	}

	public void onBarcode(String barcode) {
		screen.show(catalog.search(barcode));
		
		
	}

}
