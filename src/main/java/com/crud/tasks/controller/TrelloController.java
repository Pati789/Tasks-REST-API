package com.crud.tasks.controller;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.validator.facade.TrelloFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/trello")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TrelloController {

    @Autowired
    private final TrelloFacade trelloFacade;

        @GetMapping("/boards")
        public List<TrelloBoardDto> getTrelloBoards() {
            return (trelloFacade.fetchTrelloBoards());
        }

        @PostMapping("/cards")
        public CreatedTrelloCardDto createTrelloCard(@RequestBody TrelloCardDto trelloCardDto) {
            return trelloFacade.createCard(trelloCardDto);
        }
}
