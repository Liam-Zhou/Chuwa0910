write your answer to this folder.

2. practise git using the platform. list the git command your learned
- git init
- git clone
- git add
- git rm
- git commit
- git status
- git log
- git branch
- git checkout
- git pull
- git push
- git fetch
- git reset
- git diff
- git status
- git cherry-pick
- git rebase

3.  What is the basic steps to init a git repo in you local ?
```bash
cd /path/to/your/directory
git init
git add .
git commit -m "commit_message"
 ```
4.  How to clone a repo from Github ?
```bash
git clone ssh_url
```

5.  How to create a new branch and checkout to that branch ?
```bash 
git branch branch_name
git checkout -b branch_name
```
6.  How to merge the branch_test to master branch in command ? show me the commands
```bash
git checkout master
git merge branch_test
```
7.  How to stash your new code before leaving branch branch_learn_stash and pop your stash when you
    checkout back to **branch_learn_stash ? try commands way and intellij way.
```bash
git stash
git checkout branch_learn_stash
git stash pop
```

8.  How do you understand PR is based on Branch?
```text
PR is a request to merge a branch to another branch.
```
9.  What is maven role ? what it be used to do ?
```text
Maven is a project life cycle management tool for Java. It can be used to build, test and deploy a project.
```

10.  What is the lifecycle of maven? could you tell me the details ?
```text
- validate: this phase validates the project and its configuration. It checks for things like the presence of required properties and dependencies. If validation fails, the build will stop.
- package: Packages the compiled code and resources into a distributable format, such as a JAR, WAR, or EAR file. The packaged artifact is placed in the target directory.
- compile: This is where the project's source code is compiled into binary bytecode. The compiled classes are placed in the target/classes directory.
- test: Executes the project's unit tests. It runs the test cases using a testing framework like JUnit
- install:Copies the project's package to the local repository, making it available for other projects to use as a dependency. 
- deploy:Deploys the project's package to a remote repository, making it available for other developers or projects.
```


11.  what is the difference between package and install in maven lifecycle ?
```text
package: Packages the compiled code and resources into a distributable format, such as a JAR, WAR, or EAR file. The packaged artifact is placed in the target directory.
install:Copies the project's package to the local repository, making it available for other projects to use as a dependency. 
```
12.  What is plugins in maven, list some plugins.
```text
Plugins are used to perform specific tasks in Maven. For example, the compiler plugin is used to compile the project's source code, the surefire plugin is used to run the project's unit tests, and the jar plugin is used to create a JAR file for the project.
-maven-compiler-plugin
-maven-war-plugin
```