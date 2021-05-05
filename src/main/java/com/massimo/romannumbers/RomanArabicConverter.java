package com.massimo.romannumbers;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RomanArabicConverter {
	enum RomanNumber {
	    I(1), IV(4), V(5), IX(9), X(10), 
	    XL(40), L(50), XC(90), C(100), 
	    CD(400), D(500), CM(900), M(1000);

	    private int value;

	    RomanNumber(int value) {
	        this.value = value;
	    }

	    public int getValue() {
	        return value;
	    }
	    
	    public static List<RomanNumber> getReverseSortedValues() {
	        return Arrays.stream(values())
	          .sorted(Comparator.comparing((RomanNumber e) -> e.value).reversed())
	          .collect(Collectors.toList());
	    }
	}
	
	public static String arabicToRoman(int arabicNumber) {
	    if ((arabicNumber <= 0) || (arabicNumber >= 4000)) {
	        throw new IllegalArgumentException(arabicNumber + " is not in range (0,3999)");
	    }

	    List<RomanNumber> romanNumbers = RomanNumber.getReverseSortedValues();

	    
	    StringBuilder builder = new StringBuilder();

	    for (int i = 0; (arabicNumber > 0) && (i < romanNumbers.size()); ) {
	        RomanNumber currentRomanNumber = romanNumbers.get(i);
	        if (currentRomanNumber.getValue() <= arabicNumber) {
	            builder.append(currentRomanNumber.name());
	            arabicNumber -= currentRomanNumber.getValue();
	        } else {
	            i++;
	        }
	    }

	    return builder.toString();
	}
}
