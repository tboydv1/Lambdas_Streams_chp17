package exercise17_12;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.MatcherAssert.assertThat;

class InvoiceTest {
	
	Invoice[] invoices = {
			
			new Invoice(83, "Electric sander", 7, 57.98),
			new Invoice(24, "Power saw", 18, 99.99),
			new Invoice(7, "Sledge hammer", 11, 21.50),
			new Invoice(77, "Hammer", 76, 11.99),
			new Invoice(39, "Lawn mower", 3, 79.50),
			new Invoice(68, "Screwdriver", 106, 6.99),
			new Invoice(56, "Jig saw", 21, 11.00),
			new Invoice(3, "Wrench", 34, 7.50)
			
	};
	
	List<Invoice> invoicesList;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		
		invoicesList = Arrays.asList(invoices);
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void sortInvoiceByPartDescriptionTest() {
		
		List<Invoice> result = invoicesList.stream()
										   .sorted(Comparator.comparing(Invoice::getPartDescription))
										   .collect(Collectors.toList());
		
		
		assertThat(result.get(0).getPartDescription(), is("Electric sander"));
		assertThat(result.get(1).getPartDescription(), is("Hammer"));
		assertThat(result.get(2).getPartDescription(), is("Jig saw"));
		assertThat(result.get(3).getPartDescription(), is("Lawn mower"));
		assertThat(result.get(4).getPartDescription(), is("Power saw"));
		assertThat(result.get(5).getPartDescription(), is("Screwdriver"));
		
		System.out.printf("%nInvoices sorted by part description%n%n");
		System.out.printf("%-5s%-20s%-5s%-5s%n","P/N","Part/Desc","Q/N","Price");
		result.stream()
			  .forEach(System.out::println);
		
		
		
	}
	
	@Test
	void sortInvoiceByPricePerItemTest() {
		
		List<Invoice> result = invoicesList.stream()
										   .sorted(Comparator.comparing(Invoice::getPricePerItem))
										   .collect(Collectors.toList());
		
		
		assertThat(result.get(0).getPricePerItem(), is(6.99));
		assertThat(result.get(1).getPricePerItem(), is(7.50));
		assertThat(result.get(2).getPricePerItem(), is(11.00));
		assertThat(result.get(3).getPricePerItem(), is(11.99));
		assertThat(result.get(4).getPricePerItem(), is(21.50));
		assertThat(result.get(5).getPricePerItem(), is(57.98));
		
		System.out.printf("%nInvoices sorted by price per item description%n%n");
		System.out.printf("%-5s%-20s%-5s%-5s%n","P/N","Part/Desc","Q/N","Price");
		result.stream()
			  .forEach(System.out::println);
		
		
		
	}
	
	@Test 
	void mapInvoicesToPartDecriptionTest(){
		
		Function<Invoice, Integer> byQuantity = Invoice::getQuantity;
		
		invoicesList.stream()
					.sorted(Comparator.comparing(byQuantity))
					.collect(Collectors.toMap(Invoice::getPartDescription, Invoice::getQuantity))
					.forEach((x, y) -> {
						System.out.printf("%-20s%s%n",x, y);
					});

				
	
		
	}


}
