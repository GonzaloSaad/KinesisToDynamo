package example;

import com.amazonaws.services.s3.model.Region;
import example.model.ObjectToConsume;
import example.model.ObjectToProduce;
import example.model.persistance.ObjectToProduceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component("kinesisFunction")
public class TheFunction implements Consumer<ObjectToConsume>{

    private static final String tableName = "lambdatest";
    private static final Region region = Region.SA_SaoPaulo;

    @Autowired
    private ObjectToProduceRepository repository;

    @Override
    public void accept(ObjectToConsume objectToConsume) {

        System.out.println(objectToConsume);
        ObjectToProduce object = objectToConsume.toProduce();

/*        DynamoAdapter dynamoAdapter = new DynamoAdapter(tableName,region);
        PutItemResult result = dynamoAdapter.putItem(object);*/

        repository.save(object);

        //System.out.println("Result: " + result.toString());
        System.out.println("Written to dynamo....");
    }
}
