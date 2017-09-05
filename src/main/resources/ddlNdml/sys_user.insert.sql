insert into sys_user (login_name, name, password, salt, sex, age, phone, user_type, status, department_code, create_time)
select 'lenson' login_name, 'lenson' name, password, salt, sex, age, phone, user_type, status, department_code, sysdate()    
  from sys_user where id=1;

insert into sys_user (login_name, name, password, salt, sex, age, phone, user_type, status, department_code, create_time)
select 'xiaolan' login_name, 'xiaolan' name, password, salt, sex, age, phone, user_type, status, department_code, sysdate()    
  from sys_user where id=1;

insert into sys_user (login_name, name, password, salt, sex, age, phone, user_type, status, department_code, create_time)
select 'apple' login_name, 'apple' name, password, salt, sex, age, phone, user_type, status, department_code, sysdate()    
  from sys_user where id=1;

insert into sys_user (login_name, name, password, salt, sex, age, phone, user_type, status, department_code, create_time)
select 'green' login_name, 'green' name, password, salt, sex, age, phone, user_type, status, department_code, sysdate()    
  from sys_user where id=1;

insert into sys_user (login_name, name, password, salt, sex, age, phone, user_type, status, department_code, create_time)
select 'pink' login_name, 'pink' name, password, salt, sex, age, phone, user_type, status, department_code, sysdate()    
  from sys_user where id=1;

insert into sys_user (login_name, name, password, salt, sex, age, phone, user_type, status, department_code, create_time)
select 'chenda' login_name, 'chenda' name, password, salt, sex, age, phone, user_type, status, department_code, sysdate()    
  from sys_user where id=1;

insert into sys_user (login_name, name, password, salt, sex, age, phone, user_type, status, department_code, create_time)
select 'haoll' login_name, 'haoll' name, password, salt, sex, age, phone, user_type, status, department_code, sysdate()    
  from sys_user where id=1;

insert into sys_user (login_name, name, password, salt, sex, age, phone, user_type, status, department_code, create_time)
select 'guohw' login_name, 'guohw' name, password, salt, sex, age, phone, user_type, status, department_code, sysdate()    
  from sys_user where id=1;

insert into sys_user (login_name, name, password, salt, sex, age, phone, user_type, status, department_code, create_time)
select 'zhaoxp' login_name, 'zhaoxp' name, password, salt, sex, age, phone, user_type, status, department_code, sysdate()    
  from sys_user where id=1;

insert into sys_user (login_name, name, password, salt, sex, age, phone, user_type, status, department_code, create_time)
select 'guochong' login_name, 'guochong' name, password, salt, sex, age, phone, user_type, status, department_code, sysdate()    
  from sys_user where id=1;

insert into sys_user (login_name, name, password, salt, sex, age, phone, user_type, status, department_code, create_time)
select 'zhaochun' login_name, 'zhaochun' name, password, salt, sex, age, phone, user_type, status, department_code, sysdate()    
  from sys_user where id=1;

insert into sys_user_sys_role (users_id, roles_id) select a.id, b.id from sys_user a, sys_role b where a.id <> 1

insert into sys_role(name, description) values("BenefitEvalProcess", "效益评估流程参与者");

insert into sys_user_sys_role (users_id, roles_id) select a.id, b.id from sys_user a, sys_role b where a.id>1 and b.name = 'BenefitEvalProcess';

update sys_user set department_code = 5 where id between 6 and 8;
update sys_user set department_code = 3 where id between 9 and 12;
