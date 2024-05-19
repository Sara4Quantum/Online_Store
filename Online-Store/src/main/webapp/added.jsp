<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Buying Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
            background-color: #f9f9f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        
        .container {
            width: 80%;
            background-color: #ffffff;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 6px rgba(0, 0, 0, 0.1);
        }
        
        input[type="text"],
       
        textarea {
            width: 100%;
            padding: 12px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
            font-size: 16px;
        }
         input[type="tel"],
         textarea {
            width: 89%;
            padding: 12px;
	padding-right: 5px;

            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 6px;
            box-sizing: border-box;
            font-size: 16px;
        }
        button {
            display: block;
             width: 26%;
  			height: 53px;
            padding: 12px;
            margin-top: 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 6px;
            cursor: pointer;
            font-size: 16px;
            margin: 0 auto;
            text-align: center;
            transition: background-color 0.3s ease;
        }
        .tbuy-btn {
  font-size: 24px; /* Increase font size to 24px */
}
        button:hover {
            background-color: green;
        }
        
        label {
            font-weight: bold;
            font-size: 18px;
        }
        
        h1, h2 {
            text-align: center;
            color: #333;
        }
        
        h1 {
            font-size: 24px;
            margin-bottom: 10px;
        }
        
        h2 {
            font-size: 20px;
            margin-top: 30px;
        }

        .error-message {
            color: red;
            margin-top: 5px;
            font-size: 16px;
            font-weight: bold;
        }

        /* Add margin between "Online Payment" and "Credit / Debit Card Number" */
        .payment-method {
            margin-bottom: 10px;
        }
    </style>
</head>
<body>

    <div class="container">
      <form id=Productform action="plc" >
        <h1>Product Name: ${productName} <span id="productName"></span></h1>
        <h1>Price: &#8377;${productPrice}<span id="productPrice"></span></h1>
<h1>UserName: ${UserName}<span id="UserName"></span></h1>

        <!-- Mobile Number Input -->
     
        <div class="input-group">
            <label for="mobileNumber">Mobile Number:</label>
            <input type="tel" id="mobileNumber" name="mobileNumber" placeholder="Enter your mobile number">
        </div>

        <!-- Inside the form -->

        <!-- Address Input -->
        <label for="address">Delivery Address:</label>
        <textarea id="address" name="address" rows="2" placeholder="Enter your full address" required></textarea>

        <!-- Payment Method Selection -->
           <h2>Select Payment Method</h2>
        <div class="payment-method">
            <label>
                <input type="radio" name="paymentMethod" value="cashOnDelivery" checked>
                Cash on Delivery
            </label>
        </div>
        <div class="payment-method">
            <label>
                <input type="radio" name="paymentMethod" value="onlinePayment">
                Online Payment
            </label>
        </div>
 
       <div id="cardDetails"  style="display: none;"> <div class="form-group">
                <label for="cardNumber">Credit / Debit Card Number:</label>
                <input type="text" id="digits" name="digits" placeholder="Enter 16-digit card number"   maxlength="19">
                <div class="error-message" id="cardNumberErrorMessage"></div> </div>
        </div>
         
        <input type="hidden" name="productName" id="productName" value= "${productName}" >
        <input type="hidden" name="productPrice" id="productPrice" value= "${productPrice}">
         <input type="hidden" name="digits" id="digits" value= "${digits}">
       
        <!-- Place Order Button -->
         <button class="tbuy-btn">Place Order</button>
       </form>
    </div>

    <script>
    
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


    </script>
</body>
</html>
