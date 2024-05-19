<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Order Placing Page</title>
    <link  href="OrderDetails.css" rel="stylesheet">
    </head>
<body>

    <div class="container">
      <form id=Productform action="placeorder" >
        <h1>Product Name: ${productName} <span id="productName"></span></h1>
        <h1>Price: &#8377;${productPrice}<span id="productPrice"></span></h1>
<h1>UserName: ${UserName}<span id="UserName"></span></h1>

        <!-- Mobile Number Input -->
     <div>
      <div class="input-group">
     <label for="mobileNumber">Mobile Number:</label>
<input type="tel" id="mobileNumber" name="mobileNumber" placeholder="Enter your mobile number" maxlength="10" oninput="this.value = this.value.replace(/[^0-9]/g, '')" onkeyup="validateMobileNumber()">

  </div>

  <span id="errorMessage" class="error-message"></span>
</div>

<label for="address">Delivery Address:</label>
<textarea id="address" name="address" rows="2" placeholder="Enter your full address" required></textarea>

<span id="addressError" class="error-message">Please Enter Your Complete Address</span>

        <!-- Address Input -->
     
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
    <script src="OrderDetails.js"></script>
    </body>
    </html>