

# HW1. Xiao Yang
### 1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md

# Headings
## Headings
### Headings
**bold text**
_Italic text_
~~Strikethrough text~~
**This text is _extremely_ important**
This is a <sub>subscript</sub> text
This is a <sup>superscript</sup> text
> Text that is a quote

`Quoting code` 

```
Quoting code
Quoting code
Quoting code
```
background color is `#ffffff` for light mode and `#000000` for dark mode.

This site was my github page [GitHub Pages](https://github.com/FossilDaddy)

[Refer to root readme.md](../readme.md)

+ Xiao Yang
+ Xiao Yang
+ Xiao Yang


### 2. Practice git using the platform. list the git commands you learned [link](https://learngitbranching.js.org/)

`git init` 

`git status` 

`git add .`

`git branch`

`git merge`

`git rebase`

`git clone`

`git getch`

`git pull`

`git push`

`git checkout`

`git stash`

`git remote`

### 3. What is the basic steps to init a git repo in you local ?

1. `cd your_work_dir`
2. `git init`
3. Add files to current dir
4. `git add .`
5. `git commit -m "your comment"`
6. `git remote add origin [URL]`
7. `git push origin master`

### 4. How to clone a repo from Github ?
1. `cd your_work_dir`
2. `git clone [url]`

### 5. How to create a new branch and checkout to that branch ?

```
git branch your_branch_name
git checkout your_branch_name
```

or 
```
git checkout -b your_branch_name
```

### 6. How to merge the branch_test to master branch in command ? 

1. In both branches, we need to run `git fetch` to make sure that everything is up-to-date. 
2. switch to master `git checkout master`.
3. do merge `git merge branch_test`.
4. solve conficts when needed.

### 7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to branch_learn_stash ? try commands way and intellij way.

* Commands way
1. Leave before stash all changes
```
git stash
```
2. Checkout to new branch

```
git checkout new_branch
```
3. Return to branch_learn_stash and pop all changes
```
git checkout branch_learn_stash
git stash pop
```
* Intellij

to-do

### 8. How do you understand PR is based on Branch?
Once the developer has completed their work in their branch, and is satified with thoses changes, they create a PR in order to merge those changes from their branch into the master branch.

### 9. What is maven role ? what it be used to do
Maven is a package management tool primarily used in Java project. It can used to:
- Dependency Management: Automatically handles projects dependencies and fetch them from online repo.
- Build Automation: Compiles, tests and packages code.
- Project Structure Standardization: Provides a consistent directory structure and build lifecycle.

### 10. What is the lifecycle of maven? Could you tell me the details?

Lifecycle of maven is a well-defined sequence of phases, which define the order in which the goals are to be executed. There are three built-in build lifecycles: default, clean and site. The default lifecycle handles your project deployment, the clean lifecycle handles project cleaning, while the site lifecycle handles the creation of your project's web site.

Take `default lifecycle` as an example, 

`nvm validate` - validate the project is correct and all necessary information is available

`nvm compile` - compile the source code of the project
test - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed

`nvm package` - take the compiled code and package it in its distributable format, such as a JAR.

`nvm verify` - run any checks on results of integration tests to ensure quality criteria are met

`nvm install` - install the package into the local repository, for use as a dependency in other projects locally

`nvm deploy` - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.

### 11. What is the difference between package and install in maven lifecycle?
The main difference between the “mvn package” and “mvn install” commands is that mvn package command will compile the source and will package it in its distributable formats, such as a JAR or WAR. The mvn install command, however, additionally to compiling the source code and packaging it into a JAR or a WAR, it will also install the package into the local repository, for use as a dependency in other projects locally.

### 12. What is plugins in maven, list some plugins.
In Maven, a plugin is a collection of one or more goals. A goal represents a specific task (finer than the build phase) which contributes to the building and managing of a project. It may be bound to zero or more build phases. A goal not bound to any build phase could be executed outside of the build lifecycle by direct invocation.

Here are some commonly used Maven plugins:

- `maven-compiler-plugin`: Compiles Java source code. It's responsible for invoking the Java compiler during the compile phase.
- `maven-surefire-plugin`: Executes unit tests and generates test reports. It's often associated with the test phase.
- `maven-jar-plugin`: Builds a JAR file from the current project. It's tied to the package phase.
- `maven-war-plugin`: Like the JAR plugin but for building WAR files for web applications.
- `maven-clean-plugin`: Cleans up the target/ directory used for the build. Typically tied to the clean phase.
- `maven-install-plugin`: Installs the project's artifact into the local repository. This is usually done during the install phase.
- `maven-deploy-plugin`: Deploys the project's artifact to a remote repository. It's tied to the deploy phase.
- `maven-failsafe-plugin`: Designed for integration tests. It ensures that even if there are failures, the post-integration-test phase will still be executed to clean up resources.
- `maven-dependency-plugin`: Provides operations on dependencies like copying, unpacking, analyzing, etc.
maven-release-plugin: Manages the release of a project including tagging and version management.
- `maven-site-plugin`: Generates a site for the project, which can include documentation generated from the code as well as other documentation.
- `maven-assembly-plugin`: Used to aggregate multiple artifacts together into a single distributable archive.

### 14. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:

- groupID: com.chuwa.learn
- artifactID: java-core

