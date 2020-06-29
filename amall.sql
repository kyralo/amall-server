-- 用户(User)
CREATE TABLE `tb_user` (
    `id` CHAR(32) NOT NULL DEFAULT REPLACE(UUID(),"-","") COMMENT '用户ID',
    `name` VARCHAR(45) NOT NULL COMMENT '用户名',
    `mail` VARCHAR(255) NOT NULL COMMENT '用户邮箱',
    `password` VARCHAR(255) NOT NULL COMMENT '用户密码',
    `telephone` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '用户电话',
    `sex` TINYINT(3) NOT NULL DEFAULT '2' COMMENT '0表示男, 1表示女, 2表示未知',
    `avatar_url` VARCHAR(255) NOT NULL DEFAULT '/avatar/boy.jpg' COMMENT '用户头像 (默认路径 “/avatar/boy.jpg”)',
    `is_vip` TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否为vip,0表示是,1表示不是, 默认为0',
    `is_banned` TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否被封禁,0表示未被封禁,1表示被封禁, 默认为0',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY `pk_tb_user_id` (`id`),
    UNIQUE KEY `uk_tb_user_name` (`name`),
    UNIQUE KEY `uk_tb_user_mail` (`mail`),
    UNIQUE KEY `uk_tb_user_telephone` (`telephone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户';

-- 第三方账户
CREATE TABLE `account_platform` (
    `id` CHAR(32) NOT NULL DEFAULT REPLACE(UUID(),"-","") COMMENT '自增id',
    `uid` CHAR(32) NOT NULL DEFAULT '' COMMENT '账号id',
    `platform_id` VARCHAR(60) NOT NULL DEFAULT '' COMMENT '平台id',
    `platform_token` VARCHAR(60) NOT NULL DEFAULT '' COMMENT '平台access_token',
    `type` TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '平台类型 0:未知,1:facebook,2:google,3:wechat,4:qq,5:weibo,6:twitter',
    `nickname` VARCHAR(60) NOT NULL DEFAULT '' COMMENT '昵称',
    `avatar` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '头像',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY `pk_account_platform_id` (`id`),
    KEY `idx_account_platform_uid` (`uid`) USING BTREE,
    KEY `idx_account_platform_platform_id` (`platform_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4mb4 COMMENT='第三方用户信息';

-- 用户地址(User Address)
CREATE TABLE `tb_user_address` (
    `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT COMMENT '用户地址ID',
    `user_id` CHAR(32) NOT NULL COMMENT '用户ID',
    `location` VARCHAR(255) NOT NULL COMMENT '用户地址',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY `pk_tb_user_address_id` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='用户地址';

-- 用户收藏(User Collection)


-- 用户订单(User Order)


-- 商家(Merchant)
CREATE TABLE `tb_merchant` (
  `id` CHAR(32) NOT NULL DEFAULT REPLACE(UUID(),"-","") COMMENT '商家ID',
  `name` VARCHAR(45) NOT NULL COMMENT '商家用户名',
  `mail` VARCHAR(255) NOT NULL COMMENT '商家邮箱',
  `password` VARCHAR(255) NOT NULL COMMENT '商家密码',
  `store_name` VARCHAR(255) NOT NULL DEFAULT '' COMMENT '商家店名',
  `telephone` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '商家负责人电话',
  `info` VARCHAR(255) NOT NULL COMMENT '商家业务经营说明',
  `address` VARCHAR(255) NOT NULL COMMENT '商家地址',
  `sex` TINYINT(3) NOT NULL DEFAULT '2' COMMENT '0表示男, 1表示女, 2表示未知',
  `avatar_url` VARCHAR(255) NOT NULL DEFAULT '/avatar/boy.jpg' COMMENT '管理员头像 (默认路径 “/avatar/boy.jpg”)',
  `is_delete` TINYINT(3) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否被封禁,0表示未封禁,1表示已经封禁',
  `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY `pk_tb_merchant_id` (`id`),
  UNIQUE KEY `uk_tb_merchant_name` (`name`),
  UNIQUE KEY `uk_tb_merchant_mail` (`mail`),
  UNIQUE KEY `uk_tb_merchant_telephone` (`telephone`),
  KEY `idx_tb_merchant_store_name` (`store_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商家';

-- 商品(Commodity) 关键属性(SPU) [SKU使用mongodb解决]
-- spu表 commodity_spu
-- spu: standard product unit 标准产品单位
CREATE TABLE `commodity_spu` (
    `id` CHAR(32) NOT NULL DEFAULT REPLACE(UUID(),"-","") COMMENT 'SPU ID',
    `brand_id` int(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '品牌ID',
    `category_id` int(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '分类ID',
    `name` varchar(255) UNSIGNED NOT NULL DEFAULT '' COMMENT 'spu名称',
    `desc` varchar(255) UNSIGNED NOT NULL DEFAULT '' COMMENT 'spu描述',
    `selling_point` varchar(255) UNSIGNED NOT NULL DEFAULT '' COMMENT '卖点',
    `unit` varchar(255) UNSIGNED NOT NULL DEFAULT '' COMMENT 'spu单位',
    `banner_url` text COMMENT 'banner图片 多个图片逗号分隔',
    `main_url` text COMMENT '商品介绍主图 多个图片逗号分隔',
    `price_fee` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '售价，整数方式保存',
    `price_scale` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '售价，金额对应的小数位数',
    `market_price_fee` int UNSIGNED NOT NULL DEFAULT 0 COMMENT '市场价，整数方式保存',
    `market_price_scale` tinyint UNSIGNED NOT NULL DEFAULT 0 COMMENT '市场价，金额对应的小数位数',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `create_by` int(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '创建人staff_id',
    `update_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    `update_by` int(11) UNSIGNED NOT NULL DEFAULT '0' COMMENT '修改人staff_id',
    `status` tinyint(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '状态 1:enable, 0:disable, -1:deleted',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品spu表';


-- 商品评价(Commodity Comment)


-- 管理员(Admin)
CREATE TABLE `tb_admin` (
  `id` CHAR(32) NOT NULL DEFAULT REPLACE(UUID(),"-","") COMMENT '管理员ID',
  `name` VARCHAR(45) NOT NULL COMMENT '管理员用户名',
  `mail` VARCHAR(255) DEFAULT '' COMMENT '管理员邮箱',
  `password` VARCHAR(255) NOT NULL COMMENT '管理员密码',
  `telephone` VARCHAR(32) NOT NULL DEFAULT '' COMMENT '管理员电话',
  `sex` TINYINT(3) NOT NULL DEFAULT '2' COMMENT '0表示男, 1表示女, 2表示未知',
  `avatar_url` VARCHAR(255) NOT NULL DEFAULT '/avatar/boy.jpg' COMMENT '管理员头像 (默认路径 “/avatar/boy.jpg”)',
  `super_key` TINYINT(3) UNSIGNED NOT NULL DEFAULT '0' COMMENT '超级管理员标识 (0,普通管理员  1,超级管理员)',
  `is_delete` TINYINT(3) UNSIGNED NOT NULL DEFAULT '0' COMMENT '是否删除,0表示未删除,1表示已经删除',
  `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY `pk_tb_admin_id` (`id`),
  UNIQUE KEY `uk_tb_admin_name` (`name`),
  UNIQUE KEY `uk_tb_admin_mail` (`mail`),
  UNIQUE KEY `uk_tb_admin_telephone` (`telephone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='管理员';

-- 商品类型(Commodity Type)
CREATE TABLE `tb_commodity_type` (
    `id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '商品类型ID',
    `parent_type_id`  INT(10) DEFAULT '-1' COMMENT '父级商品类型ID 默认为 -1 表示当前商品类型无父类型',
    `name` VARCHAR(45) NOT NULL COMMENT '商品类型 名称',
    `info` VARCHAR(255) NOT NULL COMMENT '商品类型 类型说明',
    `pic_url` VARCHAR(255) NOT NULL COMMENT '商品类型 图标',
    `is_primary` TINYINT(1) NULL DEFAULT '0' COMMENT '0表示一级类型, 1表示其他类型(二级类型), 默认为0',
    `status` TINYINT(1) UNSIGNED NOT NULL DEFAULT '0' COMMENT '状态 1:ENABLE, 0:DISABLE, -1:DELETED',
    `create_time` DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `update_time` TIMESTAMP NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
    PRIMARY KEY `pk_tb_commodity_type_id` (`id`),
    UNIQUE KEY `uk_tb_commodity_type_name` (`name`)
) ENGINE=INNODB DEFAULT CHARSET=utf8mb4 COMMENT='商品类型';


-- 活动(Activity)