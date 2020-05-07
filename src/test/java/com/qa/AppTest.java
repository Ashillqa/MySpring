package com.qa;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;


public class AppTest 
{

    @Test
    public void shouldAnswerWithTrue()
    {
       App app = new App();
       String [] args = null;
       App.main(args);
        assertTrue( app instanceof App );
    }

}
