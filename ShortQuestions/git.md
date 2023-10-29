# Git

学习：

https://learngitbranching.js.org

答案:

https://gist.github.com/CraftingGamerTom/d334740303b647339b00875d27d38d34 
https://www.youtube.com/watch?v=HU2ItgyhGNU

## git commit
- A commit in a git repository保存的是你的目录下所有文件的a snapshot，就像是把整个目录复制，然后再粘贴一样，但比复制粘贴优雅许多！（A commit in a git repository records a snapshot of all the (tracked) files in your directory. It's like a giant copy and paste, but even better!）

- Git 希望commits尽可能地轻量，因此在你每次进行commit时，它并不会盲目地复制整个目录。条件允许的情况下，它会将当前版本与仓库中的上一个版本进行对比，并把所有a set of changes compress到一起作为a commit。（Git wants to keep commits as lightweight as possible though, so it doesn't just blindly copy the entire directory every time you commit. It can (when possible) compress a commit as a set of changes, or a "delta", from one version of the repository to the next.）

- Git 还保存了commits的历史记录。这也是为什么大多数commits的上面都有 parent 节点的原因 —— 我们会在图示中用箭头来表示这种关系。对于项目组的成员来说，维护commits对大家都有好处。（Git also maintains a history of which commits were made when. That's why most commits have ancestor commits above them -- we designate this with arrows in our visualization. Maintaining history is great for everyone working on the project）

- 现在你可以<u>把commits看作是项目的快照（snapshots of the project）</u>。提交记录非常轻量，可以快速地在这些提交记录之间切换！（for now you can think of commits as snapshots of the project. Commits are very lightweight and switching between them is wicked fast!）

当前有two commits —— the first initial commit C0 和在C0之后的可能包含某些修改的commit C1（On the picture we have a visualization of a (small) git repository. There are two commits right now -- the first initial commit, C0, and one commit after that C1 that might have some meaningful changes.）

![git commit before](images/hw1/git%20commit-before.png)

`       git commit      `

当运行完git commit之后，仓库会修改代码库，并把这些修改保存成了a commit，C2。

C2 的 parent 节点是 C1， parent 节点是当前commit中变更的基础。(We just made changes to the repository and saved them as a commit. The commit we just made has a parent, C1, which references which commit it was based off of.)
![git commit after](images/hw1/git%20commit-after.png)

	
## 分支branch操作
### git branch:
- git 的Branches也非常轻量。它们<u>只是简单地指向某个commit —— 仅此而已</u>。所以许多 Git 爱好者传颂：早建分支！多用分支！(Branches in Git are incredibly lightweight as well. They are simply pointers to a specific commit -- nothing more. This is why many Git enthusiasts chant the mantra:branch early, and branch often)

- 这是因为即使创建再多的分支也不会造成储存或内存上的开销，并且按逻辑分解工作到不同的分支要比维护那些特别臃肿的分支简单多了。(Because there is no storage / memory overhead with making many branches, it's easier to logically divide up your work than have big beefy branches.)

- 在将分支和commits结合起来后，我们会看到两者如何协作。现在只要记住<u>一个分支其实就相当于在说：“我想基于当前commits以及它所有的 parent commits的工作。”</u>(When we start mixing branches and commits, we will see how these two features combine. For now though, just remember that a branch essentially says "I want to include the work of this commit and all parent commits.")

我们将要创建一个到名为 newImage 的分支： 

git branch newImage ---> 新创建的分支 newImage 指向的是commit C1。

`       git branch newImage     `

![git branch](images/hw1/git%20branch.png)

Let's try to put some work on this new branch. 
```
git branch newImage
git commit
```

为什么 main 分支前进了，但 newImage 分支还待在原地呢？！这是因为我们没有“在”这个新分支上，看到 main 分支上的那个星号（*）了吗？这表示当前所在的分支是 main。（Oh no! The main branch moved but the newImage branch didn't! That's because we weren't "on" the new branch, which is why the asterisk (*) was on main.）

![git branch之后的git commit](images/hw1/git%20branch%E4%B9%8B%E5%90%8E%E7%9A%84git%20commit.png)



### git checkout:
- 切换到某一分支上 checkout the branch with name。查看分支，跳转到指定分支

```
git checkout newImage
git commit
修改已经保存到新的分支里了`
```

![git checkout之后的git commit](images/hw1/git%20checkout%E4%B9%8B%E5%90%8E%E7%9A%84git%20commit.png)

### git switch: 
- 最终会取代 git checkout，因为 checkout 作为单个命令有点超载（它承载了很多独立的功能）。 由于现在很多人还无法使用 switch，本次课程仍然使用 checkout 而不是 switch. (replace git checkout, but still use git checkout)


### git checkout -b your-branch-name:
- 创建一个新的分支同时切换到新创建的分支的话 (create a new branch and check it out)



## 合并: merge + rebase
- 将两个分支合并到一起。就是说我们新建一个分支，在其上开发某个新功能，开发完成后再合并回主线。

### git merge:
- 在 Git 中合并两个分支时会产生一个特殊的commit，它有两个 parent 节点。翻译成自然语言相当于：“我要把这两个 parent 节点本身及它们所有的祖先都包含进来。”（Merging in Git creates a special commit that has two unique parents. A commit with two parents essentially means "I want to include all the work from this parent over here and this one over here, and the set of all their parents."）

我们准备了两个分支，每个分支上各有一个独有的提交。这意味着没有单独的一个分支包含了我们修改的所有内容（修改的内容分成了2个分支）（we have two branches： bugFix + main; each has one commit that's unique: bugFix->C2, main->C3. This means that neither branch includes the entire set of "work" in the repository that we have done. ）

把 bugFix 合并到 main 里, 当前在main分支上
![bugFix 合并到 main 里git merge前](images/hw1/bugFix%20%E5%90%88%E5%B9%B6%E5%88%B0%20main%20%E9%87%8Cgit%20merge%E5%89%8D.png)

`       git merge bugFix       `

首先，main 现在指向了一个拥有两个 parent 节点的commits：C2 + C3。假如从 main 开始沿着箭头向上看，在到达起点的路上会经过所有的提交记录。这意味着 main 包含了对代码库的所有修改.(main now points to a commit that has two parents. If you follow the arrows up the commit tree from main, you will hit every commit along the way to the root. This means that main contains all the work in the repository now.)

还有，看见各个提交记录的颜色变化了吗？为了帮助学习理解，我引入了颜色搭配。每个分支都有不同的颜色，而每个提交记录的颜色是所有包含该提交记录的分支的颜色混合之后的颜色。

![bugFix 合并到 main 里git merge后](images/hw1/bugFix%20%E5%90%88%E5%B9%B6%E5%88%B0%20main%20%E9%87%8Cgit%20merge%E5%90%8E.png)


所以，main 分支的颜色被混入到所有的提交记录，但 bugFix 没有。下面咱们让它也改变一下颜色。<u>(git merge先做的就是产生当前branch的copy commit， 然后这个commit再同时指向2个parent commits)</u>。

再把 main 分支合并到 bugFix:
```
git checkout bugFix 
git merge main`
```

因为 main 继承自 bugFix，Git 什么都不用做，只是简单地把 bugFix 移动到 main 所指向的那个commit。<u>(同样的，git merge先做的就是产生当前branch的copy commit，但是因为 main 继承自 bugFix，所以可以直接把bugFix 移动到 main 所指向的那个commit)</u>

现在所有提交记录的颜色都一样了，这表明每一个分支都包含了代码库的所有修改！大功告成！

![mian合并到 bugFix 里](images/hw1/mian%E5%90%88%E5%B9%B6%E5%88%B0%20bugFix%20%E9%87%8C.png)


### git rebase
- Rebase 实际上就是取出一系列的提交记录，“复制”它们，然后在另外一个地方逐个的放下去。(Rebasing essentially takes a set of commits, "copies" them, and plops them down somewhere else.)

- Rebase 的优势就是可以创造更线性的提交历史，这听上去有些难以理解。如果只允许使用 Rebase 的话，代码库的提交历史将会变得异常清晰。(the advantage of rebasing is that it can be used to make a nice linear sequence of commits. The commit log / history of the repository will be a lot cleaner if only rebasing is allowed.)

- move our work from bugFix directly onto the work from main(合并本地的多条提交(commit)记录 )。

还是准备了两个分支: main + bugFix；注意当前所在的分支是 bugFix（星号标识的是当前分支）

我们想要把 bugFix 分支里的工作直接移到 main 分支上。移动以后会使得两个分支的功能看起来像是按顺序开发，但实际上它们是并行开发的。

![git rebase main前](images/hw1/git%20rebase%20main%E5%89%8D.png)

`       git rebase main     当前在bugFix上    把bugFix放到main的下面`

在 bugFix 分支上的工作在 main 的最顶端，同时我们也得到了一个更线性的提交序列。

注意，提交记录 C3 依然存在（树上那个半透明的节点），而 C3' 是我们 Rebase 到 main 分支上的 C3 的副本。

![git rebase main后](images/hw1/git%20rebase%20main%E5%90%8E.png)

现在唯一的问题就是 main 还没有更新，下面咱们就来更新它： 现在已经切换到 main 上。把它 rebase 到 bugFix 分支上

```
git checkout main
git rebase bugFix       
```

由于 bugFix 继承自 main，所以 Git 只是简单的把 main 分支的引用向前移动了一下而已。

![git rebase bugFix](images/hw1/git%20rebase%20bugFix.png)


## 在working tree上移动: 
- HEAD 是一个对当前所在分支的符号引用 —— 也就是指向你正在其基础上进行工作的commit。(HEAD is the symbolic name for the currently checked out commit -- it's essentially what commit you're working on top of.)
- <u>HEAD 总是指向当前分支上最近一次commit</u>。大多数修改working tree的 Git 命令都是从改变 HEAD 的指向开始的。(HEAD always points to the most recent commit which is reflected in the working tree. Most git commands which make changes to the working tree will start by changing HEAD.)
- HEAD 通常情况下是指向分支名的（如 bugFix）。在你commit时，改变了 bugFix 的状态，这一变化通过 HEAD 变得可见。(Normally HEAD points to a branch name (like bugFix). When you commit, the status of bugFix is altered and this change is visible through HEAD.)

![commit前HEAD的位置](images/hw1/commit%E5%89%8DHEAD%E7%9A%84%E4%BD%8D%E7%BD%AE.png)

```
git checkout C1
git checkout main
git commit
git checkout C2  //HEAD随着提交向前移动
```

![commit后HEAD的位置](images/hw1/commit%E5%90%8EHEAD%E7%9A%84%E4%BD%8D%E7%BD%AE.png)

## 分离的head
- 分离的 HEAD 就是让其指向了某个具体的commit而不是branch name。
- 在命令执行之前的状态如下所示：
    - HEAD -> main -> C1
    - HEAD 指向 main， main 指向 C1
- 执行完：git checkout C1
    - HEAD 指向 C1

## 相对引用 relative reference
- 通过指定commit hashes的方式在 Git 中移动不太方便。在实际应用时，并没有像本程序中这么漂亮的可视化提交树供你参考，所以你就不得不用 git log 来查查看提交记录的哈希值。(Moving around in Git by specifying commit hashes can get a bit tedious. In the real world you won't have a nice commit tree visualization next to your terminal, so you'll have to use git log to see hashes.)

- 并且hashes在真实的 Git 世界中也会更长（译者注：基于 SHA-1，共 40 位）。例如前一关的介绍中的the hash of the commit可能是 fed2da64c0efc5293610bdd892f82a58e8cbc5d8。舌头都快打结了吧...(Furthermore, hashes are usually a lot longer in the real Git world as well. For instance, the hash of the commit that introduced the previous level is fed2da64c0efc5293610bdd892f82a58e8cbc5d8. Doesn't exactly roll off the tongue...)

- 比较令人欣慰的是，Git 对哈希的处理很智能。你只需要提供能够唯一标识提交记录的前几个字符即可。因此我可以仅输入fed2 而不是上面的一长串字符。(The upside is that Git is smart about hashes. It only requires you to specify enough characters of the hash until it uniquely identifies the commit. So I can type fed2 instead of the long string above.)

- 正如我前面所说，specifying commits by their hash很不方便，所以 Git 引入了相对引用。这个就很厉害了!(specifying commits by their hash isn't the most convenient thing ever, which is why Git has relative refs. They are awesome!)

- 使用相对引用的话，你就可以从一个易于记忆的地方（比如 bugFix 分支或 HEAD）开始计算。(With relative refs, you can start somewhere memorable (like the branch bugFix or HEAD) and work from there.)

- 相对引用非常给力，这里我介绍两个简单的用法：(Relative commits are powerful, but we will introduce two simple ones here:)
    - <u>使用 ^ 向上移动 1 个提交记录</u>
    - <u>使用 ~<num> 向上移动多个提交记录，如 ~3</u>

### 相对引用 ^: 找到父母节点:
- 把这个符号加在引用名称的后面，表示让 Git 寻找指定提交记录的 parent 提交。(Each time you append that to a ref name, you are telling Git to find the parent of the specified commit.)

- 所以 main^ 相当于 main 的 parent 节点
- main^^ 是 main 的第二个 parent 节点

![git checkout main^前](images/hw1/git%20checkout%20main%5E%E5%89%8D.png)
`       git checkout main^      `
![git checkout main^后](images/hw1/git%20checkout%20main%5E%E5%90%8E.png)

你也可以将 HEAD 作为相对引用的参照。下面咱们就用 HEAD 在提交树中向上移动几次。
![git checkout HEAD^前](images/hw1/git%20checkout%20HEAD%5E%E5%89%8D.png)
`       git checkout HEAD^      `
![git checkout HEAD^后](images/hw1/git%20checkout%20HEAD%5E%E5%90%8E.png)


### 相对引用 ～: 在树上一次性移动多次
- 如果你想在commit tree中向上移动很多步的话，敲那么多 ^ 貌似也挺烦人的，Git 当然也考虑到了这一点，于是又引入了操作符 \~。（you want to move a lot of levels up in the commit tree. It might be tedious to type ^ several times, so Git also has the tilde (\~) operator.）
- 该操作符后面可以跟一个数字（可选，不跟数字时与 ^ 相同，向上移动一次），指定向上移动多少次（The tilde operator (optionally) takes in a trailing number that specifies the number of parents you would like to ascend.）

咱们用 \~<num> 一次后退四步： 
![git checkout HEAD~4前](images/hw1/git%20checkout%20HEAD~4%E5%89%8D.png)

`       git checkout HEAD~4     `

![git checkout HEAD~4后](images/hw1/git%20checkout%20HEAD~4%E5%90%8E.png)

## 强制移动分支位置: git branch -f
- 可以直接使用 -f 选项让分支指向另一个提交。

![git branch -f前](images/hw1/git%20branch%20-f%E5%89%8D.png)

`       git branch -f main HEAD~3      //将 main 分支强制指向 HEAD 的第 3 级 parent 提交。`

![git branch -f后](images/hw1/git%20branch%20-f%E5%90%8E.png)

- -f 则容许我们将分支强制移动到那个位置。
    - `git branch -f main C6`: 会将 main 分支强制指向 commit: C6 处提交。


## 撤销变更 reset + revert / undo

- 在 Git 里撤销变更的方法很多。和提交一样，撤销变更由底层部分（暂存区的独立文件或者片段）和上层部分（变更到底是通过哪种方式被撤销的）组成。我们这个应用主要关注的是后者。(There are many ways to reverse changes in Git. And just like committing, reversing changes in Git has both a low-level component (staging individual files or chunks) and a high-level component (how the changes are actually reversed). Our application will focus on the latter.)
- 主要有两种方法用来撤销变更 —— 一是 git reset，还有就是 git revert。(There are two primary ways to undo changes in Git -- one is using git reset and the other is using git revert. )

### git reset: 本地 + 直接回退
- git reset 通过把分支记录回退到前一个commit来实现撤销改动。你可以将这想象成“改写历史”。git reset 向上移动分支，原来指向的提交记录就跟从来没有提交过一样。(git reset reverses changes by moving a branch reference backwards in time to an older commit. In this sense you can think of it as "rewriting history;" git reset will move a branch backwards as if the commit had never been made in the first place.)

`       git reset HEAD~1        `

![git reset HEAD~1前](images/hw1/git%20reset%20HEAD~1%E5%89%8D.png)

Git 把 main 分支移回到 C1；现在我们的本地代码库根本就不知道有 C2 这个提交了。(Git moved the main branch reference back to C1; now our local repository is in a state as if C2 had never happened.)

![git reset HEAD~1后](images/hw1/git%20reset%20HEAD~1%E5%90%8E.png)

### git revert: 远程
- 虽然在你的本地分支中使用 git reset 很方便，但是这种“改写历史”的方法对大家一起使用的远程分支是无效的哦！(While resetting works great for local branches on your own machine, its method of "rewriting history" doesn't work for remote branches that others are using.)
- 为了撤销更改并分享给别人，我们需要使用 git revert(In order to reverse changes and share those reversed changes with others, we need to use git revert.)

`       git revert HEAD         `

![git revert HEAD前](images/hw1/git%20revert%20HEAD%E5%89%8D.png)

奇怪！在我们要撤销的commit后面居然多了a new commit！这是因为new commit C2' 引入了更改 —— 这些更改刚好是用来撤销 C2 这个提交的。也就是说 C2' 的状态与 C1 是相同的。(weird, a new commit plopped down below the commit we wanted to reverse. That's because this new commit C2' introduces changes -- it just happens to introduce changes that exactly reverses the commit of C2.)

revert 之后就可以把你的更改推送到远程仓库与别人分享啦。(With reverting, you can push out your changes to share with others.)
![git revert HEAD后](images/hw1/git%20revert%20HEAD%E5%90%8E.png)

## 整理commit（顺序/删除）
- 开发人员有时会说“我想要把这个提交放到这里, 那个提交放到刚才那个提交的后面”, 而接下来就讲的就是它的实现方式，非常清晰、灵活，还很生动。(The next concept we're going to cover is "moving work around" -- in other words, it's a way for developers to say "I want this work here and that work there" in precise, eloquent, flexible ways.)

### git cherry-pick <Commit1> <Commit2> <...>
- 如果你想将<u>复制一些commits到当前所在的位置（HEAD）下面</u>的话， Cherry-pick 是最直接的方式了。(you would like to copy a series of commits below your current location (HEAD).)

`       git cherry-pick C2 C4       `

![git cherry-pick C2 C4前](images/hw1/git%20cherry-pick%20C2%20C4%E5%90%8E.png)

我们只需要commits C2 和 C4，所以 Git 就将被它们抓过来放到当前分支下了。(We wanted commits C2 and C4 and git plopped them down right below us)

![git cherry-pick C2 C4后](images/hw1/git%20cherry-pick%20C2%20C4%E5%89%8D.png)


## 交互式整理commit（顺序/删除） rebase -i 
- Git Interactive Rebase
- 当你知道你所需要的提交记录（并且还知道这些提交记录的哈希值）时, 用 cherry-pick 再好不过了 —— 没有比这更简单的方式了。(Git cherry-pick is great when you know which commits you want (and you know their corresponding hashes) -- it's hard to beat the simplicity it provides.)

- 但是如果你不清楚你想要的提交记录的哈希值呢? 幸好 Git 帮你想到了这一点, 我们可以利用交互式的 rebase —— 如果你想从一系列的提交记录中找到想要的记录, 这就是最好的方法了(But what about the situation where you don't know what commits you want? Thankfully git has you covered there as well! We can use interactive rebasing for this -- it's the best way to review a series of commits you're about to rebase.)

- 交互式 rebase 指的是使用带参数 --interactive 的 rebase 命令, 简写为 -i(All interactive rebase means Git is using the rebase command with the -i option.)

- 如果你在命令后增加了这个选项, Git 会打开一个 UI 界面并列出将要被复制到目标分支的备选提交记录，它还会显示每个提交记录的哈希值和提交说明，提交说明有助于你理解这个提交进行了哪些更改。(If you include this option, git will open up a UI to show you which commits are about to be copied below the target of the rebase. It also shows their commit hashes and messages, which is great for getting a bearing on what's what.)

- 在实际使用时，所谓的 UI 窗口一般会在文本编辑器 —— 如 Vim —— 中打开一个文件。 考虑到课程的初衷，我弄了一个对话框来模拟这些操作。(For "real" git, the UI window means opening up a file in a text editor like vim. For our purposes, I've built a small dialog window that behaves the same way.)

- 当 rebase UI界面打开时, 你能做3件事:
    - <u>调整提交记录的顺序（通过鼠标拖放来完成）</u>(You can reorder commits simply by changing their order in the UI (via dragging and dropping with the mouse).)
    - <u>删除你不想要的提交（通过切换 pick 的状态来完成，omit就意味着你不想要这个提交记录）</u>(You can choose to keep all commits or drop specific ones. When the dialog opens, each commit is set to be included by the pick button next to it being active. To drop a commit, toggle off its pick button.)
    - 合并提交。 遗憾的是由于某种逻辑的原因，我们的课程不支持此功能，因此我不会详细介绍这个操作。简而言之，它允许你把多个提交记录合并成一个。

当你点击下面的按钮时，会出现一个交互对话框。对提交记录做个排序（当然你也可以删除某些提交）:

`       git rebase -i HEAD~4        ` 

操作：将C5的位置通过鼠标的拖拽，移到了最前面，并且删除掉了C2,C3

![git rebase -i前](images/hw1/git%20rebase%20-i%E5%89%8D.png)

![git rebase -i后](images/hw1/git%20rebase%20-i%E5%90%8E.png)

## 只取一个提交记录 本地栈式提交
- 来看一个在开发中经常会遇到的情况：我正在解决某个特别棘手的 Bug，为了便于调试而在代码中添加了一些调试命令并向控制台打印了一些信息。(Here's a development situation that often happens: I'm trying to track down a bug but it is quite elusive. In order to aid in my detective work, I put in a few debug commands and a few print statements.)

- 这些调试和打印语句都在它们各自的提交记录里。最后我终于找到了造成这个 Bug 的根本原因，解决掉以后觉得沾沾自喜！(All of these debugging / print statements are in their own commits. Finally I track down the bug, fix it, and rejoice!)

- 最后就差把 bugFix 分支里的工作合并回 main 分支了。你可以选择通过 fast-forward 快速合并到 main 分支上，但这样的话 main 分支就会包含我这些调试语句了。你肯定不想这样，应该还有更好的方式……(Only problem is that I now need to get my bugFix back into the main branch. If I simply fast-forwarded main, then main would get all my debug statements which is undesirable. There has to be another way...)

- 实际我们只要让 Git 复制解决问题的那一个提交记录就可以了。跟之前我们在“整理提交记录”中学到的一样，我们可以使用:(We need to tell git to copy only one of the commits over. This is just like the levels earlier on moving work around -- we can use the same commands:)`git rebase -i 或者git cherry-pick` 来达到目的

### 提交的技巧 #1
接下来这种情况也是很常见的：你之前在 newImage 分支上进行了一次提交，然后又基于它创建了 caption 分支，然后又提交了一次。(Here's another situation that happens quite commonly. You have some changes (newImage) and another set of changes (caption) that are related, so they are stacked on top of each other in your repository (aka one after another).)

此时你想对某个以前的提交记录进行一些小小的调整。比如设计师想修改一下 newImage 中图片的分辨率，尽管那个提交记录并不是最新的了。(The tricky thing is that sometimes you need to make a small modification to an earlier commit. In this case, design wants us to change the dimensions of newImage slightly, even though that commit is way back in our history!!)

- 我们可以通过下面的方法来克服困难：

- 
    - 先用 git rebase -i 将提交重新排序，然后把我们想要修改的提交记录挪到最前
    - 然后用 git commit --amend 来进行一些小修改
    - 接着再用 git rebase -i 来将他们调回原来的顺序
    - 最后我们把 main 移到修改的最前端（用你自己喜欢的方法），就大功告成啦！

- 当然完成这个任务的方法不止上面提到的一种（我知道你在看 cherry-pick 啦），之后我们会多点关注这些技巧啦，但现在暂时只专注上面这种方法。 最后有必要说明一下目标状态中的那几个' —— 我们把这个提交移动了两次，每移动一次会产生一个 '；而 C2 上多出来的那个是我们在使用了 amend 参数提交时产生的，所以最终结果就是这样了。

- 也就是说，我在对比结果的时候只会对比提交树的结构，对于 ' 的数量上的不同，并不纳入对比范围内。只要你的 main 分支结构与目标结构相同，我就算你通过。

## 提交的技巧 #2

## Git Tag

## Git Describe

## 多次 Rebase

## 两个 parent 节点

## 纠缠不清的分支

