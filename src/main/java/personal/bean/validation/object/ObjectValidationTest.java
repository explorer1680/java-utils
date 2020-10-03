package personal.bean.validation.object;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;

import org.springframework.validation.annotation.Validated;

@Validated
public class ObjectValidationTest {
	public static void main(String[] args) {
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        
        Child c =new Child();
        
        Parent p1 = new Parent("ABC", 21, c);
        Set<ConstraintViolation<Parent>> violations1 = validator.validate(p1);
        violations1.stream().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
        
        Set<ConstraintViolation<Parent>> violations1_1 = validator.validate(p1, AdvanceInfo.class);
        violations1_1.stream().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
        
        Parent p2 = new Parent();
        Set<ConstraintViolation<Parent>> violations2 = validator.validate(p2);
        violations2.stream().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
        
        Set<ConstraintViolation<Parent>> violations3 = validator.validate(p2, BasicInfo.class);
        violations3.stream().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
        
        Set<ConstraintViolation<Parent>> violations4 = validator.validate(p2, AdvanceInfo.class);
        violations4.stream().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
        
        Set<ConstraintViolation<Parent>> violations5 = validator.validate(p2, SequenceGroup.class);
        violations5.stream().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
        
        Set<ConstraintViolation<Parent>> violations6 = validator.validate(p2, BasicInfo.class, AdvanceInfo.class, Default.class);
        violations6.stream().forEach(System.out::println);
        System.out.println("---------------------------------------------------------------");
	}
}
