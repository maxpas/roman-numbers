package com.massimo.romannumbers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class RomanNumbersApplicationTests {

	@Test
	public void given1999Arabic_WhenConvertingToRoman_ThenReturnMCMXCIX() {
		int arabic1999 = 1999;

		String result = RomanArabicConverter.arabicToRoman(arabic1999);

		assertEquals("MCMXCIX", result);
	}

	@Test
	public void given3999Arabic_WhenConvertingToRoman_ThenReturnMMMCMXCIX() {
		int arabic3999 = 3999;

		String result = RomanArabicConverter.arabicToRoman(arabic3999);

		assertEquals("MMMCMXCIX", result);
	}

	@Test
	public void whenExceptionThrown_thenAssertionSucceeds() {
		Exception exception = assertThrows(IllegalArgumentException.class, () -> {
			int arabic4000 = 4000;
			RomanArabicConverter.arabicToRoman(arabic4000);
		});

		String expectedMessage = "is not in range (0,3999)";
		String actualMessage = exception.getMessage();

		assertTrue(actualMessage.contains(expectedMessage));
	}
	
}
