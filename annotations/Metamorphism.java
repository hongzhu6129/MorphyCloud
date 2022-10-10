package morphy.annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface Metamorphism {
	// The applicable test case can be "all", "seed" or "mutant"
	String applicableTestCase() default "all";
	// If the applicable test case is "mutant", The applicable datamorphism can 
	// be "all" or the name on the data morphism. 
	String applicableDatamorphism() default "all";
	// The message when the test case fails checking againts the metamorphism; 
	String message() default "Failed checking againt a metamorphism";
}
