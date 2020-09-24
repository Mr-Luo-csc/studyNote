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