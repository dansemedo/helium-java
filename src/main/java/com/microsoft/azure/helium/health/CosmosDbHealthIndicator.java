package com.microsoft.azure.helium.health;

import com.microsoft.azure.documentdb.Database;
import com.microsoft.azure.documentdb.DocumentClient;
import com.microsoft.azure.documentdb.RequestOptions;
import com.microsoft.azure.documentdb.ResourceResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.health.AbstractHealthIndicator;
import org.springframework.boot.actuate.health.Health.Builder;
import org.springframework.stereotype.Component;

/**
 * CosmosDbHealthIndicator
 */
@Component
public class CosmosDbHealthIndicator extends AbstractHealthIndicator {

	@Value("${azure.cosmosdb.database}")
	private String dbName;
	
	@Autowired
	private DocumentClient documentClient;

	@Override
	protected void doHealthCheck(Builder builder) throws Exception {
		try{
			ResourceResponse<Database> response = documentClient.readDatabase("dbs/" + dbName , new RequestOptions());
			if(response.getStatusCode() == 200){
				builder.up().build();
			}else{
				builder.down().withDetail("Error Code", response.getStatusCode()).build();
			}
		}catch(Exception ex){
			builder.down().withDetail("Error", ex.getMessage()).build();
		}
	}

}