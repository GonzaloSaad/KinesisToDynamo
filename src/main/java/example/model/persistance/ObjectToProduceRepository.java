package example.model.persistance;

import example.model.ObjectToProduce;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;

public interface ObjectToProduceRepository extends DynamoDBCrudRepository<ObjectToProduce,String> {
}
