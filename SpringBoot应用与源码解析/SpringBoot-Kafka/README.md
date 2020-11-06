#### Kafka中生产者参数
- acks <br/>
>至少要多少个分区副本接收到了消息返回确认消息 <br/>
0(一般是): 只要消息发送出去了就确认(不管是否失败) <br/>
1: 只要有一个broker接收到了消息就返回 <br/>
all: 所有集群副本都接收到了消息确认当然[2 3 4 5]这种数字都可以,就是具体多少台机器接收到了消息返回,但是一般这种情况很少用到

- buffer.memory <br/>
>生产者缓存在本地的消息大小: <br/>
如果生产者在生产消息的速度过快,快过了往broker发送消息的速度,那么就会出现buffer.memory不足的问题. <br/>
默认值为32M,注意:单位是byte,大概3355000左右

- max.block.ms <br/>
>生产者获取kafka元数据(集群数据,服务器数据等)等待时间: <br/>
当因网络原因导致客户端与服务器通讯时等待的时间超过此值时 <br/>
会抛出一个TimeoutException,默认值为:60000ms

- retries <br/>
>设置生产者生产消息失败后重试的次数,默认值:3次

- retry.backoff.ms <br/>
>设置生产者每次重试的间隔,默认:100ms

- batch.size <br/>
>生产者批次发送消息的大小,默认:16k,注意:单位还是byte

- linger.ms <br/>
>生产者生产消息后等待多少毫秒发送到broker与batch.size谁先到达就根据谁,默认值:0

- compression.type <br/>
>kafka在压缩数据时使用的压缩算法 <br/>
可选参数有:none(不压缩)、gzip、snappy <br/>
gzip,和snappy压缩算法之间取舍的话 <br/>
gzip压缩率比较高,系统cpu占用比较大,但是带来的好处是,网络带宽占用少 <br/>
snappy压缩比没有gzip高,cpu占用率不是很高,性能也还行 <br/>
如果网络带宽比较紧张的话,可以选择gzip,一般推荐snappy

- client.id <br/>
>一个标识,可以用来标识消息来自哪,不影响kafka消息生产

- max.in.flight.requests.per.connection
>指定kafka一次发送请求在得到服务器回应之前,可发送的消息数量

#### Kafka中消费者参数
- fetch.min.bytes <br/>
>该属性指定了消费者从服务器获取记录的最小字节数.broker在收到消费者的数据请求时,如果可用的数据量小
 于 fetch.min.bytes 指定的大小,那么它会等到有足够的可用数据时才把它返回给消费者.这样可以降低消费者和
 broker的工作负载,因为它们在主题不是很活跃的时候（或者一天里的低谷时段）就不需要来来回回地处理消
 息.如果没有很多可用数据,但消费者的 CPU 使用率却很高,那么就需要把该属性的值设得比默认值大.如果消
 费者的数量比较多,把该属性的值设置得大一点可以降低 broker 的工作负载.默认值为1byte

- fetch.max.wait.ms <br/>
>我们通过 fetch.min.bytes 告诉 Kafka,等到有足够的数据时才把它返回给消费者。而 feth.max.wait.ms 则用于指
 定 broker 的等待时间，默认是如果没有足够的数据流入Kafka，消费者获取最小数据量的要求就得不到满足，最终
 导致 500ms 的延迟。如果 fetch.max.wait.ms 被设为 100ms，并且 fetch.min.bytes 被设为 1MB，那么 Kafka 在
 收到消费者的请求后，要么返回 1MB 数据，要么在 100ms 后返回所有可用的数据，就看哪个条件先得到满足。
 默认值为500ms

- max.partition.fetch.bytes <br/>
>该属性指定了服务器从每个分区里返回给消费者的最大字节数.默认值是:1MB

- session.timeout.ms 和 heartbeat.interval.ms <br/>
    - session.timeout.ms
    >消费者多久没有发送心跳给服务器服务器则认为消费者死亡/退出消费者组 默认值:10000ms
    - heartbeat.interval.ms
    >消费者往kafka服务器发送心跳的间隔 一般设置为[session.timeout.ms]的三分之一 默认值:3000ms
                                                                                                                                                             >
- auto.offset.reset <br/>
[当消费者本地没有对应分区的offset时,会根据此参数做不同的处理 默认值为:latest]
    - earliest
    >当各分区下有已提交的offset时,从提交的offset开始消费;无提交的offset时`从头开始消费`
    - latest
    >当各分区下有已提交的offset时,从提交的offset开始消费;无提交的offset时`消费新产生的该分区下的数据`
    - none
    >topic各分区都存在已提交的offset时,从offset后开始消费;只要有一个分区不存在已提交的offset`则抛出异常`

- enable.auto.commit <br/>
>todo

- partition.assignment.strategy <br/>
>todo

- max.poll.records <br/>
>单次调用 poll() 方法最多能够返回的记录条数 默认值:500

- receive.buffer.bytes 和 send.buffer.bytes
>todo
