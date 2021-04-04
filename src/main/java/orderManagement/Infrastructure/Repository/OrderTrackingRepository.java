package orderManagement.Infrastructure.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import orderManagement.Domain.Address;
import orderManagement.Domain.TransitLocation;
import orderManagement.Domain.Interfaces.IOrderTrackingRepository;

@Service
public class OrderTrackingRepository implements IOrderTrackingRepository
{
	@Override
    public List<TransitLocation> GetTransitLocations(int orderId)
    {
    	List<TransitLocation> transitLocations= new ArrayList<TransitLocation>();
    	transitLocations.add(
            TransitLocation.Create(
                "loc1",
                new Date(),
                Address.Create(
                    "addressLine1",
                    "addressLine2",
                    "country")));
    	transitLocations.add(
            TransitLocation.Create(
                "loc2",
                new Date(),
                Address.Create(
                    "addressLine1",
                    "addressLine2",
                    "country")));
        return transitLocations;
    }
}

