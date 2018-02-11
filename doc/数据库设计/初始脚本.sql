CREATE DATABASE gznb_open_plateform CHARACTER SET utf8;

USE gznb_open_plateform;

INSERT INTO system_dic  (dic_type,dic_type_name,dic_code,dic_name,dic_value,dic_status,note)
VALUES
   ('system_data_status','系统数据状态','system_data_status_normal','正常',1,1,'初始数据'),
   ('system_data_status','系统数据状态','system_data_status_disable','禁用',2,1,'初始数据'),
   ('system_data_status','系统数据状态','system_data_status_delete','删除',3,1,'初始数据');

INSERT INTO system_dic  (dic_type,dic_type_name,dic_code,dic_name,dic_value,dic_status,note)
VALUES
   ('interface_request_mode','接口请求方式','interface_request_mode_get','GET',1,1,'初始数据'),
   ('interface_request_mode','接口请求方式','interface_request_mode_post','POST',2,1,'初始数据'),
   ('interface_request_mode','接口请求方式','interface_request_mode_put','PUT',3,1,'初始数据'),
   ('interface_request_mode','接口请求方式','interface_request_mode_delete','DELETE',4,1,'初始数据');

INSERT INTO system_dic  (dic_type,dic_type_name,dic_code,dic_name,dic_value,dic_status,note)
VALUES
   ('interface_param_type','接口参数类型','interface_param_type_int','int',1,1,'初始数据'),
   ('interface_param_type','接口参数类型','interface_param_type_long','long',2,1,'初始数据'),
   ('interface_param_type','接口参数类型','interface_param_type_string','String',3,1,'初始数据'),
   ('interface_param_type','接口参数类型','interface_param_type_object','object',4,1,'初始数据');

INSERT INTO system_dic  (dic_type,dic_type_name,dic_code,dic_name,dic_value,dic_status,note)
VALUES
   ('interface_resp_type','接口返回类型','interface_resp_type_void','void',1,1,'初始数据'),
   ('interface_resp_type','接口返回类型','interface_resp_type_json','json',2,1,'初始数据'),
   ('interface_resp_type','接口返回类型','interface_resp_type_string','String',3,1,'初始数据');

INSERT INTO system_dic  (dic_type,dic_type_name,dic_code,dic_name,dic_value,dic_status,note)
VALUES
   ('interface_param_format','接口参数格式','interface_param_format_form','Form',1,1,'初始数据'),
   ('interface_param_format','接口参数格式','interface_param_format_json','Json',2,1,'初始数据');

INSERT INTO system_dic  (dic_type,dic_type_name,dic_code,dic_name,dic_value,dic_status,note)
VALUES
   ('system_user_type','系统用户类型','system_user_type_administrator','超级管理员',1,1,'初始数据'),
   ('system_user_type','系统用户类型','system_user_type_integration','集成系统平台用户',2,1,'初始数据'),
   ('system_user_type','系统用户类型','system_user_type_business','业务系统平台管理用户',3,1,'初始数据'),
   ('system_user_type','系统用户类型','system_user_type_business','业务系统平台普通用户',4,1,'初始数据');

INSERT INTO system_dic  (dic_type,dic_type_name,dic_code,dic_name,dic_value,dic_status,note)
VALUES
   ('system_apply_status','业务系统接入申请状态','system_apply_status_init','初始申请状态',1,1,'初始数据'),
   ('system_apply_status','业务系统接入申请状态','system_apply_status_auditing','审核中',2,1,'初始数据'),
   ('system_apply_status','业务系统接入申请状态','system_apply_status_complete','审核完成',3,1,'初始数据');

INSERT INTO system_dic  (dic_type,dic_type_name,dic_code,dic_name,dic_value,dic_status,note)
VALUES
   ('system_apply_result','业务系统接入申请结果','system_apply_result_success','审核通过',1,1,'初始数据'),
   ('system_apply_result','业务系统接入申请结果','system_apply_result_failed','审核未通过',2,1,'初始数据');

INSERT INTO system_dic  (dic_type,dic_type_name,dic_code,dic_name,dic_value,dic_status,note)
VALUES
   ('encrypt_type','加密类型','encrypt_type_rsa','RSA加密',1,1,'初始数据'),
   ('encrypt_type','加密类型','encrypt_type_aes','AES加密',2,1,'初始数据'),
   ('encrypt_type','加密类型','encrypt_type_md5','MD5加密',3,1,'初始数据');

INSERT INTO system_dic  (dic_type,dic_type_name,dic_code,dic_name,dic_value,dic_status,note)
VALUES
   ('param_segment_type','参数片段类型','param_segment_type_head','Head',1,1,'初始数据'),
   ('param_segment_type','参数片段类型','param_segment_type_body','Body',2,1,'初始数据');

INSERT INTO system_dic  (dic_type,dic_type_name,dic_code,dic_name,dic_value,dic_status,note)
VALUES
   ('param_wrapper_type','参数片段类型','param_wrapper_type_key_value','key-value类型',1,1,'初始数据'),
   ('param_wrapper_type','参数片段类型','param_wrapper_type_complicated','复杂包装类型',2,1,'初始数据');

INSERT INTO system_dic  (dic_type,dic_type_name,dic_code,dic_name,dic_value,dic_status,note)
VALUES
   ('param_tree_type','参数树节点类型类型','param_tree_type_root','Root',1,1,'初始数据'),
   ('param_tree_type','参数树节点类型类型','param_tree_type_branch','Branch',2,1,'初始数据'),
   ('param_tree_type','参数树节点类型类型','param_tree_type_leaf','Leaf',3,1,'初始数据');