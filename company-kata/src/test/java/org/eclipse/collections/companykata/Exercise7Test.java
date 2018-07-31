/*
 * Copyright (c) 2018 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.companykata;

import org.junit.Assert;
import org.junit.Test;

/**
 * Below are links to APIs that may be helpful during these exercises.
 *
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/19">Exercise 7 Slides</a>
 */
public class Exercise7Test extends CompanyDomainForKata
{
    /**
     * Create a Multimap where the keys are the names of cities and the values are the Customers from those cities.
     * A Customer is only associated to one city.
     */
    @Test
    public void customersByCity()
    {
//        MutableListMultimap<String, Customer> multimap = null;
//
//        Assert.assertEquals(Lists.mutable.with(this.company.getCustomerNamed("Mary")), multimap.get("Liphook"));
//        Assert.assertEquals(
//                Lists.mutable.with(
//                        this.company.getCustomerNamed("Fred"),
//                        this.company.getCustomerNamed("Bill")),
//                multimap.get("London"));
    }

    /**
     * Create a Multimap where the keys are the names of items and the values are the Suppliers that supply them.
     * A Supplier is associated to many item names.
     */
    @Test
    public void itemsBySuppliers()
    {
      //  MutableMultimap<String, Supplier> itemsToSuppliers = null;

      //  Verify.assertIterableSize("should be 2 suppliers for sofa", 2, itemsToSuppliers.get("sofa"));
    }

    /**
     * Delete this whole method when you're done. It's just a reminder.
     */
    @Test
    public void reminder()
    {
        Assert.fail("Refactor setUpCustomersAndOrders() in the super class to not have so much repetition.");
    }
}
