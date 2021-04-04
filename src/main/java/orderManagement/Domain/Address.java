package orderManagement.Domain;

public class Address
{
    public String AddressLine1;
    public String AddressLine2;
    public String Country;

    private Address(String addressLine1, String addressLine2, String country)
    {
        AddressLine1 = addressLine1;
        AddressLine2 = addressLine2;
        Country = country;
    }
    public static Address Create(String addressLine1, String addressLine2, String country)
    {
        return new Address(addressLine1, addressLine2, country);
    }
}

