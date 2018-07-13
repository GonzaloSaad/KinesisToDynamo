package example.dynamo;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.PutItemResult;
import com.amazonaws.services.s3.model.Region;
import example.model.ObjectToConsume;
import example.model.ObjectToProduce;

import java.util.HashMap;
import java.util.Map;

public class DynamoAdapter {

    private final String tableName;
    private final Region region;

    public DynamoAdapter(String tableName, Region region){
        this.tableName = tableName;
        this.region = region;
    }

    public PutItemResult putItem(ObjectToProduce object){
        PutItemRequest request = getRequest(object);
        AmazonDynamoDB db = getDynamoForRegion();
        return db.putItem(request);
    }

    private PutItemRequest getRequest(ObjectToProduce object){
        return new PutItemRequest()
                .withItem(prepareItem(object))
                .withTableName(tableName);
    }


    private Map<String,AttributeValue> prepareItem(ObjectToProduce object){
        Map<String, AttributeValue> map = new HashMap<>();
        map.put("name",new AttributeValue(object.getName()));
        map.put("age", new AttributeValue(Integer.toString(object.getAge())));
        return map;
    }

    private AmazonDynamoDB getDynamoForRegion(){
        return AmazonDynamoDBClientBuilder
                .standard()
                .withRegion(region.toString())
                .build();
    }


}
