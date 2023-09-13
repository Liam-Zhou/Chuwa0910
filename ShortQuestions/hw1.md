### 2. practice git using the platform. list the git commands you learned
- git commit 
- git clone
- git fetch
- git fakeTeamwork
- git push

- git branch
    - git branch -f
        <!-- > force change the current branch point -->
- git checkout
    - git checkout point^
        <!-- > only one point back -->
    - git checkout point~[num]
        <!-- > nums of point back -->
- git merge
    <!-- > merge other branch into current -->
- git rebase
    <!-- > copy commit to current -->
    - git rebase -i range
        <!-- > reorder or edit the commits  -->
- git reset
    <!-- > go back to target point -->
- git revert
    <!-- > undo the commit -->
- git cherry-pick <Commit1> <Commit2> <...>
    <!-- > copy series of commits to current point  -->
- git tag version targetPoint
    <!-- > tag the target point with version -->
- git describe
    <!-- > <tag>_<numCommits>_g<hash> -->

### 3. What is the basic steps to init a git repo in your local?
1. cd to the target directory using the command 
1. use 'git init .' to init the repo

### 4. How to clone a repo from Github?
1. cd to the target directory using the command 
1. use 'git clone _url_' to clone the repo

### 5. How to create a new branch and checkout to that branch?
1. git branch branchName
1. git checkout branchName

### 6. How to merge the branch_test to master branch in command? Show me the commands.
1. git checkout main
1. git merge branch_test

### 7.  How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
1. git stash
1. git stash pop

### 8. How do you understand PR is based on Branch?
The PR is an action that happened between two branches, it's meaningless without the specific branch

### 9. What is Maven's role? What is it used for?
It's a tool that used to manage the project, such as compliling and packaging.

### 10. What is the lifecycle of Maven? Could you tell me the details?
1. Validate: This step validates if the project structure is correct. For example – It checks if all the dependencies have been downloaded and are available in the local repository.
1. Compile: It compiles the source code, converts the .java files to .class, and stores the classes in the target/classes folder.
1. Test: It runs unit tests for the project.
1. Package: This step packages the compiled code in a distributable format like JAR or WAR.
1. Integration test: It runs the integration tests for the project.
1. Verify: This step runs checks to verify that the project is valid and meets the quality standards.
1. Install: This step installs the packaged code to the local Maven repository.
1. Deploy: It copies the packaged code to the remote repository for sharing it with other developers.

### 11. What is the difference between 'package' and 'install' in Maven lifecycle?
Package would only compile and package the project into a jar/war file, while the install will also put the current proejct into the local repo, which could be used by other local projects.

### 12. What are plugins in Maven, list some plugins?
Extension that provide more function, the place that real action performed 
- clean 
- complier 
- changes
- surefire-report