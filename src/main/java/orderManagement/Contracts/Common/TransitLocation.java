package orderManagement.Contracts.Common;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class TransitLocation
{
    public String Name;
    public Date mDate;
    public Address Address;

    @JsonCreator
    private TransitLocation(@JsonProperty("name") String name, 
    		@JsonProperty("date") Date date, 
    		@JsonProperty("address") Address address)
    {
        Name = name;
        mDate = date;
        Address = address;
    }

    public static TransitLocation Create(String name, Date date, Address address)
    {
        return new TransitLocation(name, date, address);
    }
}

