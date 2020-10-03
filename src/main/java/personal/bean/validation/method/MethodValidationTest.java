package personal.bean.validation.method;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.executable.ExecutableValidator;

public class MethodValidationTest {

	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		Validator validator = factory.getValidator();
		ExecutableValidator executableValidator = validator.forExecutables();

		User user1 = new User();

		Method setName = User.class.getMethod("setName", String.class);
		executableValidator.validateParameters(user1, setName, new Object[] { "" }).stream()
				.map(ConstraintViolation::getMessage)
				.forEach(System.out::println);
		
		System.out.println("--------------------------------------");
		
		Address address = new Address();
		
		Method setAddress = User.class.getMethod("setAddress", Address.class);
		executableValidator.validateParameters(user1, setAddress, new Object[] { address }).stream()
				.map(ConstraintViolation::getMessage)
				.forEach(System.out::println);
		
		System.out.println("--------------------------------------");
		
		executableValidator.validateParameters(user1, setName, new Object[] { "Name1" }).stream()
		.map(ConstraintViolation::getMessage)
		.forEach(System.out::println);
		
		setName.invoke(user1, "Name2");
		
		System.out.println(user1);
		
	}

}
