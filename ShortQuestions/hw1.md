# Question 2: practice git using the platform. list the git commands you learned
git init: Initialize a new Git repository.
git clone [repository_url]: Clone a remote repository.
git add [file(s)]: Stage changes for commit.
git commit -m "[commit_message]": Commit changes with a message.
git pull: Fetch and merge remote changes.


# Question 3: What are the basic steps to initialize a Git repo in your local?
## Navigate to my project directory
cd your_project_directory

## Initialize a Git repository
git init

## Optionally, add my files to the staging area
git add .

## Commit changes
git commit -m "Initial commit"

# Question 4: How to clone a repo from GitHub?
git clone repository_url

# Question 5: How to create a new branch and checkout to that branch?
##  Create and switch to a new branch
git checkout -b branch_name

## Question 6: How to merge the branch_test to the master branch using Git commands?
# Switch to the target branch (e.g., master)
git checkout master

# Merge the source branch (e.g., branch_test) into the target branch
git merge branch_test

# Question 7: How to stash your new code before leaving the branch_learn_stash and pop your stash when you checkout back to branch_learn_stash?
## While on branch_learn_stash, stash your changes
git stash save "My work in progress"

## Checkout to another branch or do whatever you need to do
## When you return to branch_learn_stash, apply the stash
git stash apply

# Question 8: How do you understand that a Pull Request (PR) is based on a branch?
PR is a way to propose changes from one branch to another.

# Question 9: What is Maven's role, and what is it used for?
Maven is a build automation and project management tool. Its role is to help manage the build lifecycle of a software project

# Question 10: What is the lifecycle of maven? could you tell me the details ?
## Clean Lifecycle:
Removes previously generated files and artifacts.

## Default Lifecycle:
validate: Validates project configuration.
compile: Compiles source code.
test: Runs unit tests.
package: Packages code into distributable format.
verify: Checks package integrity.
install: Installs package in the local repository.
deploy: Copies package to a remote repository.
## Site Lifecycle:
Generates project documentation and reports.

# Question 11: What is the difference between package and install in Maven lifecycle?
package: the package phase is responsible for taking the compiled code and packaging it into a distributable format, such as a JAR or WAR file.
The packaged artifact is placed in the project's target directory but is not yet made available in a repository.

install: The install phase takes the packaged artifact from the target directory and installs it in the local Maven repository


# Question 12: What is plugins in maven, list some plugins.
maven-compiler-plugin: Compiles source code.
maven-surefire-plugin: Runs tests.
maven-jar-plugin: Creates JAR files.
maven-war-plugin: Builds WAR files.
maven-clean-plugin: Cleans the project.