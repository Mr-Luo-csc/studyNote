### Redis常用命令
- 查看键
```bash
keys <pattern>

列出所有键:
keys *
```
- 创建
```bash
set key value
```
- 获取值
```bash
get key
```
- 查看临时密码
```bash
config get requirepass

设置临时密码
config set requirepass <password>

持久化密码
config rewrite (可以将config set持久化到Redis配置文件中)

设置永久密码的另一种操作,修改redis.conf配置文件的requirepass参数
```
- 清库
```bash
清除当前库中的数据
flushDB

清除16个库中的数据
flushALL
```
- linux下启动redis实例、客户端连接操作
```bash
/usr/local/bin/redis-server + <要启动redis实例的配置文件路径>

/usr/local/bin/redis-cli -h<ip> -p<port> -c<表示使用集群的方式连接>
```
- redis过期时间相关命令
```bash
设置一个key在seconds秒后失效
EXPIRE key "seconds"

设置一个key在milliseconds毫秒后失效
PEXPIRE key "milliseconds"

获取key的过期时间,秒,[如果key是永久的,返回-1;如果key不存在或者已过期,返回-2]
TTL key

获取key的过期时间,毫秒
PTTL key
```
- 查看mysql事务和锁的情况
```mysql
show processlist;
select * from information_schema.innodb_trx; -- 搜索的数据中找到`trx_mysql_thread_id`列中的线程id,kill id
SELECT * FROM INFORMATION_SCHEMA.INNODB_LOCKS;
SELECT * FROM INFORMATION_SCHEMA.INNODB_LOCK_WAITS;
```

------
### Redis五大数据类型
- String
- List
- Set
- Hash
- Zset

