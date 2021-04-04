package orderManagement.Contracts.Output;

import orderManagement.Contracts.Common.Order;


public class OrderPlacedEvent
{
    Order Order;

//        [JsonConstructor]
    private OrderPlacedEvent(Order order)
    {
        Order = order;
    }

    public static OrderPlacedEvent Create(Order order)
    {
        return new OrderPlacedEvent(order);
    }
}

