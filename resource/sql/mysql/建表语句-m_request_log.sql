-- m_request_log
DROP TABLE IF EXISTS m_request_log;
CREATE TABLE m_request_log(
       id VARCHAR(32) ,
       request_date DATETIME COMMENT  '请求时间',
       run_time_count BIGINT COMMENT '请求IP',
       request_method VARCHAR(32) COMMENT '简单类名',
       request_ip VARCHAR(32) COMMENT '方法名',
       request_addr VARCHAR(2048) COMMENT '请求地址',
       class_Simple_Name VARCHAR(256) COMMENT '简单类名',
       method VARCHAR(256) COMMENT '方法名',
       in_str VARCHAR(2048) COMMENT '入参',
       out_code DECIMAL COMMENT '出参状态码',
       out_msg VARCHAR(2048) COMMENT '出参msg',
       out_data VARCHAR(2048) COMMENT '出参返回数据',
       program_version VARCHAR(256) COMMENT '程序版本',
       return_type VARCHAR(32) COMMENT '返回方式 0正常返回 1业务异常 2运行异常'
)DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci  COMMENT='请求日志';

ALTER TABLE m_request_log
  ADD CONSTRAINT PK_m_request_log PRIMARY KEY (ID);


-- t_user
DROP TABLE IF EXISTS t_user;
CREATE TABLE t_user(
       id BIGINT,
       CODE VARCHAR(32),
       NAME VARCHAR(32),
       PRIMARY KEY(id)
);

INSERT INTO t_user(id,CODE,NAME) VALUES(-1,'1code','1name');
INSERT INTO t_user(id,CODE,NAME) VALUES(-2,'2code','2name');

COMMIT;


