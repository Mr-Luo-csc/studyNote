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
------
### Redis五大数据类型
- String
- List
- Set
- Hash
- Zset

