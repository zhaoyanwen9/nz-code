package com.nz.test.constants;

/**
 * 队列、交换机、路由键
 *
 Direct：完全根据key进行投递的，例如，绑定时设置了routing key为”abc”，那么客户端提交的消息，只有设置了key为”abc”的才会投递到队列。
 Topic：对key进行模式匹配后进行投递，符号”#”匹配一个或多个词，符号”*”匹配正好一个词。例如”abc.#”匹配”abc.def.ghi”，”abc.*”只匹配”abc.def”。
 Fanout：不需要key，它采取广播模式，一个消息进来时，投递到与该交换机绑定的所有队列。
 Headers:我们可以不考虑它
 */
public class QueueInfoConstant {

    /**
     * Direct Exchange 直连交换机,直连型交换机，根据消息携带的路由键将消息投递给对应队列。
     */
    public static final String DIRECT_QUEUE = "direct";
    public static final String DIRECT_QUEUE_EXCHANGE = "direct_exchange";
    public static final String DIRECT_QUEUE_ROUTE_KEY = "direct_route_key";

    /**
     * Topic Exchange 主题交换机，这个交换机其实跟直连交换机流程差不多，但是它的特点就是在它的路由键和绑定键之间是有规则的。
     */
    public static final String TOPIC_QUEUE_ALL = "topic.#";
    public static final String TOPIC_QUEUE_1 = "topic.chaos";
    public static final String TOPIC_QUEUE_2 = "topic.single";
    public static final String TOPIC_QUEUE_EXCHANGE = "topic_exchange";
    public static final String TOPIC_QUEUE_ROUTE_KEY = "topic_route_key";

    /**
     * Fanout Exchange 扇型交换机，这个交换机没有路由键概念，就算你绑了路由键也是无视的。 这个交换机在接收到消息后，会直接转发到绑定到它上面的所有队列。
     */
    public static final String FANOUT_QUEUE_1 = "fanout.chaos";
    public static final String FANOUT_QUEUE_2 = "fanout.single";
    public static final String FANOUT_QUEUE_3 = "fanout.drill";
    public static final String FANOUT_QUEUE_EXCHANGE = "fanout_exchange";
    public static final String FANOUT_QUEUE_ROUTE_KEY = "fanout_route_key";

}
