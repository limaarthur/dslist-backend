package com.ignitec.dslist.services;

import com.ignitec.dslist.dtos.GameMinDTO;
import com.ignitec.dslist.entities.Game;
import com.ignitec.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public List<GameMinDTO> findAll() {
        List<Game> gameList = gameRepository.findAll();
        List<GameMinDTO> gameListDTO = gameList.stream().map(game -> new GameMinDTO(game)).toList();
        return gameListDTO;
    }
}
