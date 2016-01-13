/**
 * 乐活黄海项目数据库
 * 数据库名称：lhhh
 * 服务器类型：MySql
 */
 
use lhhh;

-- 123456 MD5 加密为 0adc3949ba59abbe56e057f20f883e

-- 发票上传待审核表（fpsc）
-- userid 用户id，shmc 商户名称，lxdh 联系电话,xfje 消费金额，fpdm 发票代码,fphm 发票号码,zplj 照片链接,shzt 审核状态,jf 积分,shrq 审核日期
-- 审核状态 n 未审核,y 审核通过,f 审核未通过
create table fpsc(
	fpscid int  not null auto_increment,
	userid char(13) not null,
	shmc varchar(50),
	lxdh char(13) not null,
	xfje varchar(20),
	fpdm char(12),
	fphm char(8),
	zplj varchar(200),
	shzt char(2) default 'n',
	jf int default 0,
	shrq date,
	primary key (fpscid)
);

-- 兑换记录表（dhjl）
-- sjhm 手机号码,lpbh 礼品编号,dhsl 兑换数量,kcjf 扣除积分,fhdz 发货地址,fhzt 发货状态,dhrq 兑换日期
create table dhjl(
	dhjlid int not null auto_increment,
	userid char(13) not null,
	sjhm char(13),
	lpbh char(10) not null,
	dhsl int not null,
	kcjf int default 0,
	fhdz varchar(100),
	fhzt char(2) default 'n',
	dhrq date,
	primary key (dhjlid)
); 


-- 礼品表（lp）
-- lpbh 礼品编号,lpmc 礼品名称,lpdj 礼品单价（积分）,lpzs 礼品总数,kcsl 库存数量，zplj 照片链接
create table lp(
	lpbh char(10) not null,
	lpmc varchar(50),
	lpdj int,
	lpzs int,
	kcsl int,
	zplj varchar(200),
	primary key (lpbh)
);

-- 个人信息表（grxx）
-- id 手机号码,mm 密码，nc 昵称,jfye 积分余额
create table grxx(
	id char(13) not null primary key,
	mm varchar(100),
	nc varchar(20),
	jfye int default 0
);

-- 管理员表（gly）
-- glyid 管理员id，glyyhm 管理员用户名，glymm 管理员密码
create table gly(
	glyid int not null primary key auto_increment,
	glyyhm varchar(20) not null unique,
	glymm varchar(50) not null
);

-- Key-Value表（存小数据）
create table kv(
	kvid int not null primary key auto_increment,
	kvkey varchar(100) not null unique,
	kvvalue varchar(2000)
);

-- 视图mydhjl
CREATE VIEW mydhjl AS
SELECT dhjl.dhjlid,dhjl.userid,dhjl.dhsl,dhjl.dhrq,dhjl.fhzt, lp.lpbh,lp.lpmc,lp.lpdj 
from dhjl,lp
where dhjl.lpbh = lp.lpbh;

-- 添加注册时间记录
ALTER TABLE `grxx` 
	ADD COLUMN `zcsj` datetime NULL AFTER `jfye`;
	
-- 
