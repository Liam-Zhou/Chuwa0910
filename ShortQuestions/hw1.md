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
```
	git checkout master
	git merge branch_test
```
or
```
	git chekout master
	git rebase branch_test
```


## 7. How to stash(隐藏) your new code before leaving branch: branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.

### command way
	git checkout branch_learn_stash
	git stash save "Ke Chen"

	git checkout main

	git checkout branch_learn_stash

	git stash pop

### IntelliJ IDEA way
	Click on the "VCS" menu
	Select "Git"
	Click on "Stash Changes"

	Click on the "Git" branch icon in the bottom-right corner.
	Select the branch want to switch to

	lick on the "VCS" menu
	Select "Git"
	Click on "Unstash Changes"

## 8. How do you understand PR is based on Branch?
a PR <u>is stand for "Pull Request"</u>.

A Pull Request is a mechanism for <u>proposing and merging changes from one branch into another branch within a Git repository</u>, often used in platforms like GitHub, GitLab, or Bitbucket. 

the changes proposed in the PR are the changes made in the source branch compared to the traget branch.

## 9. What is maven role ? what it be used to do ?

Maven is <u>a popular build automation and project management tool</u>(构建自动化 + 项目管理 的工具) used primarily for Java projects.

Its primary purpose is <u>to manage and automate various aspects of the software development lifecycle, including building, packaging, and dependency management</u>. (管理和自动化软件开发生命周期的各个方面，包括构建、打包和依赖关系管理。)

In summary, Maven simplifies and standardizes the build and project management process for Java-based applications. 


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

- package phase: packages the compiled code and resources into an artifact, such as a JAR or WAR file.
- install phase: Installs the packaged artifact in local/remote maven repository.

**Artifact Destination**:

package phase: The resulting artifact is created in the project's target directory (e.g., target/my-project.jar).
install phase: The artifact is copied from the target directory of the project and placed into your local Maven repository (e.g., ~/.m2/repository/groupId/artifactId/version/artifactId-version.jar).

**Local Respository**:
package phase:The artifact created in the package phase is not installed in the local repository. It remains in the project's target directory, and it's typically used for local testing and development.
install phase:The primary purpose of the install phase is to make the artifact available locally for other Maven projects on the same machine. This allows other projects to use your project as a dependency during their builds.

In summary, the key difference between the package and install phases lies in where the resulting artifact is stored:

package: creates the artifact in the project's target directory but doesn't install it in the local repository. It's mainly used for local testing and development within the project.
install: not only creates the artifact but also copies it to the local Maven repository, making it available for use as a dependency in other Maven projects on your machine.

## 12. What is plugins in maven, list some plugins.
In Maven, plugins are extensions or modules that provide additional functionality to the build process.

1. Maven Compiler Plugin (maven-compiler-plugin):
	    Purpose: Compiles Java source code in your project.
        Common Goals: compile, testCompile
2. Maven Surefire Plugin (maven-surefire-plugin):
        Purpose: Executes unit tests in your project.
        Common Goals: test
3. Maven Failsafe Plugin (maven-failsafe-plugin):
        Purpose: Executes integration tests in your project.
        Common Goals: integration-test, verify


## 13. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:
1.  groupID: com.chuwa.learn
2.  artifactID: java-core

	![the picture to show how to make a maven project by IntelliJ IDEA](/Users/kechen/Desktop/work/Chuwa0910/ShortQuestions/Q12.png)

## 14.  Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other 
students' PR, please don't merge it.
















