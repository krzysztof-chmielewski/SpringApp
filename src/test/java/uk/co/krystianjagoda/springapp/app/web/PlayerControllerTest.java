package uk.co.krystianjagoda.springapp.app.web;


import org.assertj.core.api.SoftAssertions;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import uk.co.krystianjagoda.springapp.app.model.Player;
import uk.co.krystianjagoda.springapp.app.service.PlayerService;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class PlayerControllerTest {
    private final PlayerService service = mock(PlayerService.class);
    private final PlayerController controller = new PlayerController(service);
    private final MockMvc mvc = standaloneSetup(controller).build();

    @Test
    public void display() throws Exception {
        MvcResult result = mvc.perform(get("/players/displayPlayers")).andExpect(status().isOk()).andReturn();

        verifyViewNameAndModelKey(result, "players", "players");
        verify(service).getPlayers();
    }

    @Test
    public void addNewPlayer() throws Exception {
        MvcResult result = mvc.perform(post("/players/addPlayers")
                .param("firstName", "John")
                .param("lastName", "Doe"))
                .andExpect(status().isOk()).andReturn();

        verifyViewNameAndModelKey(result, "players", "players");
        verify(service).getPlayers();
        verify(service).addPlayers(new Player("John", "Doe"));
    }

    @Test
    public void removeAPlayer() throws Exception {
        MvcResult result = mvc.perform(post("/players/removePlayers")
                .param("firstName", "John")
                .param("lastName", "Doe"))
                .andExpect(status().isOk()).andReturn();

        verifyViewNameAndModelKey(result, "players", "players");
        Player player = new Player("John", "Doe");
        service.addPlayers(player);
        verify(service).removePlayers(new Player("John", "Doe"));
        verify(service).getPlayers();
    }

    private void verifyViewNameAndModelKey(MvcResult result, String viewName, String modelKey) {
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(result.getModelAndView().getViewName()).isEqualTo(viewName);
        softly.assertThat(result.getModelAndView().getModel()).containsKey(modelKey);
        softly.assertAll();
    }
}