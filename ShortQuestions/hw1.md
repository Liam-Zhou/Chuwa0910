# HW1 - Ke Chen

## 1. 
    ### Styling text
	This is **Ke Chen**
	This is _Ke Chen_
	This is ~~Ke Chen~~
	**This is_Ke Chen_**
	This is ***Ke Chen***
	This is <sub>Ke Chen<sub>
	This is <sup>Ke Chen</sup>

    ### Quoting text
	>This is Ke Chen

	### Quoting code
	This is a command : 'Ke Chen'
	There are three commands:
	'''
	Ke Chen1
	Ke Chen2
	Ke Chen3
	'''

	### Supported color models
	The background color is '#ffffff' for light mode.

	### Links
	This is a github link from [Ke Chen](https://github.com/kechen11257)

	### Section links + Relative links
	section links: can link directly to a section in a rendered file by hovering over the section heading to expose
	relative links: is a link that is relative to the current file/

	### Images
	![tomcat](https://myoctocat.com/assets/images/base-octocat.svg)

	### Lists
	-Ke Chen
	*Ke Chen2
	+Ke Chen3

	1.Ke Chen
	1.Ke Chen2
	1.Ke Chen3

	### Nested Lists
	1.Ke Chen
	  - Ke Chen2
		- Ke Chen3

	### Task Lists
	- [x] #Ke Chen
	- [ ] https://github.com/octo-org/octo-repo/issues/740
	- [ ] Add delight to the experience when all tasks are complete :tada:

	### Mentioning people and teams
	@Ke Chen what do you think about this hw?

	### Referencing issues and pull requests
	if you have any questions, please find: #26

	### Uploading assets
	You can upload assets like images by dragging and dropping, selecting from a file browser, or pasting. You can upload assets to issues, pull requests, comments, and .md files in your repository.

	### Using emoji
	:+1:    :shipit:

	### Paragraphs
	This is Ke Chen

	This is Ke Chen2

	### Footnotes
	This is Ke Chen[^1]

	### Alerts
	> [!IMPORTANT]
	> This is important
	> [!NOTE]
	> This is note
	> [!WARNING]
	> This is warning

	### Hiding content with comments
	<!-- This is Ke Chen -->

	### Ignoring Markdown formatting
	This is \*Ke Chen\*

	### Disabling Markdown rendering
	When viewing a Markdown file, you can click <> at the top of the file to disable Markdown rendering and view the file's source instead.

## 2. 
    ### Introduction Sequence
		git commit : 
			make a new commit 相当于提交copy
			A commit in a git repository records a snapshot of all the (tracked) files in your directory. It's like a giant copy and paste, but even better!
			can think of commits as snapshots of the project
	
		git branch: 
			create new branch 创建新的分支

		git checkout: 
			checkout the branch with name。查看分支，跳转到指定分支
		git switch: 
			eplace git checkout, but still use git checkout

		git checkout -b: 
			create a new branch and check it out 创建并且跳转到指定分支

		git merge: 
			merge the branch with other branch  合并两个分支

		git rebase:
			move our work from bugFix directly onto the work from main
		       (合并本地的多条提交(commit)记录 )。

    ### Ramping Up
    	HEAD always points to the most recent commit
		git log: 
			see hashes of the commit
	
		find parent:
			1. Moving upwards one commit at a time with ^ ：
				find the parent of the specified commit 找到父母
				ex：git checkout bugFix^
			2. Moving upwards a number of times with ~<num>：
				takes in a trailing number that specifies the number of parents you would like to ascend
				找到当前分支的第几个父母
				ex：git checkout bugFix ～3
			3. git branch -f:
			ex: git branch -f main HEAD~3 
			当前在bugFix的分支，然后直接从mian分支往上找第3个父母，找到之后还是在bugFix分支
			moves (by force) the main branch to three parents behind HEAD.

		git reset: 
			撤销older commit
			reverses changes by moving a branch reference backwards in time to an older commit.
			"rewriting history;
			ex: git rest HEAD~1
		git revert:
			为了把reversed changes 分享给其他人，做备份
			will move a branch backwards as if the commit had never been made in the first place.
			ex: git revert HEAD

	### Moving Work Around
		git cherry-pick <Commit1> <Commit2> <...>
			copy a series of commits below your current location (HEAD)
			ex: git cherry-pick c2 c4
		git rebase -i HEAD~4
		    you don't know what commits you want
		    an interactive rebase window will appear. Reorder some commits around (or feel free to unpick some) and see the result!

		    EX: git rebase -i HEAD~4
		    比如你选择了c2， c5，生成c3，c4的copy

    ### A Mixed Bag
    	git tag v1 c1
    		name the tag v1 and referenced the commit C1 explicitly
    	git describe <ref>:
    	the output of the command looks like: <tag>_<numCommits>_g<hash>

## 3. 
	cd /path: navigate to the project directory
	git init: initialize the Git repository
	git add . : add the project files
	git commit -m "test": commit changes
	git push -u origin master: push commits

## 4. 
	git clone <repository_url>

## 5. 
	git checkout -b branch_name
	or:
	git branch branch_name
	git checkout branch_name

## 6. 
	git checkout master
	git merge branch_test

## 7. 
	> command
	git checkout branch_learn_stash
	git stash save "Ke Chen"

	git checkout main

	git checkout branch_learn_stash

	git stash pop

	> IntelliJ IDEA
	Click on the "VCS" menu
	Select "Git"
	Click on "Stash Changes"

	Click on the "Git" branch icon in the bottom-right corner.
	Select the branch want to switch to

	lick on the "VCS" menu
	Select "Git"
	Click on "Unstash Changes"

## 8.
	a PR is stand for "Pull Request"

	A Pull Request is a mechanism for proposing and merging changes from one branch into another branch within a Git repository, often used in platforms like GitHub, GitLab, or Bitbucket. 

	the changes proposed in the PR are the changes made in the source branch compared to the traget branch.

## 9. 
	Maven is a build automation and project management tool
	Its primary purpose is to manage and automate various aspects of the software development lifecycle, including building, packaging, and dependency management. 

## 10. 
	validate - compile - test - package - verify - install - deploy

	validate:
		This phase validates the project's structure and configuration. It checks for issues like missing dependencies and validates the project's properties.
	compile:
		Maven compiles the source code (Java files, for example) into bytecode.
	test:
		Maven runs unit tests in the project.
	package:
		This phase packages the compiled code and resources into distributable formats, such as JARs, WARs, or other formats depending on the project type.
		Commonly used goals: jar, war
	verify:
		Maven runs additional checks on the packaged artifact to ensure its correctness and integrity.
	install:
		Maven installs the packaged artifact into the local repository on your development machine. This makes it available for other projects to use as a dependency.
		deploy:
		This phase deploys the artifact to a remote repository, making it available for others to download and use.

## 11.
	1. Purpose:
		package phase: is primarily concerned with creating the project's artifact (e.g., JAR, WAR) from the compiled code and resources.
		install phase: is responsible for installing the project's artifact into the local repository on your development machine.
	2. Artifact Destination:
		package phase: The resulting artifact is created in the project's target directory (e.g., target/my-project.jar).
		install phase: The artifact is copied from the target directory of the project and placed into your local Maven repository (e.g., ~/.m2/repository/groupId/artifactId/version/artifactId-version.jar).
	3. Local Respository
		package phase:The artifact created in the package phase is not installed in the local repository. It remains in the project's target directory, and it's typically used for local testing and development.
		install phase:The primary purpose of the install phase is to make the artifact available locally for other Maven projects on the same machine. This allows other projects to use your project as a dependency during their builds.

	In summary, the key difference between the package and install phases lies in where the resulting artifact is stored:

    package: creates the artifact in the project's target directory but doesn't install it in the local repository. It's mainly used for local testing and development within the project.
    install: not only creates the artifact but also copies it to the local Maven repository, making it available for use as a dependency in other Maven projects on your machine.

## 12.
	In Maven, plugins are extensions or modules that provide additional functionality to the build process.

	1. Maven Compiler Plugin (maven-compiler-plugin):
	    Purpose: Compiles Java source code in your project.
        Common Goals: compile, testCompile
    2. Maven Surefire Plugin (maven-surefire-plugin):
        Purpose: Executes unit tests in your project.
        Common Goals: test
    3. Maven Failsafe Plugin (maven-failsafe-plugin):
        Purpose: Executes integration tests in your project.
        Common Goals: integration-test, verify

## 13.
	![the picture to show how to make a maven project by IntelliJ IDEA](/Users/kechen/Desktop/work/chuwa0620/ShortQuestions/Q12.png)















