package com.cybertek.APItesting;

import org.hamcrest.text.IsEqualIgnoringCase;
import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.Is.is;


public class assertionWithHamcrast {

    @Test
    public void test1(){
        assertThat(1, equalTo(1));

        assertThat("as", is("as"));

       // assertThat(List, hasSize(5));

        assertThat("Shayida", equalToIgnoringCase("shayIDA"));

       // Assert.assertEquals("Shayida","shayIDA");

       // assertThat(9,greaterThan(10));//false

        assertThat(10, lessThan(299));//true



    }
}
