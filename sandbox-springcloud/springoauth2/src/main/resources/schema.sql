--mysql -uroot -p123456<./schema.sql

CREATE SCHEMA IF NOT EXISTS `spring_oauth2` DEFAULT CHARACTER SET utf8 ;
USE `spring_oauth2` ;

-- used in tests that use HSQL
create table IF NOT EXISTS oauth_client_details (
  client_id VARCHAR(256) PRIMARY KEY,
  resource_ids VARCHAR(256),
  client_secret VARCHAR(256),
  scope VARCHAR(256),
  authorized_grant_types VARCHAR(256),
  web_server_redirect_uri VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additional_information VARCHAR(4096),
  autoapprove VARCHAR(256)
);

create table IF NOT EXISTS oauth_client_token (
  token_id VARCHAR(256),
  token VARBINARY(512),
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

create table IF NOT EXISTS oauth_access_token (
  token_id VARCHAR(256),
  token VARBINARY(1024),        -- 内容为二进制的OAuth2AccessToken，包括(value,expiration,tokenType,refreshToken,scope,additionInformation)
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication VARBINARY(4096),
  refresh_token VARCHAR(256)
);

create table IF NOT EXISTS oauth_refresh_token (
  token_id VARCHAR(256),
  token VARBINARY(512),
  authentication VARBINARY(512)
);

create table IF NOT EXISTS oauth_code (
  code VARCHAR(256), authentication VARBINARY(512)
);

create table IF NOT EXISTS oauth_approvals (
  userId VARCHAR(256),
  clientId VARCHAR(256),
  scope VARCHAR(256),
  status VARCHAR(10),
  expiresAt TIMESTAMP DEFAULT '1970-01-02 00:00:00',
  lastModifiedAt TIMESTAMP DEFAULT '1970-01-02 00:00:00'
);


-- customized oauth_client_details table
create table IF NOT EXISTS ClientDetails (
  appId VARCHAR(256) PRIMARY KEY,
  resourceIds VARCHAR(256),
  appSecret VARCHAR(256),
  scope VARCHAR(256),
  grantTypes VARCHAR(256),
  redirectUrl VARCHAR(256),
  authorities VARCHAR(256),
  access_token_validity INTEGER,
  refresh_token_validity INTEGER,
  additionalInformation VARCHAR(4096),
  autoApproveScopes VARCHAR(256)
);

/*
insert into oauth_client_details
 (client_id, resource_ids, client_secret, scope, authorized_grant_types, web_server_redirect_uri, authorities, access_token_validity, refresh_token_validity, additional_information, autoapprove)
 values ('client', NULL, 'secret', 'app', 'authorization_code', 'http://www.baidu.com', NULL, NULL, NULL, NULL, NULL);
*/

