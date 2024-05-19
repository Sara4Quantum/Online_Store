# 📦 Online Store (E-Commerce) 🛒

## 📑 Table of Contents
1. [Overview](#overview)
2. [Features](#features)
3. [Design and web pages](#Design-and-webpages)
   - [Login Page & Home Page](#login-page--home-page-)
   - [Products List Page](#products-list-page-)
   - [Product Purchasing Page](#product-purchasing-page-)
   - [Order Details Page](#order-details-page-)
   - [Order Placed Page](#order-placed-page-)
   - [Order Cancellation Page](#order-cancellation-page-)
   - [Invalid Card Page](#invalid-card-page-)
4. [Technical Documentation](#technical-documentation)
   - [Key Classes and Interfaces](#key-classes-and-interfaces-)
   - [Maven Dependencies](#maven-dependencies-)
5. [User Guide](#user-guide)
6. [Detailed Documentation](#detailed-documentation-here)

## Overview 📋
**Main Language:** Java  
**Web Framework:** Spring Boot  
**Tools:** Spring Tool Suite 4  

### Purpose 🎯
Create an e-commerce platform for customers to browse and purchase products conveniently from anywhere.

---

## Features ✨
- Browse and purchase products with ease.
- Validate credit and debit card numbers using the Luhn Algorithm.
- User-friendly interface with interactive pages for login, product listing, purchasing, and order confirmation.

---

## 🖌️ Design and webpages 💻

### 1. Login Page & Home Page 🏠
- **HTML:** Big title "Online Store", input field for Name, "Login" button.
- **CSS:** Bold 3D title, centered container, color variations.
- **JavaScript:** Restrict input to alphabetic characters, display error for empty input.

### 2. Products List Page 📜
- **JSP & HTML:** Welcome message with username, product listing with image, name, price, description, "Open" button.
- **CSS:** Rounded box edges, HD images, blue price text, green "Open" button, 3D shadow effect.

### 3. Product Purchasing Page 🛒
- **HTML & CSS:** Product title, price, description, HD image in a rounded container, green "Buy Now" button with hover effect.

### 4. Order Details Page 📋
- **JSP, HTML, CSS:** Display product and user details, input fields for mobile number, address, payment method selection, "Place Order" button with hover effect.
- **JavaScript:** Validate mobile number (10 digits), complete address, and card number (16 digits).

### 5. Order Placed Page ✅
- **HTML, CSS:** "Order Placed Successfully" message, thank you note, "Cancel Order" and "Continue Shopping" buttons.

### 6. Order Cancellation Page ❌
- **HTML, CSS:** "Order Cancelled" message, "Continue Shopping" button with hover effect.

### 7. Invalid Card Page ❌
- **HTML, CSS:** "Card number is incorrect" message with a cross symbol, "Try Again" button, thank you note.

---

## 💻 Technical Details 📚

### Key Classes and Interfaces 🛠️

#### 1. `User_Details` Class
- Represents user details, mapped to `user_details` table.
- **Annotations:** `@Component`, `@Entity`, `@Table(name = "user_details")`

#### 2. `User_Details_CRUD` Interface
- Extends `CrudRepository` for `User_Details`.
- **Annotations:** `@Repository`

#### 3. `Purchase_OrderDetails` Class
- Represents order details, mapped to `order_details` table.
- **Annotations:** `@Component`, `@Entity`, `@Table(name = "order_details")`

#### 4. `purchase_orderDetailsCRUD` Interface
- Extends `CrudRepository` for `Purchase_OrderDetails`.
- **Annotations:** `@Component`

#### 5. `Credit_Card_Digits` Class
- Handles credit card digits, removes spaces.

#### 6. `StringToArray_CreditCard` Class
- Converts string of digits to integer array.

#### 7. `Credit_or_DebitCard_Validation` Class
- Validates card numbers using the Luhn Algorithm.
- **Annotations:** `@Component`

#### 8. `OnlineStoreApplication` Class
- Main entry point for the Spring Boot application.
- **Annotations:** `@SpringBootApplication`

#### 9. `Store_Controller` Class
- Handles HTTP requests, manages user interactions and business logic.
- **Annotations:** `@Controller`, `@Autowired`

### Maven Dependencies 🏗️
- **Apache Tomcat Jasper:** JSP and JSTL support.
- **Spring Boot Starter Data JPA:** Simplifies data access with JPA.
- **Spring Boot Starter Web:** Develop web applications using Spring MVC.
- **H2 Database:** Embedded database for development and testing.
- **Spring Boot Starter Test:** Testing Spring Boot applications.

---

## User Guide 📖

### How to Use 🛠️
1. **Run the Application:** Start the "ONLINE STORE (E-Commerce)" application.
2. **Access the Application:** Go to `localhost:8080/onlinestore` in your browser.
3. **Login:** Enter your name and login.
4. **Browse Products:** Select and open any product to view details.
5. **Purchase Products:** Fill in the order details and place your order.
   - **Cash on Delivery:** Order placed successfully.
   - **Online Payment:** Enter a valid 16-digit card number.
     - **Valid Card:** Order placed successfully.
     - **Invalid Card:** Error message displayed, retry option available.
6. **Order Management:** 
   - **Cancel Order:** Option available after placing an order.
   - **Continue Shopping:** Option to return to product listing and shop more.

---

### 🎉 Happy Shopping! 🛍️
Thank you for choosing our online store. We hope you have a seamless and enjoyable shopping experience!


## Detailed 👇 Documentation here       
[Online Store Document](Online_Store_Documentation.pdf)
