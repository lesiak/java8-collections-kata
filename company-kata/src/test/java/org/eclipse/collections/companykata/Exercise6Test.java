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


import com.google.common.collect.Iterables;
import org.junit.Test;

import java.util.List;

import static com.google.common.truth.Truth.assertThat;

/**
 * Below are links to APIs that may be helpful during these exercises.
 *

 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/17">Exercise 6 Slides</a>
 */
public class Exercise6Test extends CompanyDomainForKata
{
    /**
     * Get a list of the customers' total order values, sorted. Check out the implementation of {@link
     * Customer#getTotalOrderValue()} and {@link Order#getValue()} .
     */
    @Test
    public void sortedTotalOrderValue()
    {
        List<Double> sortedTotalValues = null;

        // Don't forget the handy utility methods getFirst() and getLast()...
        assertThat(Iterables.getLast(sortedTotalValues, null)).isEqualTo(857.0);
        assertThat(Iterables.getFirst(sortedTotalValues, null)).isEqualTo(71.0);
    }

    /**
     * Get a list of the customers' total order values, sorted. Use primitive doubles instead of boxed Doubles.
     */
    @Test
    public void sortedTotalOrderValueUsingPrimitives()
    {
        List<Double> sortedTotalValues = null;

        // Don't forget the handy utility methods getFirst() and getLast()...
        assertThat(Iterables.getLast(sortedTotalValues, null)).isEqualTo(857.0);
        assertThat(Iterables.getFirst(sortedTotalValues, null)).isEqualTo(71.0);
    }

    /**
     * Find the max total order value across all customers.
     */
    @Test
    public void maximumTotalOrderValue()
    {
        Double maximumTotalOrderValue = null;
        assertThat(maximumTotalOrderValue).isEqualTo(857.0);
    }

    /**
     * Find the max total order value across all customers, but use primitive double instead of boxed Double.
     */
    @Test
    public void maximumTotalOrderValueUsingPrimitives()
    {
        double maximumTotalOrderValue = 0.0;
        assertThat(maximumTotalOrderValue).isEqualTo(857.0);
    }

    /**
     * Find the customer with the highest total order value.
     */
    @Test
    public void customerWithMaxTotalOrderValue()
    {
        Customer customerWithMaxTotalOrderValue = null;
        assertThat(customerWithMaxTotalOrderValue).isEqualTo(company.getCustomerNamed("Mary"));
    }

    /**
     * Create some code to get the company's supplier names as a tilde delimited string.
     */
    @Test
    public void supplierNamesAsTildeDelimitedString()
    {
        String tildeSeparatedNames = null;
        assertThat(tildeSeparatedNames).isEqualTo("Shedtastic~Splendid Crocks~Annoying Pets~Gnomes 'R' Us~Furniture Hamlet~SFD~Doxins");
    }

    /**
     * Deliver all orders going to customers from London.
     * <p/>
     * Hint:
     *
     * @see Order#deliver()
     */
    @Test
    public void deliverOrdersToLondon()
    {
        assertThat(this.company.getCustomerNamed("Fred").getOrders().stream().allMatch(Order::isDelivered)).isTrue();
        assertThat(this.company.getCustomerNamed("Mary").getOrders().stream().anyMatch(Order::isDelivered)).isFalse();
        assertThat(this.company.getCustomerNamed("Bill").getOrders().stream().allMatch(Order::isDelivered)).isTrue();

    }
}
