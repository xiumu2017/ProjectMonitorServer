create table if not exists ums_admin
(
    id         bigint auto_increment primary key comment '自增主键',
    username   varchar(64)  default ''                not null comment '用户名',
    password   varchar(64)  default ''                not null comment '密码',
    icon       varchar(255) default ''                not null comment '头像',
    email      varchar(50)  default ''                not null comment '邮箱',
    nick_name  varchar(20)  default ''                not null comment '昵称',
    real_name  varchar(20)  default ''                not null comment '真实姓名',
    phone      varchar(20)  default ''                not null comment '手机号码',
    remark     varchar(255) default ''                not null comment '备注信息',
    login_time datetime     default current_timestamp not null comment '最后登录时间',
    status     int(2)       default 1                 null comment '帐号启用状态：0->禁用；1->启用',
    enable     int(1)       default 1                 not null comment '是否启用',
    create_at  timestamp    default current_timestamp not null comment '创建时间',
    update_at  timestamp    default current_timestamp not null on update current_timestamp comment '更新时间',
    create_by  bigint       default 0                 not null comment '创建管理员ID',
    update_by  bigint       default 0                 not null comment '更新管理员ID'
)
    comment '后台用户表';

create table if not exists ums_admin_login_log
(
    id           bigint auto_increment primary key comment '自增主键',
    admin_id     bigint       default 0                 not null comment '管理员ID',
    login_time   datetime     default current_timestamp not null comment '登录时间',
    ip_addr      varchar(20)  default ''                not null comment 'IP地址',
    user_agent   varchar(100) default ''                not null comment '浏览器类型',
    login_status int(1)       default 1                 not null comment '登录结果[success(1),fail(0)]',
    fail_reason  char(15)     default ''                not null comment '登录失败原因'
)
    comment '后台用户登录日志表' charset = utf8;

create table if not exists ums_admin_permission_relation
(
    id            bigint auto_increment primary key comment '自增主键',
    admin_id      bigint not null comment '管理员ID',
    permission_id bigint not null comment '权限ID',
    type          int    not null comment '类型[include(1):包含权限,exclude(0):去除权限]'
)
    comment '后台用户额外权限关系表';

create table if not exists ums_admin_role_relation
(
    id       bigint auto_increment primary key comment '自增主键',
    admin_id bigint not null comment '管理员ID',
    role_id  bigint not null comment '角色ID'
)
    comment '后台用户和角色关系表';

create table if not exists ums_menu
(
    id        bigint auto_increment primary key,
    parent_id bigint       default 0                 not null comment '父级ID',
    title     varchar(100) default ''                not null comment '菜单名称',
    level     int(2)       default 1                 not null comment '菜单级数',
    sort      int          default 0                 not null comment '菜单排序',
    name      varchar(100) default ''                not null comment '前端名称',
    icon      varchar(200) default ''                not null comment '前端图标',
    hidden    int(1)       default 0                 not null comment '是否隐藏',
    create_at timestamp    default current_timestamp not null comment '创建时间',
    update_at timestamp    default current_timestamp not null on update current_timestamp comment '更新时间',
    create_by bigint       default 0                 not null comment '创建管理员ID',
    update_by bigint       default 0                 not null comment '更新管理员ID'
)
    comment '后台菜单表' auto_increment = 100;

create table if not exists ums_permission
(
    id     bigint auto_increment primary key comment '自增主键',
    pid    bigint       default 0  not null comment '父级权限id',
    name   varchar(100) default '' not null comment '名称',
    value  varchar(200) default '' not null comment '权限值',
    icon   varchar(500) default '' not null comment '图标',
    type   int(1)       default 0  not null comment '权限类型：0->目录；1->菜单；2->按钮（接口绑定权限）',
    uri    varchar(200) default '' not null comment '前端资源路径',
    enable int(1)       default 1  not null comment '启用状态；0->禁用；1->启用',
    sort   int          default 0  not null comment '排序'
)
    comment '后台用户权限表' auto_increment = 500;


create table if not exists ums_resource
(
    id          bigint auto_increment primary key comment '自增主键',
    name        varchar(200) default ''                not null comment '资源名称',
    url         varchar(200) default ''                not null comment '资源URL',
    description varchar(500) default ''                not null comment '描述',
    category_id bigint       default 0                 not null comment '资源分类ID',
    enable      int(1)       default 1                 not null comment '启用禁用',
    create_at   timestamp    default current_timestamp not null comment '创建时间',
    update_at   timestamp    default current_timestamp not null on update current_timestamp comment '更新时间',
    create_by   bigint       default 0                 not null comment '创建管理员ID',
    update_by   bigint       default 0                 not null comment '更新管理员ID'
)
    comment '后台资源表' auto_increment = 200;


create table ums_resource_category
(
    id        bigint auto_increment primary key comment '自增主键',
    name      varchar(200)                        not null comment '分类名称',
    sort      int                                 not null comment '排序',
    enable    int(1)    default 1                 not null comment '启用禁用',
    create_at timestamp default current_timestamp not null comment '创建时间',
    update_at timestamp default current_timestamp not null on update current_timestamp comment '更新时间',
    create_by bigint    default 0                 not null comment '创建管理员ID',
    update_by bigint    default 0                 not null comment '更新管理员ID'
)
    comment '资源分类表' auto_increment = 50;

create table ums_role
(
    id          bigint auto_increment primary key comment '自增主键',
    name        varchar(20)  default ''                not null comment '名称',
    description varchar(255) default ''                not null comment '描述',
    sort        int          default 0                 not null,
    enable      int(1)       default 1                 not null comment '启用禁用',
    create_at   timestamp    default current_timestamp not null comment '创建时间',
    update_at   timestamp    default current_timestamp not null on update current_timestamp comment '更新时间',
    create_by   bigint       default 0                 not null comment '创建管理员ID',
    update_by   bigint       default 0                 not null comment '更新管理员ID'
)
    comment '后台用户角色表' auto_increment = 100;

create table ums_role_menu_relation
(
    id      bigint auto_increment primary key comment '自增主键',
    role_id bigint not null comment '角色ID',
    menu_id bigint not null comment '菜单ID'
)
    comment '后台角色菜单关系表' auto_increment = 150;


create table ums_role_resource_relation
(
    id          bigint auto_increment primary key comment '自增主键',
    role_id     bigint not null comment '角色ID',
    resource_id bigint not null comment '资源ID'
)
    comment '后台角色资源关系表' auto_increment = 200;



create table ums_role_permission_relation
(
    id            bigint auto_increment primary key comment '自增主键',
    role_id       bigint not null comment '角色ID',
    permission_id bigint not null comment '权限ID'
)
    comment '后台用户角色权限关系表' auto_increment = 250;




