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

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        Map<String, List<Customer>> multimap = company.getCustomers()
                .stream()
                .collect(Collectors.groupingBy(Customer::getCity));

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
        Stream<Tuple<Supplier, String>> tupleStream =
                Arrays.stream(company.getSuppliers())
                .flatMap(s -> Arrays.stream(s.getItemNames()).map(i -> new Tuple<>(s, i)));
        
        Map<String, List<Supplier>> itemsToSuppliers = tupleStream
                .collect(Collectors.groupingBy(Tuple::two, Collectors.collectingAndThen(
                        Collectors.toList(),
                        listOfTuples -> listOfTuples.stream().map(Tuple::one).collect(Collectors.toList()))));

        assertThat(itemsToSuppliers.get("sofa")).hasSize(2);
    }



    static class Tuple<T, U> {
        private final T one;
        private final U two;

        public T one() { return one; }
        public U two() { return two; }

        public Tuple(T one, U two) {
            this.one = one;
            this.two = two;
        }

        //public static <T,U> Tuple<T,U> tuple(T t, U u) {
         //   return new Tuple<>(t, u);
       // }

        //public <V,W> Tuple<V,W> map(BiFunction<T,U,Tuple<V,W>> mapper) {
        //    return mapper.apply(one(), two());
       // }

        @Override
        public String toString() {
            return "(" + one() + ", " + two() + ")";
        }

        /*
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Tuple<?, ?> tuple = (Tuple<?, ?>) o;

            if (one != null ? !one.equals(tuple.one) : tuple.one != null) return false;
            return !(two != null ? !two.equals(tuple.two) : tuple.two != null);

        }

        @Override
        public int hashCode() {
            int result = one != null ? one.hashCode() : 0;
            result = 31 * result + (two != null ? two.hashCode() : 0);
            return result;
        }
        */
    }
}
