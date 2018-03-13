package uk.co.krystianjagoda.springapp.app.web;

import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;


public class PlayerControllerTest {
    private final PlayerController controller = new PlayerController();
    private final MockMvc mvc = standaloneSetup(controller).build();

    @Test
    public void displayMethodShouldReturnPlayers() throws Exception {
        MvcResult result = mvc.perform(get("/display"))
                .andExpect(status().isOk()).andReturn();
        assertThat(result.getModelAndView().getViewName()).isEqualTo("players");
    }

    @Test
    public void displayMethodShouldContainsPlayers() throws Exception {
        MvcResult result = mvc.perform(get("/display"))
                .andExpect(status().isOk()).andReturn();

        assertThat(result.getModelAndView().getViewName()).isEqualTo("players");
    }

    @Test
    public void addMethodShouldReturnPlayers() throws Exception {
        MvcResult result = mvc.perform(post("/add")
                .param("firstName", "Adam")
                .param("lastName", "Lalanna"))
                .andExpect(status().isOk()).andReturn();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result.getModelAndView().getViewName()).isEqualTo("players");
        softly.assertThat(result.getModelAndView().getModel()).containsKey("players");
        softly.assertAll();

    }

    @Test
    public void removeMethodShouldReturnPlayers() throws Exception {
        MvcResult result = mvc.perform(post("/remove")
                .param("firstName", "Adam")
                .param("lastName", "Lalanna"))
                .andExpect(status().isOk()).andReturn();

        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result.getModelAndView().getViewName()).isEqualTo("players");
        softly.assertThat(result.getModelAndView().getModel()).containsKey("players");
        softly.assertAll();
    }
}