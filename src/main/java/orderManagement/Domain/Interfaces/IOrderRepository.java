package orderManagement.Domain.Interfaces;

import java.util.List;
import orderManagement.Domain.Order;

public interface IOrderRepository
{
    int Store(Order order);
    Order Load(int orderId);
    List<Order> Search(int customerId);
}

