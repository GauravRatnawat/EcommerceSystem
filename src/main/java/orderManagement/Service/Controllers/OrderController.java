package orderManagement.Service.Controllers;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import orderManagement.Application.Interfaces.IOrderService;
import orderManagement.Contracts.Common.*;
import orderManagement.Contracts.Input.*;
import orderManagement.Contracts.Output.*;

// to remove Duplicate Model In Swagger refer
//https://github.com/springfox/springfox/issues/1297
@RestController
@RequestMapping(value="orders")
@Api(tags="Order")
public class OrderController
{
	public IOrderService _orderService;
	
    public OrderController(IOrderService orderService)
    {
        this._orderService = orderService;
    }
    
	@RequestMapping(value = "history/{id}", method = RequestMethod.GET)
	@ApiOperation(value = "Get specific OrderHistory in the System ", notes="Returns a particular",
				response = List.class, tags = "Order")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Suceess|OK"),
			@ApiResponse(code = 401, message = "not authorized!"), 
			@ApiResponse(code = 403, message = "forbidden!!!"),
			@ApiResponse(code = 404, message = "not found!!!"),
			@ApiResponse(code = 500, message="Internal Server Error")
			})
	
    public List<Order> GetOrderHistory(@PathVariable(value = "id") int customerId)
    {
        List<Order> orders = _orderService.GetOrderHistory(customerId);
         return orders;
    }

	@ApiOperation(value = "Get specific OrderTrackingInfo in the System ", response = List.class, tags = "Order")
	@ApiResponses(value = {
			@ApiResponse(code = 200, message = "Suceess|OK")
			})
	@RequestMapping(value = "tracking/{id}", method = RequestMethod.GET)
    public List<TransitLocation> GetOrderTrackingInfo(int orderId)
    {
    	List<TransitLocation> transitLocations = _orderService.GetOrderTrackingInfo(orderId);
        return transitLocations;
    }
	

	@ApiOperation(value = "Place Order ", tags = "Order")
	@ApiResponses(value = { 
			@ApiResponse(code = 200, message = "Suceess|OK")})
	@RequestMapping(method = RequestMethod.POST, consumes={"application/json"})
    public PlaceOrderResponse PlaceOrder(@RequestBody PlaceOrderRequest placeOrderRequest)
    {
    	PlaceOrderResponse placeOrderResponse = _orderService.PlaceOrder(placeOrderRequest);
        return placeOrderResponse;
    }
}

