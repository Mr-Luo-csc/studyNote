Docker 是一个开源的应用容器引擎，基于 Go 语言 并遵从 Apache2.0 协议开源。<br>
Docker 可以让开发者打包他们的应用以及依赖包到一个轻量级、可移植的容器中，然后发布到任何流行的 Linux 机器上，也可以实现虚拟化。<br>
容器是完全使用沙箱机制，相互之间不会有任何接口（类似 iPhone 的 app）,更重要的是容器性能开销极低。<br>

目录
===
- [Docker常用命令](#Docker常用命令)
- [DockerFile常用指令](#DockerFile常用指令)
- [Docker的几类网络配置](#Docker的几类网络配置)
- [Docker-Compose](#Docker-Compose)
- [使用Docker时遇到的问题](#使用Docker时遇到的问题)
------

## Docker常用命令

>以后的docker命令都运用对象操作
查看docker信息
```bash
docker info
```
查看镜像
```bash
docker image ls
```
查看容器
```bash
docker container ls
```
查看docker占用的空间
```bash
docker system df
```
查看挂载的[本地或者其它位置]占用内存
```bash
1.查看挂载卷
docker volume ls

2.删除宿主机上无用的挂载卷
docker volume prune
```
查看容器的运行日志
```bash
docker logs
```
查看某个镜像或者容器的详细信息
```bash
docker inspect
```
分配命令行,进入容器内部
```bash
docker exec -it 容器名 /bin/bash
```
运行容器时,挂载目录
```bash
docker run --name test -d -P <映射容器中的所有端口到宿主机,宿主机随机分配端口> -v /usr/local/data:/var/data <宿主机目录:容器目录> test:v1
```

## DockerFile常用指令

**14条常用指定(大写)**

- FROM
- ADD
- COPY
- ...

## Docker的几类网络配置

- bridge
- host
- none
- container

**常用命令**
```bash
1.将容器连接到网络
docker network connect

2.创建新的Docker网络.默认情况下,在Windows上会采用NAT驱动,在Linux上会采用Bridge驱动.可以使用 -d 参数指定驱动(网络类型)
docker network create

3.断开容器的网络
docker network disconnect

4.提供Docker网络的详细配置信息
docker network inspect

5.用于列出运行在本地Docker主机上的全部网络
docker network ls

6.删除Docker主机上全部未使用的网络
docker network prune

7.删除Docker主机上指定网络
docker network rm
```

**思考:不同网桥下的容器间能通信吗?**
1. 先手动建立一个bridge模式的新网桥,docker network create --driver bridge --subnet=172.18.0.0/16 --gateway=172.18.0.1 new_bridge
2. docker network ls 可以查看docker下现在的网络模式(新加的那个)
3. docker run --name test1 -ti --net=new_bridge 镜像名 `用新网桥的一个容器test1`
4. docker run --name test2 -ti --net=bridge 镜像名 `用docker默认网桥的一个容器test2`
5. 进入到其中一个容器,ip a查看网卡,ping另一个容器IP
6. 进另一个容器,同上.两个容器IP段不一样.不同网桥,会创建不同网段的虚拟网卡给容器
7. 不同网桥下的容器间不能ping通,在于docker设计时候就隔离了不同网桥
8. docker network connect new_bridge test2 //为test2容器添加一块new_bridge的虚拟网卡,这样test2上会创建一个新的虚拟网卡,网段就是新网桥设置的
9. 如此就能互相ping通

## Docker-Compose

**使用Docker Compose运行多个容器**

**常用命令(慎用还未尝试)**
```bash
1.构建镜像
docker-compose build --no-cache

2.后台运行镜像
docker-compose up -d

3.列出所有运行容器
docker-compose ps

4.查看服务日志输出
docker-compose logs

5.yml文件中指定host的网络模式,配置如下参数:
network_mode: host
```

## 使用Docker时遇到的问题

- 问题一:docker: Error response from daemon故障

```bash
step1: pkill docker
step2: iptables -t nat -F
step3: ifconfig docker0 down
step4: brctl delbr docker0
step5: service docker restart
```

- 问题二:如何将镜像推送到阿里云
```bash
1. 登录阿里云的docker仓库
$ sudo docker login --username=[用户名] registry.cn-hangzhou.aliyuncs.com

2. 创建指定镜像的tag，归入某个仓库
$ sudo docker tag [镜像ID] registry.cn-hangzhou.aliyuncs.com/huaan/huaan:[镜像版本号]

3. 将镜像推送到仓库
$ sudo docker push registry.cn-hangzhou.aliyuncs.com/huaan/huaan:[镜像版本号]
```