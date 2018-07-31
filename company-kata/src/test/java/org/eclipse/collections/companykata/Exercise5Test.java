/*
 * Copyright (c) 2017 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.companykata;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;
import com.google.common.truth.Truth;
import org.junit.Assert;
import org.junit.Test;

/**
 * Below are links to APIs that may be helpful during these exercises.
 *
 * {@link Stream#collect(Collector)}
 * {@link Stream#mapToDouble(ToDoubleFunction)}
 * {@link Stream#filter(Predicate)}
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/15">Exercise 5 Slides</a>
 */
public class Exercise5Test extends CompanyDomainForKata
{
    /**
     * Same exercise but don't use static utility - refactor the type of orders and {@link Customer#getOrders()}
     * instead.
     * Get the order values that are greater than 1.5.
     */
    @Test
    public void filterOrderValues()
    {
        List<Order> orders = this.company.getMostRecentCustomer().getOrders();
        List<Double> orderValues = null;
        List<Double> filtered = orderValues.stream().filter(v -> v > 1.5).collect(Collectors.toList());

        Assert.assertEquals(Lists.newArrayList(372.5, 1.75), filtered);
        Truth.assertThat(this.company.getMostRecentCustomer().getOrders()).isInstanceOf(List.class);
        this.company.getMostRecentCustomer().getOrders().add(null);
       // Verify.assertContains("Don't return a copy from Customer.getOrders(). The field should be a MutableList.", null, this.company.getMostRecentCustomer().getOrders());
    }

    /**
     * Same as above exercise, but use primitive doubles instead of boxed Doubles.
     */
    @Test
    public void filterOrderValuesUsingPrimitives()
    {
        List<Order> orders = this.company.getMostRecentCustomer().getOrders();
       // MutableDoubleList orderValues = null;
      //  MutableDoubleList filtered = orderValues.select(DoublePredicates.greaterThan(1.5));

      //  Assert.assertEquals(DoubleLists.mutable.with(372.5, 1.75), filtered);
    }

    /**
     * Same exercise but don't use static utility - refactor the type of orders and {@link Customer#getOrders()}
     * instead.
     * Get the actual orders (not their double values) where those orders have a value greater than 2.0.
     */
    @Test
    public void filterOrders()
    {
        List<Order> orders = this.company.getMostRecentCustomer().getOrders();
        List<Order> filtered = null;

     //   Assert.assertEquals(Lists.newArrayList(Iterate.getFirst(this.company.getMostRecentCustomer().getOrders())), filtered);
     //   Verify.assertInstanceOf(MutableList.class, this.company.getMostRecentCustomer().getOrders());
        this.company.getMostRecentCustomer().getOrders().add(null);
      //  Verify.assertContains("Don't return a copy from Customer.getOrders(). The field should be a MutableList.", null, this.company.getMostRecentCustomer().getOrders());
    }
}
