/*
 * Copyright (c) 2016 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.petkata;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Person
{
    private final String firstName;
    private final String lastName;
    private final List<Pet> pets = new ArrayList<>();

    public Person(String firstName, String lastName)
    {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName()
    {
        return this.firstName;
    }

    public String getLastName()
    {
        return this.lastName;
    }

    public boolean named(String name)
    {
        return name.equals(this.firstName + ' ' + this.lastName);
    }

    public boolean hasPet(PetType petType)
    {
        return this.pets.stream()
                .anyMatch(pet -> petType.equals(pet.getType()));
    }

    public List<Pet> getPets()
    {
        return this.pets;
    }

    public Set<PetType> getPetTypes()
    {
        return this.pets.stream()
            .map(Pet::getType)
            .collect(Collectors.toSet());
    }

    public Person addPet(PetType petType, String name, int age)
    {
        this.pets.add(new Pet(petType, name, age));
        return this;
    }

    public boolean isPetPerson()
    {
        return this.getNumberOfPets() >= 1;
    }

    public int getNumberOfPets()
    {
        return this.pets.size();
    }
}
