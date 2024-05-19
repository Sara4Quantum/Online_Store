package Store;

import org.springframework.stereotype.Component;

@Component // This marks the class as a Spring component, allowing it to be automatically detected and instantiated by the Spring framework.
public class StringToArray_CreditCard { // Class declaration starts here

    // Method to convert a string of digits into an integer array.
    public int[] convertStringToIntArray(String number) { // Method declaration starts here
        
    	
    	int[] Aray = new int[number.length()]; // Create an integer array to store the converted digits.

        // Iterate through each character in the string.
        for (int i = 0; i < number.length(); i++) { // Loop starts here
            
        	char digitChar = number.charAt(i); // Get the character at the current index.
            int digit = Character.getNumericValue(digitChar); // Convert the character to its numeric value.
            
            Aray[i] = digit; // Store the numeric value in the array.
        
        } // Loop ends here

        return Aray; // Return the integer array.
    } // Method ends here
} // Class ends here
