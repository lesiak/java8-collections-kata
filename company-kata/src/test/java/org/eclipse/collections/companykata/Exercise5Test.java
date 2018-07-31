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

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertThat;

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
     * Same exercise but don't use static utility
     * Get the order values that are greater than 1.5.
     */
    @Test
    public void filterOrderValues()
    {
        List<Order> orders = this.company.getMostRecentCustomer().getOrders();
        List<Double> orderValues = null;
        List<Double> filtered = orderValues.stream().filter(v -> v > 1.5).collect(Collectors.toList());

        Assert.assertEquals(Lists.newArrayList(372.5, 1.75), filtered);
        assertThat(this.company.getMostRecentCustomer().getOrders()).isInstanceOf(List.class);
        this.company.getMostRecentCustomer().getOrders().add(null);
        //"Don't return a copy from Customer.getOrders(). The field should be a mutable List."
        assertThat(this.company.getMostRecentCustomer().getOrders()).contains(null);
    }

    /**
     * Same as above exercise, but use primitive doubles instead of boxed Doubles.
     */
    @Test
    public void filterOrderValuesUsingPrimitives()
    {
        List<Order> orders = this.company.getMostRecentCustomer().getOrders();
        List<Double> orderValues = null;
        List<Double> filtered = orderValues.stream().filter(v -> v > 1.5).collect(Collectors.toList());
        assertThat(filtered).containsExactly(372.5, 1.75).inOrder();
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

        assertThat(filtered).isEqualTo(Lists.newArrayList(this.company.getMostRecentCustomer().getOrders()).stream().findFirst().get());
        assertThat(this.company.getMostRecentCustomer().getOrders()).isInstanceOf(ArrayList.class);
        this.company.getMostRecentCustomer().getOrders().add(null);
        //"Don't return a copy from Customer.getOrders(). The field should be a mutable List."
        assertThat(this.company.getMostRecentCustomer().getOrders()).contains(null);
    }
}
