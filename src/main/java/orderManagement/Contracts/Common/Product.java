package orderManagement.Contracts.Common;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Product
{
    public int Stockcode;
    public String ProductImageUrl;
    public BigDecimal VolumetricWeight;

    @JsonCreator
    private Product(@JsonProperty("stockcode") int stockcode, 
    		@JsonProperty("productImageUrl") String productImageUrl, 
    		@JsonProperty("volumetricWeight") BigDecimal volumetricWeight)
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

