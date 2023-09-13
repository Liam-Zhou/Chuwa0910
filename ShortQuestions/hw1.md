## 1. show all the basic usage of markdown file ##
## headings ##
# A first-level heading
## A second-level heading
### A third-level heading

**This is bold text** <br>
_This text is italicized_ <br>
~~This was mistaken text~~ <br>
**This text is _extremely_ important** <br>
***All this text is important*** <br>
This is a <sub>subscript</sub> text <br>
This is a <sup>superscript</sup> text <br>

> Text that is a quote  <br>

Use `git status` to list all new or modified files that haven't yet been committed. <br>

This is my Linkedin Profile [Linkedin](https://www.linkedin.com/in/changqing-dong-72788451/). <br>

![Screenshot of a comment on a GitHub issue showing an image, added in the Markdown, of an Octocat smiling and raising a tentacle.](https://myoctocat.com/assets/images/base-octocat.svg)  <br>
1. Louis
1. Dong
1. Changqing   <br>
- Louis 
* Dong
+ Changqing  <br>

## 2. List frequently used git command ##  

`git init`

`git add`

`git commit`

`git status`

git config``

`git branch`

`git checkout`

`git merge`

`git remote`

`git clone`

`git pull`

`git push`

`git stash`

`git log`

`git rm`

## 3. What are the basic steps to intialize a Git repo in your local ##  
1. Create a new directory for your project. <br>
1. Run the `git init` command in the new directory. <br> 
1. Add the files you want to track to the repository using the `git add` command. <br>
1. Commit the changes to the repository using the `git commit` command. <br>

## 4. How to clone a repo from Github ? ##  

1. Go to the GitHub repository you want to clone.
1. Click on the "Clone or download" button.
1. Copy the SSH or HTTPS clone URL.
1. In your local machine, open a terminal window and navigate to the directory where you want to clone the repository.
1. Run the command: `git clone targert_url`

## 5.	How to create a new branch and checkout to that branch ? ##  
1. Run the command: `git checkout -b targert_branch_name`

## 6.	How to merge the branch_test to master branch in command ? show me the commands ##  
1. Run the command: `git checkout master`
1. Run the command: `git merge branch_test`

## 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash? Try commands and IntelliJ way. ##

1. Run the `git stash`command to stash your changes.
1. Leave the `branch_learn_stash` branch.
1. Checkout back to the `branch_learn_stash` branch.
1. Run the `git stash pop` command to pop your stash.

## 8.	How do you understand PR is based on Branch? ##  

A pull request (PR) is a request to merge changes from one branch to another. In the context of Git, a PR is typically used to merge changes from a feature branch to the master branch.

## 9.	What is maven role ? what it be used to do ? ##  

Maven is a build automation tool used to manage Java projects. It provides a standard way to build, test, and deploy Java applications

## 10.	What is the lifecycle of maven? could you tell me the details ? ##  

The Maven lifecycle is a set of phases that define the different stages of a Java project's build process. The phases are:

* clean: Cleans the project's build output. <br>
* compile: Compiles the project's Java source code. <br>
* test: Runs the project's unit tests. <br>
* package: Packages the project's compiled code into a distributable artifact. <br>
* install: Installs the project's artifact into the local Maven repository. <br>
* deploy: Deploys the project's artifact to a remote repository. <br>

## 11.	what is the difference between package and install in maven lifecycle ? ##  

The main difference between package and install in the Maven lifecycle is that package only packages the project's artifact, while install also installs the artifact into the local Maven repository.

## 12.	What is plugins in maven, list some plugins. ##  

Plugins in Maven are used to extend the functionality of Maven. There are many different plugins available, 

* maven-compiler-plugin: Compiles Java source code. <br>
* maven-surefire-plugin: Runs unit tests. <br>
* maven-jar-plugin: Creates JAR files. <br>
* maven-war-plugin: Creates WAR files. <br>
* maven-clean-plugin: Deletes build output directories. <br>

