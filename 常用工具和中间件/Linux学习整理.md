### 一、常用Linux命令

当前用户根目录
```bash
cd ～
```
mac顶层目录
```bash
cd /
```
查看命令
```bash
ps -ef | grep redis
```
创建一个新的空白文件
```bash
touch <fileName>
```
查看日志输出文件
```bash
tail -f -n 500 <logFile-path>(/usr/logs/info/e.log)
```
移动文件到指定目录
```bash
mv <文件名> <目标目录路径>
例如:
mv example.txt /usr/local
```
刷新网络配置
```bash
sudo dscacheutil -flushcache; sudo killall -HUP mDNSResponder; say DNS cache flushed
```
解压tar文件
```bash
tar  -zxvf <压缩文件名>
```
mac添加网络配置
```bash
1.必须是root用户
must be root to alter routing table

2.mac切换root用户
sudo su

3.添加路由
route -n add -net 172.10.0.0 -netmask 255.255.0.0 192.168.208.100
```
命令查看端口
```bash
netstat -ntlp
```
重启网卡
```bash
service network restart
```
mac终端配置重新生效
```bash
source ~/.bash_profile
```
mac命令查看某服务是否安装`标注:新版本的Xcode已经不支持SVN了`
```bash
which svn
```
mac安装homebrew安装到指定目录
```bash
1.安装到/usr/local/homebrew
mkdir homebrew && curl -L https://github.com/Homebrew/homebrew/tarball/master | tar xz --strip 1 -C homebrew

2.配置环境变量,修改(.bash_profile)这个文件,添加以下配置:
homebrew=/usr/local/homebrew/bin:/usr/local/homebrew/sbin
export PATH=$homebrew:$PATH

3.使文件生效
source ~/.bash_profile
```

### 二、Linux常识

**1.GCC[接口程序]**

>1.GCC是一个用于Linux系统下编程的编译器,是一个用于编程开发的自由编译器<br>
>2.最初GCC只是一个C语言编译器,GCC借助于它的特性,具有了交叉编译器的功能,即在一个平台下编译另一个平台的代码<br>
>3.GCC-C++(G++) 表示的是: C++编译器,G++: 安装大小84MB

查看GCC版本
```bash
gcc -v
```
------