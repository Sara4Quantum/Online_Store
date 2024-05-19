package Store;

public class Credit_Card_Digits {

    private String digits; // Variable to store the credit card digits.
    
    
    // Getter method for retrieving credit card digits.
    public String getDigits() {
        return digits;
    }
    // Setter method for setting credit card digits.
    public void setDigits(String digits) {
        this.digits = digits;
    }

    
    
    
    // Method to remove spaces from a string of digits.
    public String removeSpace(String strNumber) {
    	
        StringBuilder number = new StringBuilder();

        // Iterate through each character in the string.
        for (int i = 0; i < strNumber.length(); i++) {
            char c = strNumber.charAt(i);
            if (c != ' ') {
                number.append(c); // Append non-space characters to the StringBuilder.
            }
        }
        return number.toString(); // Return the string without spaces.
    }
}
