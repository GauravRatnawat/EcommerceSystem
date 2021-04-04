package orderManagement.Domain.Services;

import orderManagement.Domain.Interfaces.ICostCalculatorService;
import orderManagement.Domain.Product;
import orderManagement.Domain.Address;
import orderManagement.Domain.OrderLine;
import java.util.List;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

// You can create package-private classes by omitting the security modifier (public, private)
// from the class's declaration. It is equivalent to c# "internal class"

@Service
public class CostCalculatorService implements ICostCalculatorService
{
	@Override
    public BigDecimal CalculateShippingPrice(List<Product> products, Address shippingAddress)
    {
        return BigDecimal.valueOf(50);
    }
	@Override
    public BigDecimal CalculateTotalPrice(List<OrderLine> orderLines, String promotionCode)
    {
    	if (orderLines.isEmpty())
    		return BigDecimal.valueOf(0);
    	
    	BigDecimal sum = new BigDecimal("0");

    	for (OrderLine line : orderLines)
    	{
    		sum.add(line.UnitPrice.multiply(BigDecimal.valueOf(line.Quantity)));
    	}
        return sum;
    }
}   


