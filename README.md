# springboot2-jwt-shiro
实现jwt无状态服务，shiro进行认证授权，基础框架springboot2

# 技术栈
1. spring boot2.0+
2. hutool工具包
3. mybatis-plus 3.0.6
4. swagger2  2.9
5. pagehelper
6. shiro权限控制
7. JWT 无状态令牌：token + refresh_token
8. 多数据源dynamic-datasource 

# ShiroFilter

``` java
public class JwtFilter extends BasicHttpAuthenticationFilter {

	/**
	 * 判断用户是否想要登入。 检测header里面是否包含Authorization字段即可
	 */
	@Override
	protected boolean isLoginAttempt(ServletRequest request, ServletResponse response) {
		HttpServletRequest req = (HttpServletRequest) request;
		String authorization = req.getHeader("Authorization");
		return authorization != null;
	}

	/**
	 *
	 */
	@Override
	protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		String authorization = httpServletRequest.getHeader("Authorization");
		JwtToken token = new JwtToken(authorization);
		// 提交给realm进行登入，如果错误他会抛出异常并被捕获
		getSubject(request, response).login(token);
		// 如果没有抛出异常则代表登入成功，返回true
		return true;
	}

	@Override
	protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
		if (isLoginAttempt(request, response)) {
			try {
				executeLogin(request, response);
			} catch (Exception e) {
				response401(request, response);
			}
		}
		return true;
	}

	/**
	 * 对跨域提供支持
	 */
	@Override
	protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		httpServletResponse.setHeader("Access-control-Allow-Origin", httpServletRequest.getHeader("Origin"));
		httpServletResponse.setHeader("Access-Control-Allow-Methods", "GET,POST,OPTIONS,PUT,DELETE");
		httpServletResponse.setHeader("Access-Control-Allow-Headers",
				httpServletRequest.getHeader("Access-Control-Request-Headers"));
		// 跨域时会首先发送一个option请求，这里我们给option请求直接返回正常状态
		if (httpServletRequest.getMethod().equals(RequestMethod.OPTIONS.name())) {
			httpServletResponse.setStatus(HttpStatus.OK.value());
			return false;
		}
		return super.preHandle(request, response);
	}

	/**
	 * 将非法请求跳转到 /401
	 */
	private void response401(ServletRequest req, ServletResponse resp) {
		try {
			HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
			httpServletResponse.sendRedirect("/api/unLogin");
		} catch (IOException e) {
			log.error(e.getMessage());
		}
	}
}
```

# 多数据源配置

``` yaml
#多数据源配置      
spring:
  datasource:
    dynamic:
      primary: local #设置默认的数据源或者数据源组,默认值即为master
      datasource:
        local:
          username: sa
          password: 123456
          driver-class-name: com.microsoft.sqlserver.jdbc.SQLServerDriver
          url: jdbc:sqlserver://192.168.100.170;DatabaseName=water_lock
        iot:
          username: sa
          password: c4FZy63120760jqT
          driver-class-name: com.microsoft.sqlserver.jdbc.SQLServerDriver
          url: jdbc:sqlserver://192.168.100.15;DatabaseName=ZY_Server_Web_v3
        egb:
          username: sa
          password: c4FZy63120760jqT
          driver-class-name: com.microsoft.sqlserver.jdbc.SQLServerDriver
          url: jdbc:sqlserver://192.168.100.15;DatabaseName=zxtTWS

```
