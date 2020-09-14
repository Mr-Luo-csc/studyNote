## Docker常用命令

===

__以后的docker命令都运用对象操作__

**查看镜像**
```bash
docker image ls
```
**查看容器**
```bash
docker container ls
```
**查看docker占用的空间**
```bash
docker system df
```
**查看挂载的占用内存**
```bash
docker volume ls
```
**查看某个镜像或者容器的日志**
```bash
docker logs
```
**查看某个镜像或者容器的详细信息**
```bash
docker inspect
```
**分配命令行,进入容器内部**
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
