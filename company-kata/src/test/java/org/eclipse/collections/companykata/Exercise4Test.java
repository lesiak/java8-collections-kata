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

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;

import static com.google.common.truth.Truth.assertThat;

/**
 * Below are links to APIs that may be helpful during these exercises.

 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/12">Exercise 4 Slides</a>
 */
public class Exercise4Test extends CompanyDomainForKata
{
    /**
     * Solve this without changing the return type of {@link Company#getSuppliers()}. Find the appropriate method on
     * {@link }.
     */
    @Test
    public void findSupplierNames()
    {
        List<String> supplierNames = null;

        assertThat(supplierNames).containsExactly(
                "Shedtastic",
                "Splendid Crocks",
                "Annoying Pets",
                "Gnomes 'R' Us",
                "Furniture Hamlet",
                "SFD",
                "Doxins").inOrder();
    }

    /**
     * Create a {@link Predicate} for Suppliers that supply more than 2 items. Find the number of suppliers that
     * satisfy that Predicate.
     */
    @Test
    public void countSuppliersWithMoreThanTwoItems()
    {
        Predicate<Supplier> moreThanTwoItems = null;
        int suppliersWithMoreThanTwoItems = 0;
        Assert.assertEquals("suppliers with more than 2 items", 5, suppliersWithMoreThanTwoItems);
    }

    /**
     * Try to solve this without changing the return type of {@link Supplier#getItemNames()}.
     */
    @Test
    public void whoSuppliesSandwichToaster()
    {
        // Create a Predicate that will check to see if a Supplier supplies a "sandwich toaster".
        Predicate<Supplier> suppliesToaster = null;

        // Find one supplier that supplies toasters.
        Supplier toasterSupplier = null;
        assertThat(toasterSupplier).isNotNull();
        assertThat(toasterSupplier.getName()).isEqualTo("Doxins");
    }

    /**
     * Get the order values that are greater than 1.5.
     */
    @Test
    public void filterOrderValues()
    {
        List<Order> orders = this.company.getMostRecentCustomer().getOrders();
        List<Double> orderValues = null;
        List<Double> filtered = null;
        assertThat(filtered).containsExactly(372.5, 1.75).inOrder();
    }

    /**
     * Get the order values that are greater than 1.5 using double instead of Double.
     */
    @Test
    public void filterOrderValuesUsingPrimitives()
    {
        List<Order> orders = this.company.getMostRecentCustomer().getOrders();
        List<Double> orderValues = null;
        List<Double> filtered = null;
        assertThat(filtered).containsExactly(372.5, 1.75).inOrder();
    }

    /**
     * Get the actual orders (not their double values) where those orders have a value greater than 2.0.
     */
    @Test
    public void filterOrders()
    {
        List<Order> orders = this.company.getMostRecentCustomer().getOrders();
        List<Order> filtered = null;
        assertThat(filtered).isEqualTo(Lists.newArrayList(this.company.getMostRecentCustomer().getOrders()).stream().findFirst().get());
    }
}
