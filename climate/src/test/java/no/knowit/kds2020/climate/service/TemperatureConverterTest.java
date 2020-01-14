package no.knowit.kds2020.climate.service;

import static no.knowit.kds2020.climate.service.TemperatureConverter.celsiusToFahrenheit;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.aMapWithSize;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.blankString;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsInRelativeOrder;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasLength;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.stringContainsInOrder;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import org.junit.Test;

public class TemperatureConverterTest {

  private static final double ACCEPTABLE_DELTA = 0.0001;

  @Test
  public void celsiusToFahrenheit_should_convert_to_expected_fahrenheit_value() {
    assertEquals(32.0, celsiusToFahrenheit(0), ACCEPTABLE_DELTA);
    assertEquals(212.0, celsiusToFahrenheit(100), ACCEPTABLE_DELTA);
    assertEquals(-148.0, celsiusToFahrenheit(-100), ACCEPTABLE_DELTA);
  }

  @Test
  public void demonstrate_junit_assertions() {
    assertEquals("foo", "foo");
    assertNotEquals("foo", "bar");

    Object object = new Object();
    assertSame(object, object);
    assertNotSame(object, new Object());

    assertNull(null);
    assertNotNull(object);

    assertTrue(0 < 1);
    assertFalse(2 < 1);

    assertThrows(Exception.class, () -> {throw new Exception();});
  }

  @Test
  public void celsiusToFahrenheit_should_convert_to_expected_fahrenheit_value_with_hamcrest() {
    assertThat(celsiusToFahrenheit(0), is(equalTo(32.0)));
    assertThat(celsiusToFahrenheit(100), is(equalTo(212.0)));
    assertThat(celsiusToFahrenheit(-100), is(equalTo(-148.0)));
  }

  @Test
  public void demonstrate_hamcrest_matchers() {
    assertThat("foo", equalTo("foo"));
    assertThat("foo", is(equalTo("foo")));
    assertThat("foo", is("foo"));

    assertThat("foo", is(not(equalTo("bar"))));

    Object object = new Object();
    assertThat(object, is(sameInstance(object)));
    assertThat(object, is(not(sameInstance(new Object()))));

    assertThat(null, is(nullValue()));
    assertThat(object, is(not(nullValue())));

    assertThat(0 < 1, is(true));
    assertThat(2 < 1, is(false));

    // Use JUnit assertThrows for exceptions
  }

  @Test
  public void demonstrate_additional_hamcrest_matchers() {
    assertThat("foo", is(anything()));

    // strings
    assertThat("",    is(emptyString()));
    assertThat(null,  is(emptyOrNullString()));
    assertThat("   ", is(blankString()));
    assertThat(null,  is(blankOrNullString()));

    assertThat("Tom Marvolo Riddle", startsWith("Tom"));
    assertThat("Tom Marvolo Riddle", endsWith("Riddle"));
    assertThat("Tom Marvolo Riddle", containsString("Marvolo"));
    assertThat("Tom Marvolo Riddle", containsStringIgnoringCase("marvolo"));
    assertThat("Tom Marvolo Riddle", stringContainsInOrder("Tom", "Riddle"));
    assertThat("Tom Marvolo Riddle", equalToIgnoringCase("tom marvolo riddle"));
    assertThat("Tom Marvolo Riddle",
        equalToCompressingWhiteSpace("\t Tom  Marvolo Riddle \n"));

    // iterables
    assertThat(Arrays.asList(1, 2, 3), not(empty()));
    assertThat(Arrays.asList(1, 2, 3), hasSize(3));
    assertThat(Arrays.asList(1, 2, 3), hasItem(2));
    assertThat(Arrays.asList(1, 2, 3), hasItem(greaterThan(2)));
    assertThat(Arrays.asList(1, 2, 3), hasItems(2, 1));
    assertThat(Arrays.asList(1, 2, 3), hasItems(lessThan(2), greaterThan(2)));
    assertThat(Arrays.asList(1, 2, 3), containsInRelativeOrder(1, 3));
    assertThat(Arrays.asList(1, 2, 3), everyItem(greaterThan(0)));

    LinkedHashSet<Integer> set = new LinkedHashSet<>();
    set.add(1); set.add(2); set.add(3);

    assertThat(set, is(not(equalTo(Arrays.asList(1, 2, 3)))));
    assertThat(set, contains(1, 2, 3));
    assertThat(set,
        contains(
            lessThan(2),
            lessThanOrEqualTo(2),
            greaterThan(2)
        )
    );
    assertThat(set, containsInAnyOrder(1, 3, 2));

    // maps
    Map<String, Integer> fruits = new HashMap<>();
    fruits.put("apples", 3);
    fruits.put("oranges", 5);

    assertThat(fruits, hasKey("apples"));
    assertThat(fruits, hasKey(startsWith("apple")));
    assertThat(fruits, hasValue(5));
    assertThat(fruits, hasEntry("oranges", 5));
    assertThat(fruits, aMapWithSize(2));

    // arrays (no primitive types)
    assertThat(new Integer[]{1, 2, 3}, not(emptyArray()));
    assertThat(new Integer[]{1, 2, 3}, arrayWithSize(3));
    assertThat(new Integer[]{1, 2, 3}, hasItemInArray(2));
    assertThat(new Integer[]{1, 2, 3}, arrayContaining(1, 2, 3));
    assertThat(new Integer[]{1, 2, 3}, arrayContainingInAnyOrder(1, 3, 2));

    // logic operators
    assertThat("foo", either(endsWith("ar")).or(endsWith("oo")));
    assertThat("foo", anyOf(endsWith("ar"), endsWith("oo"), endsWith("az")));
    assertThat("foo", both(is(startsWith("f"))).and(endsWith("oo")));
    assertThat("foo",
        allOf(startsWith("f"), containsString("o"), hasLength(3)));

    // type checking
    assertThat("foo", is(instanceOf(String.class)));
    assertThat("foo", is(instanceOf(Object.class)));
    assertThat("foo", is(any(String.class)));
    assertThat("foo", isA(String.class));
  }

}
