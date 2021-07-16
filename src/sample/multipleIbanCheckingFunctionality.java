package sample;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class multipleIbanCheckingFunctionality {

    public static final int minIbanLength = 15;
    public static final int maxIbanLength = 34;
    public static final BigInteger modNumber = new BigInteger("97");


    public static void testMultipleIban(List<String> compiledList) {
        List<String> validList = new ArrayList<>();
        List<String> invalidList = new ArrayList<>();

        for (String k : compiledList) {
            String addedAccountNumber = k;
            //Check if the length of overall IBAN input is correct in accordance with a particular country
            if (addedAccountNumber.length() < minIbanLength || addedAccountNumber.length() > maxIbanLength) {
                System.out.println("Length of account number less or more than the minimum length according to IBAN. Invalid iban account number!!!");
            }

            //Swap the first 4 characters of the string (IBAN) with the last four characters.
            addedAccountNumber = addedAccountNumber.substring(4) + addedAccountNumber.substring(0, 4);

            //Each alphabetic character in the string should be replaced with two digits
            // so that the string would be lengthened where A = 10, B = 11, C = 12, D = 13… Z = 35.
            StringBuilder numericAccountNumber = new StringBuilder();
            for (int i = 0; i < addedAccountNumber.length(); i++) {
                int replacedDigit = Character.getNumericValue(addedAccountNumber.charAt(i));
                if (-1 >= replacedDigit) {
                    System.out.println("Have you checked if there are other characters in your IBAN input?");

                } else {
                    numericAccountNumber.append(replacedDigit);
                }
            }

            //The string should be interpreted as a decimal number,
            // and the remainder if divided by 97, should be 1.
            //If the outcome is really 1, check digit has passed the test, and the IBAN could be valid.
            // Else, the user the opportunity to reenter IBAN.
            BigInteger ibanNumber = new BigInteger(numericAccountNumber.toString());

            if (ibanNumber.mod(modNumber).intValue() == 1) {
                validList.add(addedAccountNumber);

                anotherValidationAlert.alert("Outcome", validList + " is a VALID IBAN. Do you want to validate another IBAN?");


            } else {
                invalidList.add(addedAccountNumber);

                anotherValidationAlert.alert("Outcome", invalidList + " are INVALID IBAN. Do you want to validate another IBAN?");
            }
            break;
        }
    }

}
