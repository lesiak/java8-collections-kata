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
import com.google.common.truth.Truth;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertThat;

/**
 * Below are links to APIs that may be helpful during these exercises.
 *
 * <p/>
 * {@link Stream#collect(Collector)}<br>
 * {@link Stream#map(Function)}<br>
 * {@link Stream#mapToDouble(ToDoubleFunction)}
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/1">Exercise 1 Slides</a>
 */
public class Exercise1Test extends CompanyDomainForKata
{
    /**
     * Get the name of each of the company's customers.
     */
    @Test
    public void getCustomerNames()
    {
        Function<Customer, String> nameFunction = Customer::getName;
        List<String> customerNames = this.company.getCustomers()
                .stream()
                .map(nameFunction)
                .collect(Collectors.toList());

        assertThat(customerNames).containsExactly("Fred", "Mary", "Bill").inOrder();
    }

    /**
     * Get the city for each of the company's customers.
     */
    @Test
    public void getCustomerCities()
    {
        List<String> customerCities = this.company.getCustomers()
                .stream()
                .map(Customer::getCity)
                .collect(Collectors.toList());

        assertThat(customerCities).containsExactly("London", "Liphook", "London").inOrder();
    }

    /**
     * Which customers come from London? Get a collection of those which do.
     */
    @Test
    public void getLondonCustomers()
    {
        List<Customer> customersFromLondon = this.company.getCustomers()
                .stream()
                .filter(c -> "London".equals(c.getCity()))
                .collect(Collectors.toList());

        assertThat(customersFromLondon).hasSize(2);
    }
}
