package uk.co.krystianjagoda.springapp.app.service;

import org.junit.Test;
import uk.co.krystianjagoda.springapp.app.model.Player;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerServiceTest {

    private final PlayerService service = new PlayerService();

    @Test
    public void forANullPlayerAddedToTeamThrowNullPointerException() throws Exception {

        assertThatThrownBy(() -> service.addPlayers(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Player cannot be null");
    }

    @Test
    public void forANullPlayerRemovedFromTeamThrowNullPointerException() throws Exception {

        assertThatThrownBy(() -> service.removePlayers(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessage("Player cannot be null");
    }

    @Test
    public void addPlayersMethodIncreasesTheNumberOfPlayers(){
        Player player = new Player("John", "Doe");
        service.addPlayers(player);

        assertThat(service.getPlayers()).hasSize(1).containsExactly(player);
    }

    @Test
    public void removePlayersMethodDecreasesNumOfPlayers(){
        Player player = new Player("John", "Doe");
        service.addPlayers(player);
        service.removePlayers(player);

        assertThat(service.getPlayers()).hasSize(0).doesNotContain(player);
    }
}