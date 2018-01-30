package com.example.dvmhi.quadraticequationsolver;

import com.example.dvmhi.quadraticequationsolver.MathUtil;

public class QuadSolve {
    /**
     * Method called when the user hits calculate.
     * @param A String form of a in a quadratic equation
     * @param B String form of b in a quadratic equation
     * @param C String form of c in a quadratic equation
     * @return
     */
    public static String quadSolveMain(String A, String B, String C)
    {
        // Checks if the strings given are doubles(Should only happen if there is nothing entered)
        if(MathUtil.isDouble(A)&&MathUtil.isDouble(B)&&MathUtil.isDouble(C))
        {
            double a = Double.parseDouble(A);
            double b = Double.parseDouble(B);
            double c = Double.parseDouble(C);
            double xplus = solveQuadPlus(a,b,c);
            double xminus = solveQuadMinus(a,b,c);
            if(a==0)
            {
                return "A cannot be 0";
            }
            String solutions =("The two solutions are X="+xplus+" and X="+xminus);
            // Will be true if there is an imaginary number
            if(Double.isNaN(xplus))
            {
                String underRoot = imaginaryUnderSquareRoot(a, b, c);
                return underRoot;
            }
            else return solutions;
        }
        else return MathUtil.nogo(2);
    }

    /**
     *  Whatever is returned is shown in the lower answer box, this takes the quadratic and tries to
     *  reduce/factor it.
     * @param A Raw String A from user input
     * @param B Raw String B from user input
     * @param C Raw String C from user input
     * @return
     */
    public static String factorMain(String A, String B, String C)
    {
        if(MathUtil.isDouble(A)&&MathUtil.isDouble(B)&&MathUtil.isDouble(C))
        {
            double a = Double.parseDouble(A);
            double b = Double.parseDouble(B);
            double c = Double.parseDouble(C);
            double answerplus = solveQuadPlus(a,b,c);
            double answerminus = solveQuadMinus(a,b,c);
            int factor = 1;
            if(a==0)
            {
                return "";
            }
            if(Double.isNaN(answerplus))
            {
                return "No factor for imaginary solutions";
            }
            else
            {
                if(isReducable(a,b,c))
                {
                    factor = gcf(a,b,c);
                }
                //If both can be factored.
                if(MathUtil.isInt(answerplus)&&MathUtil.isInt(answerminus)&&a==1)
                {
                    String first;
                    String second;
                    // These next two if's are cause it looks dumb to have X+0 as one of them
                    if(-answerplus!=0)
                    {
                        first =("(X+("+((int)-answerplus)+"))");
                    }
                    else first =("(X)");

                    if(-answerminus!=0)
                    {
                        second =("(X+("+((int)-answerminus)+"))");
                    }
                    else second =("(X)");
                    if(factor>1) return ("Factored form is: "+factor+first+second);
                    else return ("Factored form is: "+first+second);
                }
                // If answerplus is not a full number(Meaning there might be a number before an X)
                else if(MathUtil.isInt(a)&&!MathUtil.isInt(answerplus)&&MathUtil.isInt(answerminus))
                {
                    String first;
                    String second;
                    if(MathUtil.isInt(answerplus*a))
                    {
                        first = ("("+(int)a/factor+"X+("+(int)((-answerplus*a)/factor)+"))");
                        if(-answerminus!=0)
                        {
                            second =("(X+("+((int)-answerminus)+"))");
                        }
                        else second =("(X)");
                        if(factor>1) return ("Factored form is: "+factor+first+second);
                        else return ("Factored form is: "+first+second);
                    }
                }
                // If answerminus is not a full number(Meaning there might be a number before an X)
                else if(MathUtil.isInt(a)&&MathUtil.isInt(answerplus)&&!MathUtil.isInt(answerminus))
                {
                    String first;
                    String second;
                    if(MathUtil.isInt(answerminus*a))
                    {
                        first = ("("+(int)a/factor+"X+("+(int)((-answerminus*a)/factor)+"))");
                        if(-answerplus!=0)
                        {
                            second =("(X+("+((int)-answerplus)+"))");
                        }
                        else second =("(X)");
                        if(factor>1) return ("Factored form is: "+factor+first+second);
                        else return ("Factored form is: "+first+second);
                    }
                }
            }

        }
        return "No factored form available";
    }

    /**
     * This solves the + part in -b + or - the sqroot of ect ect
     * @param a variable "a" in a quadratic equation
     * @param b variable "b" in a quadratic equation
     * @param c variable "c" in a quadratic equation
     * @return
     */
    public static double solveQuadPlus(double a, double b, double c)
    {
        double answer = ((-b+(Math.sqrt((b*b)-4*a*c)))/(2*a));
        return answer;
    }


    /**
     * This solves the - part in -b + or - the sqroot of ect ect
     * @param a variable "a" in a quadratic equation
     * @param b variable "b" in a quadratic equation
     * @param c variable "c" in a quadratic equation
     * @return
     */
    public static double solveQuadMinus(double a, double b, double c)
    {
        double answer = ((-b-(Math.sqrt((b*b)-4*a*c)))/(2*a));
        return answer;
    }

    /**
     * This returns whether or not A B and C can be reduced.
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static boolean isReducable(double a, double b, double c)
    {
        int greatestfactor = gcf(a,b,c);
        if(greatestfactor>1)
        {
            //System.out.println("Greatest common factor found, manually reducing is suggested, but probably not required");
            //reduceThenSolve(greatestfactor,a,b,c);
            return true;
        }
        else return false;
    }


    /**
     * Basically part 2 of isReducable, the uses a for loop to check if all numbers through 1001 are factors of a b and c.
     *
     * @param a
     * @param b
     * @param c
     * @return Greatest common factor of A B and C
     */
    public static int gcf(double a, double b, double c)
    {
        int greatestfactor = 1;
        for(int i=0;i<1000;i++)
        {
            if(MathUtil.isInt(a/i)&&MathUtil.isInt(b/i)&&MathUtil.isInt(c/i))
            {
                greatestfactor = i;
            }
        }
        return greatestfactor;
    }

    /**
     * Should ONLY be called if there is an imaginary number.(In this case meaning the above 2 came out with an NaN.)
     * This will return a string giving the answer in quadratic form
     * @param a variable "a" in a quadratic equation
     * @param b variable "b" in a quadratic equation
     * @param c variable "c" in a quadratic equation
     * @return
     */
    public static String imaginaryUnderSquareRoot(double a, double b, double c)
    {
        String answer="You should never see this";
        double solution= ((b*b)-4*a*c);
        answer = ("Imaginary number found, answer is "+(-b)+"+ or -\u221A("+solution+") all over "+(2*a));
        return answer;
    }
}