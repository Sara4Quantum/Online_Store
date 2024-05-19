    
    

const addressInput = document.getElementById('address');
  const addressError = document.getElementById('addressError');

  // Initially hide the error message
  addressError.style.display = 'none';

  addressInput.addEventListener('blur', () => {
    if (addressInput.value.trim() === '') {
      addressError.style.display = 'block'; // Show error message
    } else {
      addressError.style.display = 'none'; // Hide error message
    }
  });


  
 
  
  function validateMobileNumber() {
    const mobileNumberInput = document.getElementById('mobileNumber');
    const errorMessage = document.getElementById('errorMessage');
    const submitButton = document.getElementById('submitButton');

    // Get the entered value without any leading/trailing spaces
    const enteredValue = mobileNumberInput.value.trim();

    // Regular expression for 10-digit mobile number
    const mobileNumberRegex = /^\d{10}$/;

    // Check for valid 10-digit mobile number using regex
    if (enteredValue.length === 10 && mobileNumberRegex.test(enteredValue)) {
        errorMessage.textContent = ""; // Clear any previous message
        errorMessage.style.display = 'none'; // Hide message
        submitButton.disabled = false; // Enable submit button
    } else {
        errorMessage.textContent = "Please enter exactly 10 digits for the mobile number.";
        errorMessage.style.display = 'block'; // Show error message
        submitButton.disabled = true; // Disable submit button
    }
}


 
 



    document.querySelectorAll('input[name="paymentMethod"]').forEach(function(elem) {
    elem.addEventListener('change', function() {
        if (this.value === "onlinePayment") {
            cardDetails.style.display = 'block';
        } else {
            cardDetails.style.display = 'none';
            // Clear card number on Cash on Delivery selection
            document.getElementById('digits').value = '';
        }
    });
});


        document.addEventListener('DOMContentLoaded', function() {
            var cardDetails = document.getElementById('cardDetails');

            document.querySelectorAll('input[name="paymentMethod"]').forEach(function(elem) {
                elem.addEventListener('change', function() {
                    if (this.value === "onlinePayment") {
                        cardDetails.style.display = 'block';
                    } else {
                        cardDetails.style.display = 'none';
                    }
                });
            });
        });

document.getElementById('cardDetails').addEventListener('submit', function(e) {
    var cardNumberInput = document.getElementById('digits');
    var digitsOnly = cardNumberInput.value.replace(/\s/g, '');
    if (digitsOnly.length !== 16) {
        cardNumberInput.setCustomValidity('Please Enter exactly 16 digits Credit / Debit card number');
        document.getElementById('cardNumberErrorMessage').textContent = 'Please Enter exactly 16 digits Credit / Debit card number';
        e.preventDefault();
    } else {
        cardNumberInput.setCustomValidity('');
        document.getElementById('cardNumberErrorMessage').textContent = '';
    }
});

document.getElementById('digits').addEventListener('input', function(e) {
    var target = e.target,
        position = target.selectionEnd,
        length = target.value.length;
    target.value = target.value.replace(/[^\dA-Z]/g, '').replace(/(.{4})/g, '$1 ').trim();
    target.selectionEnd = position += ((target.value.charAt(position - 1) === ' ' && target.value.charAt(length - 1) === ' ') ? 1 : 0);
});


    