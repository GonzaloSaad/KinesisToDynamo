package example;

import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import org.socialsignin.spring.data.dynamodb.repository.config.EnableDynamoDBRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@EnableDynamoDBRepositories(basePackages = "example.model.persistance")
@SpringBootApplication
public class AppStart {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(AppStart.class, args);
    }

    @Bean
    public AmazonDynamoDB amazonDynamoDB(){
        return AmazonDynamoDBClientBuilder
                .standard()
                //.withRegion(System.getenv("dynamoRegion"))
                .withRegion(Regions.SA_EAST_1.toString())
                .build();
    }
}
