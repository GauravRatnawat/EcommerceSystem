package orderManagement.Contracts.Input;

import orderManagement.Contracts.Common.Order;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PlaceOrderRequest
{
    public Order Order;
    public BigDecimal ExpectedTotalCost;
    public BigDecimal ExpectedShippingCost;

    @JsonCreator
    private PlaceOrderRequest(@JsonProperty("order") Order order, 
    		@JsonProperty("expectedTotalCost") BigDecimal expectedTotalCost, 
    		@JsonProperty("expectedShippingCost") BigDecimal expectedShippingCost)
    {
        this.Order = order;
        this.ExpectedTotalCost = expectedTotalCost;
        this.ExpectedShippingCost = expectedShippingCost;
    }

    public static PlaceOrderRequest Create(Order order, BigDecimal expectedTotalCost, BigDecimal expectedShippingCost)
    {
        return new PlaceOrderRequest(order, expectedTotalCost, expectedShippingCost);
    }
}

