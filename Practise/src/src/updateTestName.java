package src;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;


@Retention(RetentionPolicy.RUNTIME)

public @interface updateTestName
{
	 int idx() default 0;
}