3. make a dir, cd, do git init
4. git clone url
5. git chechout -b newbranch
6. git check out master
	git merge branch_test
7. git checkout branch_learn_stash
	git stash
	git checkout anotherbranch
	git checkout branch_learn_stash
	git stash pop
	
	intellij:
	To stash
	go to VCS,Git,Stash changes
	Apply stash:
	go to VCS, Git, Unstash changes
8. PR represents a request to merge changes from one branch into another, with the branch on which the PR is based containing the changes to be merged.
9. Maven is a build automation and project management tool used primarily for Java projects.
	Dependency Management,Build Automation,Project Structuring
10. Clean Lifecycle: It is used to clean the project, removing all generated files and directories.
	Default Lifecycle: This is the most important lifecycle for building and deploying your project
	Site Lifecycle: Used for generating the project's site documentation
11. Package: The package phase is responsible for taking the compiled code and packaging it into a distributable format (e.g., JAR, WAR). It creates the artifact but doesn't install it in the local repository or deploy it to a remote repository.

    Install: The install phase takes the artifact produced in the package phase and installs it in the local Maven repository (usually located in your ~/.m2/repository). This allows other projects on your local machine to depend on and use the artifact as a dependency.
12.  In Maven, plugins are extensions that provide additional functionality to the build process. They can be used to perform various tasks such as compiling code, running tests, generating reports, and more. Plugins are configured in the project's pom.xml file

