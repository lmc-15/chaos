-- 用户
INSERT INTO chaos.sys_user
(id, user_name, password, nick_name, telephone_number, email, state, enable, user_type, last_updated_password, last_login_time, deleted, created_time, updated_time)
VALUES(1808770857955364864, 'root', '1967c9f81bfc7fb66414ea329315bbdd', '超级管理员', '19849481263', 'q.exnuhnlm@wkksncu.tj', 0, 0, 0, NULL, NULL, 0, '2024-07-04 15:52:33', '2024-07-04 07:52:53');
INSERT INTO chaos.sys_user
(id, user_name, password, nick_name, telephone_number, email, state, enable, user_type, last_updated_password, last_login_time, deleted, created_time, updated_time)
VALUES(1809056949908672512, 'admin', '1967c9f81bfc7fb66414ea329315bbdd', '操作员', '19817342326', 'i.edsglpn@uprjjfbfpu.mv', 0, 0, 1, NULL, NULL, 0, '2024-07-05 10:49:22', '2024-07-05 06:38:21');
-- 角色
INSERT INTO chaos.sys_role
(id, `type`, name, description, deleted, created_time, updated_time)
VALUES(1808772430269911040, 0, '超级管理', '超级管理', 0, '2024-07-04 15:58:47', '2024-07-04 07:59:01');
INSERT INTO chaos.sys_role
(id, `type`, name, description, deleted, created_time, updated_time)
VALUES(1809041297164603392, 1, '操作员', '操作员', 0, '2024-07-05 09:47:10', '2024-07-05 06:38:05');

-- 用户角色关系
INSERT INTO chaos.sys_user_role
(user_id, role_id)
VALUES(1808770857955364864, 1808772430269911040);
INSERT INTO chaos.sys_user_role
(user_id, role_id)
VALUES(1809056949908672512, 1809041297164603392);

-- 菜单
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1808768182337540096, NULL, '概览', 'overview', '/overview', 1, 'i-antd:dashboard-outlined', 1, 1, 0, '2024-07-04 15:41:55', '2024-07-04 15:41:55');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1808768182484340736, NULL, '迁移评估', 'evaluation', '/evaluation', 1, 'i-antd:file-done-outlined', 2, 2, 0, '2024-07-04 15:41:55', '2024-07-04 15:41:55');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1808768182605975552, NULL, '结构迁移', 'migration', '/migration', 1, 'i-antd:retweet-outlined', 2, 3, 0, '2024-07-04 15:41:55', '2024-07-04 15:41:55');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1808768182715027456, NULL, '数据复制', 'replication', '/replication', 1, 'i-antd:block-outlined', 2, 4, 0, '2024-07-04 15:41:55', '2024-07-04 15:41:55');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1808768182824079360, NULL, '数据导入', 'import', '/import', 1, 'i-antd:import-outlined', 2, 5, 0, '2024-07-04 15:41:55', '2024-07-04 15:41:55');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1808768182933131264, NULL, '数据对比', 'comparison', '/comparison', 1, 'i-antd:diff-outlined', 2, 6, 0, '2024-07-04 15:41:55', '2024-07-04 15:41:55');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1808768183063154688, NULL, '数据源', 'datasource', '/datasource', 1, 'i-antd:database-outlined', 2, 7, 0, '2024-07-04 15:41:55', '2024-07-04 15:41:55');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1808768183159623680, NULL, '工作节点', 'tm', '/tm', 1, 'i-antd:build-outlined', 2, 8, 0, '2024-07-04 15:41:55', '2024-07-04 15:41:55');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1808768183256092672, NULL, '权限管理', 'auth', '/auth', 1, 'i-antd:key-outlined', 3, 9, 0, '2024-07-04 15:41:55', '2024-07-04 15:41:55');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1808768183377727488, 1808768183256092672, '用户管理', 'user', 'user', 1, 'i-antd:user-outlined', 3, 11, 0, '2024-07-04 15:41:55', '2024-07-04 07:42:25');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1808768183478390784, 1808768183256092672, '角色管理', 'role', 'role', 1, 'i-antd:idcard-outlined', 3, 12, 0, '2024-07-04 15:41:55', '2024-07-04 07:42:25');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1808768183591636992, 1808768183256092672, '菜单管理', 'menu', 'menu', 1, 'i-antd:menu-unfold-outlined', 3, 13, 0, '2024-07-04 15:41:55', '2024-07-04 07:42:25');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1808768183700688896, 1808768183256092672, '接口管理', 'interface', 'interface', 1, 'i-antd:api-outlined', 3, 14, 0, '2024-07-04 15:41:55', '2024-07-04 07:42:25');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1809129549859000320, NULL, '用户查询', 'query:uac:users', '', 2, '', 3, 0, 0, '2024-07-05 15:37:51', '2024-07-05 15:37:51');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1809129550278430720, NULL, '创建用户', 'add:uac:users', '', 2, '', 3, 1, 0, '2024-07-05 15:37:51', '2024-07-05 15:37:51');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1809129550416842752, NULL, '编辑用户', 'update:uac:users', '', 2, '', 3, 2, 0, '2024-07-05 15:37:51', '2024-07-05 15:37:51');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1809129550513311744, NULL, '用户删除', 'delete:uac:users', '', 2, '', 3, 3, 0, '2024-07-05 15:37:52', '2024-07-05 15:37:52');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1809129550605586432, NULL, '批量删除', 'delete:uac:users:batch-delete', '', 2, '', 3, 4, 0, '2024-07-05 15:37:52', '2024-07-05 15:37:52');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1809129550882410496, NULL, '重制密码', 'query:uac:users:reset:password', '', 2, '', 3, 6, 0, '2024-07-05 15:37:52', '2024-07-05 15:37:52');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1809129551020822528, NULL, '角色查询列表', 'query:uac:roles', '', 2, '', 3, 7, 0, '2024-07-05 15:37:52', '2024-07-05 15:37:52');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1809129551117291520, NULL, '菜单查询', 'query:uac:menus', '', 2, '', 3, 8, 0, '2024-07-05 15:37:52', '2024-07-05 15:37:52');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1809129551205371904, NULL, '权限查询', 'query:uac:permissions', '', 2, '', 3, 9, 0, '2024-07-05 15:37:52', '2024-07-05 15:37:52');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930100028444672, NULL, '【迁移评估】创建任务', 'add:job:evaluation', '', 2, '', 2, 10, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930100397543424, NULL, '【迁移评估】修改任务', 'put:job:evaluation', '', 2, '', 2, 11, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930100569509888, NULL, '【迁移评估】删除任务', 'delete:job:evaluation', '', 2, '', 2, 12, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930100674367488, NULL, '【迁移评估】查询任务详情', 'query:job:evaluation', '', 2, '', 2, 13, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930100800196608, NULL, '【迁移评估】查询任务列表', 'query:job:evaluations', '', 2, '', 2, 14, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930100930220032, NULL, '【迁移评估】查询评估PLAIN-SQLS', 'query:job:evaluation:plain-sqls', '', 2, '', 2, 15, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930101051854848, NULL, '【迁移评估】执行任务', 'patch:job:evaluation:exec', '', 2, '', 2, 16, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930101139935232, NULL, '【迁移评估】停止任务', 'patch:job:evaluation:stop', '', 2, '', 2, 17, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930101240598528, NULL, '【迁移评估】重置任务', 'patch:job:evaluation:reset', '', 2, '', 2, 18, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930101341261824, NULL, '【迁移评估】查询评估任务进度/状态', 'query:job:evaluation:status', '', 2, '', 2, 19, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930101450313728, NULL, '【迁移评估】查询评估结果', 'query:job:evaluation:results', '', 2, '', 2, 20, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930101555171328, NULL, '【迁移评估】下载评估报告', 'query:job:evaluation:report', '', 2, '', 2, 21, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930101672611840, NULL, '【迁移评估】查询任务实例列表', 'query:job:evaluation:instances', '', 2, '', 2, 22, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930101764886528, NULL, '【迁移评估】查询任务实例详情', 'query:job:evaluation:instance', '', 2, '', 2, 23, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930101844578304, NULL, '【迁移评估】根据实例ID停止任务', 'patch:job:evaluation:instance:stop', '', 2, '', 2, 24, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930101962018816, NULL, '【迁移评估】根据实例ID重试任务', 'patch:job:evaluation:instance:retry', '', 2, '', 2, 25, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930102079459328, NULL, '【结构迁移】删除任务', 'delete:job:migration', '', 2, '', 2, 26, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930102184316928, NULL, '【结构迁移】查询任务详情', 'query:job:migration', '', 2, '', 2, 27, 0, '2024-07-10 14:52:36', '2024-07-10 14:52:36');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930102301757440, NULL, '【结构迁移】查询任务列表', 'query:job:migrations', '', 2, '', 2, 28, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930102406615040, NULL, '【结构迁移】查询任务进度详情', 'query:job:migration:progress', '', 2, '', 2, 29, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930102524055552, NULL, '【结构迁移】查询任务执行配置', 'query:job:migration:execution-config', '', 2, '', 2, 30, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930102607941632, NULL, '【结构迁移】修改任务执行配置', 'put:job:migration:execution-config', '', 2, '', 2, 31, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930102696022016, NULL, '【结构迁移】启动任务', 'patch:job:migration:execute', '', 2, '', 2, 32, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930102800879616, NULL, '【结构迁移】停止任务', 'patch:job:migration:stop', '', 2, '', 2, 33, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930102888960000, NULL, '【结构迁移】查询结构迁移结果', 'query:job:migration:results', '', 2, '', 2, 34, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930102985428992, NULL, '【结构迁移】修改目标SQL', 'put:job:migration:modify-sql', '', 2, '', 2, 35, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930103115452416, NULL, '【结构迁移】重置任务', 'patch:job:migration:reset', '', 2, '', 2, 36, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930103253864448, NULL, '【结构迁移】下载结构迁移报告', 'query:job:migration:report', '', 2, '', 2, 37, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930103371304960, NULL, '【结构迁移】查询类型映射', 'query:job:migration:type-mappings', '', 2, '', 2, 38, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930103484551168, NULL, '【结构迁移】执行目标SQL', 'patch:job:migration:exec-sqls', '', 2, '', 2, 39, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930103581020160, NULL, '【结构迁移】查询任务实例列表', 'query:job:migration:instances', '', 2, '', 2, 40, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930103664906240, NULL, '【结构迁移】查询任务实例详情', 'query:job:migration:instance', '', 2, '', 2, 41, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930103757180928, NULL, '【结构迁移】根据实例ID停止结构迁移任务', 'patch:job:migration:instance:stop', '', 2, '', 2, 42, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930103853649920, NULL, '【结构迁移】根据实例ID重试结构迁移任务', 'patch:job:migration:instance:retry', '', 2, '', 2, 43, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930103933341696, NULL, '【数据复制】创建任务', 'add:job:replication', '', 2, '', 2, 44, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930104013033472, NULL, '【数据复制】修改任务', 'put:job:replication', '', 2, '', 2, 45, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930104101113856, NULL, '【数据复制】删除任务', 'delete:job:replication', '', 2, '', 2, 46, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930104193388544, NULL, '【数据复制】查询任务详情', 'query:job:replication', '', 2, '', 2, 47, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930104289857536, NULL, '【数据复制】查询任务状态', 'query:job:replication:status', '', 2, '', 2, 48, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930104382132224, NULL, '【数据复制】查询任务列表', 'query:job:replications', '', 2, '', 2, 49, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930104466018304, NULL, '【数据复制】执行任务', 'patch:job:replication:exec', '', 2, '', 2, 50, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930104558292992, NULL, '【数据复制】停止任务', 'patch:job:replication:stop', '', 2, '', 2, 51, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930104663150592, NULL, '【数据复制】预检查', 'patch:job:replication:pre-check', '', 2, '', 2, 52, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930104747036672, NULL, '【数据复制】上传schema-history文件', 'add:job:replication:schema-history', '', 2, '', 2, 53, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930104847699968, NULL, '【数据复制】删除schema-history文件', 'delete:job:replication:schema-history', '', 2, '', 2, 54, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930104977723392, NULL, '【数据复制】查询schema-history文件', 'query:job:replication:schema-history', '', 2, '', 2, 55, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930105065803776, NULL, '【数据复制】查询state', 'query:job:replication:state', '', 2, '', 2, 56, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930105166467072, NULL, '【数据复制】删除state', 'delete:job:replication:state', '', 2, '', 2, 57, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930105262936064, NULL, '【数据复制】创建&更新增量的currentOffset', 'add:job:replication:offset', '', 2, '', 2, 58, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930105363599360, NULL, '【数据复制】查询任务的table-include-list', 'query:job:replication:table-include-list', '', 2, '', 2, 59, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930105460068352, NULL, '【数据复制】查询全量对比配置', 'query:job:replication:snapshot-comparison:config', '', 2, '', 2, 60, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930105564925952, NULL, '【数据复制】创建/修改全量对比配置', 'add:job:replication:snapshot-comparison:config', '', 2, '', 2, 61, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930105669783552, NULL, '【数据复制】查询全量对比结果', 'query:job:replication:snapshot-comparison:results', '', 2, '', 2, 62, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930105774641152, NULL, '【数据复制】执行全量任务', 'patch:job:replication:snapshot-comparison:exec', '', 2, '', 2, 63, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930105879498752, NULL, '【数据复制】查询增量对比任务详情', 'query:job:replication:increment-comparison:detail', '', 2, '', 2, 64, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930105963384832, NULL, '【数据复制】查询增量任务配置', 'query:job:replication:increment-comparison:config', '', 2, '', 2, 65, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930106043076608, NULL, '【数据复制】创建/修改增量任务配置', 'add:job:replication:increment-comparison:config', '', 2, '', 2, 66, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930106147934208, NULL, '【数据复制】查询对比桶数量信息', 'query:job:replication:increment-comparison:bucket:overview', '', 2, '', 2, 67, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930106244403200, NULL, '【数据复制】分页查询对比桶基础信息', 'query:job:replication:increment-comparison:bucket:simple-infos', '', 2, '', 2, 68, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930106332483584, NULL, '【数据复制】查询对比桶详情', 'query:job:replication:increment-comparison:bucket', '', 2, '', 2, 69, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930106428952576, NULL, '【数据导入】创建任务', 'add:job:kafka:replication', '', 2, '', 2, 70, 0, '2024-07-10 14:52:37', '2024-07-10 14:52:37');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930106512838656, NULL, '【数据导入】修改任务', 'put:job:kafka:replication', '', 2, '', 2, 71, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930106609307648, NULL, '【数据导入】删除任务', 'delete:job:kafka:replication', '', 2, '', 2, 72, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930106718359552, NULL, '【数据导入】查询任务详情', 'query:job:kafka:replication', '', 2, '', 2, 73, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930106839994368, NULL, '【数据导入】查询任务列表', 'query:job:kafka:replications', '', 2, '', 2, 74, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930106936463360, NULL, '【数据导入】执行任务', 'patch:job:kafka:replication:exec', '', 2, '', 2, 75, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930107049709568, NULL, '【数据导入】停止任务', 'patch:job:kafka:replication:stop', '', 2, '', 2, 76, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930107146178560, NULL, '【数据导入】获取任务offset状态', 'query:job:kafka:replication:state', '', 2, '', 2, 77, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930107221676032, NULL, '【数据导入】设置任务的offset', 'patch:job:kafka:replication:reset', '', 2, '', 2, 78, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930107309756416, NULL, '【数据导入】查询任务的table-include-list', 'query:job:kafka:replication:table-include-list', '', 2, '', 2, 79, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930107397836800, NULL, '【数据导入】查询增量对比任务详情', 'query:job:kafka:replication:increment-comparison:detail', '', 2, '', 2, 80, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930107481722880, NULL, '【数据导入】查询增量对比配置信息', 'query:job:kafka:replication:increment-comparison:config', '', 2, '', 2, 81, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930107573997568, NULL, '【数据导入】修改增量对比配置信息', 'add:job:kafka:replication:increment-comparison:config', '', 2, '', 2, 82, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930107674660864, NULL, '【数据导入】查询任务实例列表', 'query:job:kafka:replication:instances', '', 2, '', 2, 83, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930107783712768, NULL, '【数据导入】查询任务实例详情', 'query:job:kafka:replication:instance', '', 2, '', 2, 84, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930107909541888, NULL, '【数据导入】根据实例ID停止任务', 'patch:job:kafka:replication:instance:stop', '', 2, '', 2, 85, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930107993427968, NULL, '【数据导入】根据实例ID重试任务', 'patch:job:kafka:replication:instance:retry', '', 2, '', 2, 86, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930108073119744, NULL, '【数据对比】查询任务详情', 'query:job:comparison', '', 2, '', 2, 87, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930108161200128, NULL, '【数据对比】查询任务列表', 'query:job:comparisons', '', 2, '', 2, 88, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930108257669120, NULL, '【数据对比】创建任务', 'add:job:comparison', '', 2, '', 2, 89, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930108358332416, NULL, '【数据对比】修改任务', 'put:job:comparison', '', 2, '', 2, 90, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930108454801408, NULL, '【数据对比】删除任务', 'delete:job:comparison', '', 2, '', 2, 91, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930108542881792, NULL, '【数据对比】执行任务', 'patch:job:comparison:exec', '', 2, '', 2, 92, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930108635156480, NULL, '【数据对比】停止任务', 'patch:job:comparison:stop', '', 2, '', 2, 93, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930108756791296, NULL, '【数据对比】查询比对任务的table-include-list', 'query:job:comparison:table-include-list', '', 2, '', 2, 94, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930108861648896, NULL, '【数据对比】查询比对任务实例列表', 'query:job:comparison:instances', '', 2, '', 2, 95, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930108979089408, NULL, '【数据对比】查询比对任务实例详情', 'query:job:comparison:instance', '', 2, '', 2, 96, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930109062975488, NULL, '【数据对比】比对结果概览', 'query:job:comparison:instance:state:detail', '', 2, '', 2, 97, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930109163638784, NULL, '【数据对比】比对差异详情', 'query:job:comparison:instance:data:results', '', 2, '', 2, 98, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930109255913472, NULL, '【数据对比】下载修复SQL文件', 'query:job:comparison:instance:data:sqls', '', 2, '', 2, 99, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930109436268544, NULL, '【数据对比】查询校验任务结果', 'query:job:comparison:instance:state', '', 2, '', 2, 101, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930109520154624, NULL, '【数据对比】根据实例ID停止比对任务', 'patch:job:comparison:instance:stop', '', 2, '', 2, 102, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930109625012224, NULL, '【数据对比】根据实例ID重试比对任务', 'patch:job:comparison:instance:retry', '', 2, '', 2, 103, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930109717286912, NULL, '【数据对比】查询执行修复SQL状态', 'query:job:comparison:instance:executeFixSqlStatus', '', 2, '', 2, 104, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930109792784384, NULL, '【数据对比】添加至执行会话', 'query:job:comparison:instance:executeFixSqlJoin', '', 2, '', 2, 105, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930109868281856, NULL, '【数据对比】退出执行会话', 'patch:job:comparison:instance:executeFixSqlExit', '', 2, '', 2, 106, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930109935390720, NULL, '【数据对比】执行修复SQL', 'patch:job:comparison:instance:executeFixSql', '', 2, '', 2, 107, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930110010888192, NULL, '【数据源】创建数据源', 'add:configuration:datasource', '', 2, '', 2, 108, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930110077997056, NULL, '【数据源】修改数据源', 'put:configuration:datasource', '', 2, '', 2, 109, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930110153494528, NULL, '【数据源】删除数据源', 'delete:configuration:datasource', '', 2, '', 2, 110, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930110237380608, NULL, '【数据源】查询数据源详情', 'query:configuration:datasource', '', 2, '', 2, 111, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930110333849600, NULL, '【数据源】查询数据源列表', 'query:configuration:datasources', '', 2, '', 2, 112, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930110430318592, NULL, '【数据源】连通性测试（无id）', 'patch:configuration:datasource:check', '', 2, '', 2, 113, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930110539370496, NULL, '【数据源】连通性检查（有id）', 'patch:configuration:datasource:id:check', '', 2, '', 2, 114, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930110635839488, NULL, '【数据源】状态信息', 'query:configuration:datasource:status-info', '', 2, '', 2, 115, 0, '2024-07-10 14:52:38', '2024-07-10 14:52:38');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930110757474304, NULL, '【数据源】schemas', 'query:configuration:datasource:schemas', '', 2, '', 2, 116, 0, '2024-07-10 14:52:39', '2024-07-10 14:52:39');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930110862331904, NULL, '【数据源】schemas’s object-types', 'query:configuration:datasource:object-types', '', 2, '', 2, 117, 0, '2024-07-10 14:52:39', '2024-07-10 14:52:39');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930110950412288, NULL, '【数据源】object-types', 'query:configuration:datasource:schema:objects', '', 2, '', 2, 118, 0, '2024-07-10 14:52:39', '2024-07-10 14:52:39');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930111055269888, NULL, '【数据源】查询对象列表（分页）', 'query:configuration:datasource:objects', '', 2, '', 2, 119, 0, '2024-07-10 14:52:39', '2024-07-10 14:52:39');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930111147544576, NULL, '【数据源】添加对象列表', 'add:configuration:datasource:objects', '', 2, '', 2, 120, 0, '2024-07-10 14:52:39', '2024-07-10 14:52:39');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930111248207872, NULL, '【数据源】查询对象列表（不分页）', 'add:configuration:datasource:all-objects', '', 2, '', 2, 121, 0, '2024-07-10 14:52:39', '2024-07-10 14:52:39');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930111353065472, NULL, '【数据源】查询snap列表（AWR）', 'query:configuration:datasource:snap-ids', '', 2, '', 2, 122, 0, '2024-07-10 14:52:39', '2024-07-10 14:52:39');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930111445340160, NULL, '【数据源】table''s tableInfo', 'query:configuration:datasource:tableInfo', '', 2, '', 2, 123, 0, '2024-07-10 14:52:39', '2024-07-10 14:52:39');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930111554392064, NULL, '【数据源】table''s partitions', 'query:configuration:datasource:partitions', '', 2, '', 2, 124, 0, '2024-07-10 14:52:39', '2024-07-10 14:52:39');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930111642472448, NULL, '【数据源】table''s indexInfos', 'query:configuration:datasource:indexInfos', '', 2, '', 2, 125, 0, '2024-07-10 14:52:39', '2024-07-10 14:52:39');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930111743135744, NULL, '【数据源】table''s columns', 'query:configuration:datasource:columns', '', 2, '', 2, 126, 0, '2024-07-10 14:52:39', '2024-07-10 14:52:39');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930111856381952, NULL, '【数据源】查询kafka下的topics', 'query:configuration:datasource:topics', '', 2, '', 2, 127, 0, '2024-07-10 14:52:39', '2024-07-10 14:52:39');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930111978016768, NULL, '【数据源】kafka信息概览', 'query:configuration:datasource:statistics', '', 2, '', 2, 128, 0, '2024-07-10 14:52:39', '2024-07-10 14:52:39');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930112066097152, NULL, '【数据源】kafka分析好的topics', 'query:configuration:datasource:statistics:topics', '', 2, '', 2, 129, 0, '2024-07-10 14:52:39', '2024-07-10 14:52:39');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930112179343360, NULL, '【数据源】查询kafka下某个topic统计信息', 'query:configuration:datasource:topic:statistics', '', 2, '', 2, 130, 0, '2024-07-10 14:52:39', '2024-07-10 14:52:39');
INSERT INTO chaos.sys_menu
(id, parent_id, name, code, url, `type`, menu_icon, permission_type, sort_num, deleted, created_time, updated_time)
VALUES(1810930112275812352, NULL, '【数据源】分析topic', 'patch:configuration:datasource:statistics:analyse', '', 2, '', 2, 131, 0, '2024-07-10 14:52:39', '2024-07-10 14:52:39');
-- 操作员菜单

insert into sys_role_menu (role_id,menu_id) select 1809041297164603392,sm.id from sys_menu sm where sm.permission_type = 2;


INSERT INTO chaos.sys_role
(id, name, `type`, description, deleted, created_time, updated_time)
VALUES(1810984998627577856, '只读', 1, '只能查询', 0, '2024-07-10 18:30:45', '2024-07-10 18:30:45');

insert into sys_role_menu (role_id,menu_id) select 1810984998627577856,sm.id from sys_menu sm where sm.type = 1 and sm.permission_type = 2;

insert into sys_role_menu (role_id,menu_id) select 1810984998627577856,sm.id from sys_menu sm where sm.type = 2 and sm.permission_type = 2 and code like 'query%';



