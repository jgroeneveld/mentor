package de.jgroeneveld.mentor.managers.boundary;

import de.jgroeneveld.mentor.MockMvcTest;
import de.jgroeneveld.mentor.managers.control.ManagerRepository;
import de.jgroeneveld.mentor.managers.entity.Manager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath;
import static org.springframework.restdocs.payload.PayloadDocumentation.relaxedResponseFields;
import static org.springframework.restdocs.payload.PayloadDocumentation.responseFields;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ManagerControllerTest extends MockMvcTest {

    @Autowired
    ManagerRepository repository;

    @Test
    public void getManager() throws Exception {
        Manager manager = repository.save(new Manager("Jon", "Snow"));

        mockMvc.perform(get("/managers/{id}", manager.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("id").value(manager.getId()))
                .andExpect(jsonPath("firstName").value("Jon"))
                .andExpect(jsonPath("lastName").value("Snow"))
                .andDo(document("{class-name}/{method-name}",
                        responseFields(
                                fieldWithPath("id").description("Manager ID"),
                                fieldWithPath("firstName").description("First Name"),
                                fieldWithPath("lastName").description("Last Name")
                        )
                ));
    }

    @Test
    public void listManagers() throws Exception {
        Manager manager = repository.save(new Manager("Robert", "Baratheon"));

        mockMvc.perform(get("/managers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("content.length()").value(1))
                .andExpect(jsonPath("content[0].id").value(manager.getId()))
                .andExpect(jsonPath("content[0].firstName").value("Robert"))
                .andExpect(jsonPath("content[0].lastName").value("Baratheon"))
                .andDo(document("{class-name}/{method-name}",
                        relaxedResponseFields(
                                fieldWithPath("content").description("List of Managers"),
                                fieldWithPath("numberOfElements").description("How many elements on this page"),
                                fieldWithPath("last").description("Is this the last page"),
                                fieldWithPath("first").description("Is this the first page"),
                                fieldWithPath("totalElements").description("Number of elements"),
                                fieldWithPath("totalPages").description("Number of pages"),
                                fieldWithPath("size").description("Max. Page Size"),
                                fieldWithPath("number").description("Page Number")
                        )
                ));
    }
}