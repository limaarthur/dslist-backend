package com.ignitec.dslist.controllers;

import com.ignitec.dslist.dtos.GameListDTO;
import com.ignitec.dslist.dtos.GameMinDTO;
import com.ignitec.dslist.services.GameListService;
import com.ignitec.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

    @Autowired
    private GameListService gameListService;

    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameListDTO> findAll() {
        List<GameListDTO> gameListDTO = gameListService.findAll();
        return gameListDTO;
    }

    @GetMapping(value = "/{listId}/games")
    public List<GameMinDTO> findByList(@PathVariable Long listId) {
        List<GameMinDTO> gameListDTO = gameService.findByList(listId);
        return gameListDTO;
    }
}
