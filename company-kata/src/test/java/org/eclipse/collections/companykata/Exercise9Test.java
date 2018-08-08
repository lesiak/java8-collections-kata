/*
 * Copyright (c) 2018 Goldman Sachs.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */

package org.eclipse.collections.companykata;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static com.google.common.truth.Truth.assertThat;

public class Exercise9Test
{

    @Test
    public void countsRepetitions() {
        List<String> input = Lists.newArrayList("London", "Warsaw", "Warsaw", "Paris", "London", "London");
        Map<String, Integer> stringIntegerMap = itDoesDomething(input);
        assertThat(stringIntegerMap).containsEntry("London", 3);
        assertThat(stringIntegerMap).containsEntry("Warsaw", 2);
        assertThat(stringIntegerMap).containsEntry("Paris", 1);
    }

    @Test
    public void countsRepetitionsStreams() {
        List<String> input = Lists.newArrayList("London", "Warsaw", "Warsaw", "Paris", "London", "London");
        Map<String, Integer> stringIntegerMap = itDoesDomethingStreams(input);
        assertThat(stringIntegerMap).containsEntry("London", 3);
        assertThat(stringIntegerMap).containsEntry("Warsaw", 2);
        assertThat(stringIntegerMap).containsEntry("Paris", 1);
    }

    Map<String, Integer> itDoesDomethingStreams(List<String> elements) {
        return elements.stream().collect(Collectors.groupingBy(e -> e, countingInt()));
    }

    public static <T> Collector<T, ?, Integer>
    countingInt() {
        return Collectors.reducing(0, e -> 1, Integer::sum);
    }

    Map<String, Integer> itDoesDomething(List<String> elements) {
        int i = 0;
        Map<String, Integer> results = new HashMap<>();
        while (i < elements.size()) {
            Integer element = results.get(elements.get(i));
            if (element != null) {
                results.put(elements.get(i), element + 1);
            } else {
                results.put(elements.get(i), 1);
            }
            i++;
        }
        return results;
    }
}
