package es.cafeteru.apicalculator.integrations;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import es.cafeteru.apicalculator.ApiCalculatorApplication;
import es.cafeteru.apicalculator.controllers.CalculatorController;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {
    ApiCalculatorApplication.class
})
@ContextConfiguration(classes = CalculatorController.class)
@AutoConfigureMockMvc
class CalculatorControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void suma_con_parametros_correctos() throws Exception {
        mockMvc.perform(
                get("/?operando1=1&operando2=2&operador=+"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", is(3.0)));
    }

    @Test
    void suma_con_errores_numero_parametros() throws Exception {
        mockMvc.perform(
                get("/"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().is4xxClientError());

        mockMvc.perform(
                get("/?operando1=1"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().is4xxClientError());

        mockMvc.perform(
                get("/?operando2=1"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().is4xxClientError());
    }

    @Test
    void suma_con_errores_tipo_parametros() throws Exception {
        mockMvc.perform(
                get("/?operando1=1&operando2=2erere&operador=+"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().is4xxClientError());

        mockMvc.perform(
                get("/?operando1=null&operando2=2erere"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().is4xxClientError());
    }

    @Test
    void resta_con_parametros_correctos() throws Exception {
        mockMvc.perform(
                get("/?operando1=1&operando2=2&operador=-"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", is(-1.0)));
    }

    @Test
    void resta_con_errores_numero_parametros() throws Exception {
        mockMvc.perform(
                get("/"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().is4xxClientError());

        mockMvc.perform(
                get("/?operando1=1"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().is4xxClientError());

        mockMvc.perform(
                get("/?operando2=1"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().is4xxClientError());
    }

    @Test
    void resta_con_errores_tipo_parametros() throws Exception {
        mockMvc.perform(
                get("/?operando1=1&operando2=2erere&operador=-"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().is4xxClientError());

        mockMvc.perform(
                get("/?operando1=null&operando2=2erere&operador=-"))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(status().is4xxClientError());
    }
}
