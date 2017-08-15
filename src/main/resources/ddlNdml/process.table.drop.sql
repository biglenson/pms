ALTER TABLE d_upload_file DROP FOREIGN KEY FKd_upload_f913595;
ALTER TABLE d_benefit_eval DROP FOREIGN KEY FKd_benefit_962661;
ALTER TABLE g_benefit_eval_tpl_item DROP FOREIGN KEY FKg_benefit_942785;
ALTER TABLE d_benefit_eval_item DROP FOREIGN KEY FKd_benefit_707337;
ALTER TABLE d_benefit_eval_item DROP FOREIGN KEY FKd_benefit_301159;
ALTER TABLE d_benefit_eval DROP FOREIGN KEY FKd_benefit_664992;
DROP TABLE IF EXISTS d_attachments;
DROP TABLE IF EXISTS d_benefit_eval;
DROP TABLE IF EXISTS d_benefit_eval_item;
DROP TABLE IF EXISTS d_upload_file;
DROP TABLE IF EXISTS g_benefit_eval_tpl;
DROP TABLE IF EXISTS g_benefit_eval_tpl_item;
DROP TABLE IF EXISTS d__eval_code_gen;

