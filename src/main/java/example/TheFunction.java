package example;

import example.model.ObjectToConsume;
import example.model.ObjectToProduce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component("kinesisFunction")
public class TheFunction implements Consumer<ObjectToConsume>{



    @Autowired
    ObjectToProduceRepository repository;

    @Override
    public void accept(ObjectToConsume objectToConsume) {
        System.out.println(objectToConsume);
        ObjectToProduce object = objectToConsume.toProduce();

        repository.save(object);
        try{
            ObjectToProduce read = repository.findOne("gonzaL");
            System.out.println(read);
        } catch (Exception e){
            System.out.println("Error: ");
            e.printStackTrace();
        }
        System.out.println("Written to dynamo....");
    }
}
