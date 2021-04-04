package orderManagement.Application;

import orderManagement.Domain.Interfaces.*;
import orderManagement.Domain.Address;
import orderManagement.Domain.Order;
import orderManagement.Domain.OrderLine;
import orderManagement.Domain.Product;
import orderManagement.Domain.TransitLocation;
import orderManagement.Application.Interfaces.IOrderService;
import orderManagement.Application.Interfaces.IPublisher;
import orderManagement.Contracts.Input.PlaceOrderRequest;
import orderManagement.Contracts.Output.PlaceOrderResponse;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OrderService implements IOrderService
{
    private IPublisher _publisher;
    private ICostCalculatorService _costCalculatorService;
    private IOrderRepository _orderRepository;
    private IOrderTrackingRepository _orderTrackingRepository;
    private IProductAvailabilityService _productAvailabilityService;

  
    public OrderService(IPublisher publisher, ICostCalculatorService costCalculatorService, 
    		IOrderRepository orderRepository, IOrderTrackingRepository orderTrackingRepository, 
    		IProductAvailabilityService productAvailabilityService)
    {
    	super();
    	this._publisher = publisher;
    	this._costCalculatorService = costCalculatorService;
    	this._orderRepository = orderRepository;
    	this._orderTrackingRepository = orderTrackingRepository;
    	this._productAvailabilityService = productAvailabilityService;
    }
    
    @Override
    public List<orderManagement.Contracts.Common.Order> GetOrderHistory(int customerId)
    {
        // Load orders from the repository
        List<Order> orders = _orderRepository.Search(customerId);
        //Convert to output contracts and return
        List<orderManagement.Contracts.Common.Order> listOrders = 
        		new ArrayList<orderManagement.Contracts.Common.Order>();
        for (Order order:orders) {
        	listOrders.add(MapToContract(order, null));
        }
//        var contractOrders = orders.Select(order => MapToContract(order));
        return listOrders;
    }
    @Override
    public List<orderManagement.Contracts.Common.TransitLocation> GetOrderTrackingInfo(int orderId)
    {
        //Load order from the repository
        Order domainOrder = _orderRepository.Load(orderId);
        List<orderManagement.Contracts.Common.TransitLocation> listTransitLocation =
        		new ArrayList<orderManagement.Contracts.Common.TransitLocation>();
        if (domainOrder == null)
            return listTransitLocation;

        //Load the transit locations
        domainOrder.WithOrderTrackingRepository(_orderTrackingRepository);
        domainOrder.LoadTransitLocations();

        //Convert to output contracts and return
        for (TransitLocation transit:domainOrder.TransitLocations)
        {
        	listTransitLocation.add(
        			orderManagement.Contracts.Common.TransitLocation.Create(
        					transit.Name,
        					transit.mDate,
        					orderManagement.Contracts.Common.Address.Create(
        							domainOrder.BillingAddress.AddressLine1,
        							domainOrder.BillingAddress.AddressLine2,
        							domainOrder.BillingAddress.Country)));
        }
        return listTransitLocation;
    }
    
    @Override
    public PlaceOrderResponse PlaceOrder(PlaceOrderRequest request)
    {
        //Create domain order from the request
    	List<OrderLine> orderLines = new ArrayList<OrderLine>();
    	for (orderManagement.Contracts.Common.OrderLine orderLine:request.Order.OrderLines) {
    		orderLines.add(OrderLine.Create(
    				Product.Create(orderLine.Product.Stockcode, orderLine.Product.ProductImageUrl, orderLine.Product.VolumetricWeight), 
    				orderLine.Quantity, 
    				orderLine.UnitPrice));
    	}
        Order domainOrder = Order.Create(
            orderLines,
            request.Order.CustomerId,
            Address.Create(request.Order.BillingAddress.AddressLine1,
                                request.Order.BillingAddress.AddressLine2,
                                request.Order.BillingAddress.Country),
            Address.Create(request.Order.ShippingAddress.AddressLine1,
                                request.Order.ShippingAddress.AddressLine2,
                                request.Order.ShippingAddress.Country),
            request.Order.PromotionCode,
            request.Order.DatePlaced,
            _costCalculatorService,
            _productAvailabilityService,
            _orderTrackingRepository
            );
        
        //Perform domain validation
        if (domainOrder.CanPlaceOrder(request.ExpectedTotalCost, request.ExpectedShippingCost))
        {
            //store the order in the repository
            int orderId = _orderRepository.Store(domainOrder);
            PlaceOrderResponse response = PlaceOrderResponse.Create(true, String.valueOf(""), BigDecimal.valueOf(orderId));
            //publish
            _publisher.Publish(MapToContract(domainOrder, orderId));
            return response;
        }
        else
        {
        	PlaceOrderResponse response = PlaceOrderResponse.Create(false, "Order validation failed", null);
            return response;
        }
    }

    private orderManagement.Contracts.Common.Order MapToContract(Order order, Integer orderId)
    {
    	List<orderManagement.Contracts.Common.OrderLine> orderLines = 
    			new ArrayList<orderManagement.Contracts.Common.OrderLine>();
    	for (OrderLine orderLine:order.OrderLines) {
    		orderLines.add(orderManagement.Contracts.Common.OrderLine.Create(
    				orderManagement.Contracts.Common.Product.Create(orderLine.Product.Stockcode, orderLine.Product.ProductImageUrl, orderLine.Product.VolumetricWeight), 
    				orderLine.Quantity, 
    				orderLine.UnitPrice));
    	}
    	
        return orderManagement.Contracts.Common.Order.Create(
            (orderId != null) ? orderId:order.OrderId,
            		     	orderLines,
            order.CustomerId, order.TotalCost,
            order.ShippingCost,
            orderManagement.Contracts.Common.Address.Create(order.BillingAddress.AddressLine1,
                                order.BillingAddress.AddressLine2,
                                order.BillingAddress.Country),
            orderManagement.Contracts.Common.Address.Create(order.ShippingAddress.AddressLine1,
                                order.ShippingAddress.AddressLine2,
                                order.ShippingAddress.Country),
            order.PromotionCode,
            order.DatePlaced);
    }
}

