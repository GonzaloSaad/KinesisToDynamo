package example;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.s3.model.Region;
import example.model.ObjectToConsume;
import example.model.ObjectToProduce;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

@Component("kinesisFunction")
public class TheFunction implements Consumer<ObjectToConsume>{

    private static final String tableName = "lambdatest";
    @Override
    public void accept(ObjectToConsume objectToConsume) {

        System.out.println(objectToConsume);
        ObjectToProduce object = objectToConsume.toProduce();

        Map<String, AttributeValue> map = new HashMap<>();
        map.put("name",new AttributeValue(object.getName()));
        map.put("age", new AttributeValue(Integer.toString(object.getAge())));

        AmazonDynamoDB db = AmazonDynamoDBClientBuilder
                .standard()
                .withRegion(Region.SA_SaoPaulo.toString())
                .build();

        PutItemRequest request = new PutItemRequest();
        request.setTableName(tableName);
        request.setItem(map);


        PutItemResult result = db.putItem(request);
        System.out.println("Result: " + result.toString());
    }
}
