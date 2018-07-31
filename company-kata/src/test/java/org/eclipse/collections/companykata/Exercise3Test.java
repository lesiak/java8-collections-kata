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
import com.google.common.collect.Sets;
import com.google.common.truth.Truth;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;

import static com.google.common.truth.Truth.assertThat;

/**
 * Below are links to APIs that may be helpful during these exercises.
 *
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/company-kata/#/8">Exercise 3 Slides</a>
 */
public class Exercise3Test extends CompanyDomainForKata
{
    /**
     * Improve {@link Company#getOrders()} without breaking this test.
     */
    @Test
    public void improveGetOrders()
    {
        // Delete this line - it's a reminder
        Assert.fail("Improve getOrders() without breaking this test");
        assertThat(this.company.getOrders()).hasSize(5);
    }

    /**
     * Get all items that have been ordered by anybody.
     */
    @Test
    public void findItemNames()
    {
        List<LineItem> allOrderedLineItems = null;
        Set<String> actualItemNames = null;

        assertThat(actualItemNames).isInstanceOf(Set.class);
        assertThat(actualItemNames.stream().findFirst().get()).isInstanceOf(String.class);

        Set<String> expectedItemNames = Sets.newHashSet(
                "shed", "big shed", "bowl", "cat", "cup", "chair", "dog",
                "goldfish", "gnome", "saucer", "sofa", "table");
        Assert.assertEquals(expectedItemNames, actualItemNames);
    }

    @Test
    public void findCustomerNames()
    {
        List<String> names = null;

        List<String> expectedNames = Lists.newArrayList("Fred", "Mary", "Bill");
        Assert.assertEquals(expectedNames, names);
    }
}
