package com.igdy.igeodaeyeo.domain.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.igdy.igeodaeyeo.domain.example.dto.ExampleRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static com.epages.restdocs.apispec.MockMvcRestDocumentationWrapper.document;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.post;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.restdocs.request.RequestDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@ExtendWith(SpringExtension.class)
class ExampleControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getExample() throws Exception {
        mockMvc.perform(get("/example")) // /api/example?id=1
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("{class-name}/{method-name}"
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestHeaders(
//                                headerWithName().description()
//                        ),
//                        responseHeaders(
//                                headerWithName().description()
//                        ),
                ));
    }

    @Test
    public void getExample2() throws Exception {
        mockMvc.perform(get("/example/{id}", 1L))
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("{class-name}/{method-name}",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestHeaders(
//                                headerWithName().description()
//                        ),
//                        responseHeaders(
//                                headerWithName().description()
//                        ),
                        pathParameters(
                                parameterWithName("id").description("The ID of the example")
                        ),
                        responseFields(
                                fieldWithPath("id").description("The ID of the example"),
                                fieldWithPath("data").description("The data of the example")
                        )
                ));
    }

    @Test
    void postExample() throws Exception {
        ExampleRequest request = new ExampleRequest();
        request.setId(1L);

        mockMvc.perform(post("/example")
                        .contentType(APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request))
                )
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(status().isOk())
                .andDo(print())
                .andDo(document("{class-name}/{method-name}",
//                        preprocessRequest(prettyPrint()),
//                        preprocessResponse(prettyPrint()),
//                        requestHeaders(
//                                headerWithName().description()
//                        ),
//                        responseHeaders(
//                                headerWithName().description()
//                        ),
                        requestFields(
                                fieldWithPath("id").description("The ID of the example"),
                                fieldWithPath("data").description("The data of the example")
                        ),
                        responseFields(
                                fieldWithPath("id").description("The ID of the example"),
                                fieldWithPath("data").description("The data of the example")
                        )
                ));
    }
}