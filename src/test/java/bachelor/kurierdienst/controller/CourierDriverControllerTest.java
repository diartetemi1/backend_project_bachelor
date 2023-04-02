package bachelor.kurierdienst.controller;

import bachelor.kurierdienst.dto.CourierDriverDto;
import bachelor.kurierdienst.model.CourierDriver;
import bachelor.kurierdienst.service.CourierDriverService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CourierDriverControllerTest {

    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper om;

    @MockBean
    CourierDriverService courierDriverService;

    @Test
    void name() throws Exception {
        CourierDriverDto givenDTO = new CourierDriverDto("firstname", "lastname", "email", "phone");
        when(courierDriverService.create(givenDTO)).thenReturn(new CourierDriver());

        mockMvc.perform(post("/drivers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(om.writeValueAsString(givenDTO)))
                .andDo(print())
                .andExpect(status().isOk());

    }

}