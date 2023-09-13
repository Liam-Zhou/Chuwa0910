3. What is the basic steps to init a git repo in you local ?

> Create a new directory, and in the terminal `git init` to create the git file.

4.  How to clone a repo from Github ?

> in CLI, use `git clone` to clone a repository from remote.    

5.  How to create a new branch and checkout to that branch ?

> Create a new branch, you can use `git branch <branch-name>` without switch new branch and `git checkout -b <branch-name>` create and swith to new branch.  

6.  How to merge the branch_test to master branch in command ? show me the commands

```
git checkout master 
git merge branch_test 
```

7.  How to stash your new code before leaving branch branch_learn_stash and pop your stash when you 
checkout back to **branch_learn_stash ? try commands way and intellij way.

> For commands, After you changed some files, use `git add .` to stage all the changes. And then use `git stash` to the current branch. After you want to resume the change, you can ise `git stash pop` on the previous branch you stashed. 

> For intellij, they have the shelf function same as stash. the only difference would be shelf can only be used in intellij. 

8.  How do you understand PR is based on Branch?

> It is the a function for user to merge two branches. 

9.  What is maven role ? what it be used to do ?

> a dependency/package manager, meanwhile has some kind of CI/CD functions to delop the java project. In general, we are using maven as dependency manager. 

10.  What is the lifecycle of maven? could you tell me the details ?

> In general, there are several steps for lifecycles. 
> * prepare-resources: collected needed resrouces 
> * validate: Validate the correctness of the project 
> * compile: Source code compilation 
> * Test: test the compiled project 
> * package: create JAR package 
> * install: install the package to local/remote maven 
> * Deploy: Copy final package to remote repo 

11.  what is the difference between package and install in maven lifecycle ?

> In package stage, it will pack all the code, package into artifact. But not in the local/remote maven. However in the install state, it will make all the package in to the local/remote moven repository. 

12.  What is plugins in maven, list some plugins.

> In general, maven plugin is some old package, or some real actions like create jar, compile files. Like maven-clean-plugin for removing the target directory of a maven project. 

13.  In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:
     _ groupID: com.chuwa.learn 
     _ artifactID: java-core 

> In the coding file. 

14.  Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other 
students' PR, please don't merge it

> Done