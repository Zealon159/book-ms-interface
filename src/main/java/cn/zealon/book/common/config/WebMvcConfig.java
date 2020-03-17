package cn.zealon.book.common.config;

import com.alibaba.fastjson.JSON;
import cn.zealon.book.common.result.enums.HttpCodeEnum;
import cn.zealon.book.common.result.Result;
import cn.zealon.book.system.security.shiro.util.UserUtil;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @auther: Zealon
 * @Date: 2018-08-28 10:37
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    private final Logger logger = LoggerFactory.getLogger(WebMvcConfig.class);

    @Autowired
    private SystemPropertiesConfig systemPropertiesConfig;

    /** 注册web文件资源访问地址 */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 附件路径
        String mapPath = "file:" + systemPropertiesConfig.getUploadPath() + systemPropertiesConfig.getAttachmentDir();
        // 映射访问地址
        registry.addResourceHandler(systemPropertiesConfig.getAttachmentAccess()).addResourceLocations(mapPath);
    }

    /**
     * 异常处理
     * @param resolvers
     */
    @Override
    public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> resolvers) {
        resolvers.add((HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)-> {
            Result result = new Result();

            // 判断异常
            if (e instanceof NoHandlerFoundException) {
                result.setCode(HttpCodeEnum.NOT_FOUND.getCode());
                result.setMsg("服务 [" + request.getRequestURI() + "] 不存在");
                result.setData("服务 [" + request.getRequestURI() + "] 不存在");
            } else if (e instanceof ServletException) {
                result.setCode(HttpCodeEnum.FAIL.getCode());
                result.setMsg(e.getMessage());
                result.setData(e.getMessage());
            } else if(e instanceof UnauthorizedException){
                // shiro 无权限异常
                ModelAndView modelAndView = new ModelAndView();
                modelAndView.setViewName("common/error/404");
                logger.info("{}用户无权限使用{}资源",UserUtil.getCurrentUserId(),request.getRequestURI());
                return  modelAndView;

            } else{
                result.setCode(HttpCodeEnum.INTERNAL_SERVER_ERROR.getCode());
                result.setMsg("服务 [" + request.getRequestURI() + "] 内部错误，请联系管理员");
                result.setData("服务内部错误，请联系管理员");
                String message;
                if (handler instanceof HandlerMethod) {
                    HandlerMethod handlerMethod = (HandlerMethod) handler;
                    message = String.format("服务 [%s] 出现异常，方法：%s.%s，异常摘要：%s",
                            request.getRequestURI(),
                            handlerMethod.getBean().getClass().getName(),
                            handlerMethod.getMethod().getName(),
                            e.getMessage());

                } else {
                    message = e.getMessage();
                }
                logger.error(message, e);
            }

            responseResult(response, result);
            return null;
        });
    }

    private void responseResult(HttpServletResponse response, Result result) {
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "application/json;charset=UTF-8");
        response.setStatus(200);
        try {
            response.getWriter().write(JSON.toJSONString(result));
        } catch (IOException ex) {
            logger.error(ex.getMessage());
        }
    }
}
