package org.atousa.items.controller.graphql;

import graphql.GraphQLContext;
import lombok.RequiredArgsConstructor;
import org.atousa.items.dto.SearchResponseDto;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

/**
 * @author Atousa Mirhosseini
 * @since 25 Aug, 2024
 */
@Controller
@RequiredArgsConstructor
// todo Atousa: set request mapping
public class SearchGraphQlController {

    @QueryMapping
    public SearchResponseDto searchItemsGrQl(@Argument String term, GraphQLContext context) {
        context.put("term", term);
        return SearchResponseDto.builder().build();
    }
}
