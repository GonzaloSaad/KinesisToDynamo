package example;

import example.model.ObjectToProduce;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface ObjectToProduceRepository extends CrudRepository<ObjectToProduce, String> {
}
