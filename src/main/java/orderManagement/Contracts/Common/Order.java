package orderManagement.Contracts.Common;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.util.Date;

public class Order

{
    public int OrderId;
    public List<OrderLine> OrderLines;
    public int CustomerId;
    public BigDecimal ShippingCost;
    public BigDecimal TotalCost;
    public Address ShippingAddress;
    public Address BillingAddress;
    public String PromotionCode;
    public Date DatePlaced;
    public List<TransitLocation> TransitLocations;

    @JsonCreator
    private Order(@JsonProperty("orderId") int orderId, 
    		@JsonProperty("orderLines") List<OrderLine> orderLines, 
    		@JsonProperty("customerId") int customerId, 
    		@JsonProperty("totalCost") BigDecimal totalCost, 
    		@JsonProperty("shippingCost") BigDecimal shippingCost,
    		@JsonProperty("billingAddress") Address billingAddress, 
    		@JsonProperty("shippingAddress") Address shippingAddress, 
    		@JsonProperty("promotionCode") String promotionCode, 
    		@JsonProperty("datePlaced") Date datePlaced, 
    		@JsonProperty("transitLocations") List<TransitLocation> transitLocations)
    {
        OrderId = orderId;
        OrderLines = orderLines;
        CustomerId = customerId;
        TotalCost = totalCost;
        ShippingCost = shippingCost;
        BillingAddress = billingAddress;
        ShippingAddress = shippingAddress;
        PromotionCode = promotionCode;
        DatePlaced = datePlaced;
        TransitLocations = transitLocations;
        
    }

    public static Order Create(int orderId, List<OrderLine> orderLines, int customerId, 
    		BigDecimal totalCost, BigDecimal shippingCost, Address billingAddress, Address shippingAddress, 
    		String promotionCode, Date datePlaced)
    {
        return new Order(orderId, orderLines, customerId, totalCost, shippingCost, billingAddress, shippingAddress, promotionCode, datePlaced, null);
    }
}

