# hw1

1. Learn MarkDown and show all of basic usage in the ShortQuestions/README.md  
   see in [ShortQuestions/README.md](README.md)
2. practice git using the platform. list the git commands you learned  
    - `git commit -m "..."`
    - `git checkout -b newBranch`
    - `git merge someBranch`
    - `git rebase main`
    - `git checkout someCommitHash`
    - `git checkout branch^`
    - `git branch -f main HEAD~3`
    - `git reset HEAD^`
    - `git revert HEAD`
    - `git cherry-pick branch1 branch 2 ...`
    - `git rebase -i branch`
    - `git commit --amend`
    - `git tag <name> <node>`
    - `git describe <ref>`
    - `git clone <url>`
    - `git fetch`
    - `git pull`
    - `git push`
3. What is the basic steps to init a git repo in you local ?  
   using `git init`.
4. How to clone a repo from GitHub ?  
   using `git clone <url>`.
5. How to create a new branch and checkout to that branch ?
   using `git checkout -b <newBranch>`.
6. How to merge the branch_test to master branch in command ?  
   ```
   git checkout main
   git merge branch_test
   ```
7. How to stash your new code and pop your stash?  
   **in command**: 
   ```
   git stash
   git stash pop
   ```
   **intelliJ**: using **Shelve silently** and **Unshelve silently**
8. How do you understand PR is based on Branch?  
A PR is actually a request to merge one branch into another branch. Thus, you need to have a branch that want to be merged so that to make a PR.
9. What is maven role ? what it is used to do ?  
Its primary role is to manage a project's build lifecycle, dependencies/libraries, and others including documentation, reporting, etc.
10. What is the lifecycle of maven?
the whole process is `mvn` Clean -> prepare-resources -> validate -> package -> install.  
`mvn clean`: Deletes target directory  
`mvn validate`: Validates if the project is correct and if all necessary information is available.  
`mvn compile`: Source code compilation is done in this phase.  
`mvn test`: Tests the compiled source code suitable for testing framework.  
`mvn package`: This phase creates the JAR/WAR package as mentioned in the packaging in POM.xml.  
`mvn install`: This phase installs the package in local/remote maven repository.  
`mvn deploy`: Copies the final package to the remote repository.  
11. What is the difference in package and install in maven lifecycle:  
**Package** includes compiling the source code, running tests, and packaging the compiled code and resources into a specific format like JAR. However,  **Install** installs the package in local/remote maven repository, that ready to be used.  
12. What is plugins in Maven, list some plugins.  
    Plugins are extensions or add-ons that provide additional functionality to the build process. Examples: `maven-compiler-plugin`, `maven-jar-plugin`  
13. Done
14. Done


