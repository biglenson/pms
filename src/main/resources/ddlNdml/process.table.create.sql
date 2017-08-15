CREATE TABLE d_attachments (attachID int(11) NOT NULL AUTO_INCREMENT, fileCount int(11), PRIMARY KEY (attachID));
CREATE TABLE d_benefit_eval (evalID int(11) NOT NULL AUTO_INCREMENT, tplID int(11) NOT NULL, processID varchar(50) UNIQUE, evalCode varchar(50) NOT NULL, evalTitle varchar(255) NOT NULL, creator varchar(50) NOT NULL, createDate datetime NOT NULL,  hasDept int NOT NULL, evalAttach int(11), PRIMARY KEY (evalID));
CREATE TABLE d_benefit_eval_item (itemID int(11) NOT NULL AUTO_INCREMENT, evalID int(11) NOT NULL, tplItemID int(11) NOT NULL, evalValue varchar(255) NOT NULL, evalNote varchar(255), PRIMARY KEY (itemID));
CREATE TABLE d_upload_file (upFileID int(11) NOT NULL AUTO_INCREMENT comment '上传文件ID：物理主键', attachID int(11) NOT NULL comment '附件ID：外键，指向附件表。', upFileCode varchar(50) comment '上传文件编码：逻辑主键：保留字段', upFileOriginName varchar(255) comment '上传文件原始名称', upFileSavedName varchar(255) comment '上传文件存储名称', uploadTime datetime NULL comment '上传时间', commitTime datetime NOT NULL comment '提交时间', uploadStatus int(11) comment '上传状态：1-上传、2-删除、3-提交', PRIMARY KEY (upFileID)) comment='上传附件表。';
CREATE TABLE g_benefit_eval_tpl (tplID int(11) NOT NULL AUTO_INCREMENT, tplTitle varchar(255) NOT NULL, evalPhase int(11) NOT NULL, evalFor int(11) NOT NULL, createTime datetime NOT NULL, listOrder int(11) NOT NULL, version varchar(50), templateDesc varchar(255), PRIMARY KEY (tplID));
CREATE TABLE g_benefit_eval_tpl_item (tplItemID int(11) NOT NULL AUTO_INCREMENT, tplID int(11) NOT NULL, evalDimension varchar(50) NOT NULL, evalItem varchar(50) NOT NULL, evalDesc varchar(255) NOT NULL, refValue varchar(255) NOT NULL, listOrder int(11) NOT NULL, PRIMARY KEY (tplItemID));
ALTER TABLE d_upload_file ADD INDEX FKd_upload_f913595 (attachID), ADD CONSTRAINT FKd_upload_f913595 FOREIGN KEY (attachID) REFERENCES d_attachments (attachID);
ALTER TABLE d_benefit_eval ADD INDEX FKd_benefit_962661 (evalAttach), ADD CONSTRAINT FKd_benefit_962661 FOREIGN KEY (evalAttach) REFERENCES d_attachments (attachID);
ALTER TABLE g_benefit_eval_tpl_item ADD INDEX FKg_benefit_942785 (tplID), ADD CONSTRAINT FKg_benefit_942785 FOREIGN KEY (tplID) REFERENCES g_benefit_eval_tpl (tplID);
ALTER TABLE d_benefit_eval_item ADD INDEX FKd_benefit_707337 (evalID), ADD CONSTRAINT FKd_benefit_707337 FOREIGN KEY (evalID) REFERENCES d_benefit_eval (evalID);
ALTER TABLE d_benefit_eval_item ADD INDEX FKd_benefit_301159 (tplItemID), ADD CONSTRAINT FKd_benefit_301159 FOREIGN KEY (tplItemID) REFERENCES g_benefit_eval_tpl_item (tplItemID);
ALTER TABLE d_benefit_eval ADD INDEX FKd_benefit_664992 (tplID), ADD CONSTRAINT FKd_benefit_664992 FOREIGN KEY (tplID) REFERENCES g_benefit_eval_tpl (tplID);

CREATE TABLE d_eval_code_gen (evalID int(11) NOT NULL AUTO_INCREMENT, codeType varchar(50), deptShortName varchar(50), yearMonth varchar(50), currValue int(11), PRIMARY KEY (evalID));

