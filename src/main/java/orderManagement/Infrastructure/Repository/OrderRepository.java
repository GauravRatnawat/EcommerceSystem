package orderManagement.Infrastructure.Repository;

import orderManagement.Domain.Address;
import orderManagement.Domain.Order;
import orderManagement.Domain.OrderLine;
import orderManagement.Domain.Product;
import orderManagement.Domain.Interfaces.IOrderRepository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OrderRepository implements IOrderRepository
{   
	@Override
    public Order Load(int orderId)
    {
    	List<OrderLine> orderLines= new ArrayList<OrderLine>();
    	orderLines.add(OrderLine.Create(
		                Product.Create(504421,"/image/504421/a.jpg", BigDecimal.valueOf(392)),
		                	4, BigDecimal.valueOf(40)));
    	orderLines.add(OrderLine.Create(
		                Product.Create(23151,"/image/23151/ce.jpg", BigDecimal.valueOf(50)),
		                	2, BigDecimal.valueOf(10)));
    	orderLines.add(OrderLine.Create(
		                Product.Create(40833,"/image/40833/gev.jpg", BigDecimal.valueOf(22)),
		                	3, BigDecimal.valueOf(14)));
        return Order.Create(
            101,
            orderLines,
            5,
            BigDecimal.valueOf(408),
            BigDecimal.valueOf(89),
            Address.Create("address1", "address2", "country"),
            Address.Create("address1", "address2", "country"),
            "FIRSTBUY",
            new Date());     
    }
    
    @Override
    public List<Order> Search(int customerId)
    {
    	List<OrderLine> orderLines= new ArrayList<OrderLine>();
    	orderLines.add(OrderLine.Create(
		                Product.Create(504421,"/image/504421/a.jpg", BigDecimal.valueOf(392)),
		                	4, BigDecimal.valueOf(40)));
    	orderLines.add(OrderLine.Create(
		                Product.Create(23151,"/image/23151/ce.jpg", BigDecimal.valueOf(50)),
		                	2, BigDecimal.valueOf(10)));
    	orderLines.add(OrderLine.Create(
		                Product.Create(40833,"/image/40833/gev.jpg", BigDecimal.valueOf(22)),
		                	3, BigDecimal.valueOf(14)));
    	
    	List<OrderLine> orderLines2= new ArrayList<OrderLine>();
    	orderLines2.add(OrderLine.Create(
		                Product.Create(504421,"/image/504311/a4.jpg", BigDecimal.valueOf(34)),
		                	12, BigDecimal.valueOf(35)));
    	orderLines2.add(OrderLine.Create(
		                Product.Create(23151,"/image/23333/cf.jpg", BigDecimal.valueOf(16)),
		                	25, BigDecimal.valueOf(13)));
  	
    	List<Order> orders = new ArrayList<Order>();
    	orders.add(Order.Create(
                101,
                orderLines,
                5,
                BigDecimal.valueOf(408),
                BigDecimal.valueOf(89),
                Address.Create("address1", "address2", "country"),
                Address.Create("address1", "address2", "country"),
                "FIRSTBUY",
                new Date()));
    	
    	orders.add(Order.Create(
            156,
            orderLines2,
            5,
            BigDecimal.valueOf(59),
            BigDecimal.valueOf(39),
            Address.Create("address1", "address2", "country"),
            Address.Create("address1", "address2", "country"),
            "",
            new Date()));
    	return orders;
    }
    @Override
    public int Store(Order order)
    {
        return 503;
    }
}

