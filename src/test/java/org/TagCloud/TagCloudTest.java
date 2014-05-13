/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.TagCloud;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author richi
 */
public class TagCloudTest {
    
    public TagCloudTest() {
    }
    

    /**
     * Test of addTagClickListener method, of class TagCloud.
     */
    @Test
    public void testAddTagClickListener() {
        System.out.println( "addTagClickListener" );
        TagClickListener listener = null;
        TagCloud instance = new TagCloud();
        instance.addTagClickListener( listener );
        // TODO review the generated test code and remove the default call to fail.
        //fail( "The test case is a prototype." );
    }

    /**
     * Test of removeTagClickListener method, of class TagCloud.
     */
    @Test
    public void testRemoveTagClickListener() {
        System.out.println( "removeTagClickListener" );
        TagClickListener listener = null;
        TagCloud instance = new TagCloud();
        instance.removeTagClickListener( listener );
        // TODO review the generated test code and remove the default call to fail.
        //fail( "The test case is a prototype." );
    }
    
    
}
