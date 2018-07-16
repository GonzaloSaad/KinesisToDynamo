package example.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import org.springframework.beans.factory.annotation.Value;

@DynamoDBTable(tableName = "object-to-produce")
public class ObjectToProduce {
    private String name;
    private int age;
    private int passed;

    public ObjectToProduce() {
        passed = 10;
    }

    @DynamoDBHashKey
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @DynamoDBAttribute
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "ObjectToProduce{" +
                "name='" + name +"'"+
                ", age=" + age +
                ", passed=" + passed +
                '}';
    }
}
