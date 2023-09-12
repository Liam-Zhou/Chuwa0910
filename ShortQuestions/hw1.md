1. Learn **MarkDown** and show all of basic usage.

    # First Level Heading
    ## Second Level Heading
    ### Third Level Heading

    **Bold Text**
    
    *Italic Text*
    
    _Italic Text 2_
    
    ~~StrikeThrough~~
    
    **Bold and _Nested_ Italic Text**
    
    ***All Bold and Italic Text***
    
    <sub> Sub </sub> Text
    
    <sup> Sup </sup> Text
    
    > Quote Text
    
    ```
    Code
    ```
    
    This site was built using [GitHub Pages](https://pages.github.com/).
    
    ![Screenshot of a comment on a GitHub issue showing an image, added in the Markdown, of an Octocat smiling and raising a tentacle.](https://myoctocat.com/assets/images/base-octocat.svg)
    
    - George Washington
    * John Adams
    + Thomas Jefferson
    
    1. First list item
       - First nested list item
         - Second nested list item
    
2. Practice Git using the platform. List the git commands you learned.

   1. git commit
   2. git branch
   3. git merge
   4. git rebase
   5. git init
   6. git cherry-pick
   7. git clone
   8. git fetch
   9. git pull
   10. git push
   11. git branch
   12. git checkout
   13. git add
   14. git stash
   15. git remote
   16. git status

3. What is the basic steps to init a git repo in your local?

   1. Open a Terminal or Command Prompt.

   2. Navigate to the directory where you want to create your repository.
      ```
      cd path/to/your/directory
      ```
   3. Initialize a new Git repository in the current directory.
      ```
      git init
      ```
      
      After running this command, we’ll see a message indicating that a new Git repository has been initialized. This command creates a hidden .git directory in the current folder, which contains all of the information and history for the new repository.

    4. Add files to the repository.

       If we have existing files in this directory and we want to track them with Git:

       1. First, add the files to the staging area.
          ```
          git add .
          ```
          This adds all files in the current directory. If only want to add specific files, replace the . with the file's path.

       2. Commit the files to the repository.
          ```
          git commit -m "Initial commit"
          ```
     5. Configure Remote Repository.

        If we have a remote repository (e.g., on GitHub, GitLab, Bitbucket, etc.) and we want to link it to our local repository:

        1. Add the remote repository:
           ```
           git remote add origin [URL-of-your-remote-repository]
           ```
        2. Push your commits to the remote repository:
           ```
           git push -u origin master
           ```
           Here, master is the default branch name, but if we’re using a different branch name, replace master with our branch name.

4. How to clone a repo from Github?

   1. Navigate to the Repository on GitHub

   2. Copy the Repository URL

   3. Open a Terminal or Command Prompt on Your Local Machine

   4. Clone the Repository
      
      Navigate to the directory where we want to place the cloned repository, and then use the git clone command followed by the URL you copied:
      ```
      git clone https://github.com/username/reponame.git
      ```
   5. Navigate to the Cloned Directory

      Once the cloning process is complete, we can navigate into the repository's directory:
      ```
      cd reponame
      ```
5. How to create a new branch and checkout to that branch?

   1. Open a Terminal or Command Prompt and navigate to your Git repository.

   2. Create a New Branch
      ```
      git branch new-branch-name
      ```
   3. Switch to the New Branch
      ```
      git checkout new-branch-name
      ```
   4. Alternatively, Combine Both Steps

      Git offers a shorthand command to create a new branch and immediately switch to it:
      ```
      git checkout -b new-branch-name
      ```
6. How to merge the branch_test to master branch in command? Show me the commands.

   1. Ensure that we’re Up-to-Date

      Before merging, make sure both our local branch_test and master branch have the latest changes from any remote repositories:
      ```
      git fetch
      ```
   2. Switch to the master Branch
      ```
      git checkout master
      ```
   3. Merge branch_test into master
      ```
      git merge branch_test
      ```
      This will merge changes from branch_test into the currently checked-out master branch. If there are any merge conflicts, we will need to resolve them manually.

7. How to stash your new code before leaving branch **branch_learn_stash** and pop your stash when you checkout back to **branch_learn_stash**? Try commands way and intellij way.

    Command Line (Git Commands):
    1. Stash your changes:
    
       First, ensure we are on the correct branch:
       ```
       git checkout branch_learn_stash
       ```
       Now, stash your changes:
       ```
       git stash save "Descriptive stash message" 
       ```
    2. When you're ready to get your changes back:
       
       First, ensure we are back on the correct branch:
       ```
       git checkout branch_learn_stash
       ```
       Now, apply our stashed changes:
       ```
       git stash pop
       ```
    
    IntelliJ IDEA:
    1. Stash your changes:
       1. Open the Version Control tool window (usually by clicking on the tab at the bottom of the screen or using the shortcut Alt + 9).
       2. Click on the Local Changes tab.
       3. Right-click on the modified files or changes you wish to stash.
       4. Select Stash Changes... from the context menu.
       5. Provide a name or message for the stash (this is optional but recommended).
Click OK.
    2. When you're ready to get your changes back:
       1. Open the Version Control tool window again.
       2. Click on the Stashes tab or section.
       3. Locate the stash you want to apply.
       4. Right-click on it.
       5. From the context menu, we can select Apply Stash to apply the stash and keep it in the stash list or Pop Stash to apply it and remove it from the list.
 
7. How do you understand **PR is based on Branch**?

    When we say a "PR is based on a branch", it means: the changes proposed in the PR are contained within that specific branch.
    
    When we create a PR, we’re specifying two branches: the source branch (our feature/bugfix branch) and the target branch (often the main development branch, like master or main). The PR shows the differences between these two branches and allows for collaborative review, discussion, and testing of the changes.

    The PR will continue to update as more commits are added to the branch it's based on. So if after submitting a PR we push another commit to our branch, that commit will automatically show up in the PR.

9. What is  **maven** role? What it be used to do?

    Maven is a project management and build automation tool primarily used in the Java ecosystem. Its main roles include:

    1. Dependency Management: Automatically handles project dependencies, fetching them from online repositories.
    2. Build Automation: Compiles, tests, and packages code.
    3. Project Standardization: Provides a consistent directory layout and build lifecycle.
    4. Plugin Architecture: Extends functionality using plugins, such as for compiling or testing.
    5. Multi-module Support: Manages large projects split into sub-modules.

10. What is the **lifecycle** of maven? Could you tell me the details?

    Maven's lifecycle represents a sequence of phases that determine the order in which goals are executed. Maven has three primary built-in lifecycles:

    1. Default Lifecycle (handles project deployment):

       1. validate: Validate project is correct.
       2. initialize: Set up build state, e.g., properties or directories.
       3. compile: Compile the project's source code.
       4. test: Test the compiled code using a testing framework.
       5. package: Convert the compiled code into a distributable format (e.g., JAR, WAR).
       6. verify: Ensure the package meets quality criteria.
       7. install: Store the package in the local repository.
       8. deploy: Copy the package to a remote repository.

    2. Clean Lifecycle (handles project cleaning):

       1. pre-clean: Pre-clean actions.
       2. clean: Remove all previously built files.
       3. post-clean: Post-clean actions.
     
    3. Site Lifecycle (creates project documentation):

       1. pre-site: Pre-site generation actions.
       2. site: Generate project's site documentation.
       3. post-site: Post-site generation actions.
       4. site-deploy: Deploy the site to a server.
       
    In everyday Maven use, the default lifecycle is most frequently engaged, and developers often run commands like mvn compile, mvn test, or mvn deploy targeting specific phases of this lifecycle.

11. What is the difference between **package** and **install** in maven lifecycle?

    1. package:

       The package phase takes the compiled code and other files (like resources) from the project and packages them into a distributable format. The format is usually determined by the project's packaging setting (\<packaging\> tag in pom.xml). Common formats include JAR (for libraries or standalone applications), WAR (for web applications), and EAR (for Enterprise Java applications).

       At the end of the package phase, we’ll have a built artifact ready for distribution, but it will only reside in our project's target directory. It hasn't been deployed or distributed anywhere yet.

    2. install:

       The install phase takes the packaged artifact from the package phase and installs it into local Maven repository. The local Maven repository is usually a .m2 directory in the user's home directory.
    
       Installing an artifact into the local repository means that other Maven projects on the same machine can now reference and use this artifact as a dependency. This is especially useful if we’re developing multiple interrelated projects on our local machine and we don't want to deploy artifacts to a remote repository just to test them together.
    
       In order for the install phase to run, all the preceding phases, including package, must have been executed successfully. So when we run mvn install, Maven will compile, test, and package our code before installing the resulting artifact into the local repository.

12. What is **plugins** in maven, list some plugins.

    In Maven, a plugin is a collection of one or more goals. A goal represents a specific task (finer than the build phase) which contributes to the building and managing of a project. It may be bound to zero or more build phases. A goal not bound to any build phase could be executed outside of the build lifecycle by direct invocation.

    Maven uses plugins to do almost everything. Even basic commands like clean and compile are executed by Maven plugins. Each plugin can execute a number of goals.

    Here are some commonly used Maven plugins:
    1. maven-compiler-plugin: Compiles Java source code. It's responsible for invoking the Java compiler during the compile phase.
    2. maven-surefire-plugin: Executes unit tests and generates test reports. It's often associated with the test phase.
    3. maven-jar-plugin: Builds a JAR file from the current project. It's tied to the package phase.
    4. maven-war-plugin: Like the JAR plugin but for building WAR files for web applications.
    5. maven-clean-plugin: Cleans up the target/ directory used for the build. Typically tied to the clean phase.
    6. maven-install-plugin: Installs the project's artifact into the local repository. This is usually done during the install phase.
    7. maven-deploy-plugin: Deploys the project's artifact to a remote repository. It's tied to the deploy phase.
    8. maven-failsafe-plugin: Designed for integration tests. It ensures that even if there are failures, the post-integration-test phase will still be executed to clean up resources.
    9. maven-dependency-plugin: Provides operations on dependencies like copying, unpacking, analyzing, etc.
    10. maven-release-plugin: Manages the release of a project including tagging and version management.
    11. maven-site-plugin: Generates a site for the project, which can include documentation generated from the code as well as other documentation.
    12. maven-assembly-plugin: Used to aggregate multiple artifacts together into a single distributable archive.

13. In **Repo/MavenProject** directory, create a **maven Module** using Intellij, named it as belows:
    1. groupID: **com.chuwa.learn**
    2. artifactID: **java-core**
   
    

14. Do **Code Review**: Go over the PRs in your repo, tried to leave some useful comments in other students’ PR, please don’t merge it.


