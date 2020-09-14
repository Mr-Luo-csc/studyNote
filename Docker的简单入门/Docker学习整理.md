Docker 是一个开源的应用容器引擎，基于 Go 语言 并遵从 Apache2.0 协议开源。
Docker 可以让开发者打包他们的应用以及依赖包到一个轻量级、可移植的容器中，然后发布到任何流行的 Linux 机器上，也可以实现虚拟化。
容器是完全使用沙箱机制，相互之间不会有任何接口（类似 iPhone 的 app）,更重要的是容器性能开销极低。

目录
===
- [Docker常用命令](##Docker常用命令)
- [DockerFile常用指令(构建镜像)](##DockerFile常用指令(构建镜像))	
- [其它](##其它)
------

## Docker常用命令

>以后的docker命令都运用对象操作

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
docker volume ls
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

## DockerFile常用指令(构建镜像)

**14条常用指定(大写)**

- FROM
- ADD
- COPY
- ...

## 其它

- 
