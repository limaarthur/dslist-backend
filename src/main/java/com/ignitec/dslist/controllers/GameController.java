package com.ignitec.dslist.controllers;

import com.ignitec.dslist.dtos.GameDTO;
import com.ignitec.dslist.dtos.GameMinDTO;
import com.ignitec.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id) {
        GameDTO gameDTO = gameService.findById(id);
        return gameDTO;
    }

    @GetMapping
    public List<GameMinDTO> findAll() {
        List<GameMinDTO> gameListDTO = gameService.findAll();
        return gameListDTO;
    }
}
