package exercise17_11;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Paths;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DirectorySummaryTest {
	
	DirectorySummary dirSummer;
	@BeforeEach
	void setUp() throws Exception {
		
		dirSummer = new DirectorySummary(Paths.get("/home/oluwatobi/Downloads"));
		
		
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		
		
		dirSummer.dirSummarize();
	}

}
