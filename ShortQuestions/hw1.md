1. Learn **MarkDown** and show all of basic usage.


```
System.out.println(“Hello”);
```

2. Practice Git using the platform. List the git commands you learned.

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

       If we have existing files in this directory and you want to track them with Git:

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



5. How to create a new branch and checkout to that branch?



6. How to merge the branch_test to master branch in command? Show me the commands.




7. How to stash your new code before leaving branch branch_learn_stash and pop your stash when you checkout back to **branch_learn_stash**? Try commands way and intellij way.




8. How do you understand **PR is based on Branch**?




9. What is  **maven** role? What it be used to do?




10. What is the **lifecycle** of maven? Could you tell me the details?




11. What is the difference between **package** and install in maven lifecycle?




12. What is **plugins** in maven, list some plugins.




13. In **Repo/MavenProject** directory, create a **maven Module** using Intellij, named it as belows:
    1. groupID: **com.chuwa.learn**
    2. artifactID: **java-core**
   
   
   

14. Do **Code Review**: Go over the PRs in your repo, tried to leave some useful comments in other students’ PR, please don’t merge it.


