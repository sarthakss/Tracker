package CarTracker;

/**
 * Created by sarth on 5/1/2017.
 */

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class appinitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[]{appconfig.class,JPAConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[0];
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/api/*"};
    }
}
