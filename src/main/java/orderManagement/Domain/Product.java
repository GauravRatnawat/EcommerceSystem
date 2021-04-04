package orderManagement.Domain;

import java.math.BigDecimal;

public class Product
{
    public int Stockcode;
    public String ProductImageUrl;
    public BigDecimal VolumetricWeight;

    private Product(int stockcode, String productImageUrl, BigDecimal volumetricWeight)
    {
        Stockcode = stockcode;
        ProductImageUrl = productImageUrl;
        VolumetricWeight = volumetricWeight;
    }

    public static Product Create(int stockcode, String productImageUrl, BigDecimal volumetricWeight)
    {
        return new Product(stockcode, productImageUrl, volumetricWeight);
    }
}

