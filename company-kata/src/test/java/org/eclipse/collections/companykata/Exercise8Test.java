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

import java.util.*;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collectors;

import static com.google.common.truth.Truth.assertThat;

/**
 * Below are links to APIs that may be helpful during these exercises.

 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/23">Exercise 8 Slides</a>
 */
public class Exercise8Test extends CompanyDomainForKata
{
    /**
     * Extra credit. Aggregate the total order values by city.
     *
     * @see Collectors#summingDouble(ToDoubleFunction)
     */
    @Test
    public void totalOrderValuesByCity()
    {
        Map<String, Double> map = company.getCustomers()
                .stream()
                .collect(Collectors.groupingBy(Customer::getCity, Collectors.summingDouble(Customer::getTotalOrderValue)));
        assertThat(map).hasSize(2);
        assertThat(map.get("London")).isWithin(0.0).of(446.25);
        assertThat(map.get("Liphook")).isWithin(0.0).of(857.0);
    }



    /**
     * Extra credit. Aggregate the total order values by item.
     * Hint: Look at {@link RichIterable#aggregateBy(Function, Function0, Function2)} and remember
     * how to use {@link RichIterable#flatCollect(Function)} to get an iterable of all items.
     */
    @Test
    public void totalOrderValuesByItem()
    {
        Map<String, Double> map = company.getOrders().stream()
                .flatMap(o -> o.getLineItems().stream())
                .collect(Collectors.groupingBy(LineItem::getName, Collectors.summingDouble(LineItem::getValue)));


        assertThat(map).hasSize(12);
        Assert.assertEquals(100.0, map.get("shed"), 0.0);
        Assert.assertEquals(10.5, map.get("cup"), 0.0);
    }

    /**
     * Solve the same problem as above using a more specialized API.
     *
     * @see RichIterable#sumByDouble(Function, DoubleFunction)
     */
    @Test
    public void totalOrderValuesByItemUsingPrimitiveValues()
    {
        Map<String,Double> map = company.getOrders().stream()
                .flatMap(o -> o.getLineItems().stream())
                .collect(Collectors.groupingBy(LineItem::getName, Collectors.summingDouble(LineItem::getValue)));

        assertThat(map).hasSize(12);
        Assert.assertEquals(100.0, map.get("shed"), 0.0);
        Assert.assertEquals(10.5, map.get("cup"), 0.0);
    }

    /**
     * Extra credit. Find all customers' line item values greater than 7.5 and sort them by highest to lowest price.
     */
    @Test
    public void sortedOrders()
    {
        List<Double> orderedPrices = company.getOrders().stream()
                .flatMap(o -> o.getLineItems().stream())
                .map(LineItem::getValue)
                .filter(v -> v > 7.5)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        assertThat(orderedPrices).containsExactly(500.0, 150.0, 120.0, 75.0, 50.0, 50.0, 12.5).inOrder();
    }

    /**
     * Extra credit. Figure out which customers ordered saucers (in any of their orders).
     */
    @Test
    public void whoOrderedSaucers()
    {
        List<Customer> customersWithSaucers = company.getCustomers().stream()
                .filter(c -> c.getOrders().stream().flatMap(o -> o.getLineItems().stream()).anyMatch(li -> li.getName().equals("saucer")))
                .collect(Collectors.toList());
        assertThat(customersWithSaucers).hasSize(2);
    }

    /**
     * Extra credit. Look into the {@link MutableList#toMap(Function, Function)} method.
     */
    @Test
    public void ordersByCustomerUsingAsMap()
    {
       Map<String, List<Order>> customerNameToOrders =
                this.company.getCustomers().stream().collect(Collectors.toMap(Customer::getName, Customer::getOrders));

        assertThat(customerNameToOrders).isNotNull();
        assertThat(customerNameToOrders).hasSize(3);
        List<Order> ordersForBill = customerNameToOrders.get("Bill");
        assertThat(ordersForBill).hasSize(3);
    }

    /**
     * Extra credit. Create a multimap where the values are customers and the key is the price of
     * the most expensive item that the customer ordered.
     */
    @Test
    public void mostExpensiveItem()
    {
        Map<Double, List<Customer>> multimap = company.getCustomers().stream()
                .collect(Collectors.groupingBy(c -> c.getOrders().stream().flatMap(o -> o.getLineItems().stream())
                        .mapToDouble(LineItem::getValue)
                        .max().orElse(0.0) ));

        assertThat(multimap).hasSize(2);
        assertThat(multimap.values().stream().flatMap(Collection::stream).collect(Collectors.toList())).hasSize(3);

        assertThat(multimap.get(50.0)).containsExactly(
                company.getCustomerNamed("Fred"),
                company.getCustomerNamed("Bill")).inOrder();

    }

}
