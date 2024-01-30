package com.module.springboot.jazApp.controller;

import com.module.springboot.jazApp.service.RentsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import com.example.model.entity.Rents;
import java.util.List;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
@WebMvcTest(RentsController.class)
class YourControllerClassTest {

    @Mock
    private RentsService rentsService;

    private RentsController rentsController;

    private MockMvc mockMvc;

    @Test
    public void getAllReturn200() throws Exception{

        List<Rents>rentsList=new ArrayList<>();
        when(rentsService.findAll()).thenReturn(rentsList);
        mockMvc.perform(MockMvcRequestBuilders.get("/rents/list")).
                andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    void DeleteReturn200() throws Exception {
        mockMvc = standaloneSetup(rentsController).build();
        doNothing().when(rentsService).deleteById(2);
        mockMvc.perform(MockMvcRequestBuilders.delete("/rents/delete")
                        .param("rentsId", "2"))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/rents/list"));
    }

    @Test
    void FormForUpdateReturn200() throws Exception {
        mockMvc = standaloneSetup(rentsController).build();
        int rentsId = 1;
        Rents sampleRents = new Rents();
        when(rentsService.findById(rentsId)).thenReturn(sampleRents);
        mockMvc.perform(MockMvcRequestBuilders.get("/rents/showFormForUpdate")
                        .param("rentsId", String.valueOf(rentsId)))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("rents/rents-form"))
                .andExpect(MockMvcResultMatchers.model().attribute("rents", sampleRents));
    }
}