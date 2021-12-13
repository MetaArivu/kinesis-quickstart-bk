package com.metaarivu;

import java.util.Date;
import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

@Component	
public class FunctionHandler implements Function<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
	
    @Override
    public APIGatewayProxyResponseEvent apply(APIGatewayProxyRequestEvent input) {
    	String csvString = input.getBody();
    	final String msg = csvString;
    	System.out.println("Request="+msg);
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.setStatusCode(200);
        responseEvent.setBody(this.stockJSON(csvString));
        return responseEvent;
    }
    
    private String stockJSON(String str) {
     	System.out.println(str);    	
    	String split []= str.split("\\|");
    	System.out.println(split.length);
    	String stokjson = new Stock(split[0], split[1], Double.valueOf(split[2]), new Date(Long.valueOf(split[3]))).toJSON();
    	System.out.println(stokjson);
    	return stokjson;
    	
    }
    
    public static void main(String[] args) {
    	String str = "123|HDFCBANK|2300.00|"+new Date().getTime();
    	System.out.println(str);
    	String split []= str.split("\\|");
    	System.out.println(split.length);
    	System.out.println(new Stock(split[0], split[1], Double.valueOf(split[2]), new Date(Long.valueOf(split[3]))).toJSON());
	}
}