# HW1

1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md
    - **This is bold text**
    - _This text is italicized_
    - ~~This was mistaken text~~

    <u>Underline</u>
    > Text that is a quote
    > [!NOTE]
    > Highlights information that users should take into account, even when skimming.
    ```
    git status
    git add
    git commit
    ```
    `rgb(19, 105, 218)`
    - [x] #739 :+1:
    - [ ] https://github.com/octo-org/octo-repo/issues/740
    - [ ] Add delight to the experience when all tasks are complete :tada:

2. Practice git using the platform. list the git commands you learned
    - git clone (repo-url)
        - clone or copy a repo from github to local
    - git add
        - add files to the staging area
    - git commit
        - commit changes to the local repo
    - git push
        - push changes to the remote repo
    - git pull
        - pull changes from the remote repo
    - git branch
        - list, create, or delete branches
    - git checkout
        - switch branches or restore working tree files
    - git merge
        - join two or more development histories together
    - git rebase
        - reapply commits on top of another base tip

3. What is the basic steps to init a git repo in you local ?
    - git init
    - git add
    - git commit
    - git remote add origin (repo-url)
    - git push -u origin master

4. How to clone a git repo to your local ? 

    - git clone (repo-url)
    - git add
    - git commit
    - git push

5. How to create a new branch and checkout to that branch ?
    - git branch (branch-name)
    - git checkout (branch-name)

6. How to merge the branch_test to master branch in command ?
    - git checkout master
    - git merge branch_test

7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash ? try commands way and intellij way.
    - Command way
        - git checkout branch_learn_stash
        - git stash save "My stash description"
        - git checkout master
        - **DO SOMETHING**
        - git checkout branch_learn_stash
        - git stash pop
    
    - Intellij way
        - VCS -> Git -> Stash Changes
        - VCS -> Git -> Branches
        - **DO SOMETHING**
        - VCS -> Git -> Pop stash -> Apply stash

8.  How do you understand PR is based on Branch?
    - A pull request is actually like **merge request (in GitLab)** from Source Branch to Target Branch.

9. What is maven role ? what it be used to do ?
    - Dependency Injection (just like conda in python)
    - Build Automation (just like make in C/C++)
    - Repository Management (just like pip in python)
    - Project Info management (just like CMake in C/C++)
    - ...

10. What is the lifecycle of maven? could you tell me the details ?
    - Building project using maven is a process of executing a series of phases (validate, compile, test, package, Integration Test verify, install, deploy)

11. what is the difference between package and install in maven lifecycle ?
    - **package**: package the project into a jar or war file
    - **install**: install the package into local repository
    - **Diff**: package only package the project, but install will package and install the project into local repository
    - You will need to **package** first, then **install**, then deploy

12. What is plugins in maven, list some plugins.
    - plugin is a collection of one or more goals, where a "goal" represents a specific task (or action) in Maven.
    - Examples:
        - maven-compiler-plugin
        - maven-clean-plugin
        - maven-install-plugin
        - ...

13. N/A
14. N/A 
