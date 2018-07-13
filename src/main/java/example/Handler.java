package example;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.events.KinesisEvent;
import example.model.ObjectToConsume;
import org.springframework.cloud.function.adapter.aws.SpringBootKinesisEventHandler;

import java.util.List;
import java.util.Map;


//public class Handler implements RequestHandler<KinesisEvent, Void> {
public class Handler extends SpringBootKinesisEventHandler<ObjectToConsume,Void> {


    @Override
    public List<Void> handleRequest(KinesisEvent event, Context context){
        context.getLogger().log("Handler. \n");
        return super.handleRequest(event,context);
    }
   /* private static final String toAddress = "saad.gonzalo.ale@gmail.com";

    @Override
    public Void handleRequest(KinesisEvent event, Context context) {
        context.getLogger().log("Inside Lambda....\n");
        StringBuilder sb = new StringBuilder("Hello Prone from lambda and kinesis! \n");

        int record = 1;

        for (KinesisEvent.KinesisEventRecord e: event.getRecords()){
            sb.append("Record: ").append(record).append("\n");
            sb.append("Region: ").append(e.getAwsRegion()).append("\n");
            sb.append("Data: ").append(e.getKinesis().getData());
            record++;
        }

        context.getLogger().log(sb.toString());

        return null;
    }*/
}
