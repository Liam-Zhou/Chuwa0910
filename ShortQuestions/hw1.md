# Homework 1 (Sept 11) of Yichuan Hu

## 2. git commands I learned

- git init
- git clone
- git add
- git status
- git diff
- git commit
- git reset
- git checkout
- git switch
- git log
- git remote
- git fetch
- git pull
- git push

## 3. basic steps to init a git repo in my local

```
# create a directory to hold the code
# get into it
git init
# Write some code
git add .
git commit
```

## 4. clone a repo from Github

- copy the repo's https link
- open terminal and get into the working directory
- Type the following command and press Enter

```
git clone [repo's https link]
```

## 5. create a new branch and checkout to that branch

```
git checkout -b [branch_name]
```

## 6. merge the branch_test to master branch in command

```
git checkout branch_test
# do some changes in branch_test
git add .
git commit -m "some change"
git checkout master
git merge branch_test
```

## 7. stash new code before leaving branch_learn_stash and pop your stash when you checkout back to \*\*branch_learn_stash ? try commands way and intellij way.

- tips: stash would work for the files kept monitored by Git
- Command Way:

```
git add .
git status
git stash save "New Stash"
# If need to apply the stashed changes: git stash apply
```

- IDEA Way:
  - Right Click then "Git"
  - "Stash Changes"
  - put in the message and "Create Stash"
  - When poping the stash, Go to the "Stash List", Choose the stash and right click "Apply Stash"

## 8. How do you understand PR is based on Branch?

## 9. Maven's role & used to do

- Maven Role: Tools to download add and remove the dependencies/libraries
- Maven is for: In your developing project, import/reference specific version of some tools that were implemented by others.

## 10. LifeCycle of maven

Maven LifeCycle

- Clean
- Default / Build
  - validate
  - test
  - package
  - verify
  - install
  - deploy
- Site

Maven Build LifeCycle

validate -> compile -> test -> package -> verify -> install -> deploy

## 11. The difference between package and install in maven lifecycle

- install: import the dependency tools from maven
- package: package the whole java project's code into a service jar package

## 12. plugins in maven

definition: an execution in maven providing a set of goals

- compile
- validate
- test
- clean
- verify
- dependency
