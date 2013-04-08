package com.holatdd;
import static org.mockito.Mockito.*;

// No es necesario importar Assert, pues no lo usamos directamente
//import static org.junit.Assert.*;

import org.junit.Test;


public class PointOfSaleTest {

	@Test
	public void onBarcode_search_catalog()throws Exception{
		Catalog catalog = mock(Catalog.class);
		Screen screen= mock(Screen.class);
		PointOfSale pointOfSale = new PointOfSale(catalog, screen);
		pointOfSale.onBarcode("123");
		verify(catalog).search("123");
	}
	
	@Test
	public void onBarcode_show_price()throws Exception{
		Catalog catalog = mock(Catalog.class);
		Screen screen= mock(Screen.class);
		when(catalog.search("123")).thenReturn("1€");
		PointOfSale pointOfSale = new PointOfSale(catalog, screen);
		pointOfSale.onBarcode("123");

		verify(screen).show("1€");
	}

}
