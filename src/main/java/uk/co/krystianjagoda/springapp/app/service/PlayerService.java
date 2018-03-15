package uk.co.krystianjagoda.springapp.app.service;

import org.springframework.stereotype.Service;
import uk.co.krystianjagoda.springapp.app.model.Player;

import java.util.*;

import static com.google.common.base.Preconditions.checkNotNull;


@Service
public class PlayerService {
    private final List<Player> players = new ArrayList<>();

    public PlayerService() {
    }

    public void addPlayers(Player player){
        checkNotNull(player, "Player cannot be null");
        players.add(player);
    }

    public void removePlayers(Player player){
        checkNotNull(player, "Player cannot be null");
        players.remove(player);
    }

    public List<Player> getPlayers() {
        return players;
    }
}
