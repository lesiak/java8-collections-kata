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

import java.util.Collections;
import java.util.Map;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToDoubleFunction;

import com.google.common.truth.Truth;

import org.junit.Assert;
import org.junit.Test;

import static com.google.common.truth.Truth.assertThat;

/**
 * Below are links to APIs that may be helpful during these exercises.
 *
 * {@link RichIterable#aggregateBy(Function, Function0, Function2)}
 * {@link RichIterable#sumByDouble(Function, DoubleFunction)}
 * {@link RichIterable#flatCollect(Function)}
 * {@link MutableList#select(Predicate)}
 * {@link MutableList#anySatisfy(Predicate)}
 * {@link MutableList#toMap(Function, Function)}
 * {@link RichIterable#asLazy()}
 * {@link MutableList#groupBy(Function)}
 * {@link MutableList#collectDouble(DoubleFunction, MutableDoubleCollection)}
 * {@link MutableDoubleList#max()}
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/23">Exercise 8 Slides</a>
 */
public class Exercise8Test extends CompanyDomainForKata
{
    /**
     * Extra credit. Aggregate the total order values by city.
     *
     * @see RichIterable#aggregateBy(Function, Function0, Function2)
     */
    @Test
    public void totalOrderValuesByCity()
    {
        DoubleSupplier zeroValueFactory = () -> 0.0;
        ToDoubleBiFunction<Double, Customer> aggregator = (result, customer) -> result + customer.getTotalOrderValue();

        Map<String, Double> map = null;
        assertThat(map).hasSize(2);
        assertThat(map.get("London")).isWithin(0.0).of(446.25);
        assertThat(map.get("Liphook")).isWithin(0.0).of(857.0);
    }

    /**
     * Solve the same problem as above using a more specialized API.
     *
     * @see RichIterable#sumByDouble(Function, DoubleFunction)
     */
    @Test
    public void totalOrderValuesByCityUsingPrimitiveValues()
    {
        Function<Customer, String> cityFunction = Customer::getCity;
        ToDoubleFunction<Customer> totalOrderValueFunction = Customer::getTotalOrderValue;
        Map<String, Double> map = null;
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
        DoubleSupplier zeroValueFactory = () -> 0.0;
        ToDoubleBiFunction<Double, Customer> aggregator = (result, customer) -> result + customer.getTotalOrderValue();

        Map<String, Double> map = null;
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
        Function<LineItem, String> nameFunction = LineItem::getName;
        ToDoubleFunction<LineItem> valueFunction = LineItem::getValue;
        Map<String,Double> map = null;
        assertThat(map).hasSize(12);
        Assert.assertEquals(100.0, map.get("shed"), 0.0);
        Assert.assertEquals(10.5, map.get("cup"), 0.0);
    }

//    /**
//     * Extra credit. Find all customers' line item values greater than 7.5 and sort them by highest to lowest price.
//     */
//    @Test
//    public void sortedOrders()
//    {
//        MutableSortedBag<Double> orderedPrices = null;
//
//        MutableSortedBag<Double> expectedPrices = SortedBags.mutable.with(
//                Collections.reverseOrder(), 500.0, 150.0, 120.0, 75.0, 50.0, 50.0, 12.5);
//        Verify.assertSortedBagsEqual(expectedPrices, orderedPrices);
//    }
//
//    /**
//     * Extra credit. Figure out which customers ordered saucers (in any of their orders).
//     */
//    @Test
//    public void whoOrderedSaucers()
//    {
//        MutableList<Customer> customersWithSaucers = null;
//        Verify.assertSize("customers with saucers", 2, customersWithSaucers);
//    }
//
//    /**
//     * Extra credit. Look into the {@link MutableList#toMap(Function, Function)} method.
//     */
//    @Test
//    public void ordersByCustomerUsingAsMap()
//    {
//        MutableMap<String, MutableList<Order>> customerNameToOrders =
//                this.company.getCustomers().toMap(null, null);
//
//        Assert.assertNotNull("customer name to orders", customerNameToOrders);
//        Verify.assertSize("customer names", 3, customerNameToOrders);
//        MutableList<Order> ordersForBill = customerNameToOrders.get("Bill");
//        Verify.assertSize("Bill orders", 3, ordersForBill);
//    }
//
//    /**
//     * Extra credit. Create a multimap where the values are customers and the key is the price of
//     * the most expensive item that the customer ordered.
//     */
//    @Test
//    public void mostExpensiveItem()
//    {
//        MutableListMultimap<Double, Customer> multimap = null;
//        Verify.assertSize(3, multimap);
//        Verify.assertSize(2, multimap.keysView());
//        Assert.assertEquals(
//                Lists.mutable.with(
//                        this.company.getCustomerNamed("Fred"),
//                        this.company.getCustomerNamed("Bill")),
//                multimap.get(50.0));
//    }
//
}
