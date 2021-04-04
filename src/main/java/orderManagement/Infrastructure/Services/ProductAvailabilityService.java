package orderManagement.Infrastructure.Services;

import org.springframework.stereotype.Service;

import orderManagement.Domain.Interfaces.IProductAvailabilityService;

@Service
class ProductAvailabilityService implements IProductAvailabilityService
{
	@Override
    public boolean CheckProductAvailability(int stockCode, int quantity)
    {
        return true;
    }
}
