DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user(
                         `id` BIGINT NOT NULL  COMMENT '主键ID' ,
                         `user_name` VARCHAR(63) NOT NULL  COMMENT '用户账号' ,
                         `password` VARCHAR(127) NOT NULL  COMMENT '用户密码' ,
                         `nick_name` VARCHAR(63) NOT NULL  COMMENT '用户昵称' ,
                         `telephone_number` VARCHAR(155)   COMMENT '用户电话号码' ,
                         `email` VARCHAR(63)   COMMENT '用户邮箱' ,
                         `state` INT(2) NOT NULL DEFAULT 0 COMMENT '用户状态;0:使用中' ,
                         `enable` INT(2) NOT NULL DEFAULT 0 COMMENT '是否禁用;0:启用,1:禁用' ,
                         `user_type` INT(4) NOT NULL DEFAULT 0 COMMENT '用户类型;0:为root用户,1:为普通用户' ,
                         `last_updated_password` DATETIME   COMMENT '修改密码时间' ,
                         `last_login_time` DATETIME   COMMENT '登入时间' ,
                         `deleted` boolean   COMMENT '删除;false正常true删除' ,
                         `create_by` VARCHAR(32) COMMENT '操作用户ID' ,
                         `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
                         `updated_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '更新时间' ,
                         PRIMARY KEY (id)
)  COMMENT = '用户';

DROP TABLE IF EXISTS sys_role;
CREATE TABLE sys_role(
                         `id` BIGINT NOT NULL  COMMENT 'ID主键名称' ,
                         `name` VARCHAR(63) NOT NULL  COMMENT '角色名称' ,
                         `type` INT(2) NOT NULL DEFAULT 2 COMMENT '类型;0、为root角色，1、为普通角色' ,
                         `description` VARCHAR(255)   COMMENT '角色描述' ,
                         `deleted` boolean   COMMENT '逻辑删除标识;false正常true删除' ,
                         `created_time` DATETIME  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
                         `updated_time` DATETIME  DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '更新时间' ,
                         PRIMARY KEY (id)
)  COMMENT = '角色';

DROP TABLE IF EXISTS sys_user_role;
CREATE TABLE sys_user_role(
                              `id` INT AUTO_INCREMENT COMMENT '主键ID' ,
                              `user_id` BIGINT NOT NULL  COMMENT '用户id' ,
                              `role_id` BIGINT NOT NULL  COMMENT '角色id' ,
                              PRIMARY KEY (id)
)  COMMENT = '用户角色关系表';

DROP TABLE IF EXISTS sys_menu;
CREATE TABLE sys_menu(
                         `id` BIGINT NOT NULL  COMMENT '主键ID' ,
                         `parent_id` BIGINT   COMMENT '主键父ID' ,
                         `name` VARCHAR(63) NOT NULL  COMMENT '菜单名称' ,
                         `code` VARCHAR(63) NOT NULL  COMMENT '菜单编码' ,
                         `url` VARCHAR(255)   COMMENT '请求地址' ,
                         `type` INT(4) NOT NULL  COMMENT '菜单类型;1:菜单,2:功能按钮' ,
                         `menu_icon` VARCHAR(255)   COMMENT '菜单图标' ,
                         `permission_type` INT(4) NOT NULL DEFAULT 2 COMMENT '权限类型;1:默认权限,2:配置权限，3默认管理员权限' ,
                         `sort_num` INT(4)  DEFAULT 0 COMMENT '排序' ,
                         `deleted` boolean   COMMENT '逻辑删除标识;false正常true删除' ,
                         `created_time` DATETIME  DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
                         `updated_time` DATETIME  DEFAULT CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '更新时间' ,
                         PRIMARY KEY (id)
)  COMMENT = '菜单';

DROP TABLE IF EXISTS sys_role_menu;
CREATE TABLE sys_role_menu(
                              `id` INT AUTO_INCREMENT COMMENT '主键ID' ,
                              `role_id` BIGINT NOT NULL  COMMENT '角色id' ,
                              `menu_id` BIGINT NOT NULL  COMMENT '菜单id' ,
                              PRIMARY KEY (id)
)  COMMENT = '角色菜单关系表';

DROP TABLE IF EXISTS sys_log;
CREATE TABLE sys_log(
                        `id` INT AUTO_INCREMENT COMMENT '主键ID' ,
                        `create_by` VARCHAR(32) NOT NULL  COMMENT '用户ID' ,
                        `request_time` INT(32)   COMMENT '请求时间' ,
                        `created_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间' ,
                        `url` VARCHAR(255) NOT NULL  COMMENT '请求地址' ,
                        `intf_name` VARCHAR(255)   COMMENT '接口名称' ,
                        `code` VARCHAR(255)   COMMENT '返回状态' ,
                        `exception_msg` TEXT   COMMENT '异常内容' ,
                        PRIMARY KEY (id)
)  COMMENT = '登入日志';




