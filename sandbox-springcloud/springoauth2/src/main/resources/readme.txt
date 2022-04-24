1.数据准备，在下命令行下执行：mysql -uroot -p123456<./schema.sql，创建表格并初始化用户认证数据
2.启动服务器程序
3.获取授权码：http://localhost:8080/oauth/authorize?client_id=client&response_type=code&redirect_uri=http://www.baidu.com
curl -XGET "http://localhost:8080/oauth/authorize?client_id=client&response_type=code&redirect_uri=http://www.baidu.com"

4.获取令牌：curl -X POST -H "Content-Type: application/x-www-form-urlencoded" -d "grant_type=authorization_code&redirect_uri=http://www.baidu.com&code=q5khAe" "http://client:secret@localhost:8080/oauth/token"
5.访问资源：
（1）如果是
curl -H "Authorization: Bearer 33c686d5-f9a5-4dca-921a-196f2283db6c" "http://localhost:8080/hello"
或
curl http://localhost:8080/hello?access_token=33c686d5-f9a5-4dca-921a-196f2283db6c
会被引导至跳转至登录页面
（2）如果加上cookie，即
curl -H "Cookie: __guid=111872281.457474064748737400.1516690571194.2722; last-serviceName=serviceprovider1; monitor_count=65; JSESSIONID=478B74C1BB738ACB4E87289265582EDC" http://localhost:8080/hello?access_token=33c686d5-f9a5-4dca-921a-196f2283db6c
则会直接返回请求结果
