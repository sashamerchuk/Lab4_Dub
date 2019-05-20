package ua.lviv.iot.creativityGood;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;

import ua.lviv.iot.creativity.manager.CreativityManager;
import ua.lviv.iot.creativity.model.CreativityGood;
import ua.lviv.iot.creativity.model.Needle;
import ua.lviv.iot.creativity.model.Tissue;
import ua.lviv.iot.creativity.model.Type;
import ua.lviv.iot.creativity.model.Thread;

class TestCreativityGoodModal {
    
    @Test
    public void testGetterSetterCreativityGood() {
        PojoClass pojoclass = PojoClassFactory.getPojoClass(CreativityGood.class);
        Validator validator = ValidatorBuilder
                .create()
                .with(new SetterMustExistRule())
                .with(new GetterMustExistRule())
                .with(new SetterTester())
                .with(new GetterTester())
                .build();
        validator.validate(pojoclass);
    }
    

    @Test
    public void testGetterSetterNeedle() {
        PojoClass pojoclass = PojoClassFactory.getPojoClass(Needle.class);
        Validator validator = ValidatorBuilder
                .create()
                .with(new SetterMustExistRule())
                .with(new GetterMustExistRule())
                .with(new SetterTester())
                .with(new GetterTester())
                .build();
        validator.validate(pojoclass);
    }
    

    @Test
    public void testGetterSetterThread() {
        PojoClass pojoclass = PojoClassFactory.getPojoClass(Thread.class);
        Validator validator = ValidatorBuilder
                .create()
                .with(new SetterMustExistRule())
                .with(new GetterMustExistRule())
                .with(new SetterTester())
                .with(new GetterTester())
                .build();
        validator.validate(pojoclass);
    }
    

    @Test
    public void testGetterSetterTissue() {
        PojoClass pojoclass = PojoClassFactory.getPojoClass(Tissue.class);
        Validator validator = ValidatorBuilder
                .create()
                .with(new SetterMustExistRule())
                .with(new GetterMustExistRule())
                .with(new SetterTester())
                .with(new GetterTester())
                .build();
        validator.validate(pojoclass);
    }
    
}
