package Store;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

// Component annotation to mark this class as a Spring component.
@Component

// Entity annotation to specify that this class is mapped to a database entity.
@Entity

// Table annotation to specify the name of the database table for this entity.
@Table(name = "order_details")
public class Purchase_OrderDetails {
    
    // Primary key field annotated with @Id.
    @Id
    private int S_no = 0; // Unique serial number for the order details.
     
    
    private String User_Name; // Username of the user placing the order.
    private String productName; // Name of the product being ordered.
    private String productPrice; // Price of the product.
    private String mobileNumber; // Mobile number of the user.
    private String address; // Shipping address for the order.
    
    
    // Getter and setter methods for S_no field.
    public int getS_no() {
        return S_no;
    }
    public void setS_no(int s_no) {
        S_no = s_no;
    }
    
    
    
    // Getter and setter methods for User_Name field.
    public String getUser_Name() {
        return User_Name;
    }
    public void setUser_Name(String user_Name) {
        User_Name = user_Name;
    }
    
    
    
    // Getter and setter methods for productName field.
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
   
    
    
    // Getter and setter methods for productPrice field.
    public String getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }
   
    
    
    // Getter and setter methods for mobileNumber field.
    public String getMobileNumber() {
        return mobileNumber;
    }
    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }
    
    
    
    // Getter and setter methods for address field.
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    
     
    
}
