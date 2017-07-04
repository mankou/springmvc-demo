drop table m_request_log;
create table m_request_log(
       id number,
       request_date date,
       run_time_count number,
       request_method varchar2(32),
       request_ip varchar2(32),
       request_addr varchar2(512),
       class_Simple_Name varchar2(256),
       method varchar2(256),
       in_str varchar2(2048),
       out_code number(2),
       out_msg varchar2(2048),
       out_data varchar2(2048),
       return_type varchar2(32)
);

alter table m_request_log
  add constraint PK_m_request_log primary key (ID);

comment on table m_request_log is '请求日志表';
comment on column m_request_log.request_date is '请求时间';
comment on column m_request_log.request_ip is '请求IP';
comment on column m_request_log.class_Simple_Name is '简单类名';
comment on column m_request_log.method is '方法名';
comment on column m_request_log.in_str is '入参';
comment on column m_request_log.out_msg is '出参msg';
comment on column m_request_log.out_code is '出参状态码';
comment on column m_request_log.out_data is '出参返回数据';
comment on column m_request_log.return_type is '返回方式 0正常返回 1业务异常 2运行异常';
comment on column m_request_log.run_time_count is '运行时长(毫秒)';
comment on column m_request_log.request_addr is '请求地址';
comment on column m_request_log.request_method is '请求方法(GET POST)';


drop sequence s_m_request_log;
create sequence s_m_request_log
minvalue 1
maxvalue 999999999999999999999999999
start with 1
increment by 1
cache 20;


