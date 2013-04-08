package com.holatdd;

import static org.mockito.Mockito.*;

// No es necesario importar Assert, pues no lo usamos directamente
//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PointOfSaleTest {

	private Catalog catalog;
	private Screen screen;
	private PointOfSale pointOfSale;

	@Before
	public void setup() {
		catalog = mock(Catalog.class);
		screen = mock(Screen.class);
		pointOfSale = new PointOfSale(catalog, screen);
	}

	@Test
	public void onBarcode_search_catalog() throws Exception {

		pointOfSale.onBarcode("123");
		verify(catalog).search("123");
	}

	@Test
	public void onBarcode_show_price() throws Exception {
		when(catalog.search("123")).thenReturn("1€");
		pointOfSale.onBarcode("123");

		verify(screen).show("1€");
	}

}
