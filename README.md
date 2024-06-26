### 数据库设计

### 解释

1. **users 表**：存储用户信息，包括用户名、密码和角色（学生、教师、管理员）。
2. **user_groups 表**：存储分组信息，每个分组有唯一的ID和名称。
3. **projects 表**：存储项目信息，包括项目名称、描述和截止日期。
4. **group_projects 表**：存储分组与项目的关联信息及其状态。
5. **reviews 表**：存储项目互评信息，包括评分和评论。
6. **grades 表**：存储教师对项目的评分和评论，作为最终成绩评定依据。
7. **archives 表**：存储所有已完成项目的归档信息，包括最终评分和归档时间。

### 设计原因

1. **分组**：
    - **user_groups 表**用于管理学生分组。
    - **users 表**中的学生和教师信息能关联到分组。

2. **项目管理**：
    - **projects 表**管理项目基本信息。
    - **group_projects 表**管理分组和项目的关联信息及其状态。

3. **项目互评**：
    - **reviews 表**记录每个项目的互评信息，包括评分和评论。

4. **成绩评定**：
    - **grades 表**记录教师对项目的评分和评论，作为最终成绩评定依据。

5. **作业归档**：
    - **archives 表**保存所有已完成项目的归档信息，包括最终评分和归档时间。



