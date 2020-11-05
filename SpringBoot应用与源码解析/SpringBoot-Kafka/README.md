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