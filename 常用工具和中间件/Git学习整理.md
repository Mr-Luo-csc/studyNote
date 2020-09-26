#### Git常用命令
------
- 查看项目的分支们(包括本地和远程)
```shell script
git branch -a
```
- 删除本地分支
```shell script
git branch -d <branchName>
```
- 删除远程分支
```shell script
git push origin --delete <branchName>
```
- github仓库和本地仓库进行关联
```shell script
git remote add origin <github仓库地址>
```

- 暂时保存当前代码状态

```shell script
//保存
git stash push -m <状态名>
//查看
git stash list
//回退到某个状态(2种方式)
方式一: git stash apply n <n表示的是某个状态的序号>
方式二: git stash pop n <n表示的是某个状态的序号>
//删除
git stash drop n <n表示的是某个状态的序号>
```



