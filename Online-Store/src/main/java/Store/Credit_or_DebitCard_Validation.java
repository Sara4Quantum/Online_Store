package Store;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component // This marks the class as a Spring component, allowing it to be automatically detected and instantiated by the Spring framework.
public class Credit_or_DebitCard_Validation { // Class declaration starts here
      
    @Autowired
    StringToArray_CreditCard StringToArray; // Autowired dependency injection for the string_to_Array bean.

    // Method to validate credit or debit card.
    public int valida(Credit_Card_Digits orderDE) { // Method declaration starts here
       
    	//in this code used Luhn Algorithm
    	
    	int just_a_variable = 0;
        int sum = 0;
        int gsum = 0;

        int[] card_no = StringToArray.convertStringToIntArray(orderDE.removeSpace(orderDE.getDigits()));

        // Loop through the array of card numbers.
        for (int i = 0; i < card_no.length; i++) { // Loop starts here

            // Double every second digit.
            if (i % 2 == 0) {
                card_no[i] = card_no[i] * 2;
            }

            // If the doubled digit is greater than or equal to 10, split it and add the digits.
            if (card_no[i] >= 10) {
                while (card_no[i] > 0) {
                    sum = sum + card_no[i] % 10; // Add the last digit to sum.
                    card_no[i] = card_no[i] / 10; 
                }
                just_a_variable = sum;
                card_no[i] = just_a_variable;
                sum = 0; // Reset sum for the next iteration.
            }

            // Add the current digit to the running total.
            if (card_no[i] > 0) {
                gsum = gsum + card_no[i];
            }

        } // Loop ends here

        return gsum; // Return the total sum.
    } // Method ends here
}
