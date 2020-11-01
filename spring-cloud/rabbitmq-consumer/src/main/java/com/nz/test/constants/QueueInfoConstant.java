package com.nz.test.constants;

/**
 * 队列、交换机、路由键
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

    /**
     * Fanout Exchange 扇型交换机，这个交换机没有路由键概念，就算你绑了路由键也是无视的。 这个交换机在接收到消息后，会直接转发到绑定到它上面的所有队列。
     */
    public static final String FANOUT_QUEUE_1 = "fanout.chaos";
    public static final String FANOUT_QUEUE_2 = "fanout.single";
    public static final String FANOUT_QUEUE_3 = "fanout.drill";
}
