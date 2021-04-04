package orderManagement.Domain.Interfaces;


import orderManagement.Domain.TransitLocation;
import java.util.List;

public interface IOrderTrackingRepository
{
    List<TransitLocation> GetTransitLocations(int orderId);
}

