# HW1 Difan Xue

## 2.practice git using the platform. list the git commands you lear
```
git commit - m’comment’: modify the code of repository

git status: See What Branch You're On

git branch: to list local branches

git branch -r: to list remote branches

git branch -a: to list all local and remote branches

git branch <name>: create a branch named xxx

git checkout <name>: switch the branch to the xxx

  git switch: Git version 2.23

git checkout -b <name>: create and switch the branch
```
### Switch the branch from a remote repo
```
git pull
git checkout -track origin/my-branch-name
```
### Push to a branch
```
git merge <name>: merge <name> branch to the the current branch

Second way to merge

git rebase <name>: 实际上就是取出当前branch一系列的提交记录，“复制”它们，然后在另外一个地方(在name branch上)逐个的放下去。

git status: check the current branch

git push
```
## 3.  What is the basic steps to init a git repo in you local ?
```
git init
git status
git add .
git commit -m "comment"
git push origin master/main
```
## 4.  How to clone a repo from Github ?
```
git clone website_url
```
## 5.  How to create a new branch and checkout to that branch ?
```
git checkout - b branch_name
```
## 6.  How to merge the branch_test to master branch in command ? show me the commands
```
git branch main
git merge branch_test
```
## 7.  How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
```
git stash save "comment"
git checkout <name>
git stash apply
git stash pop
```
## 8.  How do you understand PR is based on Branch?
Pull Requests is the fundamental part of Git-based workflows. To collabrate with other developers, it's better to work on secific feature, bug fix on different branch. After pulling the request, the members of the team could view the code and make change of it or approve it to merge with the main branch.
## 9.  What is maven role ? what it be used to do ?
The main roles of maven include managing dependencies, building projcts. But also for documentation, reporting. It used for download or remove the dependencies.
## 10.  What is the lifecycle of maven? could you tell me the details ?
- prepare resources：Resource copying can be customized in this phase.
- validate： Validates if the project is correct and if all necessary information is available.
- compile：Source code compilation is done in this phase.
- Test： Tests the compiled source code suitable for testing framework.
- package： This phase creates the JAR/WAR package as mentioned in the packaging in POM.xml.
- install： This phase installs the package in local/remote maven repository.
- deploy： Copies the final package to the remote repository.
## 11.  what is the difference between package and install in maven lifecycle ?
Package is to create the JAR/WAR package. Install is to install the package created by package phase to the local/remote maven repository.
## 12.  What is plugins in maven, list some plugins.
In Maven, plugins are extensions that provide additional functionality and goals to the build process. Take an example, some old projects use ant to build the project. To build these projects using maven, we need to use plugin to achieve that.
