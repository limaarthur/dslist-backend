package com.ignitec.dslist.services;

import com.ignitec.dslist.dtos.GameListDTO;
import com.ignitec.dslist.entities.GameList;
import com.ignitec.dslist.repositories.GameListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> gameList = gameListRepository.findAll();
        List<GameListDTO> gameListDTO = gameList.stream().map(game -> new GameListDTO(game)).toList();
        return gameListDTO;
    }
}
