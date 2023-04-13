CREATE TABLE form (
  id int(11) NOT NULL PRIMARY KEY AUTO_INCREMENT COMMENT 'ID',
  name varchar(255) NOT NULL DEFAULT '' COMMENT '名前',
  age int(11) NOT NULL DEFAULT 0 COMMENT '年齢',
  prefecture varchar(255) NOT NULL DEFAULT '' COMMENT '都道府県',
  address1 varchar(255) NOT NULL DEFAULT '' COMMENT '市区町村',
  address2 varchar(255) NOT NULL DEFAULT '' COMMENT '番地',
  comment varchar(255) NOT NULL DEFAULT '' COMMENT 'コメント',
  created_at datetime NOT NULL DEFAULT current_timestamp() COMMENT '登録日',
  updated_at datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp() COMMENT '更新日'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='フォーム';