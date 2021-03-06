#### Git常用命令
------
- 查看项目的分支们(包括本地和远程)
```bash
git branch -a
```
- 删除本地分支
```bash
git branch -d <branchName>
```
- 删除远程分支
```bash
git push origin --delete <branchName>
```
- github仓库和本地仓库进行关联
```bash
git remote add origin <github仓库地址>
```
- 暂时保存当前代码状态

```bash
1.保存
git stash push -m <状态名>

2.查看
git stash list

3.回退到某个状态(2种方式)
方式一:	git stash apply n <n表示:某个状态的序号[例如(stash@{0}]> 或者 <n表示:删除的ID号>
方式二:	git stash pop n <n表示的是某个状态的序号>

4.删除
git stash drop n <n表示的是某个状态的序号>

5.查看删除的提交(结合git stash apply使用)
git fsck –lost-found
```
- 使用频率最高的
```bash
git status
```
- 修改 -m 提交信息
```bash
1.查看最近提交信息[单行显示]
git log --oneline

2.变更最新的message[vim编辑器语法]
git commit --amend
```
- 清除git本地缓存重新提交
```bash
git rm -r --cached .
```
- 拉取远程分支当作本地分支
```bash
git checkout -b 本地分支名 远程分支名<origin/name>
```
- 本地分支关联远程分支
```bash
git branch --set-upstream-to=origin/master master
```
- 强制回退到指定版本
```bash
git reset –hard 版本号<versionId>
```
- git合并某一次提交
```bash
1.查看历史提交的commit_id
git reflog

2.合并提交
git cherry-pick commit_id
```

#### Git常用操作
------
- 创建一个新的空分支
```bash
1.创建新的空白分支
git checkout --orphan <新的分支名>

2.会清除所有git clone下的所有文件,只剩.git
git clean -d -fx

3.清除所有git文件历史,为了空白分支
git rm -rf .

4.添加提交信息
git commit -m "提交信息"

5.推送远程分支
git push origin <新的分支名>
```