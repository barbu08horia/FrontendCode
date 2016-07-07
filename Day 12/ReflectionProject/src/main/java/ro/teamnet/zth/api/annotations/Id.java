package ro.teamnet.zth.api.annotations;

/**
 * Created by Lion King on 07-Jul-16.
 */

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)


public @interface Id {
    String name() default"id";
}
