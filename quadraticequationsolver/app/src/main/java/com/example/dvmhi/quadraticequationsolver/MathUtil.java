package com.example.dvmhi.quadraticequationsolver;

public class MathUtil {

    /**
     * Checks if the given number is an Integer, returns true or false
     * @param number Number you are checking
     * @return
     */
    public static boolean isInt(double number)
    {
        if(number==Math.rint(number)) return true;
        else return false;
    }

    /**
     * Got off the interenet, test if a string is a double. Useful to stop letters if they somehow creep in...
     * @param String
     * @return
     */
    public static boolean isDouble(String String) {
        try {
            Double.parseDouble(String);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Error 1-Person tried to make A be 0
     * Error 2-Person tried to put something besides a number as a, b, or c.
     * More errors added as I need them.
     * @param reason Integer giving the reason something failed
     */
    public static String nogo(int reason)
    {
        if(reason==1)
        {
            return "Error 1:Sorry can not have A=0";
        }
        if(reason==2)
        {
            return "Error 2:Yea you need to put a number in...";
        }
        if(reason==3)
        {
            return "Error 3:Something went very wrong...please email me at cabmanbellou@gmail.com";
        }
        return "Error unknown, please email me at cabmanbellou@gmail.com";
    }
}