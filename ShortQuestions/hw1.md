# Ke Chen - HW1 - Maven & Git & Pr

## 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
https://docs.github.com/en/get-started/writing-on-github/getting-started-with-writing-and-formatting-on-github/basic-writing-and-formatting-syntax

see file : README.md

## 2. practice git using the platform. list the git commands you learned: https://learngitbranching.js.org
see file : git.md

## 3. What is the basic steps to init a git repo in you local ?

cd /path:  navigate to the project directory

`cd desktop/work/chuwa0910`

git init:  initialize the Git repository 在当前目录中创建新的 Git 仓库。

`git init`


## 4. How to clone a repo from Github ?

git clone <repository_url>

`git clone https://github.com/Liam-Zhou/Chuwa0910.git`


## 5. How to create a new branch and checkout to that branch ?
`git checkout -b branch_name`

or:
```
git branch branch_name
git checkout branch_name
```

## 6. How to merge the branch_test to master branch in command ? show me the commands

**using merger 本地**
git merge先做的就是产生当前branch的copy commit， 然后这个commit再同时指向2个parent commits
```
	git checkout master
	git merge branch_test // master现在指向了一个拥有两个 parent 节点的commits

	git checkout branch_test 
	git merge master  // git merge先做的就是产生当前branch的copy commit，但是因为因为 master 继承自 bugFix，Git 什么都不用做，只是简单地把 bugFix 移动到 main 所指向的那个commit
```

**using rebase 远程分享**
```
	git checkout branch_test
	git rebase master  //把branch_test放到master的下面

	git checkout master
	git rebase branch_test // 由于 branch_test 继承自 master，所以 Git 只是简单的把 master 分支的引用向前移动了一下而已
```

## 7. How to stash(隐藏) your new code before leaving branch: branch_learn_stash and pop your stash when you checkout back to branch_learn_stash ? try commands way and intellij way.

- https://blog.csdn.net/weixin_44799217/article/details/128277154
- 需求背景
        <u>有时候在开发过程中，在一个分支上（dev1）已经写了一部分代码，但是需要紧急切换到别的分支(dev2)上修改某个代码，这时候不能直接从dev1分支上切换到dev2分支上，提示你需要保存代码。此时dev1分支上的代码还没有写完，暂时还不能提交。但是想在不提交代码的情况下能够临时保存dev1分支上的代码，然后切换到dev2分支上。等dev2分支上处理完成后，再切换到dev1分支上可以继续工作。</u>
- git stash介绍
        git stash会把所有未提交的修改（包括暂存的和非暂存的）都保存起来，用于后续恢复当前工作目录。通过git stash命令推送一个新的储藏，当前的工作目录就干净了。

        stash是本地的，不会通过git push命令上传到git server上。
- git stash常用命令
	- git stash save "message"  : 执行存储时，添加备注，方便查找，只有git stash save也可以的，但查找时不方便识别。
	- git stash list  ：查看stash了哪些存储

	- git stash show [stash]：查看某个特定stash的变更内容。默认情况下，会显示最新的stash。如果要显示其他存贮，后面加stash@{$num}，比如第二个 git stash show stash@{1}
	- git stash show -p : 显示第一个存储的改动，如果想显示其他存存储，命令：git stash show  stash@{$num}  -p ，比如第二个：git stash show  - stash@{1}  -p

	- git stash apply [stash]: 将某个stash的变更应用到当前工作目录。这个stash不会从stash列表中移除。如果不指定stash，默认会应用最新的stash，默认使用第一个存储,即stash@{0}，如果要使用其他个，git stash apply stash@{$num} ， 比	如第二个：git stash apply stash@{1} 

	- git stash pop [stash]：删除某个stash，从stash列表中移除。如果不指定stash，默认会删除最新的stash, 默认为第一个stash,即stash@{0}，如果要应用并删除其他stash，命令：git stash pop stash@{$num} ，比如应用并删除第二个：git stash pop stash@{1}

	- git stash drop stash@{$num} ：丢弃stash@{$num}存储，从列表中删除这个存储
	- git stash clear ：删除所有缓存的stash。慎用，它会清除所有保存的stash记录。

- 使用 git stash apply 将之前隐藏的更改重新应用到工作副本，但是和 git stash pop 不同， 并不会将他们从stash中删除。 

- git stash在各个分支之间是通用的，不同分支缓存的代码可以保存到另外的分支上。

- 注意：git stash pop默认会恢复上一个，即第一个stash@{0}缓存的内容。建议使用git stash pop之前先使用一下git stash list查看一下，然后使用git stash pop stash@{x}。

### command way
```
	git checkout branch_learn_stash   // 当在branch_learn_stash分支上修改了一些代码，需要切换到main分支上：
	git stash save "Ke Chen"  // 保存当前的修改到stash，并添加描述信息

	git checkout main

	git checkout branch_learn_stash   //切回来

	git stash pop  // 释放之前保存的代码
```

### IntelliJ IDEA way
	https://blog.csdn.net/weixin_42585386/article/details/128252639

	Click on the "Git" in the menu
	Click on "Stash Changes"

	Click on the "Git" branch icon in the bottom-right corner.
	Select the branch want to switch to

	Click on the "Git" in the menu
	Click on "Unstash Changes"

## 8. How do you understand PR is based on Branch?
a PR <u>is stand for "Pull Request"</u>.

A Pull Request is a mechanism for <u>proposing and merging changes from one branch into another branch</u> within a Git repository, often used in platforms like GitHub, GitLab, or Bitbucket.  (Pull Request是一种在Git存储库中提出更改并将其从一个分支合并到另一个分支的机制，通常用于GitHub、GitLab或Bitbucket等平台。)

the changes proposed in the PR are the changes made in the source branch compared to the traget branch.

## 9. What is maven role ? what it be used to do ?

**Role:**
- Maven is software project management and comprehension tool(软件项目管理和理解 的工具).
- Easy to download add and remove the dependencies/libraries

**Used to do:**
- Dependency Management: Automatically handles projects dependencies and fetch them from online repo.
- manage a project's build(the lifecycle of maven)
- reporting and documentation from a central piece of information


## 10. What is the lifecycle of maven? could you tell me the details ?

prepare resource - validate - compile - test - package - install - deploy

- prepare resource: 
resource copying can be customized in this phase.

- validate: 	
validates if the project is correct and if all necessary information is available.

- compile: 	
compiles the source code (in the src/main/java directory). 

- test: 	
runs unit tests found in the src/test/java directory.

- package: 	
packages the compiled code and resources into an artifact, such as a JAR or WAR file.

- install: 	
installs the packaged artifact in local/remote maven repository.

- deploy: 	
copies the final package to the remote repository.


## 11. what is the difference between package and install in maven lifecycle ?

**Purpose**:
- package phase: <u>creates the JAR/WAR package(artifact)</u> as mentioned in the packaging in POM.xml.
(packages the compiled code and resources into an artifact)
- install phase: <u>Installs the package in local/remote maven repository.</u>

**Artifact Destination**:
package phase: The resulting artifact is created <u>in the project's target directory</u> (e.g., target/my-project.jar).
install phase: The artifact <u>is copied from the target directory of the project and placed into your local Maven repository</u> (e.g., ~/.m2/repository/groupId/artifactId/version/artifactId-version.jar).

**Goal**:
package phase:The artifact created in the package phase is not installed in the local repository. It remains in the project's target directory, and it's typically used <u>for local testing and development</u>.
install phase:The primary purpose of the install phase is to <u>make the artifact available locally for other Maven projects</u> on the same machine. This allows other projects to use your project as a dependency during their builds.

## 12. What is plugins in maven, list some plugins.

<u>"Maven" is really just a core framework for a collection of Maven Plugins</u>. In other words, <u>plugins are where much of the real action is performed, plugins are used to: create jar files, create war files, compile code, unit test code, create project documentation, and on and on.</u> Almost any action that you can think of performing on a project is implemented as a Maven plugin.

Here are some commonly used Maven plugins:

- **maven-compiler-plugin**: Compiles Java source code(编译项目的源代码). It's responsible for invoking the Java compiler during the compile phase.
- maven-surefire-plugin: Executes unit tests and generates test reports. It's often associated with the test phase.
- maven-jar-plugin: Builds a JAR file from the current project. It's tied to the package phase.
- maven-war-plugin: Like the JAR plugin but for building WAR files for web applications.
- **maven-clean-plugin**: Cleans up the target/ directory used for the build. Typically tied to the clean phase.
- **maven-install-plugin**: Installs the project's artifact into the local repository. This is usually done during the install phase.
- maven-deploy-plugin: Deploys the project's artifact to a remote repository. It's tied to the deploy phase.
- maven-failsafe-plugin: Designed for integration tests. It ensures that even if there are failures, the post-integration-test phase will still be executed to clean up resources.
- maven-dependency-plugin: Provides operations on dependencies like copying, unpacking, analyzing, etc. maven-release-plugin: Manages the release of a project including tagging and version management.
- maven-site-plugin: Generates a site for the project, which can include documentation generated from the code as well as other documentation.
- maven-assembly-plugin: Used to aggregate multiple artifacts together into a single distributable archive.

## 13. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:
1.  groupID: com.chuwa.learn
2.  artifactID: java-core

see coding file : MavenProject

## 14.  Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other students' PR, please don't merge it.

done















