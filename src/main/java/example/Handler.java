package example;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.KinesisEvent;
import example.model.ObjectToConsume;
import org.springframework.cloud.function.adapter.aws.SpringBootKinesisEventHandler;

import java.util.List;
import java.util.Map;


public class Handler extends SpringBootKinesisEventHandler<ObjectToConsume,Void> {


    @Override
    public List<Void> handleRequest(KinesisEvent event, Context context){
        context.getLogger().log("Handler. \n");
        return super.handleRequest(event,context);
    }

}
