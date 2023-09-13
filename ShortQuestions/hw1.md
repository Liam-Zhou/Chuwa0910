

2.  practice git using the platform. list the git commands you learned

    git clone
    git status  
    git branch
    git commit -a
    git commit -m
    git pull
    git push
    git checkout
    1.  https://learngitbranching.js.org/

3.  What is the basic steps to init a git repo in you local ?
    1. Check your git environment using 
        git  --version
    2. Create a project folder using    
        mkdir proj
    3. Initialize Repo using   
        git init
    4. Add files to Repo using
        git add .
    5. Add comments
        git commit -m


4.  How to clone a repo from Github ?

    git clone + "URL"

5.  How to create a new branch and checkout to that branch ?

    //create a new branch
    git checkout -b "named"

    //switch to branch
    git checkout "named"

6.  How to merge the branch_test to master branch in command ? show me the commands

    git checkout master
    git merge branch_test


7.  How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
    git stash save "save"
    git checkout master 
    git checkout branch_learn_stash
    git stash pop


8.  How do you understand PR is based on Branch?
    Which means PR from specific branch and we would like to merge it to master branch



9.  What is maven role ? what it be used to do ?

    Maven is use to build project and manage dependencise(packages).

    Repo management: local, central and remote, maven could call packages automaticly
    Testing: Maven can automate the testing process 
    plugins: provided plugins with project

10.  What is the lifecycle of maven? could you tell me the details ?
    default - clean - site
    
    validate - validate the project is correct and all necessary information is available
    compile - compile the source code of the project
    test - test the compiled source code using a suitable unit testing framework. These tests should not require the code be packaged or deployed
    package - take the compiled code and package it in its distributable format, such as a JAR.
    verify - run any checks on results of integration tests to ensure quality criteria are met
    install - install the package into the local repository, for use as a dependency in other projects locally
    deploy - done in the build environment, copies the final package to the remote repository for sharing with other developers and projects.

11.  what is the difference between package and install in maven lifecycle ?

    Package: Generates the project artifact (like a JAR file) but doesn't install it in your local repository.
    Install: Takes the package created during the package phase and installs it in your local Maven repository, allowing other Maven projects on your local machine to use it as a dependency.



12.  What is plugins in maven, list some plugins.

    maven compiler plugin
    maven JAR plugin
    maven clean plugin
    maven install plugin
    maven deploy plugin

13.  In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:
    1.  groupID: com.chuwa.learn 
    2.  artifactID: java-core 

14.  Do Code Review: Go over the PRs in your repo, tried to leave some useful or useful comments in other 
students' PR, please don't merge it