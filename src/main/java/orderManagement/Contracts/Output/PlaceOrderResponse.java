package orderManagement.Contracts.Output;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;


public class PlaceOrderResponse
{
    boolean IsSuccess;
	String ErrorReason;
    BigDecimal OrderId;
//  To successfully JSON serialize, need to define get/set methods
//  https://stackoverflow.com/questions/32905917/how-to-return-json-data-from-spring-controller-using-responsebody/35822500#35822500
    public boolean isIsSuccess() {
		return IsSuccess;
	}

	public void setIsSuccess(boolean isSuccess) {
		IsSuccess = isSuccess;
	}

	public String getErrorReason() {
		return ErrorReason;
	}

	public void setErrorReason(String errorReason) {
		ErrorReason = errorReason;
	}

	public BigDecimal getOrderId() {
		return OrderId;
	}

	public void setOrderId(BigDecimal orderId) {
		OrderId = orderId;
	}

    @JsonCreator
    private PlaceOrderResponse(@JsonProperty("isSuccess") boolean isSuccess, 
    		@JsonProperty("errorReason") String errorReason, 
    		@JsonProperty("orderId") BigDecimal orderId)
    {
        IsSuccess = isSuccess;
        ErrorReason = errorReason;
        OrderId = orderId;
    }

    public static PlaceOrderResponse Create(boolean isSuccess, 
    		String errorReason, 
    		BigDecimal orderId)
    {
        return new PlaceOrderResponse(isSuccess, errorReason, orderId);
    }
}

