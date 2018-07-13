package example.model.persistance;

import example.model.ObjectToProduce;
import org.socialsignin.spring.data.dynamodb.repository.DynamoDBCrudRepository;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObjectToProduceRepository extends DynamoDBCrudRepository<ObjectToProduce,String> {
}
