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

import com.google.common.truth.Truth;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.google.common.truth.Truth.assertThat;

/**
 * In the slides leading up to this exercise you should have learned about the following APIs.
 * <p/>
 * {@link MutableList#flatCollect(Function)}<br>
 * {@link MutableList#select(Predicate)}<br>
 * {@link MutableList#reject(Predicate)}<br>
 * {@link MutableList#count(Predicate)}<br>
 * {@link MutableList#detect(Predicate)}<br>
 * {@link MutableList#anySatisfy(Predicate)}<br>
 * {@link MutableList#allSatisfy(Predicate)}<br>
 * {@link MutableList#noneSatisfy(Predicate)}<br>
 * <br>
 * You should have also learned about the following methods as well.<br>
 * <br>
 * {@link MutableList#selectWith(Predicate2, Object)}<br>
 * {@link MutableList#rejectWith(Predicate2, Object)}<br>
 * {@link MutableList#countWith(Predicate2, Object)}<br>
 * {@link MutableList#detectWith(Predicate2, Object)}<br>
 * {@link MutableList#anySatisfyWith(Predicate2, Object)}<br>
 * {@link MutableList#allSatisfyWith(Predicate2, Object)}<br>
 * {@link MutableList#noneSatisfyWith(Predicate2, Object)}<br>
 * <br>
 * @see <a href="http://eclipse.github.io/eclipse-collections-kata/pet-kata/#/4">Exercise 2 Slides</a>
 */
public class Exercise2Test extends PetDomainForKata
{
    @Test
    public void doAnyPeopleHaveCats()
    {
        Predicate<Person> predicate = null; //replace null with a Predicate lambda which checks for PetType.CAT
        Assert.assertTrue(this.people.anySatisfy(predicate));
    }

    @Test
    public void doAllPeopleHavePets()
    {
        Predicate<Person> predicate = person -> person.isPetPerson();
        boolean result = true; //replace with a method call send to this.people that checks if all people have pets
        Assert.assertFalse(result);
    }

    @Test
    public void howManyPeopleHaveCats()
    {
        int count = 0;
        Assert.assertEquals(2, count);
    }

    @Test
    public void findMarySmith()
    {
        Person result = null;
        Assert.assertEquals("Mary", result.getFirstName());
        Assert.assertEquals("Smith", result.getLastName());
    }

    @Test
    public void getPeopleWithPets()
    {
        List<Person> petPeople = this.people; // replace with only the pet owners
        assertThat(petPeople).hasSize(7);
    }

    @Test
    public void getAllPetsOfAllPeople()
    {
        Function<Person, Iterable<PetType>> function = person -> person.getPetTypes();
        Set<PetType> petTypes = null;
        assertThat(petTypes).containsExactly(PetType.CAT, PetType.DOG, PetType.TURTLE, PetType.HAMSTER, PetType.BIRD, PetType.SNAKE);
    }

    @Test
    public void getFirstNamesOfAllPeople()
    {
        List<String> firstNames = null;  // Transform this.people into a list of first names
        assertThat(firstNames).containsExactly(
                "Mary", "Bob", "Ted", "Jake", "Barry", "Terry", "Harry", "John")
                .inOrder();
    }

    @Test
    public void doAnyPeopleHaveCatsRefactor()
    {
        boolean peopleHaveCatsLambda = this.people.anySatisfy(person -> person.hasPet(PetType.CAT));
        Assert.assertTrue(peopleHaveCatsLambda);

        //use method reference, NOT lambdas, to solve the problem below
        boolean peopleHaveCatsMethodRef = false;
        Assert.assertTrue(peopleHaveCatsMethodRef);
    }

    @Test
    public void doAllPeopleHaveCatsRefactor()
    {
        boolean peopleHaveCatsLambda = this.people.allSatisfy(person -> person.hasPet(PetType.CAT));
        Assert.assertFalse(peopleHaveCatsLambda);

        //use method reference, NOT lambdas, to solve the problem below
        boolean peopleHaveCatsMethodRef = true;
        Assert.assertFalse(peopleHaveCatsMethodRef);
    }

    @Test
    public void getPeopleWithCatsRefactor()
    {
        //use method reference, NOT lambdas, to solve the problem below
        List<Person> peopleWithCatsMethodRef = null;
        assertThat(peopleWithCatsMethodRef).hasSize(2);
    }

    @Test
    public void getPeopleWithoutCatsRefactor()
    {
        //use method reference, NOT lambdas, to solve the problem below
        List<Person> peopleWithoutCatsMethodRef = null;
        assertThat(peopleWithoutCatsMethodRef).hasSize(6);
    }
}
