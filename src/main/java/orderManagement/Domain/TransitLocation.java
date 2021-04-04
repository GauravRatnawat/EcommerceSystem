package orderManagement.Domain;

import java.util.Date;

public class TransitLocation
{
    public String Name;
    public Date mDate;
    public Address Address;

    private TransitLocation(String name, Date date, Address address)
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

