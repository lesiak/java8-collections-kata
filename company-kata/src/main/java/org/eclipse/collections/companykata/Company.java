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

import java.util.ArrayList;
import java.util.List;

/**
 * A company has a {@link ArrayList} of {@link Customer}s.  It has an array of {@link Supplier}s, and a name.
 */
public class Company
{
    private final String name;
    private final ArrayList<Customer> customers = new ArrayList<>();

    // Suppliers are array based. Refactor to a MutableList<Supplier>
    private Supplier[] suppliers = new Supplier[0];

    public Company(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return this.name;
    }

    public void addCustomer(Customer aCustomer)
    {
        this.customers.add(aCustomer);
    }

    public List<Customer> getCustomers()
    {
        return this.customers;
    }

    /**
     * Remove the Assert.fail() and simplify getOrders().
     *
     */
    public List<Order> getOrders()
    {
        Assert.fail("Refactor this code to use Java8 streams as part of Exercise 3");
        List<Order> orders = new ArrayList<>();
        for (Customer customer : this.customers)
        {
            orders.addAll(customer.getOrders());
        }
        return orders;
    }

    public Customer getMostRecentCustomer()
    {
        return this.customers.get(this.customers.size() - 1);
    }

    /**
     * Simplify after refactoring to use a MutableList&lt;Supplier&gt;.
     * @param supplier
     */
    public void addSupplier(Supplier supplier)
    {
        // need to replace the current array of suppliers with another, larger array
        // Of course, normally one would not use an array.

        Supplier[] currentSuppliers = this.suppliers;
        this.suppliers = new Supplier[currentSuppliers.length + 1];
        System.arraycopy(currentSuppliers, 0, this.suppliers, 0, currentSuppliers.length);
        this.suppliers[this.suppliers.length - 1] = supplier;
    }

    public Supplier[] getSuppliers()
    {
        return this.suppliers;
    }

    /**
     * Remove the Assert.fail() and replace the null with an appropriate implementation.
     * Use a {@link Predicate} to find a {@link Customer} with the name given.
     *
     */
    public Customer getCustomerNamed(String name)
    {
        Assert.fail("Implement this method as part of Exercise 2");
        return null;
    }
}
