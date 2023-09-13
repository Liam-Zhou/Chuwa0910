3. What is the basic steps to init a git repo in you local ?

> `git init` will initialize a new Git repository in the current directory, setting it up for version control.

4.  How to clone a repo from Github ?

> use the `git clone <repository_url>` command, replacing <repository_url> with the URL you copied. Git will create a local copy of the repository for you.

5.  How to create a new branch and checkout to that branch ?

> `git checkout -b <branch_name>` creates a new branch with the specified name and immediately switches to it.

6.  How to merge the branch_test to master branch in command ? show me the commands

> `git checkout master`
`git merge branch_test`

7.  How to stash your new code before leaving branch branch_learn_stash and pop your stash when you
    checkout back to **branch_learn_stash ? try commands way and intellij way.

> For commands: <br>
> Stash your changes on the branch_learn_stash branch:`git stash save " your stash message" `<br>
> Switch to a different branch (e.g., master) using: `git checkout master`<br>
> Make your changes or work on other tasks in this branch.<br>
> When you want to go back to branch_learn_stash, switch back to it:`git checkout branch_learn_stash`<br>
> To pop your stash and apply the changes:`git stash pop`<br>
> For Intellij: <br>
> Using IntelliJ IDEA's integrated Git features can be more convenient and visual, you can use Version Control tool to do that.<br>


8.  How do you understand PR is based on Branch?

> A Pull Request (PR) is a request to merge changes from a feature branch into a base branch (usually master or main). PRs are based on these feature branches, and they serve as a way to propose and review code changes before merging them into the main codebase.

9.  What is maven role ? what it be used to do ?

> Maven is a build and project management tool commonly used in Java development. It automates tasks like building, dependency management, and project organization, making it easier for developers to create and manage Java projects efficiently.

10.  What is the lifecycle of maven? could you tell me the details ?


> Clean (clean): Removes target directories and generated files. <br>
> Validate (validate): Validates the project structure and dependencies. <br>
> Compile (compile): Compiles the source code into bytecode. <br>
> Test (test): Runs unit tests using a testing framework. <br>
> Package (package): Packages compiled code into a distributable format. <br>
> Verify (verify): Checks the integrity and quality of the built code. <br>
> Install (install): Installs the packaged artifact into the local repository. <br>
> Deploy (deploy): Copies the artifact to a remote repository for sharing. <br>

11.  what is the difference between package and install in maven lifecycle ?

> Package (package) creates a distributable format of your project (e.g., JAR or WAR) but only stores it in the project's target directory.<br>
Install (install) takes the packaged artifact and installs it into your local repository, making it available for other projects to use as a dependency.

12.  What is plugins in maven, list some plugins.

> Maven plugins are add-ons that enhance build processes. Some examples include Compiler, Surefire, War, Jar, Dependency, Clean, Assembly, Release, Exec, and Resources plugins.

13.  In Repo/MavenProject directory, create a maven Module using Intellij, named it as belows:
     _ groupID: com.chuwa.learn
     _ artifactID: java-core

> Done.
