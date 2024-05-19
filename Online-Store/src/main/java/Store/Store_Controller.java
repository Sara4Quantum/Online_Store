package Store;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.transaction.Transactional;

@Controller
public class Store_Controller {

    // Autowire repositories and services needed for the controller
    @Autowired
    User_Details_CRUD user_detailsCrud; // Repository for user details
    
    int serielNumber = 0; // Serial number for orders
    
    @Autowired
    purchase_orderDetailsCRUD orderDetails_Crud; // Repository for purchase order details
    
    @Autowired
    Credit_or_DebitCard_Validation creditCard_Validation; // Service for credit/debit card validation
    
    @Autowired
    Purchase_OrderDetails OrderDetail; // Object for holding current user's order details

	
	
	
    // Handler for displaying the login page
    @GetMapping("onlinestore")
    public String LoginPage() {
        return "login.html"; // Return the login page HTML
    }

    // Handler for processing user login and displaying product list
    @GetMapping("Login")
    public ModelAndView productList(@RequestParam("UsernamE") String username, User_Details userDetail) {
        OrderDetail.setUser_Name(username); // Set the current user's name
        
        ModelAndView mav = new ModelAndView(); // Create a new ModelAndView instance
        
        mav.addObject("userinName", username); // Add username attribute to the view
        mav.setViewName("productsList.jsp"); // Set the view to display the product list page
        
        user_detailsCrud.save(userDetail); // Save user details to the database
        
        return mav; // Return the ModelAndView object
    }

      
 // Handlers for displaying specific product pages
    
    @GetMapping("product1")
    public  String ZenThathuvaKathaigal() {
    	  
    	
        return "Zen Thathuva kathaigal.html";// Return HTML page for product 1
    }

    @GetMapping("product2")
    public String BriefHistoryOfTime() {
    	  
        return "Brief History Time.html";// Return HTML page for product 2
    }

    @GetMapping("product3")
    public String SapiensBook() {
    	 
        return "Sapiens.html";// Return HTML page for product 3
    }

    @GetMapping("product4")
    public String PencilSet() {
    	 
        return "pencil.html";// Return HTML page for product 4
    }

    @GetMapping("product5")
    public String telescope() {
    	 
        return "telescope.html";// Return HTML page for product 5
    }

    @GetMapping("product6")
    public String CricketBall() {
       
           
        return "Cricket Ball.html";// Return HTML page for product 6
    }

    @GetMapping("product7")
    public String WheatFlour() {
         
          
        return "Atta.html";// Return HTML page for product 7
    }

    @GetMapping("product8")
    public String PeanutOil() {
    	   
        return "Peanut.html";// Return HTML page for product 8
    }

    
    @GetMapping("product9")
    public String Panneer() {
    	  
    	return "Panneer.html";// Return HTML page for product 9
    }

 // Handler for processing product purchase
    @GetMapping("buying")
    public ModelAndView purchase(@RequestParam("productCode") String productCode) {
    	
    	if(serielNumber==0) {
    		serielNumber=1;
    	}
    	
    	
    	
    	ModelAndView mav = new ModelAndView();// Create a new ModelAndView instance
        String productName;
       int productPrice;
      
    // Determine product details based on productCode
        switch (productCode) {
     // Assign product name and price based on productCode
            case "product1":
                productName = "Zen Thaththuva kathaigal Book";
                productPrice = 233;
                break;
            case "product2":
                productName = "A Brief History of Time Book";
                productPrice = 699;
                break;
            case "product3":
                productName = "Sapiens Book";
                productPrice = 499;
                break;
            case "product4":
                productName = "Pencil Set";
                productPrice = 99;
                break;
            case "product5":
                productName = "Orian Telescope";
                productPrice = 49990;
                break;
            case "product6":
                productName = "Cricket Ball";
                productPrice = 990;
                break;
            case "product7":
                productName = "Wheat Flour-1 kg";
                productPrice = 70;
                break;
            case "product8":
                productName = "Pure Peanut Oil- 1 Litre";
                productPrice = 219;
                break;
            case "product9":
                productName = "Paneer-1kg";
                productPrice = 299;
                break;
            default:
                // Handle invalid product
                mav.setViewName("error.jsp");
                return mav;
        }
        
        
        mav.addObject("productName", productName); // Add productName to the view
        mav.addObject("productPrice", productPrice); // Add productPrice to the view
        mav.addObject("UserName", OrderDetail.getUser_Name()); // Add current user's name to the view
        
        mav.setViewName("OrderDetails.jsp"); // Set the view to display the order details page
        
        return mav; // Return the ModelAndView object
        
    }
  
    // Handler for placing an order
    @GetMapping("placeorder")
    @Transactional
    public String placeOrder(@RequestParam("productName") String productName,
                             @RequestParam("productPrice") String productPrice,
                             Purchase_OrderDetails orderS_detail, Credit_Card_Digits ccd,
                             @RequestParam("digits") String digits) {
        
    	
        ccd.setDigits(digits); // Set the credit/debit card digits
        
        int C_D_Result = creditCard_Validation.valida(ccd); // Validate the credit/debit card
        
        if (C_D_Result != 0) {
        	
            // Check if the total sum of credit/debit card numbers is divisible by 10
            if (C_D_Result % 10 == 0) {
                // Set order details
                orderS_detail.setS_no(serielNumber);
                orderS_detail.setProductName(productName);
                orderS_detail.setProductPrice(productPrice);
                orderS_detail.setMobileNumber(orderS_detail.getMobileNumber());
                orderS_detail.setAddress(orderS_detail.getAddress());
                orderS_detail.setUser_Name(OrderDetail.getUser_Name());
                
                orderDetails_Crud.save(orderS_detail); // Save order details to the database
                serielNumber++; // Increment the serial number for the next order
                
                System.out.println(C_D_Result); // Print the total sum of credit/debit card numbers
                
                return "PlacedOrder.html"; // Return HTML page for successful order placement
              }
            else {
                System.out.println(C_D_Result); // Print the total sum of credit/debit card numbers
                return "creditInvalid.html"; // Return HTML page for invalid credit/debit card
            }
        } 
        else {
            // Set order details
            orderS_detail.setS_no(serielNumber);
            orderS_detail.setProductName(productName);
            orderS_detail.setProductPrice(productPrice);
            orderS_detail.setMobileNumber(orderS_detail.getMobileNumber());
            orderS_detail.setAddress(orderS_detail.getAddress());
            orderS_detail.setUser_Name(OrderDetail.getUser_Name());
            
            orderDetails_Crud.save(orderS_detail); // Save order details to the database
            serielNumber++; // Increment the serial number for the next order
            
            System.out.println(C_D_Result); // Print the total sum of credit/debit card numbers
            
            return "PlacedOrder.html"; // Return HTML page for successful order placement
        }
    }
   
    
    // Handler for continuing shopping
    @GetMapping("ContinueShopping")
    public ModelAndView CONTINUE(User_Details userDetail) {
        ModelAndView mav = new ModelAndView(); // Create a new ModelAndView instance
        
        mav.setViewName("productsList.jsp"); // Set the view to display the product list page
        
        userDetail.setUsernamE(OrderDetail.getUser_Name()); // Set the username in the userDetail object
        mav.addObject("userinName", OrderDetail.getUser_Name()); // Add username to the view
        
        user_detailsCrud.save(userDetail); // Save user details to the database
        
        return mav; // Return the ModelAndView object
    }

    
    // Handler for canceling an order
    @GetMapping("CancelOrder")
    public ModelAndView CancelOrder(Purchase_OrderDetails order) {
        ModelAndView mav = new ModelAndView(); // Create a new ModelAndView instance
        
        order.setS_no(serielNumber - 1); // Set the serial number of the order to be canceled
        
        Optional<Purchase_OrderDetails> stt = orderDetails_Crud.findById(order.getS_no()); // Find order details by ID
        order = stt.get(); // Get the order details
        
        orderDetails_Crud.deleteById(order.getS_no()); // Delete the order from the database
        mav.setViewName("Deleted.html"); // Set the view to display order deletion confirmation
        
        serielNumber--; // Decrement the serial number
        
        return mav; // Return the ModelAndView object
    }
    
    
}
