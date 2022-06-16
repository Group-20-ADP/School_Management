package za.ac.cput.school_management.utility;

import org.apache.commons.validator.routines.EmailValidator;
import org.apache.commons.lang3.StringUtils;
import za.ac.cput.school_management.domain.Address;

import java.lang.reflect.Field;

public class Helper {
    public static boolean isEmptyOrNull(String str){
        return StringUtils.isEmpty(str);
    }

    public static String setEmptyIfNull(String str){
        if (isEmptyOrNull(str)){
            return StringUtils.EMPTY;
        }
        return str;
    }

    public static void checkStringParam(String paramName, String paramValue){
        if (isEmptyOrNull(paramValue))
            throw new IllegalArgumentException(String.format("Invalid value for: %s", paramName));
    }

    public static void checkEmail(String s){
        EmailValidator emailValidator = EmailValidator.getInstance();
        if (!emailValidator.isValid(s))
            throw new IllegalArgumentException("Email not valid");
    }

    public static void checkIfObjectNull(String objectName, Object object){
        if (object == null){
            throw new IllegalArgumentException(String.format("%s is null", objectName));
        }
    }

    public static void validatePostalCode(String postalCode) throws IllegalArgumentException
    {
        checkPostalCodeLength(postalCode);
        checkNonDigitCharacters(postalCode);
    }

    private static void checkPostalCodeLength(String postalCode) throws IllegalArgumentException
    {
        if(postalCode.length() != 4)
            throw new IllegalArgumentException("Invalid postal code length");
    }

    private static void checkNonDigitCharacters(String postalCode) throws IllegalArgumentException
    {
        int count = 0;
        for (int i = 0; i < postalCode.length(); i++)
        {
            if(!Character.isDigit(postalCode.charAt(i)))
                ++count;
        }

        if(count > 0)
            throw new IllegalArgumentException("Invalid postal code, " + "'" + getFieldName() + "'" + " contains: " + count + " invalid characters");
    }

    private static String getFieldName()
    {
        try{
            Field field = Address.class.getDeclaredField("postalCode");
            return field.getName();
        }
        catch(Exception e)
        {
            return "";
        }
    }
}

