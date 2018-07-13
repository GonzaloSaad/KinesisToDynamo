package example;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.s3.model.Region;
import example.dynamo.DynamoAdapter;
import example.model.ObjectToConsume;
import example.model.ObjectToProduce;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Component("kinesisFunction")
public class TheFunction implements Consumer<ObjectToConsume>{

    private static final String tableName = "lambdatest";
    private static final Region region = Region.SA_SaoPaulo;
    @Override
    public void accept(ObjectToConsume objectToConsume) {

        System.out.println(objectToConsume);
        ObjectToProduce object = objectToConsume.toProduce();

        DynamoAdapter dynamoAdapter = new DynamoAdapter(tableName,region);
        PutItemResult result = dynamoAdapter.putItem(object);
        System.out.println("Result: " + result.toString());
    }
}
