/*
 * Copyright (c) 2017 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.petkata;

import org.junit.Test;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Stream;

import static com.google.common.truth.Truth.assertThat;

/**
 * In the slides leading up to this exercise you should have learned about the following APIs.
 * <p/>
 * {@link Stream#collect(Collector)}<br>
 * {@link Stream#filter(Predicate)}<br>
 *
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/pet-kata/#/2">Exercise 1 Slides</a>
 */
public class Exercise1Test extends PetDomainForKata
{
    @Test
    public void getFirstNamesOfAllPeople()
    {
        // Replace null, with a transformation method on MutableList.
        List<String> firstNames = null; // this.people..
        assertThat(firstNames).containsExactly("Mary", "Bob", "Ted", "Jake", "Barry", "Terry", "Harry", "John").inOrder();
    }

    @Test
    public void getNamesOfMarySmithsPets()
    {
        Person person = this.getPersonNamed("Mary Smith");
        List<Pet> pets = person.getPets();

        // Replace null, with a transformation method on MutableList.
        List<String> names = null; // pets...

        //Assert.assertEquals("Tabby", names.makeString());
    }

    @Test
    public void getPeopleWithCats()
    {
        // Replace null, with a positive filtering method on MutableList.
        List<Person> peopleWithCats = null;  // this.people...

        assertThat(peopleWithCats).hasSize(2);
    }

    @Test
    public void getPeopleWithoutCats()
    {
        // Replace null, with a negative filtering method on MutableList.
        List<Person> peopleWithoutCats = null;  // this.people...

        assertThat(peopleWithoutCats).hasSize(6);
    }
}
