package ro.teamnet.zth.api.annotations;

import java.lang.annotation.*;

/**
 * Created by Lion King on 14-Jul-16.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyRequestMethod {
    String methodType() default "GET";
    String urlPath();
}
