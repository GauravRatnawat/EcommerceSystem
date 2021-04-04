package orderManagement.Domain.Interfaces;

import orderManagement.Domain.Address;
import orderManagement.Domain.OrderLine;
import orderManagement.Domain.Product;
import java.math.BigDecimal;
import java.util.List;

public interface ICostCalculatorService
{
    BigDecimal CalculateTotalPrice(List<OrderLine> orderLines, String promotionCode);
    BigDecimal CalculateShippingPrice(List<Product> products, Address shippingAddress);
}

