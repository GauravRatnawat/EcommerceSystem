package orderManagement.Application.Interfaces;

import orderManagement.Contracts.Common.Order;
import orderManagement.Contracts.Common.TransitLocation;
import orderManagement.Contracts.Input.PlaceOrderRequest;
import orderManagement.Contracts.Output.PlaceOrderResponse;
import java.util.List;


public interface IOrderService
{
    PlaceOrderResponse PlaceOrder(PlaceOrderRequest request);
    List<Order> GetOrderHistory(int customerId);
    List<TransitLocation> GetOrderTrackingInfo(int orderId);
}

