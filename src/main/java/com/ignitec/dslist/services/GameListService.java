package com.ignitec.dslist.services;

import com.ignitec.dslist.dtos.GameListDTO;
import com.ignitec.dslist.entities.GameList;
import com.ignitec.dslist.projection.GameMinProjection;
import com.ignitec.dslist.repositories.GameListRepository;

import com.ignitec.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {

    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> gameList = gameListRepository.findAll();
        List<GameListDTO> gameListDTO = gameList.stream().map(game -> new GameListDTO(game)).toList();
        return gameListDTO;
    }

    @Transactional(readOnly = true)
    public void move(Long listId, int sourceIndex, int destinationIndex) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection gameInList = list.remove(sourceIndex);
        list.add(destinationIndex, gameInList);

        int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
        int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
