package io.kodido.templates.reactive.spring.admin.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ServletHttpHandlerAdapter;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.reactive.DispatcherHandler;
import org.springframework.web.reactive.config.WebReactiveConfiguration;
import org.springframework.web.server.adapter.WebHttpHandlerBuilder;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class Application implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        ApplicationContext ctx = createContext();

        DispatcherHandler dispatcherHandler = new DispatcherHandler();
        dispatcherHandler.setApplicationContext(ctx);

        HttpHandler httpHandler = WebHttpHandlerBuilder.webHandler(dispatcherHandler).build();
        ServletHttpHandlerAdapter adapter = new ServletHttpHandlerAdapter();
        adapter.setHandler(httpHandler);

        final ServletRegistration.Dynamic registration = servletContext.addServlet("dispatcher-handler", adapter);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        registration.setAsyncSupported(true);

    }

    private ApplicationContext createContext() {
        final AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(WebReactiveConfiguration.class);
        ctx.register(getConfigClasses());
        ctx.refresh();
        return ctx;
    }

    private Class<?>[] getConfigClasses() {
        return new Class[]{AppConfig.class};
    }
}
