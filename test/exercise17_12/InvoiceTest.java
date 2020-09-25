package exercise17_12;

import java.util.Arrays;

import static org.junit.Assert.*;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.StringContains.containsString;
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
					.collect(Collectors.groupingBy(Invoice::getQuantity,
							TreeMap::new, 
							Collectors.mapping(Invoice::getPartDescription, Collectors.toList())))
		
					.forEach((x, y) -> {
						System.out.println(x + " " + y);
					});
		


				
	
		
	}
	
	@Test
	void mapInvoicesToValueTest() {
		
		Function<Invoice, Double>CalculateValue = 
				(x)-> {return x.getPricePerItem() * x.getQuantity();};
		
		
		Map<String, Double> invoiceValue = 
		invoicesList.stream()
			.collect(Collectors.toMap(Invoice::getPartDescription, 
					 CalculateValue));
		
		assertThat(invoiceValue.get("Screwdriver"), is(106 * 6.99));
		assertThat(invoiceValue.get("Electric sander"), is(7 * 57.98));
		assertThat(invoiceValue.get("Power saw"), is(18 * 99.99));
		assertThat(invoiceValue.get("Sledge hammer"), is(11 * 21.50));
		
		invoiceValue.forEach((x, y) -> {
			System.out.printf("%-15S %.2f%n",x, y);
			System.out.println("******************************************");
		
		});	
	}
	
	@Test
	void filterInvoiceValuesInRange200To500() {
		
		//calculate the value of an invoice qty * ppi and returns result
		Function<Invoice, Double>CalculateValue = 
				(x)-> {return x.getPricePerItem() * x.getQuantity();};
		
		//filters values in the range 200 - 500
		Predicate<Invoice> filterValues = (e) -> 
		(CalculateValue.apply(e) >= 200 && CalculateValue.apply(e) <= 500);
		
		
		Map<String, Double> invoiceValue = 
		invoicesList.stream()  //data source stream of invoices
			.collect(Collectors.filtering(filterValues, //filtering invoice
					Collectors.toMap(Invoice::getPartDescription, //storing result in a map
					 CalculateValue)));
		
		
		//Test and display result
		invoiceValue.forEach((x, y) -> {
			
			assertTrue(y >= 200 && y <= 500);
			System.out.printf("%-20s %.2f%n", x, y);
			
		});
		
		
		
		
	}
	
	@Test
	void findAnyPartDescriptionContainingSaw() {
		
		Predicate<Invoice> descriptionMatch= 
				(x) -> x.getPartDescription().contains("saw");
				
			
		Optional<Invoice> result =
		invoicesList.stream()
					.filter(descriptionMatch)
					.findFirst();
		
		System.out.printf("%nInvoice with Part description containing word \"saw\":%n%s%n",
				result.isPresent() ? result.get() : "No result!"); 
		
		assertThat(result.get().getPartDescription(), containsString("saw"));
					
	}
	


}
