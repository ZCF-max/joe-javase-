# 1. 使用IDEA整合Git

**流程：** 将Git整合到IDEA中。
1. `File` - `settings` - `Version Control` - `Git` 
2. 在 `Path to Git executable` 一栏填入 `git.exe` 地址。
3. 点击 `Test` 测试是否成功。

# 2. 使用IDEA整合GitHub账号
**流程：** 将GitHub整合到IDEA中。
1. `File` - `settings` - `Version Control` - `GitHub`
2. 点击 `add account` 添加你的github账号密码。
3. 由于网速关系，如果添加不成功，多尝试几次。

> 如果不整合GitHub账号，则每次操作的时候需要填写GitHub账号和密码，这种方式比较麻烦但是更灵活。

# 3. 赵四push本地项目

**流程：** 赵四将本地项目push到GitHub中
1. `VCS` - `Import Into Version Control` - `Create Git Responsirty`
2. 选择当前项目路径，点击 `ok`，此时项目中的文件变红，处于工作区。
3. 右键项目 `Git` - `add`，此时文件变绿，处于暂存区。
4. 右键项目 `Git` - `commit File`，此时文件无色，处于本地仓库分支。
    - 如果需要更换分支，右键 `Git` - `Repository` - `branches`。
5. `ctrl + t`：快速更新项目，在提交之前建议先更新。
6. `ctrl + `：快速提交项目，注意一定要填写日志注释。
7. `ctrl + shift + k`，快速push项目：
    - 添加远程仓库地址，点击 `Push`。
    - 刷新GitHub，可以看到项目 `Push` 成功。

# 4. 刘能clone项目

**流程：** 刘能将赵四GitHub上的项目clone到自己的IDEA中
1. `VCS` -> `Checkout from Version Control` -> `Git`
2. 点击GitHub项目右上角的 `Code` 按钮，复制远程库的地址。
3. 将远程库的地址粘贴到 `Clone Repository` 的URL栏中。
4. 点击Test进行测试。
5. 点击 `Clone`。
6. 一直 `Next` 直到 `Finish` 结束，完成clone操作。

> Clone 不需要登陆账号和密码。

# 5. 赵四组建团队

**流程：** 赵四需要对刘能开放权限，将刘能设置为自己的队友，否则刘能无法push。
1. 赵四在GithuB上选择 `settings` - `Manage Access`
2. 点击 `invite a collaborator`
3. 赵四填写刘能的用户名或邮箱，进行验证。
4. 点击 `add xxx to 你从仓库`。
5. 点击 `pending invite` 旁边的复制按钮复制邀请码。
6. `copy invite link` 复制邀请码。
7. 刘能访问邀请码连接，接受邀请 `accept invitation`。
8. 刘能将修改后的代码重新 `push` 即可。
    - 选中新添加或者修改后的代码（红色），右键选择 `Git` - `add`。
    - `ctrl + t`：快速更新项目，在提交之前建议先更新。
    - `ctrl + k`：快速提交项目，注意一定要填写日志注释。
    - `ctrl + shift + k`，快速push项目，对于pull项目不需要填写远程库地址。
9. 点击 `Push`。
10. 在 `GitHub` 上刷新查看。

# 6. 解决代码冲突

概念：
- 解决冲突的方法：编辑文件删除冲突代码，并重新提交。
- 避免冲突的方法：
    - 多人修改同一文件会导致冲突，所以尽量分工明确。
    - 使用IDEA可以自动检测更新。
    - 提交前先更新（push前先pull）。