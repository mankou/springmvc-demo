drop table m_request_log;
create table m_request_log(
       id varchar2(32),
       request_date date,
       run_time_count number,
       request_method varchar2(32),
       request_ip varchar2(32),
       request_addr varchar2(2048),
       class_Simple_Name varchar2(256),
       method varchar2(256),
       in_str varchar2(2048),
       out_code number,
       out_msg varchar2(2048),
       out_data varchar2(2048),
       program_version varchar2(256),
       return_type varchar2(32)
);

alter table m_request_log
  add constraint PK_m_request_log primary key (ID);

comment on table m_request_log is '������־��';
comment on column m_request_log.request_date is '����ʱ��';
comment on column m_request_log.request_ip is '����IP';
comment on column m_request_log.class_Simple_Name is '������';
comment on column m_request_log.method is '������';
comment on column m_request_log.in_str is '���';
comment on column m_request_log.out_msg is '����msg';
comment on column m_request_log.out_code is '����״̬��';
comment on column m_request_log.out_data is '���η�������';
comment on column m_request_log.return_type is '���ط�ʽ 0�������� 1ҵ���쳣 2�����쳣';
comment on column m_request_log.run_time_count is '����ʱ��(����)';
comment on column m_request_log.request_addr is '�����ַ';
comment on column m_request_log.request_method is '���󷽷�(GET POST)';
comment on column m_request_log.program_version is '����汾';

--drop sequence s_m_request_log;
--create sequence s_m_request_log
--minvalue 1
--maxvalue 999999999999999999999999999
--start with 1
--increment by 1
--cache 20;




drop table t_user;
create table t_user(
       id number,
       code varchar2(32),
       name varchar2(32),
       primary key(id)
);

insert into t_user(id,code,name) values(-1,'1code','1name');
insert into t_user(id,code,name) values(-2,'2code','2name');

commit;

