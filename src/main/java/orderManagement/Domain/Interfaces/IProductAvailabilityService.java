package orderManagement.Domain.Interfaces;


public interface IProductAvailabilityService
{
    boolean CheckProductAvailability(int stockCode, int quantity);
}

