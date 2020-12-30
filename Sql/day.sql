# 日期		昨晚入睡时间	今早醒来时间	今早起床时间	睡眠时长（小时）	睡眠质量	睡前回忆	今天值得记录的事情	熬夜原因
create table day_sleep_record
(
    id            bigint auto_increment primary key comment '自增主键',
    `date`        timestamp    not null default current_timestamp comment '日期',
    bed_time      timestamp    not null comment '上床时间',
    sleep_time    timestamp    not null comment '入睡时间',
    wake_time     timestamp    not null comment '醒来时间',
    up_time       timestamp    not null comment '起床时间',
    duration      int          not null default 0 comment '睡眠时长',
    sleep_quality int(1)       not null default 0 comment '睡眠质量',
    app_data      varchar(255) not null default '' comment 'auto_sleep_data',
    memory        varchar(255) not null default '' comment '睡前回忆',
    late_reason   varchar(255) not null default '' comment '熬夜原因',
    best_time     varchar(255) not null default '' comment '今日最佳',
    remark        varchar(255) not null default '' not null comment '备注信息',
    create_at     timestamp    not null default current_timestamp not null comment '创建时间',
    update_at     timestamp    not null default current_timestamp not null on update current_timestamp comment '更新时间',
    create_by     bigint       not null default 0 not null comment '创建ID',
    update_by     bigint       not null default 0 not null comment '更新ID'
) comment '睡眠记录表' auto_increment = 600;

create table day_meal_record
(
    id        bigint auto_increment primary key comment '自增主键',
    `date`    timestamp    not null default current_timestamp comment '日期',
    type      int          not null default 0 comment '类型',
    what      varchar(50)  not null default '' comment '吃什么',
    place     varchar(50)  not null default '' comment '在哪儿吃',
    cost      int          not null default 0 comment '花了多少',
    pay_type  int          not null default 0 comment '支付方式',
    remark    varchar(255) not null default '' not null comment '备注信息',
    create_at timestamp    not null default current_timestamp not null comment '创建时间',
    update_at timestamp    not null default current_timestamp not null on update current_timestamp comment '更新时间',
    create_by bigint       not null default 0 not null comment '创建ID',
    update_by bigint       not null default 0 not null comment '更新ID'
) comment '' auto_increment = 700;
