package com.skizware.calc;

import com.skizware.calc.exception.StringCalculatorException;

import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: david.anderson
 * Date: 2015/06/09
 * Time: 7:17 PM
 * To change this template use File | Settings | File Templates.
 */
public class StringCalculator {

    public static final String EMPTY_STRING = "";
    public static final String DELIMITER_PATTERN = "^(//\\W{1}\\\\n).*";
    public static final String MSG_ERR_NEGATIVES_NOT_ALLOWED = "Error: negatives not allowed";

    public int add(final String input){

        String delimiter = ",";
        String inputI = input;
        if(input.matches(DELIMITER_PATTERN)){
            delimiter = input.substring(2, 3);
            inputI = input.substring(5, input.length());
        }

        String[] vals = scrubInput(inputI).split(Pattern.quote(delimiter));
        int ret = 0;
        for (String val : vals) {
            if(!EMPTY_STRING.equals(val)){
                ret += validateValue(val);
            }
        }

        return ret;
    }

    private int validateValue(String val) {
        int ret = Integer.parseInt(val);
        if(ret < 0){
            throw new StringCalculatorException(MSG_ERR_NEGATIVES_NOT_ALLOWED);
        }

        return ret;
    }

    private String scrubInput(final String input) {
        return input.replace("\\n",",");
    }

}
