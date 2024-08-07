package com.in28minutes.rest.webservices.restful_web_services.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {
    @GetMapping("/filtering")
    public MappingJacksonValue filtering() {
        SomeBean someBean = new SomeBean("value1", "value2", "value3");
        return getFilteredMapping(someBean, "SomeBeanFilter", "field1", "field3");
    }

    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList() {
        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
                new SomeBean("value4", "value5", "value6"));
        return getFilteredMapping(list, "SomeBeanFilter", "field2", "field3");
    }

    /**
     * This method applies dynamic filtering to the given object based on the specified fields.
     *
     * @param object The object to be filtered (can be a single object or a list of objects).
     * @param filterName The name of the filter to be applied.
     * @param fields The fields to be included in the filter (all other fields will be excluded).
     * @return A MappingJacksonValue object with the applied filters.
     */
    private MappingJacksonValue getFilteredMapping(Object object, String filterName, String... fields) {
        // Create a MappingJacksonValue instance for the object to be filtered
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(object);

        // Create a SimpleBeanPropertyFilter to filter out all fields except the specified ones
        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);

        // Create a FilterProvider and add the filter with the specified filter name
        FilterProvider filters = new SimpleFilterProvider().addFilter(filterName, filter);

        // Set the filters on the MappingJacksonValue instance
        mappingJacksonValue.setFilters(filters);

        // Return the MappingJacksonValue instance with the applied filters
        return mappingJacksonValue;
    }

    // Repeating methods organized above
//    @GetMapping("/filtering")
//    public MappingJacksonValue filtering() {
//        SomeBean someBean = new SomeBean("value1", "value2", "value3");
//
//        //Dynamically filtering all fields except field1, field3
//        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);
//
//        //Set the field to be filtered
//        SimpleBeanPropertyFilter filter =
//                SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
//
//        //Set the filter name for the filter to use in the bean class
//        FilterProvider filters =
//                new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
//
//        //set the filter to the mapping jackson
//        mappingJacksonValue.setFilters(filters);
//
//        return mappingJacksonValue;
//    }
//
//    @GetMapping("/filtering-list")
//    public MappingJacksonValue filteringList() {
//        List<SomeBean> list = Arrays.asList(new SomeBean("value1", "value2", "value3"),
//                new SomeBean("value4", "value5", "value6"));
//        //Dynamically filtering all fields except field2, field3
//        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);
//        SimpleBeanPropertyFilter filter =
//                SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
//
//        FilterProvider filters =
//                new SimpleFilterProvider().addFilter("SomeBeanFilter", filter);
//
//        mappingJacksonValue.setFilters(filters);
//
//        return mappingJacksonValue;
//    }
}


