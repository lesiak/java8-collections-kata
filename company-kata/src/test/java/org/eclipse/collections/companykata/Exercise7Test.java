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

import com.google.common.truth.Truth;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static com.google.common.truth.Truth.assertThat;

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
        Map<String, List<Customer>> multimap = null;

        assertThat(multimap.get("Liphook")).containsExactly(company.getCustomerNamed("Mary"));
        assertThat(multimap.get("London")).containsExactly(
                company.getCustomerNamed("Fred"),
                company.getCustomerNamed("Bill")
        ).inOrder();
    }

    /**
     * Create a Multimap where the keys are the names of items and the values are the Suppliers that supply them.
     * A Supplier is associated to many item names.
     */
    @Test
    public void itemsBySuppliers()
    {
        Map<String, List<Supplier>> itemsToSuppliers = null;

        assertThat(itemsToSuppliers.get("sofa")).hasSize(2);
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
