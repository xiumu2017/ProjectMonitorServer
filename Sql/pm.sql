# 创建项目表
create table if not exists pm_project
(
    id           bigint                                    not null auto_increment primary key comment '自增主键',
    project_name varchar(100)    default ''                not null comment '项目名称',
    service_url  varchar(200)    default ''                not null comment '监测地址',
    importance   int(1)          default 0                 not null comment '重要性（一星到三星）',
    username     varchar(50)     default ''                not null comment '用户名',
    password     varchar(100)    default ''                not null comment '密码',
    status_code  int(4) unsigned default 200               not null comment '状态码',
    status       int(2)          default 1                 not null comment '项目状态(1:可用 0:禁用)',
    type         varchar(20)     default ''                not null comment '项目类型',
    company_id   bigint          default 0                 not null comment '单位id',
    max_alert    int             default 1                 not null comment '最大通知限制',
    error_count  int             default 0                 null comment '异常数量',
    remark       varchar(100)    default ''                not null comment '备注',
    create_at    timestamp       default CURRENT_TIMESTAMP null comment '创建时间',
    update_at    timestamp       default CURRENT_TIMESTAMP null comment '更新时间',
    create_by    bigint          default 0                 not null comment '创建管理员ID',
    update_by    bigint          default 0                 not null comment '更新管理员ID'
)
    comment '项目监控项目表';

create index project_name
    on pm_project (project_name);

create table if not exists pm_server_ssh
(
    id             bigint                                 not null auto_increment primary key comment '自增主键',
    ip_addr        varchar(20)  default ''                not null comment '内网IP地址',
    ip_addr_public varchar(20)  default ''                not null comment '公网IP地址',
    domain_addr    varchar(50)  default ''                not null comment '域名地址',
    port           int(6)       default 22                not null comment '端口',
    user_name      char(20)     default 'root'            not null comment '登录用户名',
    password       char(50)     default 'root'            not null comment '登录密码',
    server_type    int(2)       default 0                 null comment '服务器类型[unknown(0):未知,
                                                                    ali_cloud(1):阿里云服务器,
                                                                    tx_cloud(2):腾讯云服务器,
                                                                    company_server(3):公司服务器,
                                                                    other(4):其它]',
    os             varchar(20)  default ''                not null comment '操作系统类型',
    os_version     varchar(50)  default ''                not null comment '操作系统版本',
    memory         int(3)       default 8                 not null comment '内存大小 G',
    enable         int(1)       default 1                 not null comment '是否启用',
    server_status  int(1)       default 1                 not null comment '服务器连接状态[fail(0):失败,ok(1):正常]',
    name           varchar(50)  default ''                not null comment '服务器名称',
    remark         varchar(200) default ''                not null comment '备注信息',
    create_at      timestamp    default current_timestamp not null comment '创建时间',
    update_at      timestamp    default current_timestamp not null on update current_timestamp comment '更新时间',
    create_by      bigint       default 0                 not null comment '创建管理员ID',
    update_by      bigint       default 0                 not null comment '更新管理员ID'
) comment '项目监控服务器信息表' auto_increment = 1000;

# 数据库信息表
create table if not exists pm_db
(
    id             bigint                                 not null auto_increment primary key comment '自增主键',
    type           char(20)     default 'MySQL'           not null comment '数据库类型',
    version        varchar(50)  default 'mysql8.0'        not null comment '数据库版本',
    ip_addr        char(20)     default ''                not null comment '内网IP地址',
    ip_addr_public char(20)     default ''                not null comment '公网IP地址',
    is_public      int(1)       default 0                 not null comment '是否开放外网',
    server_id      bigint       default 0                 not null comment 'SSH-Server ID',
    domain_addr    varchar(50)  default ''                not null comment '域名访问地址',
    port           int(5)       default 3306              not null comment '端口号',
    url            varchar(100) default ''                not null comment 'JDBC连接URL',
    user_name      char(20)     default 'root'            not null comment '登录名',
    password       char(20)     default 'root'            not null comment '密码',
    enable         int(1)       default 1                 not null comment '是否启用',
    remark         varchar(255) default ''                not null comment '备注',
    create_at      timestamp    default current_timestamp not null comment '创建时间',
    update_at      timestamp    default current_timestamp not null on update current_timestamp comment '更新时间',
    create_by      bigint       default 0                 not null comment '创建管理员ID',
    update_by      bigint       default 0                 not null comment '更新管理员ID'
)
    comment '项目监控数据库信息表' auto_increment = 5000;

create table if not exists pm_ding_talk_group
(
    id        bigint auto_increment primary key comment '自增主键',
    name      varchar(50)  default ''                not null comment '钉钉群组名称',
    enable    int(1)       default 1                 not null comment '是否启用',
    remark    varchar(255) default ''                not null comment '备注',
    create_at timestamp    default current_timestamp not null comment '创建时间',
    update_at timestamp    default current_timestamp not null on update current_timestamp comment '更新时间',
    create_by bigint       default 0                 not null comment '创建管理员ID',
    update_by bigint       default 0                 not null comment '更新管理员ID'
) comment '钉钉群组管理' auto_increment = 500;

create table if not exists pm_ding_talk_robot
(
    id        bigint auto_increment primary key comment '自增主键',
    group_id  bigint       default 0                 not null comment '钉钉群组ID',
    name      varchar(50)  default ''                not null comment '钉钉群组机器人名称',
    type      varchar(50)  default ''                not null comment '钉钉群组机器人类别',
    token     varchar(100) default ''                not null comment 'Token',
    secret    varchar(100) default ''                not null comment 'Secret',
    web_hook  varchar(255) default ''                not null comment 'web-Hook地址',
    enable    int(1)       default 1                 not null comment '是否启用',
    remark    varchar(255) default ''                not null comment '备注',
    create_at timestamp    default current_timestamp not null comment '创建时间',
    update_at timestamp    default current_timestamp not null on update current_timestamp comment '更新时间',
    create_by bigint       default 0                 not null comment '创建管理员ID',
    update_by bigint       default 0                 not null comment '更新管理员ID'
) comment '钉钉群组管理' auto_increment = 2500;