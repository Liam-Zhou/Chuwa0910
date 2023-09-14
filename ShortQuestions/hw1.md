# HW1 - Grace Hu

### **Write your hw1 in hw1.md**

### 1. Learn **MarkDown** and show all of basic usage in the **ShortQuestions/README.md**

- Heading:
    # # A first-level heading
    ## ## A second-level heading
    ### ### A third-level heading

- **Bold**
- *Italic*
- ~~Strikethrough~~
- This is a <sub>subscript</sub> text
- This is a <sup>superscript</sup> text
- > Text that is a quote
- The background color is `#ffffff` for light mode and `#000000` for dark mode.
- This site was built using [GitHub Pages](https://pages.github.com/).

### 2. practice git using the platform. list the git commands you learned
    MAIN:
    git commit
    git branch
    git brach -f <branch name> HEAD^
    git checkout
    git merge
    git rebase
    
    REMOTE:
    git clone
    git fetch
    git pull
    git fakeTeamwork
    git push

### 3. What is the basic steps to init a git repo in you local ?
    cd your_work_dir
    git init # init a git repo(repository-->source code)
    git status
    git add .
    git commit -m "some message"
    git push origin master/main

### 4. How to clone a repo from Github ?
    cd your_work_dir
    git clone https://github.com/username/repo-name.git


### 5. How to create a new branch and checkout to that branch ?
    git branch branch_name
    git checkout branch_name
#### or
    git checkout -b branch_name # create and checkout to branch_name

### 6. How to merge the branch_test to master branch in command ? show me the commands
    git checkout master
    git pull origin master # optional: ensure that master branch is up to date
    git merge branch_test

### 7. How to **stash** your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **#branch_learn_stash**? try commands way and intellij way.
    git stash
    git checkout new_branche_name
#### ready to return back
    git checkout branch_learn_stash
    git stash pop

### 8. How do you understand PR is based on Branch?
A Pull Request (PR) is a proposal for merging code changes into a Git repository's target branch, and it's always based on a specific source branch where the changes were made. The source branch contains the commits with the proposed changes, and the PR allows for collaboration and code review before merging.

### 9. What is maven role ? what it be used to do ?
Roles:
- Manage Dependencies(Package).
- Build Project (Cycle)
- Documentation
- Reporting
- Others

Maven is a project management and comprehension tool that provides developers a complete build lifecycle framework. Development team can automate the project's build infrastructure in almost no time as Maven uses a standard directory layout and a default build lifecycle.

Maven's primary goal is to allow a developer to comprehend the complete state of a development effort in the shortest period of time.

### 10. What is the lifecycle of maven? could you tell me the details ?

Maven defines a standard project lifecycle with a set of phases and goals that define the sequence of actions and tasks to be performed during the build process. 

The default Maven lifecycle consists of 8 major steps: Validate, Compile, Test, Package, Integration test, Verify, Install, and Deploy for compiling, testing, building and installing a given Java project.

1. Validate: Validates the project to ensure it's correct and all necessary information is available.
2. Compile: It compiles the source code, converts the .java files to .class, and stores the classes in the target/classes folder.
3. Test: It runs unit tests for the project.
4. Package: This step packages the compiled code in a distributable format like JAR or WAR.
5. Integration test: It runs the integration tests for the project.
6. Verify: This step runs checks to verify that the project is valid and meets the quality standards.
7. Install: This step installs the packaged code to the local Maven repository.
8. Deploy: It copies the packaged code to the remote repository for sharing it with other developers.

### 11. what is the difference between package and install in maven lifecycle ?

**package** will compile the code and also package it. In detail, **package** will generate jar/war as per POM file, and put it somewhere in the target directory (by default).

**install** will do all the things that **package** does (compile and package). But it will put the package in the local repository. This will make it so other projects can refer to it and grab it from the local repository.

**install** phase comes after **package** phase.

### 12. What is plugins in maven, list some plugins.
Maven is really just a core framework for a collection of Maven Plugins. Plugins are where much of the real action is performed. Plugins perform tasks for a Maven build. These are not packaged in the application.

Core plugins:
- clean: Clean up after the build.
- compiler:	Compiles Java sources.
- deploy: Deploy the built artifact to the remote repository.
- failsafe:	Run the JUnit integration tests in an isolated classloader
- install: Install the built artifact into the local repository.
- resources: Copy the resources to the output directory for including in the JAR

### 13. In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:
1. groupID: com.chuwa.learn
2. artifactID: java-core

see directory
