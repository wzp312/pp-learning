package cn.itcast.mq.listener;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Map;

@Component
public class SpringRabbitListener {


/*简单消息队列*/


    @RabbitListener(queues = "simple.queue")  //指明监听队列
    public void listenSimpleQueue(String msg) throws InterruptedException {
        System.out.println("spring 消费者接收到消息：【" + msg + "】");
        throw new RuntimeException("故意的异常");
    }



/*工作消息队列 work queue*//*

    @RabbitListener(queues = "simple.queue")  //指明监听队列
    public void listenWorkQueue1(String msg) throws InterruptedException {
        System.out.println("spring 消费者接收到消息：【" + msg + "】" + LocalTime.now());
        Thread.sleep(20);
    }

    @RabbitListener(queues = "simple.queue")  //指明监听队列
    public void listenWorkQueue2(String msg) throws InterruptedException {
        System.err.println("spring 消费者接收到消息：【" + msg + "】" + LocalTime.now());
        Thread.sleep(200);
    }
*/


     /*发布订阅  Fanout交换机*/
      @RabbitListener(queues = "fanout.queue1")
      public void listenFanoutQueue1(String msg) {
          System.out.println("消费者1接收到Fanout.queue1消息：【" + msg + "】");
      }

      @RabbitListener(queues = "fanout.queue2")
      public void listenFanoutQueue2(String msg) {
          System.out.println("消费者2接收到Fanout.queue2消息：【" + msg + "】");
      }

    /*发布订阅  Direct交换机*/
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue1"),
            exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "blue"}
    ))
    public void listenDirectQueue1(String msg){
        System.out.println("消费者接收到direct.queue1的消息：【" + msg + "】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "direct.queue2"),
            exchange = @Exchange(name = "itcast.direct", type = ExchangeTypes.DIRECT),
            key = {"red", "yellow"}
    ))
    public void listenDirectQueue2(String msg){
        System.out.println("消费者接收到direct.queue2的消息：【" + msg + "】");
    }


    /*topic交换机*/
    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue1"),
            exchange = @Exchange(name = "wzp.topic", type = ExchangeTypes.TOPIC),
            key = "china.#"
    ))
    public void listenTopicQueue1(String msg){
        System.out.println("消费者接收到topic.queue1的消息：【" + msg + "】");
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(name = "topic.queue2"),
            exchange = @Exchange(name = "wzp.topic", type = ExchangeTypes.TOPIC),
            key = "#.news"
    ))
    public void listenTopicQueue2(String msg){
        System.out.println("消费者接收到topic.queue2的消息：【" + msg + "】");
    }


    /*测试JSON消息转换器*/
    @RabbitListener(queues = "object.queue")
    public void listenObjectQueue(Map<String, Object> msg) {
        System.out.println("收到消息：【" + msg + "】");
    }


}