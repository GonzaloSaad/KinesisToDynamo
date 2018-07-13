package example.model.persistance;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableDynamoDBRepositories(basePackages = "example.model.persistance", dynamoDBOperationsRef = "dynamoDBOperations")
@Configuration
public class DynamoDBConfiguration {

    @Bean
    public AmazonDynamoDB amazonDynamoDB(){
        return AmazonDynamoDBClientBuilder
                .standard()
                //.withRegion(System.getenv("dynamoRegion"))
                .withRegion(Regions.SA_EAST_1.toString())
                .build();
    }
}
