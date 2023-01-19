
create table `user` (
                        `id` bigint(20) PRIMARY KEY not null comment '自增主键id',
                        `user_name` varchar(100) not null comment '用户姓名',
                        `age` int(3) default 0 comment '年龄',
                        `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
                        `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

                        key `idx_userName` (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户表';