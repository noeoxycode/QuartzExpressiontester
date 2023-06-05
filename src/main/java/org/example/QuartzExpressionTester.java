package org.example;

import java.util.Date;

import org.quartz.CronExpression;

public class QuartzExpressionTester
{
    static public void main(String args[])
    {
        try
        {
            String expression = "0/30 * * * * ?";

            CronExpression cronExpression = new CronExpression(expression);
            Date[] d = new Date[50];

            d[0] = cronExpression.getNextValidTimeAfter(new Date());
            System.out.println(d[0]);
            for (int i = 1; i< 50; i++) {
                d[i] = cronExpression.getNextValidTimeAfter(d[i-1]);
                System.out.println(d[i]);
            }

        }
        catch (Exception exc)
        {
            exc.printStackTrace();
        }
    }
}