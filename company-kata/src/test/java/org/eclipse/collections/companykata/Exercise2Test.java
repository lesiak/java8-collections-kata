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

import com.google.common.truth.Truth;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static com.google.common.truth.Truth.assertThat;

/**
 * Below are links to APIs that may be helpful during these exercises.
 *
 * <p/>

 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/3">Exercise 2 Slides</a>
 */
public class Exercise2Test extends CompanyDomainForKata
{
    /**
     * Set up a {@link Predicate} that tests to see if a {@link Customer}'s city is "London".
     */
    @Test
    public void customerFromLondonPredicate()
    {
        Predicate<Customer> predicate = c -> "London".equals(c.getCity());
        String predicateClass = predicate.getClass().getSimpleName();
        Assert.assertTrue(
                "Solution should use Predicates.attributeEquals() or a lambda but used " + predicateClass,
                "AttributePredicate".equals(predicateClass) || predicateClass.startsWith("Exercise2Test$$Lambda"));

        Customer customerFromLondon = new Customer("test customer", "London");

        Assert.assertTrue(
                "predicate should accept Customers where city is London",
                predicate.test(customerFromLondon));
    }

    @Test
    public void doAnyCustomersLiveInLondon()
    {
        boolean anyCustomersFromLondon = false;
        assertThat(anyCustomersFromLondon).isTrue();
    }

    @Test
    public void doAllCustomersLiveInLondon()
    {
        boolean allCustomersFromLondon = true;
        assertThat(allCustomersFromLondon).isTrue();
    }

    @Test
    public void howManyCustomersLiveInLondon()
    {
        int numberOfCustomerFromLondon = 0;
        assertThat(numberOfCustomerFromLondon).isEqualTo(2);
    }

    @Test
    public void getLondonCustomers()
    {
        List<Customer> customersFromLondon = null;
        assertThat(customersFromLondon).hasSize(2);
    }

    @Test
    public void getCustomersWhoDontLiveInLondon()
    {
        List<Customer> customersNotFromLondon = null;
        assertThat(customersNotFromLondon).hasSize(1);
    }

    /**
     * Which customers come from London? Which customers do not come from London? Get a collection of both in a single pass.
     */
    @Test
    public void getCustomersWhoDoAndDoNotLiveInLondon()
    {
        Map<Boolean, List<Customer>> customers = null;
        List<Customer> selectedCustomers = customers.get(true);
        List<Customer> rejectedCustomers = customers.get(false);
        assertThat(selectedCustomers).hasSize(2);
        assertThat(rejectedCustomers).hasSize(1);
    }

    /**
     * Implement {@link Company#getCustomerNamed(String)} and get this test to pass.
     */
    @Test
    public void findMary()
    {
        Customer mary = this.company.getCustomerNamed("Mary");
        assertThat(mary.getName()).isEqualTo("Mary");
    }

    /**
     * Implement {@link Company#getCustomerNamed(String)} and get this test to pass.
     */
    @Test
    public void findPete()
    {
        Customer pete = this.company.getCustomerNamed("Pete");
        assertThat(pete).isNull();
    }
}
