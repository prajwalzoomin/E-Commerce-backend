package com.Ecommerce.project.Controller;

public class CartItemRequest {
    private Integer user_Id;
    private Integer productId;
    private Integer quantity;

    // Getters and setters
    public Integer getUser_Id() { return user_Id; }
    public void setUser_Id(Integer user_Id) { this.user_Id = user_Id; }

    public Integer getProductId() { return productId; }
    public void setProductId(Integer productId) { this.productId = productId; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
}
