### 1.Learn MarkDown and show all of basic usage in the ShortQuestions/README.md

# A first-level heading
## A second-level heading
### A third-level heading
**bold text**


### 2.Practice git using the platform. list the git commands you learned
```bash
git commit
git checkout
git branch
git merge
git init
git status
git add .
git branch
git rebase
git clone
git pull
git push
git stash
git remote
```

### 3. How to initialize a local git repository?
```bash
git init
```
### 4.  How to clone a repo from Github ?
```bash
git clone [URL_OF_THE_REPOSITORY]
```
### 5.  How to create a new branch and checkout to that branch ?
```bash
git branch [BRANCH_NAME]
git checkout [BRANCH_NAME]
```
### 6.  How to merge the branch_test to master branch in command ? show me the commands
```bash
git checkout master
git merge branch_test
```
### 7.  How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
```bash
git checkout branch_learn_stash
git stash save "Description of what you stashed"
git checkout branch_learn_stash
git stash pop
```
### 8.  How do you understand PR is based on Branch?

A pull request is a request to merge changes from one branch into another branch.PR represents the difference between two branches and can be used for code review.

### 9.  What is maven role ? what it be used to do ?

Maven is a build and dependency management tool for Java projects. It standardizes the project lifecycle, handles dependencies, provides build profiles, and more.


### 10.  What is the lifecycle of maven? could you tell me the details ?
three primary lifecycles:
* default: Manages the project deployment.
* clean: Handles the project cleaning.
* site: Manages the project's site documentation.


### 11.  what is the difference between package and install in maven lifecycle ?
```bash
Package: This will compile the source code and package it into a distributable format.
Install: This installs the packaged output into a local Maven repository for use in other local projects.
```
### 12.  What is plugins in maven, list some plugins.
* maven-compiler-plugin
* maven-surefire-plugin
* maven-jar-plugin
* maven-war-plugin
* maven-install-plugin
* maven-deploy-plugin
